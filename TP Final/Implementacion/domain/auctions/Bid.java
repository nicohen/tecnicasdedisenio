package domain.auctions;

import java.util.Date;

import domain.customers.Bidder;
import domain.customers.NotEnoughMembersInGroupForBidException;
import domain.querys.History;
import domain.querys.Transaction;

/**
 * Las ofertas son una clase central para el modelo resuelto; es la interacción
 * más importante de los usuarios en los remates. Igualmente, se trata de una
 * simple transacción entre un {@link Bidder} y un {@link Auction}. Como tales,
 * quedan todas registradas en el historial de movimientos para ser consultados
 * eventualmente.
 */
public class Bid extends Transaction {

	private Bidder owner;
	private int value;

	/**
	 * Construye la transacción de ofertar registrando los cambios necesarios en
	 * los usuarios involucrados, el remate y el historial.
	 * 
	 * @param owner
	 *            usuario postor
	 * @param auction
	 *            remate sobre el cual se oferta
	 * @param amountToBid
	 *            monto a ofertar
	 * @throws NotEnoughMembersInGroupForBidException
	 *             Un grupo que no tiene miembros estará inhabilitado para
	 *             ofertar
	 * @throws IllegalBidAmount
	 *             La cantidad ofertada no coincide con la cantidad establecida
	 *             por el remate.
	 */
	public Bid(Bidder owner, Auction auction, int amountToBid)
			throws NotEnoughMembersInGroupForBidException, IllegalBidAmount {
		super(new Date());
		this.owner = owner;
		this.value = amountToBid;
		auction.takeNewBid(this);
		History.getInstance().addBid(this);
	}

	/**
	 * Devuelve el usuario responsable de la oferta
	 * 
	 * @return el usuario que construyó la oferta
	 */
	public Bidder getOwner() {
		return owner;
	}

	/**
	 * Devuelve el valor del remate, siendo el valor, la última cantidad
	 * ofertada o el valor base en caso de no haber ofertas
	 * 
	 * @return el valor actual del remate
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Compara dos ofertas por su monto ofertado
	 * 
	 * @param anotherBid
	 * @return 0 if equals, -1 if this<another, 1 if this>another
	 */
	public int compareTo(Bid anotherBid) {
		int res = 0;
		if (this.value < anotherBid.value)
			res = -1;
		if (this.value > anotherBid.value)
			res = 1;
		return res;
	}
}
