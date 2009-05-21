package src.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.domain.auctions.Auction;
import src.domain.auctions.AuctionStatus;
import src.domain.auctions.AuctionType;
import src.domain.auctions.IncrementalAuction;
import src.domain.auctions.Product;
import src.domain.auctions.ReverseAuction;
import src.domain.customers.Group;
import src.domain.customers.User;
import src.domain.utils.VariationRateFunction;

public class FinishAuctionTest {

	private User aUser, anotherUser;
	private Product prize;
	Group aGroup;

	@Before
	public void setUp() throws Exception {
		aUser = new User(31733445, "Aníbal", "Lovaglio");
		anotherUser = new User(31733445, "Aníbal", "Lovaglio");
		prize = new Product("Malboro");
		aGroup = new Group(aUser);
		anotherUser.suscribeToGroup(aGroup);
		aUser.addPoints(15000);
	}

	@Test
	public void finishReverseAuction() throws Exception{
		VariationRateFunction variationFunction = null;
		int value = 1000;
		Auction anReverseAuction = new ReverseAuction(prize, variationFunction,
				value);
		aUser.bid(anReverseAuction);

		assertTrue(anReverseAuction.getStatus().equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalSingleAuction() throws Exception{
		VariationRateFunction variationFunction = new VariationRateFunction(
				null);
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);
		aUser.bid(anIncrementalAuction);
		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalGroupAuction() throws Exception{
		aGroup.addPoints(15000);
		VariationRateFunction variationFunction = new VariationRateFunction(
				null);
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.GROUP, variationFunction, value);
		aGroup.bid(anIncrementalAuction);
		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(!aGroup.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalAuctionWithSecondBid() throws Exception{
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, new VariationRateFunction(null), value);

			aUser.bid(anIncrementalAuction);
		User user = new User(31936280, "Agustina", "Bazzano");
		user.addPoints(value + 100); // le sumo una cantidad que seguro va a ser
										// más que lo que se incermente el value
										// del remate
		user.bid(anIncrementalAuction);
		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(aUser.getWonAuctions().isEmpty());
		assertTrue(!user.getWonAuctions().isEmpty());
	}
	
	@Test
	public void testFinishIncrementalAuctionWithNoBid() {
		VariationRateFunction variationFunction = new VariationRateFunction(
				null);
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);
		anIncrementalAuction.finish();
		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));

		// NO hubo ofertas por lo tanto no hay ganador
		assertNull(anIncrementalAuction.getWinner());
	}

	@Test
	public void testFinishIncrementalAuctionWithNoWinner() throws Exception{
		VariationRateFunction variationFunction = new VariationRateFunction(
				null);
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);

		User user = new User(31936280, "Agustina", "Bazzano");
		user.addPoints(value * 100);
		user.bid(anIncrementalAuction);
		anIncrementalAuction.finish();// user gana

		Auction anIncrementalAuction2 = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);
		user.bid(anIncrementalAuction);

		anIncrementalAuction2.finish();// el user no puede ganar
		assertNull(anIncrementalAuction2.getWinner());
	}
}
