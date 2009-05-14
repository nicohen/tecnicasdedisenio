package domain.auctions;

@SuppressWarnings("serial")
public class InvalidAuctionTypeException extends RuntimeException {

	public InvalidAuctionTypeException(String message) {
		super(message);
	}
}
