package domain.auctions;

public class InvalidAuctionTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 767557248614268924L;

	public InvalidAuctionTypeException(String message) {
		super(message);
	}
}
