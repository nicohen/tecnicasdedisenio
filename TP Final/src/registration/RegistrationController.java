package registration;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BidderPersistor;
import registration.views.RegistrationView;
import domain.customers.User;

import login.views.LoginView;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import api.web.session.SessionValidation;
import api.web.session.entities.Session;

@SuppressWarnings("serial")
public class RegistrationController extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		String lastname = (String) requestParameters.get("lastname");
		String name = (String) requestParameters.get("name");
		String dni = (String) requestParameters.get("dni");
		String address = (String) requestParameters.get("address");
		String telephone = (String) requestParameters.get("telephone");
		String email = (String) requestParameters.get("email");
		String user = (String) requestParameters.get("user");
		String pass = (String) requestParameters.get("pass");

		if (validateNewUser(user, pass, req, res)) {
			User newUser = new User(Integer.parseInt(dni), user, name,
					lastname, address, email, pass);
			BidderPersistor.getBidderPersistorInstance().saveUser(newUser);
			redirToUrl(res, requestParameters);
		} else {
			View view = new RegistrationView(req, res, requestAttributes,
					servletContext, requestParameters);
			view.execute();
		}
	}
	
	private void redirToUrl(HttpServletResponse res,
			HashMap<String, Object> requestParameters) throws Exception {
		String urlRedir = (String) requestParameters.get("urlredir");
		res.sendRedirect(urlRedir);
	}
	
	private boolean validateNewUser(String user, String password,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		if (user == null || user.length() == 0 || password == null
				|| password.length() == 0)
			return false;

		return true;
	}

}
