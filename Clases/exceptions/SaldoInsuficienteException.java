package exceptions;

public class SaldoInsuficienteException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficienteException() {                 
		super();         
	}
	
	public SaldoInsuficienteException(String razon) {                 
		super(razon);         
	}
	
	public SaldoInsuficienteException(String razon,Throwable cause) {                 
		super(razon,cause);         
	}
}
