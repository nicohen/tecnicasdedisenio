package web.api.cache;

import java.util.HashMap;
import java.util.Map;

import web.api.cache.key.CacheKey;

public abstract class Cache<T> {

	Map<CacheKey, T> map;
	
	private long hits;
	private long total;
	
	protected Cache(){
		this.map = new HashMap<CacheKey,T>();
		this.hits = 0;
		this.total = 0;
	}
	
	public T get(CacheKey k){
		if (!map.containsKey(k)){
			query(k);
		} else {
			hits++;
		}
		
		T obj = map.get(k);
		total++;
		return obj;
	}
	protected abstract void query(CacheKey k);
	
	public double getHitRatio(){
		return (double)hits / (double)total;
	}
}
