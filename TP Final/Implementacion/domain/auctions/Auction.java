package domain.auctions;

import domain.customers.Bidder;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public abstract class Auction {

	protected Product prize;
	protected Bidder winner;
	protected AuctionStatus status;
	protected VariationRateFunction variationRateFunction;
	protected int value;
	protected AuctionType type;

	public Auction(Product prize, VariationRateFunction varFunction, int startUpValue) {
		this.prize = prize;
		this.variationRateFunction = varFunction;
		this.winner = null;
		this.status = AuctionStatus.ACTIVE;
		this.value = startUpValue;
	}

	public abstract void finish();
	public abstract int getAmountForNextBid();
	public abstract void takeNewBid(Bid newBid);

	public Bidder getWinner() {
		return winner;
	}

	public Product getPrize() {
		return this.prize;
	}

	public AuctionType getType() {
		return type;
	}


}