package src.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import src.domain.auctions.Auction;
import src.domain.auctions.ReverseAuction;
import src.domain.utils.VariationRateFunction;

public class TimeManagementForReverseAuctionTest {

	@Test
	public void testGetAmountForNextBid() throws Exception {
		Auction rAuction = new ReverseAuction(null, new VariationRateFunction(
				null), 10);
		int amount = rAuction.getAmountForNextBid();
		while (amount > 0) {
			Date startDate = new Date();
			System.out.print(startDate + "| " + amount + " -> ");
			Thread.sleep(60000);
			Date aDate = new Date();
			while (aDate.getTime() < (startDate.getTime() + (60000 * ReverseAuction.STEP_SIZE_IN_MINUTES))) {
				Thread.sleep(1000);
			}
			int anotherAmount = rAuction.getAmountForNextBid();
			System.out.println(anotherAmount);
			assertTrue(amount >= anotherAmount);
			amount = anotherAmount;
		}
	}
}
