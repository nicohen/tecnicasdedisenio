package src.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.domain.auctions.Auction;
import src.domain.auctions.AuctionType;
import src.domain.auctions.IncrementalAuction;
import src.domain.auctions.Product;
import src.domain.auctions.ReverseAuction;
import src.domain.customers.Bidder;
import src.domain.customers.Group;
import src.domain.customers.User;
import src.domain.exceptions.InvalidAuctionTypeException;
import src.domain.exceptions.NoBiddersException;
import src.domain.exceptions.NotEnoughMembersInGroupForBidException;
import src.domain.exceptions.NotEnoughPointsToBidException;
import src.domain.utils.VariationRateFunction;

public class BiddingTesting {

	@Test
	public void bidOnIncrementalAuctionTest() throws Exception {
		User aUser = new User(31733445, "Aníbal", "Lovaglio");
		aUser.addPoints(15000);
		Product prize = null;
		VariationRateFunction variationFunction = new VariationRateFunction(
				null);
		IncrementalAuction anAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, 1000);
		assertTrue(anAuction.getAmountForNextBid() == 1000);
		aUser.bid(anAuction);
		int bidAmount = anAuction.getAmountForNextBid();

		assertTrue(bidAmount > 1000);
		assertSame(aUser, anAuction.getHighestBidder());
	}

	@Test(expected = NoBiddersException.class)
	public void getHighestBidderFailTest() throws Exception {
		IncrementalAuction auction = new IncrementalAuction(null,
				AuctionType.SINGLE, new VariationRateFunction(null), 100);

		auction.getHighestBidder();
	}

	@Test(expected = InvalidAuctionTypeException.class)
	public void takeNewBidFailureTest_IncompatibleBidder() throws Exception {
		Auction anAuction = new ReverseAuction(null, new VariationRateFunction(
				null), 1000);
		User owner = new User(31733442, "Charles", "Rain");
		owner.addPoints(10000);
		User member = new User(45456587, "Lois", "Lane");
		Bidder bidder = null;
		bidder = new Group(owner);
		member.suscribeToGroup((Group) bidder);
		owner.donate(1500);

		bidder.bid(anAuction);

	}

	@Test(expected = NotEnoughMembersInGroupForBidException.class)
	public void takeNewBidFailureTest_EmptyGroupBidder() throws Exception {
		Auction anAuction = new IncrementalAuction(null, AuctionType.GROUP,
				new VariationRateFunction(null), 100);
		User owner = new User(31733442, "Charles", "Rain");
		owner.addPoints(10000);
		Bidder bidder = null;
		bidder = new Group(owner);
		owner.donate(1500);

		bidder.bid(anAuction);
	}

	@Test(expected = NotEnoughPointsToBidException.class)
	public void groupTakeNewBidFailureTest_NotEnoughCredit() throws Exception {
		Auction anAuction = new IncrementalAuction(null, AuctionType.GROUP,
				new VariationRateFunction(null), 1000);
		User owner = new User(31733442, "Charles", "Rain");
		User member = new User(54314564, "Mario", "Ledesma");
		Group bidder = null;
		bidder = new Group(owner);
		member.suscribeToGroup(bidder);

		bidder.bid(anAuction);
	}

	@Test(expected = NotEnoughPointsToBidException.class)
	public void userTakeNewBidFailureTest_NotEnoughCredit() throws Exception {
		Auction anAuction = new IncrementalAuction(null, AuctionType.SINGLE,
				new VariationRateFunction(null), 100);
		User owner = new User(31733442, "Charles", "Rain");

		owner.bid(anAuction);
	}

	@Test
	public void takeNewBidTest_ReleaseingCompromisedPoints() throws Exception {
		User aUser1 = new User(31733445, "Aníbal", "Lovaglio");
		User aUser2 = new User(31733445, "German", "Mendez");
		User aUser3 = new User(31733445, "Martin", "De luca");
		aUser1.addPoints(1000);
		aUser2.addPoints(1000);
		aUser3.addPoints(1000);

		Auction anAuction = new IncrementalAuction(null, AuctionType.SINGLE,
				new VariationRateFunction(null), 250);

		int bidAmount = anAuction.getAmountForNextBid();
		aUser1.bid(anAuction);
		assertEquals(1000 - bidAmount, aUser1.getPoints());

		int secondBidAmount = anAuction.getAmountForNextBid();
		aUser2.bid(anAuction);

		assertEquals(1000, aUser1.getPoints());
		assertEquals(1000 - secondBidAmount, aUser2.getPoints());
	}

}
