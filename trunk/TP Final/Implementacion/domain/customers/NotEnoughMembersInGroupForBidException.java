package domain.customers;

public class NotEnoughMembersInGroupForBidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6493659878365746904L;

	public NotEnoughMembersInGroupForBidException(String message) {
		super(message);
	}
}
