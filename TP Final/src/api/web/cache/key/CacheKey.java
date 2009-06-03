package api.web.cache.key;

public abstract class CacheKey {

	@Override
	public abstract int hashCode();
	@Override
	public abstract boolean equals(Object obj);
}
