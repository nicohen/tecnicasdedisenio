package admin.keys.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.BackEndHtmlView;

public class AdminKeyGeneratorFormView extends BackEndHtmlView {

	public AdminKeyGeneratorFormView(HttpServletRequest req,
			HttpServletResponse res, HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
	}

	@Override
	protected String getAdminName() {
		// TODO Auto-generated method stub
		return "Generador automatico de claves";
	}

	@Override
	protected String getContent() {
		String html = HtmlCache.getHtml(relativePath, "./admin/keys/KeyGeneratorForm");
		return html;
	}

}
