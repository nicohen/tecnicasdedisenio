package login.admin;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.admin.views.AdminLoginView;
import api.web.mvc.controller.BackEndControllerServlet;
import api.web.mvc.view.View;
import api.web.session.SessionValidation;
import api.web.session.entities.Session;
import api.web.session.exception.ForbiddenLoginClassException;

public class AdminLogin extends BackEndControllerServlet {



	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		HashMap<String,Object> requestAttributes = new HashMap<String, Object>();
		
		HashMap<String,Object> parameters = loadRequestParameters(req);
		requestAttributes.put("parameters", parameters);

		try {
			executeView(req, res, requestAttributes, getServletContext(), parameters);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {


		String user = (String)requestParameters.get("user");
		String pass = (String)requestParameters.get("pass");
		
		if (user == null || user.length()==0 || pass == null || pass.length()==0){
			showLogin(req,res,requestAttributes,servletContext,requestParameters);
		} else {
			doLogin(req,res,requestAttributes,servletContext,requestParameters,user, pass);
		}
		
	}

	private void doLogin(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters, String user, String pass) throws Exception {

		if (AdminUsers.getInstance(this.getClass()).validar(user, pass)){
			int userId = user.hashCode();
			Session s = SessionValidation.createAdminSession(userId, this.getClass());
			Cookie cookie = new Cookie("adminUser",s.toString());
			cookie.setPath("/");
			res.addCookie(cookie);
			
			View view = new WelcomeAdminView(req,res,requestAttributes,servletContext,requestParameters);
			view.execute();
		} else 
			showLogin(req,res,requestAttributes,servletContext,requestParameters);
		
	}

	private void showLogin(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		//Borro la cookie
		Cookie cookie = new Cookie("adminUser",null);
		cookie.setPath("/");
		res.addCookie(cookie);

		//Ejecuto la vista del login
		View view = new AdminLoginView(req,res,requestAttributes,servletContext,requestParameters);
		view.execute();
	}
	


}
class AdminUsers {
	private HashMap<String, String> users;

	private static AdminUsers instance = new AdminUsers();
	private AdminUsers() {
		users = new HashMap<String,String>();
		
		users.put("admin", "admin");
		users.put("manager", "manager");
	}
	public static AdminUsers getInstance(Class c) throws ForbiddenLoginClassException {
		if (!AdminLogin.class.equals(c)){
			throw new ForbiddenLoginClassException("Solo AdminLogin puede ver usuarios");
		}
		return instance;
	}
	public boolean validar(String usr, String pwd){
		String pass = users.get(usr.toLowerCase());
		if (pass == null || !pass.equals(pwd.toLowerCase())){
			return false;
		}
		
		return true;
	}
}