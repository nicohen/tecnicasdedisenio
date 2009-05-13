package domain.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import domain.auctions.Auction;
import domain.auctions.AuctionStatus;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.IncrementalAuction;
import domain.auctions.ReverseAuction;
import domain.customers.User;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public class FinishAuctionTest {

	@Test
	public void finishReverseAuction(){
		Date dateOfBirth = new Date();
		User aUser = new User(31733445, "Aníbal", "Lovaglio", dateOfBirth);
		aUser.addPoints(15000);
		Product prize = null;
		VariationRateFunction variationFunction=null;
		int value = 1000;
		Auction anReverseAuction = new ReverseAuction(prize, variationFunction, value);
		Bid myBid = new Bid(aUser, value);
		anReverseAuction.takeNewBid(myBid);//aca adentro se llama al finish
		
		assertTrue(anReverseAuction.getStatus().equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}
	
	@Test
	public void finishIncrementalAuction(){
		Date dateOfBirth = new Date();
		User aUser = new User(31733445, "Aníbal", "Lovaglio", dateOfBirth);
		aUser.addPoints(15000);
		Product prize = null;
		VariationRateFunction variationFunction=null;
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize, AuctionType.SINGLE, variationFunction, value);
		Bid myBid = new Bid(aUser, value);
		anIncrementalAuction.takeNewBid(myBid);//HAY Q COMENTAR EL CALCULO DEL nextBidValue para q ande este test, por ahora..
		anIncrementalAuction.finish();
		
		assertTrue(anIncrementalAuction.getStatus().equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}
}
