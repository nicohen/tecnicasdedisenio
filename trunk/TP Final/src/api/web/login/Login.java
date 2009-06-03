package api.web.login;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.login.views.LoginView;
import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import api.web.session.SessionValidation;
import api.web.session.entities.Session;


public class Login extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,ServletContext servletContext, HashMap<String,Object> requestParameters) throws Exception {

		String user = (String) requestParameters.get("user");
		String password = (String) requestParameters.get("pass");
		
		if (validateUser(user,password,req,res)){
			redirToUrl(res, requestParameters);
		} else {
			View view = new LoginView(req,res,requestAttributes, servletContext, requestParameters);
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
