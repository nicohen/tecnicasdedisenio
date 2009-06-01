package web.api.login.views;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.api.cache.HtmlCache;
import web.api.mvc.view.HtmlView;
import web.api.mvc.view.View;
import web.api.text.LibTxt;

public class LoginView extends HtmlView {

	public LoginView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,HashMap<String,Object> requestParameters) throws Exception {
		super(req, res, requestAttributes,requestParameters);
		
	}

	@Override
	protected void doHtmlBody() {
		String html = HtmlCache.getHtml("login/LoginView");
		String urlRedir = req.getRequestURI();
		String queryString = req.getQueryString();
		if (queryString != null && queryString.length()>0){
			urlRedir+="?"+ queryString;
		}
		html = LibTxt.replace(html, "##REDIR##", urlRedir);
		
		out.println(html);
	}



}
