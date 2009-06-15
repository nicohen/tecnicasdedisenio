package test.web.admin;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.mvc.view.BackEndHtmlView;

public class TestAdminView extends BackEndHtmlView {

	public TestAdminView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);

	}


	@Override
	protected String getAdminName() {
		return "Prueba de administrador";
	}

	@Override
	protected String getContent() {
		return "Logueado al administrador";
	}

}
