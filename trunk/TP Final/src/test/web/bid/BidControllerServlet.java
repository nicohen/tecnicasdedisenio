package test.web.bid;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;

@SuppressWarnings("serial")
public class BidControllerServlet extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		View view = new BidHtmlView(req, res, requestAttributes,
				servletContext, requestParameters);

		view.execute();
	}

	@Override
	protected boolean getValidated(HttpServletRequest req) {
		return true;
	}
}
