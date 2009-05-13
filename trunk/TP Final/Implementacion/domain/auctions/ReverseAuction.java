package domain.auctions;

import domain.products.Product;
import domain.utils.VariationRateFunction;

public class ReverseAuction extends Auction {

	public ReverseAuction(Product prize, VariationRateFunction varFunction) {
		super(prize, varFunction);
	}

	@Override
	public void finish() {
	}

}
