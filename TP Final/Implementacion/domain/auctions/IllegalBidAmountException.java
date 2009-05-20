package domain.auctions;

/**
 * Esta excepción se lanza cuando se quiere ofertar una cantidad inválida para
 * el remate en cuestión. La cantidad debe ser deteminada por el remate mismo
 * que es el que sabe como quiere que su precio progrese.
 */
public class IllegalBidAmountException extends Exception {

	public IllegalBidAmountException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 4022952046702823175L;

}
