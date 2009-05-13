package domain.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
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
		fail ("Not yet implemented");
	}
	
}
