package web.api.session.exception;

public class NotLoggedInException extends Exception {


	private static final long serialVersionUID = 7535409172065297029L;

	public NotLoggedInException(String s){
		super(s);
	}
	
	public NotLoggedInException(String s, Throwable t){
		super(s,t);
	}
}
