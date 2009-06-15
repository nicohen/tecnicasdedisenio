package customers;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customers.views.CustomerMenuView;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import bid.views.BidView;

@SuppressWarnings("serial")
public class CustomerMenuController extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		View view = new CustomerMenuView(req,res,requestAttributes,servletContext,requestParameters);
		
		view.execute();

	}

	@Override
	protected boolean getValidated(HttpServletRequest req) {
		return true;
	}
}
