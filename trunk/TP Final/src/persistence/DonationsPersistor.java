package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domain.customers.Donation;
import domain.customers.Group;
import domain.customers.User;
import domain.persistenceInterface.DonationPersistor;

public class DonationsPersistor implements DonationPersistor{
	
	private static DonationsPersistor instance=null;
	
	private Map<Long, Donation> donations;
	
	private DonationsPersistor (){
		this.donations = new HashMap<Long, Donation>();
	}
	
	public static DonationsPersistor getDonationsPersistorInstance(){
		if(DonationsPersistor.instance==null){
			DonationsPersistor.instance = new DonationsPersistor();
		}
		return DonationsPersistor.instance;
	}

	@Override
	public ArrayList<Donation> getDonationsForGroup(Group group) {
		ArrayList<Donation> donationsForGroup = new ArrayList<Donation>();
		Iterator<Long> it = this.donations.keySet().iterator();
		while(it.hasNext()){
			Donation aDonation = this.donations.get(it.next());
			if(aDonation.getBenefeciary().equals(group))
				donationsForGroup.add(aDonation);
		}
		return donationsForGroup;
	}

	@Override
	public ArrayList<Donation> getDonationsForGroupSinceDate(Group group,
			Date dateFrom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Donation> getDonationsForUser(User user) {
		ArrayList<Donation> donationsForUser = new ArrayList<Donation>();
		Iterator<Long> it = this.donations.keySet().iterator();
		while(it.hasNext()){
			Donation aDonation = this.donations.get(it.next());
			if(aDonation.getDonor().equals(user))
				donationsForUser.add(aDonation);
		}
		return donationsForUser;
	}

	@Override
	public ArrayList<Donation> getDonationsForUserSinceDate(User user,
			Date dateFrom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveDonation(Donation donation) {
		this.donations.put(donation.getDonationId(), donation);
		
	}
	

}
