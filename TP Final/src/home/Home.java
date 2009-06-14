package home;

import home.views.HomeView;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistor;
import persistence.BidderPersistor;
import startup.StartupController;
import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.customers.User;
import domain.utils.VariationRateFunction;

import login.views.LoginView;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import api.web.session.SessionValidation;
import api.web.session.entities.Session;

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
		aUser2.addPoints(20000);
		BidderPersistor.getBidderPersistorInstance().saveUser(aUser2);
		Product p = new Product("Sony W50");
		Product p2 = new Product("Samsung 40' LCD");
		VariationRateFunction vrf = new VariationRateFunction(null);
		IncrementalAuction ia = new IncrementalAuction(p, AuctionType.SINGLE,
				vrf, 1);
		AuctionPersistor.getInstance().saveIncrementalAuction(ia);
		ia = new IncrementalAuction(p2, AuctionType.SINGLE, vrf, 1);
		AuctionPersistor.getInstance().saveIncrementalAuction(ia);
	}
}
