package domain.auctions;

import java.util.Date;

import persistence.AuctionPersistor;

import domain.customers.Bidder;
import domain.customers.User;
import domain.exceptions.BidAlreadyInstanciatedException;
import domain.exceptions.BidException;
import domain.exceptions.IllegalBidAmountException;
import domain.exceptions.NotEnoughMembersInGroupForBidException;
import domain.querys.History;

/**
 * Las ofertas son una clase central para el modelo resuelto; es la interacción
 * más importante de los usuarios en los remates. Igualmente, se trata de una
 * simple transacción entre un {@link Bidder} y un {@link Auction}. Como tales,
 * quedan todas registradas en el historial de movimientos para ser consultados
 * eventualmente.
 */
public class Bid implements Comparable<Bid> {

	private Bidder owner;
	private int value;
	private Date occurrenceDate;
	private Auction auction;
	protected long bidId;
	

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
	 * @throws IllegalBidAmountException
	 *             La cantidad ofertada no coincide con la cantidad establecida
	 *             por el remate.
	 */
	public Bid(Bidder owner, Auction auction, int amountToBid)
			throws BidException {
		occurrenceDate = new Date();
		this.owner = owner;
		this.value = amountToBid;
		auction.takeNewBid(this);
		this.auction = auction;
		History.getInstance().addBid(this);
		if(auction.getType().equals(AuctionType.SINGLE)) {
			AuctionPersistor.getInstance().saveIncrementalAuction((IncrementalAuction)auction);
		}
		this.bidId = System.currentTimeMillis();
	}

	/**
	 * Devuelve el valor del remate, siendo el valor, la última cantidad
	 * ofertada o el valor base en caso de no haber ofertas
	 * 
	 * @return el valor actual del remate
	 */
	public final int getValue() {
		return value;
	}

	/**
	 * Devuelve el usuario responsable de la oferta
	 * 
	 * @return el usuario que construyó la oferta
	 */
	public final Bidder getOwner() {
		return owner;
	}

	public final Auction getAuction() {
		return auction;
	}

	/**
	 * Compara dos ofertas por su monto ofertado
	 * 
	 * @param anotherBid
	 * @return 0 if equals, -1 if this<another, 1 if this>another
	 */
	public int compareTo(Bid anotherBid) {
		int res = this.occurrenceDate.compareTo(anotherBid.getDate());
		if (res == 0) {
			return this.owner.compareTo(anotherBid.owner);
		}
		return res;
	}

	public Date getDate() {
		return this.occurrenceDate;
	}
	
	public long getBidId() {
		return this.bidId;
	}

	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto Bid
	 * que por algún motivo se haya quitado de la memoria
	 */
	private Bid() {
	}

	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto Bid
	 * que por algún motivo se haya quitado de la memoria
	 * 
	 * @param owner
	 *            the owner to set
	 */
	private void setOwner(Bidder owner) {
		this.owner = owner;
	}

	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto Bid
	 * que por algún motivo se haya quitado de la memoria
	 * 
	 * @param value
	 *            the value to set
	 */
	private void setValue(int value) {
		this.value = value;
	}

	/**
	 * @param auction
	 *            the auction to set
	 */
	private void setAuction(Auction auction) {
		this.auction = auction;
	}

	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto Bid
	 * que por algún motivo se haya quitado de la memoria
	 * 
	 * @param occurrenceDate
	 *            the occurrenceDate to set
	 */
	private void setOccurrenceDate(Date occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}

	/**
	 * 
	 * @param user
	 * @param auction
	 * @param points
	 * @param date
	 * @return
	 * @throws BidAlreadyInstanciatedException
	 */
	public static Bid buildExistantBid(User user, Auction auction, int points,
			Date date) throws BidAlreadyInstanciatedException {
		if (History.getInstance().haveBid(date, user)) {
			throw new BidAlreadyInstanciatedException();
		}
		Bid aBid = new Bid();
		aBid.setOwner(user);
		aBid.setAuction(auction);
		aBid.setOccurrenceDate(date);
		aBid.setValue(points);
		return aBid;
	}

}
