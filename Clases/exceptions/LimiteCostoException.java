package exceptions;

public class LimiteCostoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LimiteCostoException() {                 
		super();         
	}
	
	public LimiteCostoException(String razon) {                 
		super(razon);         
	}
	
	public LimiteCostoException(String razon,Throwable cause) {                 
		super(razon,cause);         
	}
}
