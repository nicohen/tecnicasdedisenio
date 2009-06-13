package startup;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistor;
import persistence.BidderPersistor;
import api.web.mvc.controller.FrontEndControllerServlet;
import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.customers.User;
import domain.utils.VariationRateFunction;

@SuppressWarnings("serial")
public class StartupController extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		
		//aca cargar todo lo necesario en memoria
		
		User aUser2 = new User(31165251,"berta1108","roberto","herman","","","123456");
		aUser2.addPoints(20000);
		BidderPersistor.getBidderPersistorInstance().saveUser(aUser2);
		Product p = new Product("Sony W50");
		Product p2 = new Product("Samsung 40' LCD");
		VariationRateFunction vrf = new VariationRateFunction(null);
		IncrementalAuction ia = new IncrementalAuction(p,AuctionType.SINGLE,vrf,1);
		AuctionPersistor.getInstance().saveIncrementalAuction(ia);
		ia = new IncrementalAuction(p2,AuctionType.SINGLE,vrf,1);
		AuctionPersistor.getInstance().saveIncrementalAuction(ia);
	}
}
