package persistence;

import java.util.HashMap;
import java.util.Map;

import domain.customers.Key;
import domain.persistenceInterface.KeyPersistor;

public class KeysPersistor implements KeyPersistor {

	private static KeysPersistor instance = null;

	private Map<Long, Key> keys;

	private KeysPersistor() {
		this.keys = new HashMap<Long, Key>();
	}

	public static KeysPersistor getKeysPersistorInstance() {
		if (KeysPersistor.instance == null) {
			KeysPersistor.instance = new KeysPersistor();
		}
		return KeysPersistor.instance;
	}
	
	@Override
	public Key getKeyForAlphanumeric(final String alphanumeric) {
		SearchSolver<Key> solver = new SearchSolver<Key>() {
			@Override
			public boolean getCondition(Key t) {
				return t.getCode().equals(alphanumeric);
			}
		};
		return solver.solveUnique(keys);
	}

	@Override
	public void saveKey(Key key) {
		this.keys.put(key.getKeyId(), key);
	}

}
