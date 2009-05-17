package domain.auctions;

import domain.customers.Bidder;
import domain.customers.NotEnoughMembersInGroupForBidException;
import domain.utils.VariationRateFunction;

public abstract class Auction {

	protected Product prize;
	protected Bidder winner;
	protected AuctionStatus status;
	protected VariationRateFunction variationRateFunction;
	protected int value;
	protected AuctionType type;

	public Auction(Product prize, VariationRateFunction varFunction,
			AuctionType type, int startUpValue) {
		this.prize = prize;
		this.variationRateFunction = varFunction;
		this.winner = null;
		this.status = AuctionStatus.ACTIVE;
		this.value = startUpValue;
		this.type = type;
	}

	public abstract void finish();

	public abstract int getAmountForNextBid();

	/*package visibility*/ 
	abstract void takeNewBid(Bid newBid) throws NotEnoughMembersInGroupForBidException;

	public Bidder getWinner() {
		return winner;
	}

	public Product getPrize() {
		return this.prize;
	}

	public AuctionStatus getStatus() {
		return status;
	}

	public AuctionType getType() {
		return type;
	}
}