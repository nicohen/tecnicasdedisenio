package api.web.mvc.controller;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.login.views.LoginView;
import api.web.mvc.view.View;
import api.web.session.SessionValidation;


/**
 * Controller abstracto para las paginas estilo Front-end.
 * @author mgonzalez
 *
 */
public abstract class FrontEndControllerServlet extends AbstractControllerServlet {

	private static final long serialVersionUID = -8973262686871954774L;

	protected void execute(HttpServletRequest req, HttpServletResponse res) {
		
		//Atributos del request
		HashMap<String,Object> requestAttributes = new HashMap<String, Object>();
		
		HashMap<String,Object> parameters = loadRequestParameters(req);
		requestAttributes.put(AbstractControllerServlet.PARAMETERS, parameters);
		
		//Contexto
		
		//carga de Cookies
		HashMap<String, String> cookies = loadCookies(req); 
		requestAttributes.put(AbstractControllerServlet.COOKIES, cookies);

		try {
			//validacion de sesion
			if (getValidated(req)){
				boolean sessionValidated = validateSession(cookies);
				
				if (!sessionValidated){
					showLoginView(req, res,requestAttributes, getServletContext(), parameters);
					return;
				}
			}
			executeView(req,res,requestAttributes,getServletContext(),parameters);
		} catch (Exception e){
			showExceptionView(req,res, requestAttributes, e);
		}

	}
	
	private void showLoginView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,ServletContext servletContext, HashMap<String,Object> requestParameters) throws Exception {
		View view = new LoginView(req,res,requestAttributes, servletContext, requestParameters);
		
		view.execute();
	}

	private void showExceptionView(HttpServletRequest req,
			HttpServletResponse res, HashMap<String, Object> requestAttributes, Exception e) {
		try { 
			PrintWriter w = res.getWriter();
			w.println("Exception:");
			StackTraceElement []stacks = e.getStackTrace();
			w.println(e);
			for (StackTraceElement stack : stacks){
				w.println(stack);
			}
			e.printStackTrace();
		}catch (Exception we){
			System.out.println("Error fatal, no puede escribir en Response");
		}
		
	}

	protected abstract void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes, ServletContext servletContext, HashMap<String,Object> requestParameters) throws Exception;

	private boolean validateSession(HashMap<String, String> cookies) {
		String userCookie = (String)cookies.get("user");
		
		if (userCookie == null){
			return false;
		}
		String [] login = userCookie.split("-");
		int userId = Integer.parseInt(login[0]);
		long hash = Long.parseLong(login[1]);
		return SessionValidation.validateSession(userId,hash);
	}

	/**
	 * Segun el request, dice si debe validarse la sesion 
	 * @param req
	 * @return por default = false, o sobreescribir metodo.
	 */
	protected boolean getValidated(HttpServletRequest req){
		return false;
	}

}
