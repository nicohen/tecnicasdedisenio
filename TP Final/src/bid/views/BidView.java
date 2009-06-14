package bid.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistorImplementation;
import persistence.BidderPersistor;
import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;
import api.web.text.LibWeb;
import dao.mocks.AuctionsMock;
import domain.auctions.IncrementalAuction;
import domain.customers.User;
import domain.exceptions.BidException;
import domain.exceptions.InvalidAuctionTypeException;
import domain.exceptions.NotEnoughPointsToBidException;

public class BidView extends HtmlView {

	public BidView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doHtmlBody() throws Exception {
		String html = HtmlCache.getHtml(relativePath, "bid/BidView");
		
		String paramAuctionId = LibWeb.getParameter(req, "auctionId");
		boolean errorFlag=false;
		Long auctionId = null;
		try {
			auctionId = Long.parseLong(paramAuctionId);
		} catch(NumberFormatException e) {
			throw new Exception("Error obteniendo auctionId de request parameters",e);
		}

		IncrementalAuction auction = AuctionPersistorImplementation.getInstance().getIncrementalAuctionById(auctionId);

		String userName = null;
		Cookie[] c = req.getCookies();
		for(int i=0;i<c.length;i++) {
			if("userName".equals(c[i].getName())) {
				userName = c[i].getValue();
			}
		}
		
		
		User aUser = BidderPersistor.getBidderPersistorInstance().getUser(userName);
		
		try {
			aUser.bid(auction);
		} catch (NotEnoughPointsToBidException e){
			html += "Error al ofertar: El usuario no posee credito suficiente.";
			e.printStackTrace();
			errorFlag=true;
		} catch (BidException e){
				html += "Error al ofertar";
				e.printStackTrace();
				errorFlag=true;
		} catch (InvalidAuctionTypeException e){
			html += "Tipo de Subasta invalida";
			e.printStackTrace();
			errorFlag=true;
		}
		
		if (!errorFlag)
			html+="Oferta aceptada. Gracias por ofertar!";
		
		html = LibTxt.replaceAll(html, "##AUCTION_ID##", ""+ auctionId);
		
		html = LibTxt.replace(html, "##DESCRIPTION##",auction.getPrize().getDescription());
 		 
		String paramValue = LibWeb.getParameter(req, "value");
		Long valorOferta = null;
		try {
			valorOferta = Long.parseLong(paramValue);
		} catch(NumberFormatException e) {
			throw new Exception("Error obteniendo puntaje a ofertar de request parameters",e);
		}
		html = LibTxt.replaceAll(html, "##POINTS##", ""+valorOferta);


		out.println(html);
	}

}
