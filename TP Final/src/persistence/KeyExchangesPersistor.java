package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domain.customers.Key;
import domain.customers.KeyExchange;
import domain.customers.User;
import domain.persistenceInterface.KeyExchangePersistor;

public class KeyExchangesPersistor implements KeyExchangePersistor {

	private static KeyExchangesPersistor instance=null;
	
	private Map<Long, KeyExchange> exchanges;
	
	private KeyExchangesPersistor (){
		this.exchanges = new HashMap<Long, KeyExchange>();
	}
	
	public static KeyExchangesPersistor getKeyExchangesPersistorInstance(){
		if(KeyExchangesPersistor.instance==null){
			KeyExchangesPersistor.instance = new KeyExchangesPersistor();
		}
		return KeyExchangesPersistor.instance;
	}
	@Override
	public KeyExchange getKeyExchangeForKey(String key) {
		Iterator<Long> it = this.exchanges.keySet().iterator();
		KeyExchange k = null;
		boolean flag = true;
		while(it.hasNext()&& flag){
			k= this.exchanges.get(it.next());
			if(k.getKey().getCode().equals(key))
				flag = false;
		}
		return k;
	}

	@Override
	public KeyExchange getKeyExchangeForKey(Key key) {
		Iterator<Long> it = this.exchanges.keySet().iterator();
		KeyExchange k = null;
		boolean flag = true;
		while(it.hasNext()&& flag){
			k= this.exchanges.get(it.next());
			if(k.getKey().equals(key))
				flag = false;
		}
		return k;
	}

	@Override
	public ArrayList<KeyExchange> getKeyExchangesForUser(User user) {
		ArrayList<KeyExchange> keyEchangesForUser = new ArrayList<KeyExchange>();
		Iterator<Long> it = this.exchanges.keySet().iterator();
		while(it.hasNext()){
			KeyExchange k= this.exchanges.get(it.next());
			if(k.getUser().equals(user))
				keyEchangesForUser.add(k);
		}
		return keyEchangesForUser;
	}

	@Override
	public ArrayList<KeyExchange> getKeyExchangesForUserBetweenDates(User user,
			Date dateSince, Date dateTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KeyExchange> getKeyExchangesForUserSinceDate(User user,
			Date dateSince) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveKeyExchange(KeyExchange keyExchange) {
		this.exchanges.put(keyExchange.getKeyExchangeId(), keyExchange);
		
	}

}
