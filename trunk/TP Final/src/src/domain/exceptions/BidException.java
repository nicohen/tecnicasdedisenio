package src.domain.exceptions;

@SuppressWarnings("serial")
public class BidException extends Exception {

	public BidException(String message) {
		super(message);
	}

	public BidException() {
		super();
	}
}
