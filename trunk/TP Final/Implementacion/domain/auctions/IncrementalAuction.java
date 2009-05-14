package domain.auctions;

import java.util.Stack;

import domain.customers.Bidder;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public class IncrementalAuction extends Auction {

	protected int nextBidValue;
	private Stack<Bid> bids;
	private AuctionType type;

	public IncrementalAuction(Product prize, AuctionType type,
			VariationRateFunction varFunction, int startUpValue) {
		super(prize, varFunction, 0);
		this.bids = new Stack<Bid>();
		this.type = type;
		this.nextBidValue = startUpValue;
	}

	public void takeNewBid(Bid newBid) {

		try {
			newBid.getOwner().validateAuctionType(getType());
		} catch (Throwable e) {

		}
		if (!this.bids.isEmpty()) {// para el caso de no ser la primer oferta
			Bid bestBid = this.bids.peek();
			if (newBid.compareTo(bestBid) < 1)
				// TODO: poner exepcion mas copada!
				throw new IllegalArgumentException();
		}
		this.bids.push(newBid);
		this.value = this.nextBidValue;
		// this.nextBidValue += this.variationRateFunction.nextDelta();
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

	@Override
	public int getAmountForNextBid() {
		return this.nextBidValue;
	}
}