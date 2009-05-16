package domain.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import domain.customers.*;

public class DonationTest {

	@Test
	public void DonatetionOkTest() {
		Date dateOfBirth = new Date();
		User aUser2 = new User(21, "nacho", "nacho", dateOfBirth);
		User aUser3 = new User(22, "Berta", "Berta", dateOfBirth);
		User aUser4 = new User(23, "Belen", "Belen", dateOfBirth);
		User aUser = new User(24, "Mariano", "Mariano", dateOfBirth);
		
		Group aGroup= new Group(aUser);
		aUser.suscribeToGroup(aGroup);
		aUser2.suscribeToGroup(aGroup);
		aUser3.suscribeToGroup(aGroup);
		aUser4.suscribeToGroup(aGroup);	
		
		aUser.addPoints(10000);
		aUser2.addPoints(2000);
		aUser3.addPoints(12000);
		aUser4.addPoints(1500);
		
		aUser.donate(aUser, 1000);
		assertTrue(aUser.getPoints() == 9000);
		assertTrue(aGroup.getCredits() == 1000);
				
	}
        
   /* @Test
	public void DonatetionError() {
    	
    	Date dateOfBirth = new Date();		
		User aUser = new User(21, "nacho", "nacho", dateOfBirth);
		aUser.addPoints(15000);
        Group aGroup = new Group(aUser);   
        Donation aDonation=new Donation();
        aDonation.donatePoints(aUser,aGroup,1001);                                						
		assertFalse(aUser.getPoints() == 500);
        assertFalse(aGroup.getPoints() == 1000);		
	}*/
 }
