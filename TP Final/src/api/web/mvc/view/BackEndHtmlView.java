package api.web.mvc.view;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


}
