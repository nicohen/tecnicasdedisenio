/**
 * 
 */
package domain.persistenceInterface;

import java.util.Date;

import domain.customers.Donation;
import domain.customers.Group;
import domain.customers.User;

/**
 * 
 */
public interface DonationPersistor {

	public Donation[] getDonationsForUser (User user);
	public Donation[] getDonationsForUserSinceDate (User user, Date dateFrom);
	
	public Donation[] getDonationsForGroup(Group group);
	public Donation[] getDonationsForGroupSinceDate (Group group, Date dateFrom);
	
	public void saveDonation(Donation donation);
}
