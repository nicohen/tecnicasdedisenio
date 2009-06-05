package test.cache;

import api.web.cache.HtmlCache;
import api.web.cache.key.HtmlCacheKey;

public class TestHtmlCache {

	public static void main(String[] args) {
		
		String html = HtmlCache.getHtml("./","BidHtml");
		
		System.out.println(html);
		System.out.println(HtmlCache.getInstance().getHitRatio());
		HtmlCache.getHtml("./","BidHtml");
		System.out.println(HtmlCache.getInstance().getHitRatio());
		HtmlCache.getHtml("./","BidHtml");
		System.out.println(HtmlCache.getInstance().getHitRatio());
		HtmlCache.getHtml("./","BidHtml");
		System.out.println(HtmlCache.getInstance().getHitRatio());
		HtmlCache.getHtml("./","BidHtml");
		System.out.println(HtmlCache.getInstance().getHitRatio());

	}
}
