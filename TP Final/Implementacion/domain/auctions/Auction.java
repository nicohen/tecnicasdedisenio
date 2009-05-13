package domain.auctions;

import java.util.Set;

import domain.customers.User;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public abstract class Auction {

	private Product prize;
	private User winner;
	private Set<Bid> bids;

	protected VariationRateFunction variationRateFunction;

	public Auction(Product prize, VariationRateFunction varFunction) {
		this.prize = prize;
		this.variationRateFunction = varFunction;
		this.winner = null;
	}

	public abstract void finalizeAuction();

	public abstract void takeNewBid(Bid aBid);

	public User getWinner() {
		return this.getWinner();
	}

	public Product getPrize() {
		return this.prize;
	}

}