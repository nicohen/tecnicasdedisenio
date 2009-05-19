package domain.customers;

import java.util.Date;

import domain.querys.History;
import domain.querys.Transaction;

public class KeyExchange extends Transaction {

	private Key myKey;
	private User user;
	private int points;
	
	public KeyExchange(String code, User user) {
		super(new Date());
		this.user = user;
		myKey = Keys.getInstance().getKeyForExchange(code);
		History.getInstance().addKeyExchange(this);
	}
	
	public Key getKey(){
		return this.myKey;
	}
}
