package domain.persistanceInterface;

import domain.auctions.AuctionStatus;
import domain.auctions.Product;
import domain.auctions.ReverseAuction;
import domain.customers.Bidder;

public interface ReverseAuctionPersistor {

	public void saveReverseAuction(ReverseAuction auction);
	
	public ReverseAuction getReverseAuctionById(long auctionId);
	public ReverseAuction[] getReverseAuctions();
	public ReverseAuction[] getReverseAuctionsForStatus(AuctionStatus status);
	public ReverseAuction getReverseAuctionForWinner (Bidder bidder);
	public ReverseAuction getReverseAuctionForPrize (Product prize);
	public ReverseAuction getReverseAuctionForPrize (String prizeDescription);
	
}
