package customers.keyexchange.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BidderPersistor;
import persistence.KeyExchangesPersistor;
import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;
import domain.customers.KeyExchange;
import domain.customers.User;

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

		String userName = null;
		Cookie[] c = req.getCookies();
		for (int i = 0; i < c.length; i++) {
			if ("userName".equals(c[i].getName())) {
				userName = c[i].getValue();
			}
		}

		String key = (String) requestParameters.get("key");
		KeyExchangesPersistor keyExchangesPersistor = KeyExchangesPersistor
				.getKeyExchangesPersistorInstance();
		try {
			KeyExchange keyExchange = keyExchangesPersistor
					.getKeyExchangeForKey(key);

			if (keyExchange == null)
				html = LibTxt.replace(html, "##RESULT##","Error, no se encuentra la clave ingresada en el sistema");
			else {
				User exchangingUser = BidderPersistor.getBidderPersistorInstance().getUser(userName);
				exchangingUser.addPoints(keyExchange.getPoints());
				BidderPersistor.getBidderPersistorInstance().saveUser(exchangingUser);
				html = LibTxt.replace(html, "##RESULT##","Carga de puntos exitosa! Saldo actual:" + exchangingUser.getPoints() );
			}
		} catch (Exception e) {
			html = LibTxt.replace(html, "##RESULT##","Error en carga de puntos");
		}

		out.println(html);
	}

}
