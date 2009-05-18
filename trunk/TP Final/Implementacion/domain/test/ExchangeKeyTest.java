package domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.customers.Key;
import domain.customers.Keys;

public class ExchangeKeyTest {

	@Test
	public void CreateKeysTest(){
		Key key1 = new Key("code1", 100);
		//Key key2 = new Key("code2", 200);
		assertTrue(Keys.getInstance().containsKey("code1"));
	}
}
