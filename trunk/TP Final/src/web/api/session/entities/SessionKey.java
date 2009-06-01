package web.api.session.entities;

public class SessionKey {
	private int userId;
	private String type;
	
	public SessionKey(int userId, String type) {
		super();
		this.userId = userId;
		this.type = type;
	}
	
	public int getUserId() {
		return userId;
	}

	public String getType() {
		return type;
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
		SessionKey s = (SessionKey)obj;
		return this.userId == s.userId && this.type.equals(s.type);
	}
	
}
