package domain.persistanceInterface;

import domain.auctions.AuctionStatus;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.customers.Bidder;

public interface IncrementalAuctionPersistor {

	public void saveIncrementalAuction(IncrementalAuction auction);

	public IncrementalAuction getIncrementalAuctionById(long auctionId);
	public IncrementalAuction[] getIncrementalAuctions();
	public IncrementalAuction[] getIncrementalAuctionsForStatus(AuctionStatus status);
	public IncrementalAuction[] getIncrementalAuctionsForHighestBidder(Bidder bidder);
	public IncrementalAuction getIncrementalAuctionForWinner (Bidder bidder);
	
	public IncrementalAuction getIncrementalAuctionForPrize (Product prize);
	public IncrementalAuction getIncrementalAuctionForPrize (String prizeDescription);

}
