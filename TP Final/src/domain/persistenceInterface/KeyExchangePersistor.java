/**
 * 
 */
package domain.persistenceInterface;

import java.util.Date;

import domain.customers.Key;
import domain.customers.KeyExchange;
import domain.customers.User;

/**
 *
 */
public interface KeyExchangePersistor {

	public KeyExchange[] getKeyExchangesForUser(User user);
	public KeyExchange[] getKeyExchangesForUserSinceDate(User user, Date dateSince);
	public KeyExchange[] getKeyExchangesForUserBetweenDates(User user, Date dateSince, Date dateTo);
	
	public KeyExchange getKeyExchangeForKey(String key);
	public KeyExchange getKeyExchangeForKey(Key key);
	
	public void saveKeyExchange(KeyExchange keyExchange);
}
