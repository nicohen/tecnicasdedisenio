

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.domain.customers.Key;
import src.domain.customers.Keys;
import src.domain.customers.User;
import src.domain.exceptions.AlreadyUsedKeyException;
import src.domain.exceptions.NonExistentKeyException;

public class ExchangeKeyTest {
	private User aUser, anotherUser;
	@Before
	public void SetUp(){
		new Key("code1", 100);
		new Key("code2", 200);
		this.aUser = new User(31936280, "Agustina", "Bazzano");
		this.anotherUser = new User(31936281, "Agustin", "Bazzan");
	}
	
	@Test
	public void CreateKeysTest(){
		assertTrue(Keys.getInstance().containsKey("code1"));
		assertTrue(Keys.getInstance().containsKey("code2"));
	}
	
	@Test
	public void ExchangeCorrectKeyTest()throws Exception{
		
		aUser.exchangeKey("code1");
		assertTrue(aUser.getPoints()==100);
		
	}
	
	@Test(expected = NonExistentKeyException.class)
	public void ExchangeNonExistentKeyTest()throws Exception{
		
		aUser.exchangeKey("code3");
		assertTrue(aUser.getPoints()==0);
	}
	
	@Test(expected = AlreadyUsedKeyException.class)
	public void ExchangeAlreadyUsedKeyTest()throws Exception{
		
		aUser.exchangeKey("code1");
		assertTrue(aUser.getPoints()==100);
		anotherUser.exchangeKey("code1");
		assertTrue(anotherUser.getPoints()==0);
	}
}
