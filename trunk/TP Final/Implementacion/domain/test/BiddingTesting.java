package domain.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.IncrementalAuction;
import domain.customers.User;
import domain.products.Product;
import domain.utils.VariationRateFunction;


public class BiddingTesting {

	public void bidOnIncrementAuctionTest(){
		Date dateOfBirth = new Date();
		User aUser = new User(31733445, "Aníbal", "Lovaglio", dateOfBirth);
		aUser.addPoints(15000);
		Product prize = null;
		VariationRateFunction variationFunction=null;
		Auction anAuction = new IncrementalAuction(prize, AuctionType.SINGLE, variationFunction, 1000);
		aUser.bid(anAuction);
		assertTrue(anAuction.getAmountForNextBid()>1000);
	}

	public void takeNewBidTest() {
		Date dateOfBirth = new Date();
		User aUser1 = new User(31733445, "Aníbal", "Lovaglio", dateOfBirth);
		User aUser2 = new User(31733445, "German", "Mendez", dateOfBirth);
		User aUser3 = new User(31733445, "Martin", "De luca", dateOfBirth);
		aUser1.addPoints(1000);
		aUser2.addPoints(1000);
		aUser3.addPoints(1000);
		
		Product prize = null;
		VariationRateFunction variationFunction=null;
		Auction anAuction = new IncrementalAuction(prize, AuctionType.SINGLE, variationFunction, 500);
		
		Bid myBid1 = new Bid(aUser1, 200);
		anAuction.takeNewBid(myBid1);
		
		Bid myBid2= new Bid(aUser2, 400);
		anAuction.takeNewBid(myBid2);
		
		Bid myBid3 = new Bid(aUser3, 600);
		anAuction.takeNewBid(myBid3);
		assertTrue(aUser3.getPoints()== 400);
		assertTrue(aUser1.getPoints()== 200);
		
		//fail ("Not yet implemented");
	}
	
}
