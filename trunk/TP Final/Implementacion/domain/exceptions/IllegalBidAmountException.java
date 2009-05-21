package domain.exceptions;

/**
 * Esta excepci�n se lanza cuando se quiere ofertar una cantidad inv�lida para
 * el remate en cuesti�n. La cantidad debe ser deteminada por el remate mismo
 * que es el que sabe como quiere que su precio progrese.
 */
@SuppressWarnings("serial")
public class IllegalBidAmountException extends BidException {

	public IllegalBidAmountException(String string) {
		super(string);
	}
}
