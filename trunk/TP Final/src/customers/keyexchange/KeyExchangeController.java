package customers.keyexchange;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import customers.keyexchange.views.KeyExchangeView;

@SuppressWarnings("serial")
public class KeyExchangeController extends FrontEndControllerServlet {

	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		
		
			
			View view = new KeyExchangeView(req, res, requestAttributes,
					servletContext, requestParameters);
			view.execute();
		}
	
	
	private boolean exchangeKey(String key) {
		
		
		return false;
	}
	
	private void redirToUrl(HttpServletResponse res,
			HashMap<String, Object> requestParameters) throws Exception {
		String urlRedir = (String) requestParameters.get("urlredir");
		res.sendRedirect(urlRedir);
	}
	
	@Override
	protected boolean getValidated(HttpServletRequest req) {
		return true;
	}

}
