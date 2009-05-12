package domain.auctions;

import domain.customers.User;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public class ReverseAuction extends Auction {
	
	
	
	public ReverseAuction(Product prize, VariationRateFunction varFunction) {
		super(prize, varFunction);
	}

	@Override
	public void takeNewBid(Bid aBid) {
		// TODO Auto-generated method stub
	}

	@Override
	public void finalizeAuction() {
		// TODO Auto-generated method stub
	}

}
