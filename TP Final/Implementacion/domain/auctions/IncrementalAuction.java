package domain.auctions;

import java.util.Stack;

import domain.products.Product;
import domain.utils.VariationRateFunction;

public abstract class IncrementalAuction extends Auction {

	protected Stack<Bid> bids;

	public abstract void finalizeAuction();

	public IncrementalAuction(Product prize, VariationRateFunction varFunction) {
		super(prize, varFunction);
	}

	@Override
	public void takeNewBid(Bid aBid) {
		Bid bestBid = this.bids.peek();
		if (aBid.compareTo(bestBid) < 1) throw new IllegalArgumentException(); // TODO: se debería poner alguna excepción más descriptiva
		this.bids.push(aBid);
	}

}