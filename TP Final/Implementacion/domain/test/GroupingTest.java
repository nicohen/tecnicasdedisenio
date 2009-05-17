package domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.auctions.InvalidDonationException;
import domain.customers.*;

public class GroupingTest {
	
	@Test
	public void suscribeToGroupTest() {
		User groupOwner = new User(65468735, "Taco", "Bell");
		User testUser1=new User(54335734, "User 1", "Test");
		Group aGroup = null;
		
		try {
			aGroup = new Group(groupOwner);
			assertTrue(1 == aGroup.getAmountOfMembersOfGroup());
			
			testUser1.suscribeToGroup(aGroup);
			//assertTrue(true);
		} catch (UserAlreadyInGroupException e1) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}catch (GroupSizeExceededException e2){
			fail("Unexpected GroupSizeExceededException thrown");
		}
		assertTrue(2 == aGroup.getAmountOfMembersOfGroup());
	}
	
	@Test
	public void suscribeToGroupFailTest() {
		User groupOwner = new User(65468735, "Taco", "Bell");
		User testUser1 = new User(54335734, "User 1", "Test");
		User testUser2 = new User(35432144, "User 2", "Test");
		Group aGroup = null;
		Group anotherGroup = null;
		
		try {
			aGroup = new Group(groupOwner);
			testUser1.suscribeToGroup(aGroup);
			anotherGroup = new Group(testUser1);
			fail("UserAlreadyInGroupException expected");
		}catch (GroupSizeExceededException e2){
			fail("Unexpected GroupSizeExceededException thrown");
		} catch (UserAlreadyInGroupException e) {
			//assertTrue(true);
		}
		
		try {
			anotherGroup = new Group(testUser2);
			testUser1.suscribeToGroup(anotherGroup);
			fail("UserAlreadyInGroupException expected");
		} catch (GroupSizeExceededException e2){
			fail("Unexpected GroupSizeExceededException thrown");
		}catch (UserAlreadyInGroupException e) {
			//assertTrue(true);
		}
	}

	@Test
	public void DonationOkTest() {
		User aUser1 = new User(24, "Mariano", "Mariano");
		User aUser2 = new User(21, "nacho", "nacho");
		
		Group aGroup = null;
		try {
			aGroup = new Group(aUser1);
			aUser2.suscribeToGroup(aGroup);
		} catch (UserAlreadyInGroupException e2) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}catch (GroupSizeExceededException e2){
			fail("Unexpected GroupSizeExceededException thrown");
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
    	User groupOwner = new User(21, "nacho", "nacho");
		groupOwner.addPoints(15000);
		User aUser = new User(49831452, "Diego", "García");
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
			//assertTrue(true);
		}
		
		try {
			aUser.suscribeToGroup(aGroup);
			aUser.donate(1500);
		} catch (UserAlreadyInGroupException e1) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}catch (GroupSizeExceededException e2){
			fail("Unexpected GroupSizeExceededException thrown");
		}catch (InvalidDonationException e) {
			//assertTrue(true);
		}
        
	}
    
    @Test
    public void GroupSizeExceededTest(){
    	User groupOwner = new User(23617, "dueño", "del Grupo");
    	User user1 = new User(432, "miembro", "num1");
    	User user2 = new User(432, "miembro", "num2");
    	User user3 = new User(432, "miembro", "num3");
    	User user4 = new User(432, "miembro", "num4");
    	User user5= new User(432, "miembro", "num5");
    	User user6 = new User(432, "miembro", "num6");
    	User user7 = new User(432, "miembro", "num7");
    	User user8 = new User(432, "miembro", "num8");
    	User user9 = new User(432, "miembro", "num9");
    	User user10 = new User(432, "miembro", "num10");
    	Group aGroup = null;
    	try{
    		aGroup = new Group(groupOwner); 
    	} catch (UserAlreadyInGroupException e2) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}
    	
    	try {
			user1.suscribeToGroup(aGroup);
			user2.suscribeToGroup(aGroup);
			user3.suscribeToGroup(aGroup);
			user4.suscribeToGroup(aGroup);
			user5.suscribeToGroup(aGroup);
			user6.suscribeToGroup(aGroup);
			user7.suscribeToGroup(aGroup);
			user8.suscribeToGroup(aGroup);
			user9.suscribeToGroup(aGroup);
		} catch (UserAlreadyInGroupException e1) {
			fail("Unexpected UserAlreadyInGroupException thrown");
		}catch (GroupSizeExceededException e2){
			fail("Unexpected GroupSizeExceededException thrown");
		}
		try{
			user10.suscribeToGroup(aGroup);
			fail("GroupSizeExceededException expected");
		}catch(GroupSizeExceededException e3){
			//saraza
		}catch(UserAlreadyInGroupException e4){
			fail("Unexpected UserAlreadyInGroupException thrown");
		}
    }
 }
