package domain.persistenceInterface;

import java.util.ArrayList;

import domain.auctions.AuctionStatus;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.customers.Bidder;

public interface IncrementalAuctionPersistor {

	public void saveIncrementalAuction(IncrementalAuction auction);

	public IncrementalAuction getIncrementalAuctionById(long auctionId);
	public ArrayList<IncrementalAuction> getIncrementalAuctions();
	public ArrayList<IncrementalAuction> getIncrementalAuctionsForStatus(AuctionStatus status);
	public ArrayList<IncrementalAuction> getIncrementalAuctionsForHighestBidder(Bidder bidder);
	public IncrementalAuction getIncrementalAuctionForWinner (Bidder bidder);
	
	public IncrementalAuction getIncrementalAuctionForPrize (Product prize);
	public IncrementalAuction getIncrementalAuctionForPrize (String prizeDescription);

}
