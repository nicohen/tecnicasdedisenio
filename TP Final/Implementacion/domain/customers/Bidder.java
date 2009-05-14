package domain.customers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.InvalidAuctionTypeException;

public abstract class Bidder {

	protected int avaliablePoints;
	protected int compromisedPoints;
	protected Set<Auction> wonAuctions;

	public Bidder() {
		this.wonAuctions = new HashSet<Auction>();
		this.avaliablePoints=0;
		this.compromisedPoints=0;
	}

	public int getPoints() {
		return this.avaliablePoints;
	}

	public void addPoints(int points) {
		this.avaliablePoints += points;
	}

	public void spendPoints(int points) {
		if (this.avaliablePoints < points)
			throw new IllegalArgumentException();
		this.avaliablePoints -= points;
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

	public void acknowledgeBidOvercame(Bid overcameBid) {
		this.avaliablePoints += overcameBid.getValue();
		this.compromisedPoints -= overcameBid.getValue();
	}
	
	public void win(Auction auction, Bid winnerBid) {
		this.compromisedPoints -= winnerBid.getValue();
		this.wonAuctions.add(auction);
	}

}
