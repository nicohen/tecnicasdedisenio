package domain.test;

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
		Bid myBid = new Bid(aUser, value);
		anReverseAuction.takeNewBid(myBid);// aca adentro se llama al finish

		assertTrue(anReverseAuction.getStatus().equals(AuctionStatus.CLOSED));
		assertTrue(!aUser.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalSingleAuction() {
		VariationRateFunction variationFunction = null;
		int value = 1000;
		Auction anIncrementalAuction = new IncrementalAuction(prize,
				AuctionType.SINGLE, variationFunction, value);
		Bid myBid = new Bid(aUser, value);
		anIncrementalAuction.takeNewBid(myBid);// HAY Q COMENTAR EL CALCULO DEL
		// nextBidValue para q ande este
		// test, por ahora..
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

		Bid myBid = new Bid(aGroup, value);
		anIncrementalAuction.takeNewBid(myBid);
		anIncrementalAuction.finish();

		assertTrue(anIncrementalAuction.getStatus()
				.equals(AuctionStatus.CLOSED));
		assertTrue(!aGroup.getWonAuctions().isEmpty());
	}

	@Test
	public void finishIncrementalAuctionWithSecondBid() {
			//agrego dos usuarios, el primero lo hago ganar en el primer remate y al segundo en el siguiente remate.
			User aUser2 = new User(31733445, "Aníbal", "Lovaglio", dateOfBirth);
			aUser.addPoints(15000);
			aUser2.addPoints(15000);
			Product prize = null;
			VariationRateFunction variationFunction= new VariationRateFunction(null);
			int value= 1000;
			Auction anAuction = new IncrementalAuction(prize, AuctionType.SINGLE, variationFunction, value);
			aUser.win(anAuction);
			Auction anAuction2 = new IncrementalAuction(prize, AuctionType.SINGLE, variationFunction, value);
			aUser2.bid(anAuction2);
			aUser.bid(anAuction2);
			//assertTrue(anAuction2.getWinner()== aUser2.getName());


	}
}
