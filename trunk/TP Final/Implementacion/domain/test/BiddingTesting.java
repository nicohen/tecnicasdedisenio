package domain.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.IncrementalAuction;
import domain.customers.User;
import domain.products.Product;
import domain.utils.VariationRateFunction;


public class BiddingTesting {

	@Test
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
	@Test
	public void takeNewBidTest() {
		Date dateOfBirth = new Date();
		User aUser1 = new User(31733445, "Aníbal", "Lovaglio", dateOfBirth);
		User aUser2 = new User(31733445, "German", "Mendez", dateOfBirth);
		User aUser3 = new User(31733445, "Martin", "De luca", dateOfBirth);
		aUser1.addPoints(1000);
		aUser2.addPoints(1000);
		aUser3.addPoints(1000);
		Product prize = null;
		VariationRateFunction variationFunction= new VariationRateFunction(null);
		Auction anAuction = new IncrementalAuction(prize, AuctionType.SINGLE, variationFunction, 500);
		int temp= anAuction.getAmountForNextBid();
		aUser1.bid(anAuction);
		int temp2=anAuction.getAmountForNextBid();
		assertTrue(temp2>temp);
		
		aUser2.bid(anAuction);
		aUser3.bid(anAuction);
		
		assertTrue(aUser1.getPoints()== 1000);

	}
	
}
