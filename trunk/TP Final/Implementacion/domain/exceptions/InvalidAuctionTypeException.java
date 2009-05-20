package domain.exceptions;

/**
 * Esta excepción se lanza cuando un Bidder trata de ofetar en un remate que no
 * le corresponde, como podría ser un usuario en un remate grupal
 */
public class InvalidAuctionTypeException extends Exception {

	private static final long serialVersionUID = 767557248614268924L;

	public InvalidAuctionTypeException(String message) {
		super(message);
	}
}
