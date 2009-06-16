package customers.keyexchange;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BidderPersistor;
import persistence.KeyExchangesPersistor;

import api.web.mvc.controller.FrontEndControllerServlet;
import api.web.mvc.view.View;
import customers.keyexchange.views.KeyExchangeView;
import domain.customers.KeyExchange;
import domain.customers.User;

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
	
//	private boolean exchangeKey(HttpServletRequest req,String key) {
//		
//		KeyExchangesPersistor persistor= KeyExchangesPersistor.getKeyExchangesPersistorInstance();
//		String userName="";
//		
//		Cookie[] c = req.getCookies();
//		for(int i=0;i<c.length;i++) {
//			if("userName".equals(c[i].getName())) {
//				userName = c[i].getValue();
//			}
//		}
//		User user = BidderPersistor.getBidderPersistorInstance().getUser(userName);
//		KeyExchange exchange=persistor.getKeyExchangeForKey(key);
//		if (exchange!=null){
//			user.addPoints(exchange.getPoints());
//			persistor.saveKeyExchange(exchange);
//			return true;
//		}
//		else
//			return false;
//	}
//	
//	private void redirToUrl(HttpServletResponse res,
//			HashMap<String, Object> requestParameters) throws Exception {
//		String urlRedir = (String) requestParameters.get("urlredir");
//		res.sendRedirect(urlRedir);
//	}
//	
	@Override
	protected boolean getValidated(HttpServletRequest req) {
		return true;
	}

}
