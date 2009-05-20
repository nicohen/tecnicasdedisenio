package domain.exceptions;


public class NotEnoughMembersInGroupForBidException extends BidException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6493659878365746904L;

	public NotEnoughMembersInGroupForBidException(String message) {
		super(message);
	}
}
