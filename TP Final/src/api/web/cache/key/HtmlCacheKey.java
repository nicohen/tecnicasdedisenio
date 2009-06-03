package api.web.cache.key;

public class HtmlCacheKey extends CacheKey {

	public final static String FILE_PATH = "./files/html/";
	public final static String FILE_EXT = ".html";
	public final String fileName;
	public final String relativePath;
	
	public HtmlCacheKey(String relativePath, String filename) {
		this.fileName = filename;
		this.relativePath = relativePath;
	}

	
	public String getFullName(){
		return this.relativePath + HtmlCacheKey.FILE_PATH + fileName + HtmlCacheKey.FILE_EXT;
	}
	
	@Override
	public boolean equals(Object obj) {
		HtmlCacheKey k = (HtmlCacheKey) obj;
		return this.fileName.equals(k.fileName);
	}

	@Override
	public int hashCode() {
		return (this.relativePath+this.fileName).hashCode();
	}

}
