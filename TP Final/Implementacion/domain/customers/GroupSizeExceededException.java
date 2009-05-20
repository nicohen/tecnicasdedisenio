package domain.customers;

@SuppressWarnings("serial")
public class GroupSizeExceededException extends Exception {

	public GroupSizeExceededException(String message) {
		super(message);
	}
}
