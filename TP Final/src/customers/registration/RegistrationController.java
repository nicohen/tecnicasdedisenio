package customers.registration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BidderPersistor;
import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import customers.registration.views.RegistrationView;
import domain.customers.User;

@SuppressWarnings("serial")
public class RegistrationController extends FrontEndControllerServlet {

	private HashMap<String,Object> validationErrors=new HashMap<String,Object>();
	
	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		validationErrors.clear();
		
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
			
			Collection<Object> c = this.validationErrors.values();
			Iterator<Object> itr = c.iterator();
			String errors = "";
			while(itr.hasNext()){
				errors+=itr.next() + "-";
			}
			requestParameters.put("errors", errors);
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
		
		if((user==null) && (password==null)){
			return false;
		}
			
		
		if (user == null || user.length() == 0){
			this.validationErrors.put("user", "Por favor, ingrese un nombre de usuario");
		}
		else{
			if(BidderPersistor.getBidderPersistorInstance().getUser(user)!=null){
				this.validationErrors.put("user", "El usuario ingresado ya existe");
			}
		}
		
		if (password == null || password.length() < 6){
			this.validationErrors.put("password", "El password debe poseer 6 o mas caracteres");
		}	
		
		if (this.validationErrors.size()==0)
			return true;
		else
			return false;
	}

}
