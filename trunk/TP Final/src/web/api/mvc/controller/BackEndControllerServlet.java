package web.api.mvc.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.api.session.SessionValidation;
import web.api.session.exception.InvalidSessionAccessException;
import web.api.session.exception.NotLoggedInException;

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
		} catch (NotLoggedInException nlie){
//			showLoginView(req, res);
		} catch (InvalidSessionAccessException isae){
//			showInvalidAccessView(req, res)
		} catch (Exception e){
//			showGeneralAdminLoginErrorView(req, res);
		}
		
		//validacion de sesion
		//permiso de administracion

	}

	private void validateAdminSession(HashMap<String, String> cookies) 
			throws Exception{
		String [] login = ((String)cookies.get("adminuser")).split("-");
		int userId = Integer.parseInt(login[0]);
		long hash = Long.parseLong(login[1]);

		SessionValidation.validateAdminSession(userId, hash);
		
	}




}
