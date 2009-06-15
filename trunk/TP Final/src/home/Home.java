package home;

import home.views.HomeView;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistorImplementation;
import persistence.BidderPersistor;
import persistence.KeysPersistor;
import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.customers.Key;
import domain.customers.User;
import domain.utils.VariationRateFunction;

@SuppressWarnings("serial")
public class Home extends FrontEndControllerServlet {

	private static boolean initialized = false;
	Lock l = new ReentrantLock();

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		// aca cargar todo lo necesario en memoria
		if (!Home.initialized) {
			this.initialize();
			l.lock();
			Home.initialized = true;
			l.unlock();
		}
		View view = new HomeView(req, res, requestAttributes, servletContext,
				requestParameters);
		view.execute();
	}

	private void initialize() {
		User aUser2 = new User(31165251, "berta1108", "roberto", "herman", "",
				"", "123456");
		aUser2.addPoints(2000);
		BidderPersistor.getBidderPersistorInstance().saveUser(aUser2);
		Product p = new Product("Sony W50");
		Product p2 = new Product("Samsung 40' LCD");
		VariationRateFunction vrf = new VariationRateFunction(null);
		IncrementalAuction ia = new IncrementalAuction(p, AuctionType.SINGLE,
				vrf, 1);
		AuctionPersistorImplementation.getInstance().saveIncrementalAuction(ia);
		ia = new IncrementalAuction(p2, AuctionType.SINGLE, vrf, 1);
		AuctionPersistorImplementation.getInstance().saveIncrementalAuction(ia);
		KeysPersistor key=KeysPersistor.getKeysPersistorInstance();
		Key keyExchange=new Key("abcd",1000);
		
		key.saveKey(keyExchange);
		
		
		
		
	}
}
