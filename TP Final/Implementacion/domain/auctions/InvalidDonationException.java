package domain.auctions;

@SuppressWarnings("serial")
public class InvalidDonationException extends RuntimeException {

	public InvalidDonationException(String message) {
		super(message);
	}
}
