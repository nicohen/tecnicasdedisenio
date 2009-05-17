package domain.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import domain.auctions.InvalidDonationException;
import domain.customers.*;

public class GroupingTest {
	
	@Test
	public void suscribeToGroupTest() {
		User groupOwner = new User(65468735, "Taco", "Bell", null);
		User testUser1=new User(54335734, "User 1", "Test", null);
		Group aGroup = null;
		
		try {
			aGroup = new Group(groupOwner);
			assertTrue(1 == aGroup.getAmountOfMembersOfGroup());
			
			testUser1.suscribeToGroup(aGroup);
			assertTrue(true);
		} catch (UserAlreadyInGroupException e1) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}
		assertTrue(2 == aGroup.getAmountOfMembersOfGroup());
	}
	
	@Test
	public void suscribeToGroupFailTest() {
		User groupOwner = new User(65468735, "Taco", "Bell", null);
		User testUser1 = new User(54335734, "User 1", "Test", null);
		User testUser2 = new User(35432144, "User 2", "Test", null);
		Group aGroup = null;
		Group anotherGroup = null;
		
		try {
			aGroup = new Group(groupOwner);
			testUser1.suscribeToGroup(aGroup);
			anotherGroup = new Group(testUser1);
			fail("UserAlreadyInGroupException expected");
		} catch (UserAlreadyInGroupException e) {
			assertTrue(true);
		}
		
		try {
			anotherGroup = new Group(testUser2);
			testUser1.suscribeToGroup(anotherGroup);
			fail("UserAlreadyInGroupException expected");
		} catch (UserAlreadyInGroupException e) {
			assertTrue(true);
		}
	}

	@Test
	public void DonationOkTest() {
		Date dateOfBirth = new Date();
		User aUser1 = new User(24, "Mariano", "Mariano", dateOfBirth);
		User aUser2 = new User(21, "nacho", "nacho", dateOfBirth);
		
		Group aGroup = null;
		try {
			aGroup = new Group(aUser1);
			aUser2.suscribeToGroup(aGroup);
		} catch (UserAlreadyInGroupException e2) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}
		
		aUser1.addPoints(10000);
		aUser2.addPoints(2000);
		try {
			aUser1.donate(1000);
		} catch (InvalidDonationException e) {
			fail("Unexpected InvalidDonationException thrown");
		}
		assertTrue(aUser1.getPoints() == 9000);
		assertTrue(aGroup.getPoints() == 1000);
	}
        
    @Test
	public void DonationFailureTest() {
    	User groupOwner = new User(21, "nacho", "nacho", null);
		groupOwner.addPoints(15000);
		User aUser = new User(49831452, "Diego", "García", null);
		aUser.addPoints(1000);
        Group aGroup = null;
		
        try {
			aGroup = new Group(groupOwner);
		} catch (UserAlreadyInGroupException e2) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}

        try {
			aUser.donate(500);
			fail("Expected InvalidDonationException for user not in any group");
		} catch (InvalidDonationException e) {
			assertTrue(true);
		}
		
		try {
			aUser.suscribeToGroup(aGroup);
			aUser.donate(1500);
		} catch (UserAlreadyInGroupException e1) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		} catch (InvalidDonationException e) {
			assertTrue(true);
		}
        
	}
 }
