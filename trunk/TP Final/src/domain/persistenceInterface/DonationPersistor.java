/**
 * 
 */
package domain.persistenceInterface;

import java.util.ArrayList;
import java.util.Date;

import domain.customers.Donation;
import domain.customers.Group;
import domain.customers.User;

/**
 * 
 */
public interface DonationPersistor {

	public ArrayList<Donation> getDonationsForUser (User user);
	public ArrayList<Donation> getDonationsForUserSinceDate (User user, Date dateFrom);
	
	public ArrayList<Donation> getDonationsForGroup(Group group);
	public ArrayList<Donation> getDonationsForGroupSinceDate (Group group, Date dateFrom);
	
	public void saveDonation(Donation donation);
}
