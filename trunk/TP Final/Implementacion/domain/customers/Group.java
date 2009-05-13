package domain.customers;

import java.util.Set;

import domain.auctions.Auction;
import domain.auctions.AuctionType;

public class Group implements Bidder {

	private Set<Auction> wonAuctions;

	public void bid() {
	}

	public void validateAuctionType(AuctionType type) throws Throwable {
		if (!type.equals(AuctionType.GROUP)) {
			// TODO: crear excepcion
			throw new Throwable();
		}
	}

	public Set<Auction> getWonAuctions() {
		return wonAuctions;
	}

	public boolean isAllowedToWin() {
		return getWonAuctions().isEmpty();
	}

	public void win(Auction auction) {
		this.wonAuctions.add(auction);
	};
}
