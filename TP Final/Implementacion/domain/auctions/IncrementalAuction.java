package domain.auctions;

import java.util.Stack;

import domain.customers.Bidder;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public class IncrementalAuction extends Auction {

	private Stack<Bid> bids;
	private AuctionType type;

	public IncrementalAuction(Product prize, AuctionType type,
			VariationRateFunction varFunction) {
		super(prize, varFunction);
		this.bids = new Stack<Bid>();
		this.type = type;
	}

	public void takeNewBid(Bid newBid) {
		try {
			newBid.getOwner().validateAuctionType(getType());
			Bid bestBid = this.bids.peek();
			if (newBid.compareTo(bestBid) < 1)
				// TODO: poner exepcion mas copada!
				throw new IllegalArgumentException();
			this.bids.push(newBid);
		} catch (Throwable e) {
			// TODO: ver manejo de exepcion
		}

	}

	public void finish() {
		while (this.status.equals(AuctionStatus.ACTIVE) && !this.bids.isEmpty()) {
			Bid bid = this.bids.peek();
			Bidder bidder = bid.getOwner();
			if (bidder.isAllowedToWin()) {
				this.status = AuctionStatus.CLOSED;
				this.winner = bidder;
				bidder.win(this);
				// TODO: restar puntos
			}
		}
	};

	public AuctionType getType() {
		return type;
	}
}