package exceptions;

public class JugadorInexistenteException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public JugadorInexistenteException() {                 
		super();         
	}
	
	public JugadorInexistenteException(String razon) {                 
		super(razon);         
	}
	
	public JugadorInexistenteException(String razon,Throwable cause) {                 
		super(razon,cause);         
	}
}
