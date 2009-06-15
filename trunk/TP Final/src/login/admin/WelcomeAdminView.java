package login.admin;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.mvc.view.BackEndHtmlView;

public class WelcomeAdminView extends BackEndHtmlView {

	public WelcomeAdminView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);

	}

	@Override
	protected String getContent() {
		return "<div style='font-family: Arial; font-size:24px; font-weight:bold;'>Bienvenido a los administradores de La Rematada</div>";

	}

	@Override
	protected String getAdminName() {
		return "Administradores de La Rematada";
	}

}
