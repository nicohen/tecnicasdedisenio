package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import domain.customers.Donation;
import domain.customers.Group;
import domain.customers.User;
import domain.persistenceInterface.DonationPersistor;

public class DonationsPersistor implements DonationPersistor {

	private static DonationsPersistor instance = null;

	private Map<Long, Donation> donations;

	private DonationsPersistor() {
		this.donations = new HashMap<Long, Donation>();
	}

	public static DonationsPersistor getDonationsPersistorInstance() {
		if (DonationsPersistor.instance == null) {
			DonationsPersistor.instance = new DonationsPersistor();
		}
		return DonationsPersistor.instance;
	}

	@Override
	public void saveDonation(Donation donation) {
		this.donations.put(donation.getDonationId(), donation);
	}

	@Override
	public ArrayList<Donation> getDonationsForGroup(final Group group) {
		SearchSolver<Donation> solver = new SearchSolver<Donation>() {
			@Override
			public boolean getCondition(Donation t) {
				return t.getBenefeciary().equals(group);
			}
		};
		return solver.solveCollection(donations);
	}

	@Override
	public ArrayList<Donation> getDonationsForUser(final User user) {
		SearchSolver<Donation> solver = new SearchSolver<Donation>() {
			@Override
			public boolean getCondition(Donation t) {
				return t.getDonor().equals(user);
			}
		};
		return solver.solveCollection(donations);
	}

	@Override
	public ArrayList<Donation> getDonationsForGroupSinceDate(Group group,
			Date dateFrom) {
		return null;
	}

	@Override
	public ArrayList<Donation> getDonationsForUserSinceDate(User user,
			Date dateFrom) {
		return null;
	}
}
