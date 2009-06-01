package web.api.session.entities;

import web.api.session.SessionValidation;
import web.api.session.exception.ForbiddenLoginClassException;

public class AdminSession extends Session{

	
	public AdminSession(Class loginClass, int userId, long expiration,String type) 
				throws ForbiddenLoginClassException {
		super(loginClass, userId, expiration,type);
	}

}
