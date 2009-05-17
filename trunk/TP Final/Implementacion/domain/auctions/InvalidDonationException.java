package domain.auctions;

public class InvalidDonationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8050900526083204314L;

	public InvalidDonationException(String message) {
		super(message);
	}
}
