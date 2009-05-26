package domain.exceptions;

/**
 * Esta excepción se lanza cuando se quiere ofertar una cantidad inválida para
 * el remate en cuestión. La cantidad debe ser deteminada por el remate mismo
 * que es el que sabe como quiere que su precio progrese.
 */
@SuppressWarnings("serial")
public class IllegalBidAmountException extends BidException {

	public IllegalBidAmountException(String string) {
		super(string);
	}
}
