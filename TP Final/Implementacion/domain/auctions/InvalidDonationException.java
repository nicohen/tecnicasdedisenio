package domain.auctions;

/**
 * Excepci�n lanzada cuando un usuario pretende hacer una donaci�n y est�
 * imposibilitado por motivos como falta de puntos, o la no pertenencia a un
 * grupo.
 */
public class InvalidDonationException extends Exception {

	private static final long serialVersionUID = 8050900526083204314L;

	public InvalidDonationException(String message) {
		super(message);
	}
}
