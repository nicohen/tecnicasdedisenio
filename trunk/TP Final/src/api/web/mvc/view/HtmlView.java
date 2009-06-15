package api.web.mvc.view;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.text.LibTxt;


public abstract class HtmlView extends WebView {


	public HtmlView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String,Object> requestAttributes,ServletContext servletContext, HashMap<String,Object> requestParameters) throws Exception {
		super(req,res,requestAttributes,servletContext, requestParameters);
	}

	@Override
	protected void doHtmlFooter() {
		out.println(HtmlCache.getHtml(relativePath,"FooterDefault"));
	}

	@Override
	protected void doHtmlHeader() {
		out.println(HtmlCache.getHtml(relativePath,"HtmlHeaderDefault"));
	}

	@Override
	protected void doHtmlMenu() {
		String menu = HtmlCache.getHtml(relativePath,"MenuDefault");
		menu=LibTxt.replace(menu, "##LOGO##","files/images/logo.jpg");
		out.println(LibTxt.replace(menu, "##MATE##","files/images/mate.jpg"));
	}

}
