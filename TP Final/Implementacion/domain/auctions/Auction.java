package domain.auctions;

import domain.customers.Bidder;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public abstract class Auction {

	protected Product prize;
	protected Bidder winner;
	protected AuctionStatus status;
	protected VariationRateFunction variationRateFunction;

	public Auction(Product prize, VariationRateFunction varFunction) {
		this.prize = prize;
		this.variationRateFunction = varFunction;
		this.winner = null;
		this.status = AuctionStatus.ACTIVE;
	}

	public abstract void finish();

	public Bidder getWinner() {
		return winner;
	}

	public Product getPrize() {
		return this.prize;
	}

}