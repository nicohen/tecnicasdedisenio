package customers.registration.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;


public class RegistrationView extends HtmlView {

	public RegistrationView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes, ServletContext servletContext, HashMap<String,Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext,requestParameters);
		
	}

	@Override
	protected void doHtmlBody() {
		String html = HtmlCache.getHtml(relativePath,"registration/RegistrationView");
		String urlRedir = (String)requestParameters.get("urlredir"); 
		if (urlRedir == null || urlRedir.length()==0){
			urlRedir = req.getRequestURI();

			String queryString = req.getQueryString();
			if (queryString != null && queryString.length()>0){
				urlRedir+="?"+ queryString;
			}
		}
		//TODO: ver que onda esto
		//html = LibTxt.replace(html, "##REDIR##", urlRedir);
		
		out.println(html);
	}

}
