package bid.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;
import api.web.text.LibWeb;
import dao.mocks.AuctionsMock;
import domain.auctions.IncrementalAuction;
import domain.customers.User;
import domain.exceptions.BidException;
import domain.exceptions.InvalidAuctionTypeException;

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
		Long auctionId = null;
		try {
			auctionId = Long.parseLong(paramAuctionId);
		} catch(NumberFormatException e) {
			throw new Exception("Error obteniendo auctionId de request parameters",e);
		}
		IncrementalAuction auction = (IncrementalAuction)AuctionsMock.getInstance().get(auctionId);
		
		User aUser = new User(31733445, "Aníbal", "Lovaglio");
		aUser.addPoints(20000);
		try {
			aUser.bid(auction);
		} catch (BidException e){
			html += "Error al ofertar";
			e.printStackTrace();
		} catch (InvalidAuctionTypeException e){
			html += "Tipo de Subasta invalida";
			e.printStackTrace();
		}
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
