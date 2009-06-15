package api.web.mvc.view;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.text.LibTxt;

public abstract class BackEndHtmlView extends HtmlView {

	public BackEndHtmlView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void doHtmlMenu() {
	}
	@Override
	protected void doHtmlFooter() {
	}
	
	@Override
	protected void doHtmlBody() throws Exception {
		String html = HtmlCache.getHtml(relativePath, "./admin/main/AdminStructure");
		
		html = LibTxt.replace(html,"##ADMIN_NAME##",getAdminName());
		html = LibTxt.replace(html, "##ADMIN_MENU##", getAdminMenu());
		html = LibTxt.replace(html, "##ADMIN_CONTENT##", getContent());
		out.println(html);
		
	}


	protected abstract String getAdminName();
	protected abstract String getContent();

	protected final String getAdminMenu(){
		String html = HtmlCache.getHtml(relativePath, "./admin/main/AdminMenu");

		return html;
	}

}
