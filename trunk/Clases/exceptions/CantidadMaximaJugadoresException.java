
package exceptions;

public class CantidadMaximaJugadoresException extends Exception {
		
	private static final long serialVersionUID = 1L;
	
	public CantidadMaximaJugadoresException() {                 
		super();         
	}
	
	public CantidadMaximaJugadoresException(String razon) {                 
		super(razon);         
	}
	
	public CantidadMaximaJugadoresException(String razon,Throwable cause) {                 
		super(razon,cause);         
	}
	
}