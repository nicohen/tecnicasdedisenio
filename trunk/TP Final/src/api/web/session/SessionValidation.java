package api.web.session;

import login.admin.AdminLogin;
import api.web.session.entities.Session;
import api.web.session.entities.SessionKey;
import api.web.session.exception.ForbiddenLoginClassException;

public class SessionValidation {

	public static long DAY_MILLIS = 24 * 60 * 60 * 1000;
	public static String END_USER_SESSION = "USER";
	public static String ADMIN_USER_SESSION = "ADMIN";
	
	
	public static Session createSession(int userId) throws Exception {
		long time = System.currentTimeMillis();
		long expTime = time + SessionValidation.DAY_MILLIS;
		
		Session sess = new Session(SessionValidation.class,userId, expTime, SessionValidation.END_USER_SESSION);
		
		addSession(sess);
		
		return sess;
	}

	public static Session createAdminSession(int userId, Class c) throws Exception {
		if (!c.equals(AdminLogin.class)){
			throw new ForbiddenLoginClassException("Intento crear una sesion de administrador desde "+c.getName());
		}
		long time = System.currentTimeMillis();
		long expTime = time + SessionValidation.DAY_MILLIS;
		
		Session sess = new Session(SessionValidation.class,userId, expTime, SessionValidation.ADMIN_USER_SESSION);
		
		addSession(sess);
		
		return sess;
		
	}

	private static void addSession(Session sess) {
		SessionCache.getInstance().addSession(new SessionKey(sess.getUserId(),sess.getType()),sess);
	}
	
	private static boolean validate(int userId, long hash, String type){
		Session s = SessionCache.getInstance().getSession(new SessionKey(userId,type));
		
		if (s == null){
			return false;
		}
		if (hash != s.getExpiration()){
			return false;
		}
		long actTime = System.currentTimeMillis();
		if (s.getExpiration()<actTime){
			return false;
		}
		
		return true;		
	}
	
	public static boolean validateSession(int userId, long hash){
		return validate(userId,hash,SessionValidation.END_USER_SESSION);
	}
	public static boolean validateAdminSession(int userId, long hash){
		return validate(userId,hash,SessionValidation.ADMIN_USER_SESSION);
	}
}
