/**
 * 
 */
package domain.persistenceInterface;

import domain.customers.Key;

/**
 *
 */
public interface KeyPersistor {

	public Key getKeyForAlphanumeric (String alphanumeric);
	public void saveKey(Key key);
}
