import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.IncrementalAuction;
import domain.customers.Donation;
import domain.customers.Group;
import domain.customers.User;
import domain.exceptions.BidException;
import domain.exceptions.InvalidAuctionTypeException;
import domain.exceptions.InvalidDonationException;
import domain.exceptions.UserAlreadyInGroupException;
import domain.querys.History;
import domain.utils.VariationRateFunction;


public class HistoryRetrievingTest {

	@Test
	public void testHaveDonation() throws UserAlreadyInGroupException, InvalidDonationException, InterruptedException {
		History history = History.getInstance();
		User user = new User(53648759, "Mario", "Ledesma");
		Group group = new Group(user);
		user.addPoints(10000);
		user.donate(5000);
		Thread.sleep(10);
		user.donate(500);
		Thread.sleep(10);
		user.donate(500);
		Thread.sleep(10);
		user.donate(500);
		Thread.sleep(10);
		user.donate(500);
		Object[] donations = history.getDonations().toArray();
		Donation donation = (Donation) donations[0];
		Date date = donation.getDate();
		assertTrue(history.haveDonation(user, group, date));
	}

	@Test
	public void testHaveBid() throws BidException, InvalidAuctionTypeException, InterruptedException {
		History history = History.getInstance();
		Auction auction = new IncrementalAuction(null, AuctionType.SINGLE, new VariationRateFunction(null), 150);
		User assertUser = new User(53648759, "Mario", "Ledesma");
		assertUser.addPoints(10000);
		assertUser.bid(auction);
		Thread.sleep(10);
		User user = new User(12457896, "Diego", "Sanfiz");
		user.addPoints(10000);
		user.bid(auction);
		Thread.sleep(10);
		user = new User(17857896, "Jorge", "Sanfiz");
		user.addPoints(10000);
		user.bid(auction);
		Thread.sleep(10);
		user = new User(59457896, "Santiago", "Apache");
		user.addPoints(10000);
		user.bid(auction);
		Thread.sleep(10);
		user = new User(12455846, "Norberto", "Ucha");
		user.addPoints(10000);
		user.bid(auction);
		Object[] objects = history.getBids().toArray();
		Bid bid = (Bid) objects[0];
		Date date = bid.getDate();
		assertTrue(history.haveBid(date, assertUser));
	}

	@Test
	public void testHaveKeyExchange() {
		fail("Not yet implemented");
	}

	@Test
	public void testHaveQuery() {
		fail("Not yet implemented");
	}

}
