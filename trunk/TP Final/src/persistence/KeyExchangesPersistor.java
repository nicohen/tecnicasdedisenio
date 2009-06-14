package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import domain.customers.Key;
import domain.customers.KeyExchange;
import domain.customers.User;
import domain.persistenceInterface.KeyExchangePersistor;

public class KeyExchangesPersistor implements KeyExchangePersistor {

	private static KeyExchangesPersistor instance = null;

	private Map<Long, KeyExchange> exchanges;

	private KeyExchangesPersistor() {
		this.exchanges = new HashMap<Long, KeyExchange>();
	}

	public static KeyExchangesPersistor getKeyExchangesPersistorInstance() {
		if (KeyExchangesPersistor.instance == null) {
			KeyExchangesPersistor.instance = new KeyExchangesPersistor();
		}
		return KeyExchangesPersistor.instance;
	}

	@Override
	public void saveKeyExchange(KeyExchange keyExchange) {
		this.exchanges.put(keyExchange.getKeyExchangeId(), keyExchange);

	}

	@Override
	public KeyExchange getKeyExchangeForKey(final String key) {
		SearchSolver<KeyExchange> solver = new SearchSolver<KeyExchange>() {
			@Override
			public boolean getCondition(KeyExchange t) {
				return t.getKey().getCode().equals(key);
			}
		};
		return solver.solveUnique(exchanges);
	}

	@Override
	public KeyExchange getKeyExchangeForKey(final Key key) {
		SearchSolver<KeyExchange> solver = new SearchSolver<KeyExchange>() {
			@Override
			public boolean getCondition(KeyExchange t) {
				return t.getKey().equals(key);
			}
		};
		return solver.solveUnique(exchanges);
	}

	@Override
	public ArrayList<KeyExchange> getKeyExchangesForUser(final User user) {
		SearchSolver<KeyExchange> solver = new SearchSolver<KeyExchange>() {
			@Override
			public boolean getCondition(KeyExchange t) {
				return t.getUser().equals(user);
			}
		};
		return solver.solveCollection(exchanges);
	}

	@Override
	public ArrayList<KeyExchange> getKeyExchangesForUserBetweenDates(User user,
			Date dateSince, Date dateTo) {
		return null;
	}

	@Override
	public ArrayList<KeyExchange> getKeyExchangesForUserSinceDate(User user,
			Date dateSince) {
		return null;
	}

	public Map<Long, KeyExchange> getExchanges() {
		return exchanges;
	}
}
