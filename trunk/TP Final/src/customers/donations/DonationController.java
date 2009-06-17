package customers.donations;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BidderPersistor;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import api.web.text.LibWeb;
import customers.donations.views.DonationView;
import domain.customers.Donation;
import domain.customers.User;
import domain.exceptions.DonationAlreadyInstanciatedException;

public class DonationController extends FrontEndControllerServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		String pointsStr = LibWeb.getParameter(req, "points");
		Integer points = null;
		try {
			points = Integer.parseInt(pointsStr);
			String userName = null;
			Cookie[] c = req.getCookies();
			for(int i=0;i<c.length;i++) {
				if("userName".equals(c[i].getName())) {
					userName = c[i].getValue();
				}
			}
			User aUser = BidderPersistor.getBidderPersistorInstance().getUser(userName);
			aUser.donate(points);
		} catch(NumberFormatException e) {
			View view = new DonationView(req, res, requestParameters, servletContext, requestParameters);
			view.execute();
		}
		
	}

	@Override
	protected boolean getValidated(HttpServletRequest req) {
		return true;
	}
}
