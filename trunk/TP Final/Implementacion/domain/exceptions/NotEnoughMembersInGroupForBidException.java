package domain.exceptions;

@SuppressWarnings("serial")
public class NotEnoughMembersInGroupForBidException extends BidException {

	public NotEnoughMembersInGroupForBidException(String message) {
		super(message);
	}
}
