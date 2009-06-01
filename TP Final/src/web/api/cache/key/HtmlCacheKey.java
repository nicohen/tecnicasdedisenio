package web.api.cache.key;

public class HtmlCacheKey extends CacheKey {

	public final static String FILE_PATH = "./files/html/";
	public final static String FILE_EXT = ".html";
	public final String fileName;
	
	public HtmlCacheKey(String filename) {
		this.fileName = filename;
	}

	
	public String getFullName(){
		return HtmlCacheKey.FILE_PATH + fileName + HtmlCacheKey.FILE_EXT;
	}
	
	@Override
	public boolean equals(Object obj) {
		HtmlCacheKey k = (HtmlCacheKey) obj;
		return this.fileName.equals(k.fileName);
	}

	@Override
	public int hashCode() {
		return this.fileName.hashCode();
	}

}
