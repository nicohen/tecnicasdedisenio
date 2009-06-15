package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import persistence.AuctionPersistorImplementation;

import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.customers.Key;
import domain.customers.User;
import domain.utils.VariationRateFunction;

public class AuctionsForBidderTest {

	private AuctionPersistorImplementation persistor;
	private IncrementalAuction ia1, ia2;
	private User aUser, anotherUser;
	private VariationRateFunction variationFunction;
	@SuppressWarnings("unused")
	private Key k1, k2;
	
	@Before
	public void setUp() throws Exception{
		persistor = AuctionPersistorImplementation.getInstance();
		k1 = new Key("code1", 30000);
		k2 = new Key("code2", 40000);
		variationFunction = new VariationRateFunction(
				null);
		ia1= new IncrementalAuction(null, AuctionType.SINGLE, variationFunction, 100);
		Thread.sleep(100);
		ia2 = new IncrementalAuction(null, AuctionType.SINGLE, variationFunction, 100);
		Thread.sleep(100);
		persistor.saveIncrementalAuction(ia1);
		persistor.saveIncrementalAuction(ia2);
		aUser = new User(0, "agus", "bazz");
		aUser.exchangeKey("code1");
		anotherUser = new User(1, "pepe", "papa");
		anotherUser.exchangeKey("code2");
	}
	@Test
	public void getIncrementalAuctionsEmptyForBidderTest(){
		ArrayList<IncrementalAuction> result = persistor.getIncrementalAuctionsForBidder(aUser);
		assertTrue(result.isEmpty());
	}
	@Test
	public void getIncrementalAuctionsNOTEmptyForBidderTest() throws Exception{
		aUser.bid(ia1);
		ArrayList<IncrementalAuction> result = persistor.getIncrementalAuctionsForBidder(aUser);
		assertFalse(result.isEmpty());
		assertTrue(result.size()== 1);
	}
	@Test
	public void getIncrementalAuctionsNOTEmptyForAnotherBidderTest() throws Exception{
		aUser.bid(ia1);
		anotherUser.bid(ia1);
		anotherUser.bid(ia2);
		ArrayList<IncrementalAuction> result = persistor.getIncrementalAuctionsForBidder(anotherUser);
		assertFalse(result.isEmpty());
		assertTrue(result.size()== 2);
	}
	
}

