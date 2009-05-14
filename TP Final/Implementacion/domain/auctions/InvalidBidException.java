package domain.auctions;

@SuppressWarnings("serial")
public class InvalidBidException extends RuntimeException {

	public InvalidBidException(String message) {
		super(message);
	}
}
