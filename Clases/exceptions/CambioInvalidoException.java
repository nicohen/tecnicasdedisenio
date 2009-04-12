package exceptions;

public class CambioInvalidoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CambioInvalidoException() {                 
		super();         
	}
	
	public CambioInvalidoException(String razon) {                 
		super(razon);         
	}
	
	public CambioInvalidoException(String razon,Throwable cause) {                 
		super(razon,cause);         
	}
}
