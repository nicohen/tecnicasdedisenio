package domain.customers;

public class GroupSizeExceededException extends Exception {
	
	public GroupSizeExceededException(String message) {
		super(message);
	}
}
