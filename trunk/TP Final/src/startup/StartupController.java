package startup;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistorImplementation;
import persistence.BidderPersistor;
import api.web.mvc.controller.FrontEndControllerServlet;
import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.customers.User;
import domain.utils.VariationRateFunction;

@SuppressWarnings("serial")
public class StartupController extends FrontEndControllerServlet {
	
	private static boolean initialized = false;
	Lock l = new ReentrantLock();
	
	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		
		//aca cargar todo lo necesario en memoria
		if (!StartupController.initialized) {
			this.initialize();
			l.lock();
			StartupController.initialized = true;
			l.unlock();
		}
	}
	
	private void initialize() {
		User aUser2 = new User(31165251, "berta1108", "roberto", "herman", "",
				"", "123456");
		aUser2.addPoints(20000);
		BidderPersistor.getBidderPersistorInstance().saveUser(aUser2);
		Product p = new Product("Sony W50");
		Product p2 = new Product("Samsung 40' LCD");
		VariationRateFunction vrf = new VariationRateFunction(null);
		IncrementalAuction ia = new IncrementalAuction(p, AuctionType.SINGLE,
				vrf, 1);
		AuctionPersistorImplementation.getInstance().saveIncrementalAuction(ia);
		ia = new IncrementalAuction(p2, AuctionType.SINGLE, vrf, 1);
		AuctionPersistorImplementation.getInstance().saveIncrementalAuction(ia);
	}
}
