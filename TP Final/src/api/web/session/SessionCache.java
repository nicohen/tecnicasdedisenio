package api.web.session;

import java.util.HashMap;

import api.web.session.entities.Session;
import api.web.session.entities.SessionKey;


public class SessionCache {

	//singleton
	private static SessionCache instance = new SessionCache();
	private HashMap<SessionKey,Session> map;
	private HashMap<SessionKey,Session> adminMap;
	
	private SessionCache(){
		map = new HashMap<SessionKey,Session>();
		adminMap = new HashMap<SessionKey,Session>();
	}
	
	public static SessionCache getInstance(){ return instance; }
	
	public Session getSession(SessionKey sk){
		Session s = null;
		if (sk.getType().equals(SessionValidation.ADMIN_USER_SESSION)){
			s = adminMap.get(sk);
		} else if (sk.getType().equals(SessionValidation.END_USER_SESSION)){
			s = map.get(sk);
		}
		
		//TODO: cuando haya sesiones persistidas
		//if (s == null) loadSessionFromDisk
		
		return s;
	}
	
	public void addSession(SessionKey sk, Session s){
		if (sk.getType().equals(SessionValidation.ADMIN_USER_SESSION)){
			adminMap.put(sk,s);
		} else if (sk.getType().equals(SessionValidation.END_USER_SESSION)){
			map.put(sk,s);
		}

		//TODO Persistir la sesion en disco
		// saveSessionToDisk
	}
}
