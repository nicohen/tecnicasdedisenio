package home;

import home.views.HomeView;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BidderPersistor;
import domain.customers.User;

import login.views.LoginView;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import api.web.session.SessionValidation;
import api.web.session.entities.Session;

@SuppressWarnings("serial")
public class Home extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

			View view = new HomeView(req, res, requestAttributes,
					servletContext, requestParameters);
			view.execute();
		}

	
}
