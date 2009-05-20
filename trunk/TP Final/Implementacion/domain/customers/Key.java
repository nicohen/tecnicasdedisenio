package domain.customers;

import domain.exceptions.AlreadyUsedKeyException;

public class Key {

	private String code;
	private int points;
	private boolean used;
	
	public Key(String code, int points){
		this.code = code;
		this.points = points;
		this.used = false;
		//add a KEYS
		Keys.getInstance().addKey(code, this);
	}
	public int getPointsToExchange() throws AlreadyUsedKeyException {
		if (!used){
			this.used = true;
			return this.points;
		}else
			throw new AlreadyUsedKeyException();
	}

}
