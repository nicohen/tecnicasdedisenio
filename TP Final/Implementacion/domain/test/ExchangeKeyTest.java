package domain.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.customers.AlreadyUsedKeyException;
import domain.customers.Key;
import domain.customers.Keys;
import domain.customers.NonExistentKeyException;
import domain.customers.User;

public class ExchangeKeyTest {
	private Key key1 ,key2;
	private User aUser, anotherUser;
	@Before
	public void SetUp(){
		this.key1 = new Key("code1", 100);
		this.key2 = new Key("code2", 200);
		this.aUser = new User(31936280, "Agustina", "Bazzano");
		this.anotherUser = new User(31936281, "Agustin", "Bazzan");
	}
	
	@Test
	public void CreateKeysTest(){
		assertTrue(Keys.getInstance().containsKey("code1"));
		assertTrue(Keys.getInstance().containsKey("code2"));
	}
	
	@Test
	public void ExchangeCorrectKeyTest(){
		try {
			aUser.exchangeKey("code1");
			
		} catch (NonExistentKeyException e) {
			fail("Unexpected NonExistentKeyException");
		} catch (AlreadyUsedKeyException e) {
			fail("Unexpected AlreadyUsedKeyException");
		}
		assertTrue(aUser.getPoints()==100);
		
	}
	
	@Test
	public void ExchangeNonExistentKeyTest(){
		try {
			aUser.exchangeKey("code3");
			fail("NonExistentKeyException Expected");
		} catch (NonExistentKeyException e) {
			assertTrue(true);
		} catch (AlreadyUsedKeyException e) {
			fail("Unexpected AlreadyUsedKeyException");
		}
	}
	
	@Test
	public void ExchangeAlreadyUsedKeyTest(){
		try {
			aUser.exchangeKey("code1");
		} catch (NonExistentKeyException e) {
			fail("Unexpected NonExistentKeyException");
		} catch (AlreadyUsedKeyException e) {
			fail("Unexpected AlreadyUsedKeyException");
		}
		try {
			anotherUser.exchangeKey("code1");
			fail("AlreadyUsedKeyException Expected");
		} catch (NonExistentKeyException e) {
			fail("Unexpected NonExistentKeyException");
		} catch (AlreadyUsedKeyException e) {
			assertTrue(true);
		}
		assertTrue(aUser.getPoints()==100);
		assertTrue(anotherUser.getPoints()==0);
	}
}
