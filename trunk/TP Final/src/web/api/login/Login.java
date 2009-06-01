package web.api.login;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.api.login.views.LoginView;
import web.api.mvc.controller.AbstractControllerServlet;
import web.api.mvc.controller.FrontEndControllerServlet;
import web.api.mvc.view.View;
import web.api.session.SessionValidation;
import web.api.session.entities.Session;

public class Login extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes, HashMap<String,Object> requestParameters) throws Exception {

		String user = (String) requestParameters.get("user");
		String password = (String) requestParameters.get("pass");
		
		if (validateUser(user,password,req,res)){
			redirToUrl(res, requestParameters);
		} else {
			View view = new LoginView(req,res,requestAttributes,requestParameters);
			view.execute();
		}

	}

	private void redirToUrl(HttpServletResponse res,
			HashMap<String, Object> requestParameters) throws Exception {
		String urlRedir = (String)requestParameters.get("urlredir");
		res.sendRedirect(urlRedir);
	}

	private boolean validateUser(String user, String password, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//TODO VALIDAR DATOS CONTRA UNA BASE...
		int userId = user.hashCode();
		
		Session session = SessionValidation.createSession(userId);
		Cookie cookie = new Cookie("user",session.toString());
		cookie.setPath("/");
		//cookie.setMaxAge(expiry)
		res.addCookie(cookie);
		return true;
	}

}
