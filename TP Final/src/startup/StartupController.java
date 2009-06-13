package startup;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistor;
import persistence.BidderPersistor;
import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.customers.User;
import domain.utils.VariationRateFunction;

import bid.views.BidView;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import api.web.text.LibWeb;

@SuppressWarnings("serial")
public class StartupController extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		
		//aca cargar todo lo necesario en memoria
		
		User aUser2 = new User(31252197,"nacho","nacho");
		aUser2.addPoints(20000);
		BidderPersistor.getBidderPersistorInstance().saveUser(aUser2);
		Product p = new Product("Sony W50");
		VariationRateFunction vrf = new VariationRateFunction(null);
		IncrementalAuction ia = new IncrementalAuction(p,AuctionType.SINGLE,vrf,1);
		AuctionPersistor.getInstance().saveIncrementalAuction(ia);
	}

	@Override
	protected boolean getValidated(HttpServletRequest req) {
		return true;
	}
}
