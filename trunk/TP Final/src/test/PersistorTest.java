package test;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.KeyExchangesPersistor;
import domain.customers.Key;
import domain.customers.KeyExchange;
import domain.customers.User;
import domain.querys.History;

public class PersistorTest {

	private static User aUser, anotherUser;
	@SuppressWarnings("unused")
	private static Key k1, k2 ,k3, k4, k5, k6;
	private static KeyExchangesPersistor persistor;
	
	@BeforeClass
	public static void SetUp() throws Exception{
		k1 = new Key("code10", 100);
		k2 = new Key("code20", 200);
		k3 = new Key("code30", 300);
		k4 = new Key("code40", 400);
		k5 = new Key("code50", 500);
		k6 = new Key("code60", 600);
		
		aUser = new User(31936280, "Agustina", "Bazzano", null, null, null, null);
		anotherUser = new User(31936281, "Agustin", "Bazzan", null, null, null, null);
		
		aUser.exchangeKey("code10");
		Thread.sleep(100);
		aUser.exchangeKey("code20");
		Thread.sleep(100);
		aUser.exchangeKey("code30");
		Thread.sleep(100);
		aUser.exchangeKey("code40");
		Thread.sleep(100);
		anotherUser.exchangeKey("code50");
		Thread.sleep(100);
		anotherUser.exchangeKey("code60");
		
		persistor = KeyExchangesPersistor.getKeyExchangesPersistorInstance();
		List<KeyExchange> exchanges = History.getInstance().getKeyExchanges();
		Iterator<KeyExchange> it = exchanges.iterator();
		while(it.hasNext()){
			persistor.saveKeyExchange(it.next());
		}
	}
	@Test
	public void saveKeyExchangeKeyTest(){
		
		assertTrue(persistor.getExchanges().values().size()>= 6);
	}
	
	@Test
	public void getExchangesForUserTest(){
		assertTrue(persistor.getKeyExchangesForUser(aUser).size()==4);
		assertTrue(persistor.getKeyExchangesForUser(anotherUser).size()==2);
	}
	@Test
	public void getExchangesForKeyByString(){
		User donor1 = persistor.getKeyExchangeForKey("code10").getUser();
		User donor2 = persistor.getKeyExchangeForKey("code60").getUser();
		assertTrue(donor1.equals(aUser));
		assertTrue(donor2.equals(anotherUser));
	}
	@Test
	public void getExchangesForKeyByKey(){
		User donor1 = persistor.getKeyExchangeForKey(k1).getUser();
		User donor2 = persistor.getKeyExchangeForKey(k6).getUser();
		assertTrue(donor1.equals(aUser));
		assertTrue(donor2.equals(anotherUser));
	}
}
