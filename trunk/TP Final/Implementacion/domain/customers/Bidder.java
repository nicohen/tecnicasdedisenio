package domain.customers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.InvalidAuctionTypeException;
import domain.utils.BusinessRules;

public abstract class Bidder {

	protected int avaliablePoints;
	protected int compromisedPoints;
	protected Set<Auction> wonAuctions;

	/**
	 * Inicializa las estructuras necesarias para la implementación de un
	 * ofertante
	 * 
	 * @see Auction
	 */
	public Bidder() {
		this.wonAuctions = new HashSet<Auction>();
		this.avaliablePoints = 0;
		this.compromisedPoints = 0;
	}

	public int getPoints() {
		return this.avaliablePoints;
	}

	public void addPoints(int points) {
		this.avaliablePoints += points;
	}

	/**
	 * Descuenta los puntos pasados por parametro de la cuenta del ofertante
	 * 
	 * @param points
	 *            puntos utilizados
	 */
	public void spendPoints(int points) {
		if (this.avaliablePoints < points)
			throw new IllegalArgumentException();
		this.avaliablePoints -= points;
	}

	public List<Auction> getWonAuctions() {
		return new ArrayList<Auction>(this.wonAuctions);
	}

	abstract public void bid(Auction anAuction)
			throws InvalidAuctionTypeException, notEnoughPointsToBidException,
			NotEnoughMembersInGroupForBidException;

	/**
	 * Valida que el tipo de remate este permitido para el bidder
	 * 
	 * @param type
	 * 
	 * @see AuctionType
	 */
	abstract public void validateAuctionType(AuctionType type)
			throws InvalidAuctionTypeException;

	/**
	 * Indica si el ofertante puede ganar el remate
	 * 
	 */
	public boolean isAllowedToWin() {
		return getWonAuctions().size() < BusinessRules.BIDDER_MAX_WINS;
	}

	/**
	 * Devuelve los puntos al ofertante cuando su oferta es superada
	 * 
	 * @param overcameBid
	 * 
	 * @see Bid
	 */
	public void acknowledgeBidOvercame(Bid overcameBid) {
		this.avaliablePoints += overcameBid.getValue();
		this.compromisedPoints -= overcameBid.getValue();
	}

	/**
	 * 
	 * Se invoca cuando el ofertante gana el remate
	 * 
	 * @param auction
	 *            Remate ganado
	 * @param winnerBid
	 *            Oferta ganadora
	 * 
	 * @see Bid
	 * 
	 * @see Auction
	 */
	public void win(Auction auction, Bid winnerBid) {
		this.compromisedPoints -= winnerBid.getValue();
		this.wonAuctions.add(auction);
	}
}
