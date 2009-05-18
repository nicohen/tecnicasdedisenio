package domain.customers;

import java.util.Date;

import domain.querys.Transaction;

public class KeyExchange extends Transaction {

	private Key myKey;
	private User user;
	private int points;
	
	public KeyExchange(String code, User user) {
		super(new Date());
		this.user = user;
		//if(Keys.getInstance().containsKey(code))
		myKey = Keys.getInstance().getKeyForExchange(code);
		
	}
	
	public Key getKey(){
		return this.myKey;
	}
}
