package admin.auction;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			showForm(req,res,requestAttributes,servletContext,requestParameters);

		} else if ("validate".equals(action)){
			String subAct = (String)requestParameters.get("subAct");
			if ("preview".equals(subAct)){
				HashMap<Integer,String> errors = validateData(requestParameters);
				if (errors.size()==0){
					showConfirmation(req,res,requestAttributes,servletContext,requestParameters);
				} else {
					showForm(req,res,requestAttributes,servletContext,requestParameters);
				}
			} else if ("save".equals(subAct)){
				
				showSave(req,res,requestAttributes,servletContext,requestParameters);
			}
		} 
	}

	private HashMap<Integer, String> validateData(
			HashMap<String, Object> requestParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	private void showSave(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) {
		// TODO Auto-generated method stub
		
	}

	private void showConfirmation(HttpServletRequest req,
			HttpServletResponse res, HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) {
		// TODO Auto-generated method stub
		
	}

	private void showForm(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		View view = new AdminPublishAuctionFormView(req,res,requestAttributes,servletContext,requestParameters);
		
		view.execute();
		
	}

}
