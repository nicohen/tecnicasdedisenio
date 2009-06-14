package api.web.mvc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.admin.views.AdminExceptionView;
import api.web.mvc.view.View;
import api.web.session.SessionValidation;
import api.web.session.exception.InvalidSessionAccessException;
import api.web.session.exception.NotLoggedInException;


/**
 * Controller abstracto para las paginas del estilo back-end
 * @author mgonzalez
 *
 */
public abstract class BackEndControllerServlet extends
		AbstractControllerServlet {

	private static final long serialVersionUID = 3415759297132343885L;

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse res) {
		//Atributos del request
		HashMap<String,Object> requestAttributes = new HashMap<String, Object>();
		
		HashMap<String,Object> parameters = loadRequestParameters(req);
		requestAttributes.put("parameters", parameters);
		
		//Contexto
		
		//carga de Cookies
		HashMap<String, String> cookies = loadCookies(req); 
		requestAttributes.put("cookies", cookies);
		
		
		//validacion de sesion
		try {
			validateAdminSession(cookies);
			
			executeView(req,res,requestAttributes,getServletContext(), parameters);
			return;
		} catch (Exception e){

			try {//Si llego aca es porque tengo que mostrar una vista de exception.
				View view = new AdminExceptionView(req,res,requestAttributes,getServletContext(),parameters);
				((AdminExceptionView) view).setAdminException(e);	
				view.execute();
			} catch (Exception finalE){
				System.out.println("Error, no pudo mostrarse la view de AdminException");
			}
		}
		


	}


	private void validateAdminSession(HashMap<String, String> cookies) 
			throws Exception{
		
		String adminCookie = (String)cookies.get("adminUser");
		if (adminCookie == null){
			throw new NotLoggedInException("Not logged in.");
		}
		String [] login = adminCookie.split("-");
		
		if (login.length<2){
			throw new NotLoggedInException("Not logged in.");
		}
		int userId = Integer.parseInt(login[0]);
		long hash = Long.parseLong(login[1]);

		if (!SessionValidation.validateAdminSession(userId, hash)){
			throw new InvalidSessionAccessException("Invalid user/password for user: "+userId);
		}
		
	}




}
