package test.web.bid;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;


public class BidHtmlView extends HtmlView {

	public BidHtmlView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,ServletContext servletContext, HashMap<String,Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
	}

	@Override
	protected void doHtmlBody() {

		out.println(HtmlCache.getHtml(relativePath,"BidHtml"));

	}

}
