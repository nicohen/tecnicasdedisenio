package customers.auctions;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customers.auctions.views.UserAuctionsView;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import api.web.text.LibWeb;
import auction.views.AuctionView;
import auction.views.AuctionsView;

@SuppressWarnings("serial")
public class UserAuctionsController extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		View view = null;
		
		view = new UserAuctionsView(req,res,requestAttributes,servletContext,requestParameters);
		
		view.execute();

	}

	@Override
	protected boolean getValidated(HttpServletRequest req) {
		return true;
	}
}
