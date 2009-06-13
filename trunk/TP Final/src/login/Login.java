package login;

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
public class Login extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		String user = (String) requestParameters.get("user");
		String password = (String) requestParameters.get("pass");
		
		if(validateUser(user, password, req, res)) {
			redirToUrl(res, requestParameters);
		}
		else {
			View view = new LoginView(req, res, requestAttributes,
					servletContext, requestParameters);
			view.execute();
		}
	}

	private void redirToUrl(HttpServletResponse res,
			HashMap<String, Object> requestParameters) throws Exception {
		String urlRedir = (String) requestParameters.get("urlredir");
		res.sendRedirect(urlRedir);
	}

	private boolean validateUser(String user, String password,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//TODO: aca llamar al persistor de users
		BidderPersistor bidderPersistor= BidderPersistor.getBidderPersistorInstance();
		
		if (user == null || user.length()==0 || password == null || password.length()==0)
			return false;
		
		if (bidderPersistor.getUserWithPassword(user, password)!=null){
			Session session = SessionValidation.createSession(user.hashCode());
			Cookie cookieUserId = new Cookie("user", session.toString());
			cookieUserId.setPath("/");
			res.addCookie(cookieUserId);
			Cookie cookieUserName = new Cookie("userName", user);
			cookieUserName.setPath("/");
			res.addCookie(cookieUserName);
			return true;
		}
		else
			return false;
		
	}

}
