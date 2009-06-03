package api.web.session.exception;

public class InvalidSessionAccessException extends Exception {


	private static final long serialVersionUID = 7535409172065297029L;

	public InvalidSessionAccessException(String s){
		super(s);
	}
	
	public InvalidSessionAccessException(String s, Throwable t){
		super(s,t);
	}
}
