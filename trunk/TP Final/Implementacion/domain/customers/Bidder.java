package domain.customers;

import java.util.HashSet;
import java.util.Set;

import domain.auctions.Auction;
import domain.auctions.AuctionType;

public abstract class Bidder {
	private int points;
	private Set<Auction> wonAuctions;
	
	public Bidder(){
		this.wonAuctions = new HashSet<Auction>();
	}
	
	public int getPoints(){
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
	public Set<Auction> getWonAuctions() {
		return  new HashSet<Auction>(this.wonAuctions);
	}
	
	abstract public void bid(Auction anAuction);

	/**
	 * Valida que el tipo de remate este permitido para el bidder
	 * 
	 * @param type
	 */
	abstract public void validateAuctionType(AuctionType type) throws Throwable; // TODO: throw tiene que tirar una excepción mucho más definida

	public boolean isAllowedToWin() {
		return getWonAuctions().isEmpty();
	}

	public void win(Auction auction) {
		//TODO: restar puntos!
		this.wonAuctions.add(auction);
	}
	
}
