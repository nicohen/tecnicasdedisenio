package exceptions;

public class JugadoresPorPosicionException extends Exception {
		
	private static final long serialVersionUID = 1L;
	
	public JugadoresPorPosicionException() {                 
		super();         
	}
	
	public JugadoresPorPosicionException(String razon) {                 
		super(razon);         
	}
	
	public JugadoresPorPosicionException(String razon,Throwable cause) {                 
		super(razon,cause);         
	}
	
}
