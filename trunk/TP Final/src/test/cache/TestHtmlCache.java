package test.cache;

import api.web.cache.HtmlCache;

public class TestHtmlCache {

	public static void main(String[] args) {

		String html = HtmlCache.getHtml("./", "BidHtml");

		System.out.println(html);
		System.out.println(HtmlCache.getInstance().getHitRatio());
		HtmlCache.getHtml("./", "BidHtml");
		System.out.println(HtmlCache.getInstance().getHitRatio());
		HtmlCache.getHtml("./", "BidHtml");
		System.out.println(HtmlCache.getInstance().getHitRatio());
		HtmlCache.getHtml("./", "BidHtml");
		System.out.println(HtmlCache.getInstance().getHitRatio());
		HtmlCache.getHtml("./", "BidHtml");
		System.out.println(HtmlCache.getInstance().getHitRatio());

	}
}
