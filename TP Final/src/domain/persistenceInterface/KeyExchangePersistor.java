/**
 * 
 */
package domain.persistenceInterface;

import java.util.ArrayList;
import java.util.Date;

import domain.customers.Key;
import domain.customers.KeyExchange;
import domain.customers.User;

/**
 *
 */
public interface KeyExchangePersistor {

	public ArrayList<KeyExchange> getKeyExchangesForUser(User user);
	public ArrayList<KeyExchange> getKeyExchangesForUserSinceDate(User user, Date dateSince);
	public ArrayList<KeyExchange> getKeyExchangesForUserBetweenDates(User user, Date dateSince, Date dateTo);
	
	public KeyExchange getKeyExchangeForKey(String key);
	public KeyExchange getKeyExchangeForKey(Key key);
	
	public void saveKeyExchange(KeyExchange keyExchange);
}
