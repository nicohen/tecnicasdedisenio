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
	public Key saveKey(Key key);
}
