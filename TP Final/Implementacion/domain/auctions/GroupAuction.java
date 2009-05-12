package domain.auctions;

import java.util.Stack;

import domain.customers.User;
import domain.products.Product;
import domain.utils.VariationRateFunction;
import dto.GroupAuctionDto;

public class GroupAuction extends IncrementalAuction {
	
	private Stack<Bid> bids;

	public GroupAuction(Product prize, VariationRateFunction varFunction) {
		super(prize, varFunction);
	}

	@Override
	public void finalizeAuction() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void takeNewBid(Bid aBid) {
		// TODO: Check that aBid's owner is a group
		super.takeNewBid(aBid);
	}
	
	public int createAuction(GroupAuctionDto auction) {
		// TODO Auto-generated method stub
		return 0;
	}

}
