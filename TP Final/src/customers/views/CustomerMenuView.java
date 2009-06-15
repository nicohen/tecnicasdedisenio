package customers.views;

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
import domain.auctions.Auction;
import domain.customers.User;
import domain.exceptions.BidException;
import domain.exceptions.InvalidAuctionTypeException;
import domain.exceptions.NotEnoughPointsToBidException;

public class CustomerMenuView extends HtmlView {

	public CustomerMenuView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doHtmlBody() throws Exception {
		String html = HtmlCache.getHtml(relativePath, "customers/CustomerMenuView");
		
		String userName = null;
		Cookie[] c = req.getCookies();
		for(int i=0;i<c.length;i++) {
			if("userName".equals(c[i].getName())) {
				userName = c[i].getValue();
			}
		}
		
		
		User aUser = BidderPersistor.getBidderPersistorInstance().getUser(userName);
		
		html = LibTxt.replaceAll(html, "##USER##", ""+ aUser.getLastName() + "," + aUser.getName());
		
		out.println(html);
	}

}
