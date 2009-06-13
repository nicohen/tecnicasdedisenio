package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.customers.Key;
import domain.customers.Keys;
import domain.customers.User;
import domain.exceptions.AlreadyUsedKeyException;
import domain.exceptions.NonExistentKeyException;

public class ExchangeKeyTest {
	private User aUser, anotherUser;
	@Before
	public void SetUp(){
		new Key("code1", 100);
		new Key("code2", 200);
		this.aUser = new User(31936280, "Agustina", "Bazzano", null, null, null, null);
		this.anotherUser = new User(31936281, "Agustin", "Bazzan", null, null, null, null);
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
