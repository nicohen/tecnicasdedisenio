package domain.persistenceInterface;

import java.util.ArrayList;

import domain.auctions.AuctionStatus;
import domain.auctions.Product;
import domain.auctions.ReverseAuction;
import domain.customers.Bidder;

public interface ReverseAuctionPersistor {

	public void saveReverseAuction(ReverseAuction auction);
	
	public ReverseAuction getReverseAuctionById(long auctionId);
	public ArrayList<ReverseAuction> getReverseAuctions();
	public ArrayList<ReverseAuction> getReverseAuctionsForStatus(AuctionStatus status);
	public ReverseAuction getReverseAuctionForWinner (Bidder bidder);
	public ReverseAuction getReverseAuctionForPrize (Product prize);
	public ReverseAuction getReverseAuctionForPrize (String prizeDescription);
	
}
