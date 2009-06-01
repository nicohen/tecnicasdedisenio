import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import domain.customers.Donation;
import domain.customers.Group;
import domain.customers.User;
import domain.exceptions.InvalidDonationException;
import domain.exceptions.UserAlreadyInGroupException;
import domain.querys.History;


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
	public void testHaveBid() {
		fail("Not yet implemented");
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
