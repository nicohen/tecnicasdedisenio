package domain.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import domain.auctions.Auction;
import domain.auctions.AuctionStatus;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.IncrementalAuction;
import domain.auctions.ReverseAuction;
import domain.customers.Group;
import domain.customers.User;
import domain.products.Product;
import domain.utils.VariationRateFunction;

public class FinishAuctionTest {

	private Date dateOfBirth;
	private User aUser;
	private Product prize;
	Group aGroup;

	@Before
	public void setUp() {
		dateOfBirth = new Date();
		aUser = new User(31733445, "Aníbal", "Lovaglio", dateOfBirth);
		prize = new Product("Malboro");
		aGroup = new Group(aUser);
		aUser.addPoints(15000);
	}

	@Test
	public void finishReverseAuction() {
		VariationRateFunction variationFunction = null;
		int value = 1000;
		Auction anReverseAuction = new ReverseAuction(prize, variationFunction,
				value);
		new Bid(aUser, anReverseAuction, value);

		assertTrue(anReverseAuction.getStatus().equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalSingleAuction() {
		VariationRateFunction variationFunction = null;
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);
		new Bid(aUser, anIncrementalAuction, value);

		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalGroupAuction() {
		aGroup.addPoints(15000);
		VariationRateFunction variationFunction = null;
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.GROUP, variationFunction, value);

		new Bid(aGroup, anIncrementalAuction, value);

		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(!aGroup.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalAuctionWithSecondBid() {
		VariationRateFunction variationFunction = null;
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);

		new Bid(aUser, anIncrementalAuction, value);

		User user = new User(31936280, "Agustina", "Bazzano", dateOfBirth);
		user.addPoints(value);
		new Bid(user, anIncrementalAuction, value * 2);

		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(aUser.getWonAuctions().isEmpty());
		assertTrue(!user.getWonAuctions().isEmpty());
	}

	@Test
	public void testFinishIncrementalAuctionWithNoBid() {
		VariationRateFunction variationFunction = null;
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
	public void testFinishIncrementalAuctionWithNoWinner() {
		VariationRateFunction variationFunction = null;
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);

		new Bid(aUser, anIncrementalAuction, value);

		User user = new User(31936280, "Agustina", "Bazzano", dateOfBirth);
		user.addPoints(value);
		new Bid(user, anIncrementalAuction, value * 2);
		anIncrementalAuction.finish();

		Auction anIncrementalAuction2 = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);
		new Bid(user, anIncrementalAuction2, value * 2);
		
		anIncrementalAuction2.finish();
		assertNull(anIncrementalAuction.getWinner());
	}
}
