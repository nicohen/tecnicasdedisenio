package domain.test;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Test;

import domain.customers.Group;
import domain.customers.User;
import domain.exceptions.GroupSizeExceededException;
import domain.exceptions.InvalidDonationException;
import domain.exceptions.UserAlreadyInGroupException;

public class GroupingTest {

	@Test()
	public void suscribeToGroupTest() throws Exception {
		User groupOwner = new User(65468735, "Taco", "Bell");
		User testUser1 = new User(54335734, "User 1", "Test");
		Group aGroup = null;

		aGroup = new Group(groupOwner);
		assertTrue(1 == aGroup.getAmountOfMembersOfGroup());

		testUser1.suscribeToGroup(aGroup);
		assertTrue(2 == aGroup.getAmountOfMembersOfGroup());
	}

	@Test (expected = UserAlreadyInGroupException.class)
	public void suscribeToGroupFailTest() throws Exception {
		User groupOwner = new User(65468735, "Taco", "Bell");
		User testUser1 = new User(54335734, "User 1", "Test");
		Group aGroup = null;

		// Lo subscribo por primera vez
		aGroup = new Group(groupOwner);
		testUser1.suscribeToGroup(aGroup);
		// Lo subscribo por segunda vez
		new Group(testUser1);
		
	}

	@Test
	public void DonationOkTest() throws Exception {
		User aUser1 = new User(24, "Mariano", "Mariano");
		User aUser2 = new User(21, "nacho", "nacho");

		Group aGroup = null;
		aGroup = new Group(aUser1);
		aUser2.suscribeToGroup(aGroup);

		aUser1.addPoints(10000);
		aUser2.addPoints(2000);
		aUser1.donate(1000);
		assertTrue(aUser1.getPoints() == 9000);
		assertTrue(aGroup.getPoints() == 1000);
	}

	@Test(expected = InvalidDonationException.class)
	public void DonationFailureTest() throws Exception {
		User groupOwner = new User(21, "nacho", "nacho");
		groupOwner.addPoints(15000);
		User aUser = new User(49831452, "Diego", "García");
		aUser.addPoints(1000);
		Group aGroup = null;

		aGroup = new Group(groupOwner);

		aUser.donate(500);
		aUser.suscribeToGroup(aGroup);
		aUser.donate(1500);
	}

	@Test(expected = GroupSizeExceededException.class)
	public void GroupSizeExceededTest() throws Exception {
		User groupOwner = new User(23617, "dueño", "del Grupo");
		User user1 = new User(432, "miembro", "num1");
		User user2 = new User(432, "miembro", "num2");
		User user3 = new User(432, "miembro", "num3");
		User user4 = new User(432, "miembro", "num4");
		User user5 = new User(432, "miembro", "num5");
		User user6 = new User(432, "miembro", "num6");
		User user7 = new User(432, "miembro", "num7");
		User user8 = new User(432, "miembro", "num8");
		User user9 = new User(432, "miembro", "num9");
		User user10 = new User(432, "miembro", "num10");
		Group aGroup = null;
		aGroup = new Group(groupOwner);

		user1.suscribeToGroup(aGroup);
		user2.suscribeToGroup(aGroup);
		user3.suscribeToGroup(aGroup);
		user4.suscribeToGroup(aGroup);
		user5.suscribeToGroup(aGroup);
		user6.suscribeToGroup(aGroup);
		user7.suscribeToGroup(aGroup);
		user8.suscribeToGroup(aGroup);
		user9.suscribeToGroup(aGroup);
		user10.suscribeToGroup(aGroup);
	}
}
