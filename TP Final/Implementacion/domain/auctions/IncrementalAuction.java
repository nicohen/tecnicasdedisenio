package domain.auctions;

import java.util.Stack;

import domain.customers.Bidder;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public class IncrementalAuction extends Auction {

	private int nextBidValue;
	private Stack<Bid> bids;

	public IncrementalAuction(Product prize, AuctionType type,
			VariationRateFunction varFunction, int startUpValue) {
		super(prize, varFunction, type, 0);
		this.bids = new Stack<Bid>();
		this.nextBidValue = startUpValue;
	}

	public void takeNewBid(Bid newBid) throws InvalidBidException {
		try {
			newBid.getOwner().validateAuctionType(getType());
			// para la primera oferta
			if (!this.bids.isEmpty()) {
				Bid bestBid = this.bids.peek();
				if (newBid.compareTo(bestBid) < 1) {
					throw new InvalidBidException(
							"El valor de la oferta debe superar "
									+ bestBid.getValue());
				}
			}
			this.bids.push(newBid);
			this.value = this.nextBidValue;
		} catch (InvalidAuctionTypeException e) {
			e.printStackTrace();
		}
	}

	public void finish() {
		this.status = AuctionStatus.CLOSED;
		boolean finish = false;
		while (!finish && !this.bids.isEmpty()) {
			Bid bid = this.bids.peek();
			Bidder bidder = bid.getOwner();
			if (bidder.isAllowedToWin()) {
				this.winner = bidder;
				bidder.win(this);
				finish = true;
			}
		}
	};

	@Override
	public int getAmountForNextBid() {
		return this.nextBidValue;
	}
}