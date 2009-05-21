package domain.customers;

import java.util.HashMap;
import java.util.Map;

public class Keys {
	private Map<String, Key> keyMap;
	//SINGLETON
	static private Keys keys = new Keys();
	
	private Keys(){
		this.keyMap = new HashMap<String, Key>();
	}
	public static Keys getInstance(){
		return keys;
	}
	
	public boolean containsKey(String code){
		return this.keyMap.containsKey(code);
	}
	
	public Key getKeyForExchange(String code){
		return this.keyMap.get(code);
	}
	public void addKey(String code, Key key){
		this.keyMap.put(code, key);
	}
}
