package domain.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import domain.auctions.Auction;
import domain.auctions.AuctionStatus;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.IncrementalAuction;
import domain.auctions.InvalidAuctionTypeException;
import domain.auctions.Product;
import domain.auctions.ReverseAuction;
import domain.customers.Group;
import domain.customers.NotEnoughMembersInGroupForBidException;
import domain.customers.User;
import domain.customers.UserAlreadyInGroupException;
import domain.customers.notEnoughPointsToBidException;
import domain.utils.VariationRateFunction;

public class FinishAuctionTest {

	private Date dateOfBirth;
	private User aUser, anotherUser;
	private Product prize;
	Group aGroup;

	@Before
	public void setUp() {
		dateOfBirth = new Date();
		aUser = new User(31733445, "Aníbal", "Lovaglio", dateOfBirth);
		anotherUser = new User(31733445, "Aníbal", "Lovaglio", null);
		prize = new Product("Malboro");
		try {
			aGroup = new Group(aUser);
		} catch (UserAlreadyInGroupException e) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}
		try {
			anotherUser.suscribeToGroup(aGroup);
		} catch (UserAlreadyInGroupException e) {
			// ain't gonna happen
		}
		aUser.addPoints(15000);
	}

	@Test
	public void finishReverseAuction() {
		VariationRateFunction variationFunction = null;
		int value = 1000;
		Auction anReverseAuction = new ReverseAuction(prize, variationFunction,
				value);
		try {
			aUser.bid(anReverseAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected notEnoughPointsToBidException thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
		assertTrue(anReverseAuction.getStatus().equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalSingleAuction() {
		VariationRateFunction variationFunction = new VariationRateFunction(null);
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);
		try {
			aUser.bid(anIncrementalAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected notEnoughPointsToBidException thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}

		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalGroupAuction() {
		aGroup.addPoints(15000);
		VariationRateFunction variationFunction = new VariationRateFunction(null);
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.GROUP, variationFunction, value);

		try {
			aGroup.bid(anIncrementalAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected notEnoughPointsToBidException thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("InvalidAuctionTypeException thrown");
		} catch (NotEnoughMembersInGroupForBidException e) {
			fail("NotEnoughMembersInGroupForBidException thrown");
		}

		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(!aGroup.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalAuctionWithSecondBid() {
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, new VariationRateFunction(null), value);

		try {
			aUser.bid(anIncrementalAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected notEnoughPointsToBidException thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
		User user = new User(31936280, "Agustina", "Bazzano", dateOfBirth);
		user.addPoints(value+100); // le sumo una cantidad que seguro va a ser más que lo que se incermente el value del remate
		try {
			user.bid(anIncrementalAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected notEnoughPointsToBidException thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
		
		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(aUser.getWonAuctions().isEmpty());
		assertTrue(!user.getWonAuctions().isEmpty());
	}

	@Test
	public void testFinishIncrementalAuctionWithNoBid() {
		VariationRateFunction variationFunction = new VariationRateFunction(null);
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
		VariationRateFunction variationFunction = new VariationRateFunction(null);
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);

		User user = new User(31936280, "Agustina", "Bazzano", dateOfBirth);
		user.addPoints(value*100);
		try {
			aUser.bid(anIncrementalAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected notEnoughPointsToBidException thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
		anIncrementalAuction.finish();

		Auction anIncrementalAuction2 = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);
		try {
			aUser.bid(anIncrementalAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected notEnoughPointsToBidException thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
		
		anIncrementalAuction2.finish();
		assertNull(anIncrementalAuction2.getWinner());
	}
}
