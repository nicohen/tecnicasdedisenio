package api.web.session.exception;

public class ForbiddenLoginClassException extends Exception {


	private static final long serialVersionUID = 7535409172065297029L;

	public ForbiddenLoginClassException(String s){
		super(s);
	}
	
	public ForbiddenLoginClassException(String s, Throwable t){
		super(s,t);
	}
}
