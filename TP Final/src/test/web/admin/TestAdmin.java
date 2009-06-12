package test.web.admin;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.mvc.controller.BackEndControllerServlet;
import api.web.mvc.view.View;

public class TestAdmin extends BackEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		// TODO Auto-generated method stub
		
		View view = new TestAdminView(req,res,requestAttributes,servletContext,requestParameters);
		
		view.execute();

	}

}
