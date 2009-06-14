package domain.persistenceInterface;

import java.util.ArrayList;

import domain.auctions.Auction;
import domain.auctions.AuctionStatus;
import domain.auctions.IncrementalAuction;
import domain.auctions.Product;
import domain.auctions.ReverseAuction;
import domain.customers.Bidder;

public interface AuctionPersistor {

	public void saveAuction (Auction auction);
	public Auction getAuctionById (long id);
	
	public void saveIncrementalAuction(IncrementalAuction auction);

	public IncrementalAuction getIncrementalAuctionById(long auctionId);
	public ArrayList<IncrementalAuction> getIncrementalAuctions();
	public ArrayList<IncrementalAuction> getIncrementalAuctionsForStatus(AuctionStatus status);
	public ArrayList<IncrementalAuction> getIncrementalAuctionsForHighestBidder(Bidder bidder);
	public IncrementalAuction getIncrementalAuctionForWinner (Bidder bidder);
	public IncrementalAuction getIncrementalAuctionForPrize (Product prize);
	public IncrementalAuction getIncrementalAuctionForPrize (String prizeDescription);

	public void saveReverseAuction(ReverseAuction auction);
	
	public ReverseAuction getReverseAuctionById(long auctionId);
	public ArrayList<ReverseAuction> getReverseAuctions();
	public ArrayList<ReverseAuction> getReverseAuctionsForStatus(AuctionStatus status);
	public ReverseAuction getReverseAuctionForWinner (Bidder bidder);
	public ReverseAuction getReverseAuctionForPrize (Product prize);
	public ReverseAuction getReverseAuctionForPrize (String prizeDescription);
	
}
