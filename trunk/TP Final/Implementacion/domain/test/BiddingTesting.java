package domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.IncrementalAuction;
import domain.auctions.InvalidAuctionTypeException;
import domain.auctions.InvalidDonationException;
import domain.auctions.NoBiddersException;
import domain.auctions.Product;
import domain.auctions.ReverseAuction;
import domain.customers.Bidder;
import domain.customers.Group;
import domain.customers.GroupSizeExceededException;
import domain.customers.NotEnoughMembersInGroupForBidException;
import domain.customers.User;
import domain.customers.UserAlreadyInGroupException;
import domain.customers.notEnoughPointsToBidException;
import domain.utils.VariationRateFunction;

public class BiddingTesting {

	@Test
	public void bidOnIncrementalAuctionTest() {
		User aUser = new User(31733445, "Aníbal", "Lovaglio");
		aUser.addPoints(15000);
		
		Product prize = null;
		VariationRateFunction variationFunction = new VariationRateFunction(null);
		IncrementalAuction anAuction = new IncrementalAuction(prize, AuctionType.SINGLE,
				variationFunction, 1000);
		
		assertTrue(anAuction.getAmountForNextBid() == 1000);
		try {
			aUser.bid(anAuction);
		} catch (notEnoughPointsToBidException e1) {
			fail("Unexpected exception");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
		int bidAmount = anAuction.getAmountForNextBid();
		assertTrue(bidAmount > 1000);
		try {
			assertSame(aUser, anAuction.getHighestBidder());
		} catch (NoBiddersException e) {
			fail("Bidder excistance expected");
		}
	}

	@Test
	public void getHighestBidderFailTest() {
		IncrementalAuction auction = new IncrementalAuction(null, AuctionType.SINGLE, new VariationRateFunction(null), 100);
		try {
			auction.getHighestBidder();
			fail("Expected NoBiddersException");
		} catch (NoBiddersException e) {
			assertTrue(true);
		}
	}

	@Test
	public void takeNewBidFailureTest_IncompatibleBidder() {
		Auction anAuction = new ReverseAuction(null, new VariationRateFunction(null), 1000);
		User owner = new User(31733442, "Charles", "Rain");
		owner.addPoints(10000);
		User member = new User(45456587, "Lois", "Lane");
		Bidder bidder = null;
		try {
			bidder = new Group(owner);
			member.suscribeToGroup((Group) bidder);
			owner.donate(1500);
		} catch (UserAlreadyInGroupException e3) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		} catch (InvalidDonationException e1) {
			fail("Unexpected InvalidDonationException thrown");
		}catch (GroupSizeExceededException e2){
			fail("Unexpected GroupSizeExceededException thrown");
		}
		try {
			bidder.bid(anAuction);
		} catch (InvalidAuctionTypeException e) {
			assertTrue(true);
		} catch (notEnoughPointsToBidException e) {
			e.printStackTrace();
			fail("Unexpected exception thrown");
		} catch (NotEnoughMembersInGroupForBidException e) {
			e.printStackTrace();
			fail("Unexpected exception thrown");
		}
	}
	
	@Test
	public void takeNewBidFailureTest_EmptyGroupBidder() {
		Auction anAuction = new IncrementalAuction(null, AuctionType.GROUP, new VariationRateFunction(null), 100);

		User owner = new User(31733442, "Charles", "Rain");
		owner.addPoints(10000);
		
		Bidder bidder = null;
		try {
			bidder = new Group(owner);
			owner.donate(1500);
		} catch (UserAlreadyInGroupException e2) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		} catch (InvalidDonationException e1) {
			fail("Unexpected InvalidDonationException thrown");
		}
		
		try {
			bidder.bid(anAuction);
		} catch (InvalidAuctionTypeException e) {
			e.printStackTrace();
			fail("Unexpected exception class");
		} catch (notEnoughPointsToBidException e) {
			e.printStackTrace();
			fail("Unexpected exception class");
		} catch (NotEnoughMembersInGroupForBidException e) {
			assertTrue(true);
		}
		
	}

	@Test
	public void takeNewBidFailureTest_NotEnoughCredit() {
		Auction anAuction = new IncrementalAuction(null, AuctionType.GROUP, new VariationRateFunction(null), 1000);
		User owner = new User(31733442, "Charles", "Rain");
		User member = new User(54314564, "Mario", "Ledesma");
		Group bidder = null;
		try {
			bidder = new Group(owner);
			member.suscribeToGroup(bidder);
		} catch (UserAlreadyInGroupException e1) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}catch (GroupSizeExceededException e2){
			fail("Unexpected GroupSizeExceededException thrown");
		}
		
		try {
			bidder.bid(anAuction);
			fail("Group - expected: notEnoughPointsToBidException | actual: none");
		} catch (InvalidAuctionTypeException e) {
			fail("Group - expected: notEnoughPointsToBidException | actual: InvalidAuctionTypeException");
		} catch (NotEnoughMembersInGroupForBidException e) {
			fail("Group - expected: notEnoughPointsToBidException | actual: NotEnoughMembersInGroupForBidException");
		} catch (notEnoughPointsToBidException e) {
			assertTrue(true);
		}
		
		anAuction = new IncrementalAuction(null, AuctionType.SINGLE, new VariationRateFunction(null), 100);
		try {
			owner.bid(anAuction);
			fail("User - expected: notEnoughPointsToBidException | actual: none");
		} catch (notEnoughPointsToBidException e) {
			assertTrue(true);
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
	}
	
	@Test
	public void takeNewBidTest_ReleaseingCompromisedPoints() {
		User aUser1 = new User(31733445, "Aníbal", "Lovaglio");
		User aUser2 = new User(31733445, "German", "Mendez");
		User aUser3 = new User(31733445, "Martin", "De luca");
		aUser1.addPoints(1000);
		aUser2.addPoints(1000);
		aUser3.addPoints(1000);

		Auction anAuction = new IncrementalAuction(null, AuctionType.SINGLE,
				new VariationRateFunction(null), 250);

		int bidAmount = anAuction.getAmountForNextBid();
		try {
			aUser1.bid(anAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected notEnoughPointsToBidException thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
		assertEquals(1000-bidAmount, aUser1.getPoints());
		
		int secondBidAmount = anAuction.getAmountForNextBid();
		try {
			aUser2.bid(anAuction);
		} catch (notEnoughPointsToBidException e) {
			fail("Unexpected exception thrown");
		} catch (InvalidAuctionTypeException e) {
			fail("Unexpected InvalidAuctionTypeException thrown");
		}
		assertEquals(1000, aUser1.getPoints());
		assertEquals(1000-secondBidAmount, aUser2.getPoints());
	}

}
