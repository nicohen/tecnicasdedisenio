package domain.exceptions;

/**
 * Esta excepci�n se lanza cuando se pide alg�n postor y este no existe. Puede
 * ser el caso en que se pida el mejor postor en un remate, y que este no tenga
 * ofertas hechas, por lo que no va a tener postores
 */
public class NoBiddersException extends Exception {

	private static final long serialVersionUID = -8743323919556713196L;

}
