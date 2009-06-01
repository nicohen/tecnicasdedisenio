package web.api.session.entities;

import web.api.session.SessionValidation;
import web.api.session.exception.ForbiddenLoginClassException;

public class Session {

	public long getExpiration() {
		return expiration;
	}

	public int getUserId() {
		return userId;
	}

	public String getType() {
		return type;
	}
	private int userId;
	private long expiration;
	private String type;
	
	public Session(Class loginClass, int userId, long expiration,String type) 
				throws ForbiddenLoginClassException {
		if (!(loginClass.equals(SessionValidation.class))){
			throw new ForbiddenLoginClassException("Quiso crear login desde class: "+loginClass.getName());
		}
		this.userId = userId;
		this.expiration = expiration;
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		return (type+"-"+userId).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null){
			return false;
		}
		Session s = (Session)obj;
		return this.userId == s.userId && this.type.equals(s.type);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return userId+"-"+expiration;
	}
}
