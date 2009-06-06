package api.web.cache;

import api.web.cache.key.CacheKey;
import api.web.cache.key.HtmlCacheKey;
import api.web.files.InputTextFile;

public class HtmlCache extends Cache<String> {

	// Singleton
	private static HtmlCache instance;

	private HtmlCache() {
		super();
	}

	public static HtmlCache getInstance() {
		if (instance == null)
			instance = new HtmlCache();
		return instance;
	}

	@Override
	protected void query(CacheKey k) {
		StringBuffer html = new StringBuffer();
		HtmlCacheKey htmlKey = (HtmlCacheKey) k;

		InputTextFile file = new InputTextFile(htmlKey.getFullName());

		try {
			while (file.next()) {
				html.append(file.getLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(k, html.toString());
	}

	public static String getHtml(String relativePath, String html) {
		HtmlCache cache = HtmlCache.getInstance();

		return cache.get(new HtmlCacheKey(relativePath, html));
	}

}
