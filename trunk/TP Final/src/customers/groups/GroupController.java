package customers.groups;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customers.groups.views.GroupView;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;

public class GroupController extends FrontEndControllerServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		View view = new GroupView(req, res, requestParameters, servletContext, requestParameters);
		view.execute();
	}

}
