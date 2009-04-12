package exceptions;

public class ValidationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ValidationException() {                 
		super();         
	}
	
	public ValidationException(String razon) {                 
		super(razon);         
	}
	
	public ValidationException(String razon,Throwable cause) {                 
		super(razon,cause);         
	}
}
