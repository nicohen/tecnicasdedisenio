package customers.keyexchange.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BidderPersistor;
import persistence.KeysPersistor;
import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibWeb;
import domain.customers.Key;
import domain.customers.User;
import domain.exceptions.AlreadyUsedKeyException;

public class KeyExchangeView extends HtmlView {

	public KeyExchangeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);

	}

	@Override
	protected void doHtmlBody() {
		String html = HtmlCache.getHtml(relativePath,
				"customers/keyexchange/KeyExchange");

		if(!"".equals(LibWeb.getParameter(req, "points"))) {
			String userName = null;
			Cookie[] c = req.getCookies();
			for (int i = 0; i < c.length; i++) {
				if ("userName".equals(c[i].getName())) {
					userName = c[i].getValue();
				}
			}
	
			String key = LibWeb.getParameter(req, "points");
			KeysPersistor keyExchangesPersistor = KeysPersistor.getKeysPersistorInstance();

			try {
				Key keyExchange = keyExchangesPersistor.getKeyForAlphanumeric(key);
	
				if (keyExchange == null)
					out.println("Error, no se encuentra la clave ingresada en el sistema");
				else {
					User exchangingUser = BidderPersistor.getBidderPersistorInstance().getUser(userName);
					exchangingUser.addPoints(keyExchange.getPointsToExchange());
					BidderPersistor.getBidderPersistorInstance().saveUser(exchangingUser);
					out.println("Carga de puntos exitosa! Saldo actual:" + exchangingUser.getPoints());
				}
			} catch (AlreadyUsedKeyException e) {
				out.println("Error, la clave ["+key+"] ya fue utilizada anteriormente");
			}
		}
		out.println(html);
	}

}
