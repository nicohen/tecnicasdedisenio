package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import domain.customers.Donation;
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
	
	public KeyExchangesPersistor getKeyExchangesPersistorInstance(){
		if(KeyExchangesPersistor.instance==null){
			KeyExchangesPersistor.instance = new KeyExchangesPersistor();
		}
		return KeyExchangesPersistor.instance;
	}
	@Override
	public KeyExchange getKeyExchangeForKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeyExchange getKeyExchangeForKey(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KeyExchange> getKeyExchangesForUser(User user) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

}
