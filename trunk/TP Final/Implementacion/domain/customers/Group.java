package domain.customers;

import java.util.HashSet;
import java.util.Set;

import domain.auctions.Auction;
import domain.auctions.AuctionType;

public class Group implements Bidder {

	private Set<Auction> wonAuctions;

	public void bid(Auction anAuction) {
		
	}

	public void validateAuctionType(AuctionType type) throws Throwable {
		if (!type.equals(AuctionType.GROUP)) {
			// TODO: crear excepcion
			throw new Throwable();
		}
	}

	public Set<Auction> getWonAuctions() {
		return  new HashSet<Auction>(this.wonAuctions);
	}

	public boolean isAllowedToWin() {
		return getWonAuctions().isEmpty();
	}

	public void win(Auction auction) {
		this.wonAuctions.add(auction);
	};
}
