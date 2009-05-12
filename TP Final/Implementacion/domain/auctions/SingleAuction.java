package domain.auctions;

import java.util.Stack;

import domain.customers.User;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public class SingleAuction extends IncrementalAuction {
	
	public SingleAuction (Product product, VariationRateFunction varFunction){
		super(product, varFunction);
		this.bids = new Stack<Bid> ();
	}
	
	@Override
	public void takeNewBid(Bid aBid) {
		// TODO: Check that aBid's owner is a user
		super.takeNewBid(aBid);
	}
	
	@Override
	public void finalizeAuction() {
		// TODO Auto-generated method stub
	}

}
