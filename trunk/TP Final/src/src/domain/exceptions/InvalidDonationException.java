package src.domain.exceptions;

/**
 * Esta excepci�n se lanza cuando un usuario pretende hacer una donaci�n y est�
 * imposibilitado por motivos como falta de puntos, o la no pertenencia a un
 * grupo.
 */
@SuppressWarnings("serial")
public class InvalidDonationException extends Exception {
	public InvalidDonationException(String message) {
		super(message);
	}
}
