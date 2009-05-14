package domain.customers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.InvalidAuctionTypeException;

public abstract class Bidder {

	protected int points;
	protected Set<Auction> wonAuctions;

	public Bidder() {
		this.wonAuctions = new HashSet<Auction>();
	}

	public int getPoints() {
		return this.points;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public void spendPoints(int points) {
		if (this.points < points)
			throw new IllegalArgumentException();
		this.points -= points;
	}

	public List<Auction> getWonAuctions() {
		return new ArrayList<Auction>(this.wonAuctions);
	}

	abstract public void bid(Auction anAuction);

	/**
	 * Valida que el tipo de remate este permitido para el bidder
	 * 
	 * @param type
	 */
	abstract public void validateAuctionType(AuctionType type)
			throws InvalidAuctionTypeException;

	public boolean isAllowedToWin() {
		return getWonAuctions().isEmpty();
	}

	public void win(Auction auction) {
		// TODO: restar puntos!
		this.wonAuctions.add(auction);
	}

}
