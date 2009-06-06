package api.web.session.entities;

import api.web.session.exception.ForbiddenLoginClassException;

public class AdminSession extends Session {

	@SuppressWarnings("unchecked")
	public AdminSession(Class loginClass, int userId, long expiration,
			String type) throws ForbiddenLoginClassException {
		super(loginClass, userId, expiration, type);
	}

}
