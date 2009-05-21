package domain.exceptions;

/**
 * Esta excepci�n se lanza cuando un Bidder trata de ofetar en un remate que no
 * le corresponde, como podr�a ser un usuario en un remate grupal
 */
@SuppressWarnings("serial")
public class InvalidAuctionTypeException extends Exception {
	public InvalidAuctionTypeException(String message) {
		super(message);
	}
}
