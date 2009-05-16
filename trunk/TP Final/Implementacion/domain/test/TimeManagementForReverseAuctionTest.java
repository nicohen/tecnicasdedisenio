package domain.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import domain.auctions.Auction;
import domain.auctions.ReverseAuction;
import domain.utils.VariationRateFunction;

public class TimeManagementForReverseAuctionTest {

	@Test
	public void testGetAmountForNextBid() {
		Auction rAuction = new ReverseAuction(null, new VariationRateFunction(
				null), 100);
		int amount = rAuction.getAmountForNextBid();
		while (amount > 0) {
			Date startDate = new Date();
			System.out.print (startDate + "| " + amount + " -> ");
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Couldn't sleep enough");
			}
			Date aDate = new Date();
			while (aDate.getTime() < (startDate.getTime() + (60000 * ReverseAuction.STEP_SIZE_IN_MINUTES))) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					fail("Couldn't sleep enough");
				}
			}
			int anotherAmount = rAuction.getAmountForNextBid();
			System.out.println(anotherAmount);
			assertTrue(amount >= anotherAmount);
			amount = anotherAmount;
		}
	}
}
