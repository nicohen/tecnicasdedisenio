package test.web.bid;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.api.mvc.controller.FrontEndControllerServlet;
import web.api.mvc.view.View;

public class BidControllerServlet extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,HashMap<String,Object> requestParameters) throws Exception {


		View view = new BidHtmlView(req,res,requestAttributes,requestParameters);

		view.execute();
	}

	@Override
	protected boolean getValidated(HttpServletRequest req) {
		return true;
	}
}
