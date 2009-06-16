package admin.auction;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistorImplementation;
import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.utils.VariationRateFunction;

import admin.auction.views.AdminPublishAuctionFormView;
import api.web.mvc.controller.BackEndControllerServlet;
import api.web.mvc.view.View;

public class AdminPublishAuctionController extends BackEndControllerServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7094083637565452343L;

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		String action = (String)requestParameters.get("act");
		
		if (action == null){
			action = "form";
		}

		if ("form".equals(action)){
			showForm(req,res,requestAttributes,servletContext,requestParameters,"");

		} else if ("validate".equals(action)){
			String subAct = (String)requestParameters.get("subAct");
			if ("preview".equals(subAct)){
				String errors = validateData(requestParameters);
				if (errors == null || errors.length() == 0){
					showConfirmation(req,res,requestAttributes,servletContext,requestParameters);
				} else {
					showForm(req,res,requestAttributes,servletContext,requestParameters,errors);
				}
			} else if ("save".equals(subAct)){
				
				showSave(req,res,requestAttributes,servletContext,requestParameters);
			}
		} 
	}

	private String validateData(
			HashMap<String, Object> requestParameters) {
		String errors = "";
		String title = (String)requestParameters.get("title");
		String auctionType = (String)requestParameters.get("auction_type");
		String price = (String)requestParameters.get("price");
		if (title==null || title.length()==0){
			errors +="Debe completar el titulo. ";
		}
		if (auctionType==null || auctionType.length()==0){
			errors+="Especifique tipo de remate. ";
		}
		if (price==null||price.length()==0){
			errors+="Debe completar el precio. ";
		} else {
			try {
				Integer valor = Integer.parseInt(price);
				if (valor==0){
					errors+="El valor inicial debe ser mayor a 0 (cero). ";
				}
			} catch (Exception e){
				errors+="El precio debe ser un numero. ";
			}
		}
		return errors;
	}

	private void showSave(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		
		Product p = new Product((String)requestParameters.get("title"));
		VariationRateFunction vrf = new VariationRateFunction(null);
		AuctionType type = AuctionType.SINGLE;
		String auctionType = (String)requestParameters.get("auction_type");
		if ("normal".equals(auctionType))
			type = AuctionType.SINGLE;
		else if ("group".equals(auctionType))
			type = AuctionType.GROUP;
		else if ("reverse".equals(auctionType))
			type = AuctionType.REVERSE;
		
		Integer initialValue = Integer.parseInt((String)requestParameters.get("price"));
		IncrementalAuction ia = new IncrementalAuction(p,type,
				vrf, initialValue);
		
		AuctionPersistorImplementation.getInstance().saveIncrementalAuction(ia);

		View view = new AdminPublishAuctionFormView(req,res,requestAttributes,servletContext,requestParameters);
		((AdminPublishAuctionFormView)view).setHtmlTemplate("AuctionSaved");
		
		view.execute();
	}

	private void showConfirmation(HttpServletRequest req,
			HttpServletResponse res, HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		View view = new AdminPublishAuctionFormView(req,res,requestAttributes,servletContext,requestParameters);
		((AdminPublishAuctionFormView)view).setHtmlTemplate("AuctionConfirm");
		
		view.execute();
		
	}

	private void showForm(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters, String errors) throws Exception {
		View view = new AdminPublishAuctionFormView(req,res,requestAttributes,servletContext,requestParameters);
		((AdminPublishAuctionFormView)view).setErrors(errors);
		
		view.execute();
		
	}

}
