package api.web.login.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;


public class LoginView extends HtmlView {

	public LoginView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes, ServletContext servletContext, HashMap<String,Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext,requestParameters);
		
	}

	@Override
	protected void doHtmlBody() {
		String html = HtmlCache.getHtml(relativePath,"login/LoginView");
		String urlRedir = req.getRequestURI();
		String queryString = req.getQueryString();
		if (queryString != null && queryString.length()>0){
			urlRedir+="?"+ queryString;
		}
		html = LibTxt.replace(html, "##REDIR##", urlRedir);
		
		out.println(html);
	}

}
