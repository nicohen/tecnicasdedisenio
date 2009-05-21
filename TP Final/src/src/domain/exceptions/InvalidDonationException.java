package src.domain.exceptions;

/**
 * Esta excepción se lanza cuando un usuario pretende hacer una donación y está
 * imposibilitado por motivos como falta de puntos, o la no pertenencia a un
 * grupo.
 */
@SuppressWarnings("serial")
public class InvalidDonationException extends Exception {
	public InvalidDonationException(String message) {
		super(message);
	}
}
