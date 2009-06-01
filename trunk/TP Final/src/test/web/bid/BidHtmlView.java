package test.web.bid;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.api.cache.HtmlCache;
import web.api.cache.key.HtmlCacheKey;
import web.api.mvc.view.HtmlView;

public class BidHtmlView extends HtmlView {

	public BidHtmlView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,HashMap<String,Object> requestParameters) throws Exception {
		super(req, res, requestAttributes,requestParameters);
	}

	@Override
	protected void doHtmlBody() {

		out.println(HtmlCache.getHtml("BidHtml"));

	}

}
