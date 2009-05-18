package domain.customers;

import java.util.Date;

import domain.querys.Transaction;



public class Donation extends Transaction {
	private Group beneficiaryGroup;
	private User donorUser;
	private int donatedCredits;

	/** Creates a new instance of Donation */
	public Donation(User user,Group group,int points) {
		super(new Date());
		if (user==null || group==null) throw new NullPointerException();
		if(points<=0) throw new IllegalArgumentException();
		beneficiaryGroup=group;
		donorUser=user;
		donatedCredits=points;
		group.addPoints(points);
		user.spendPoints(points);
	}

	public Group getBenefeciary(){
		return beneficiaryGroup;
	}

	public User getDonor(){
		return donorUser;
	}

	public int getCreditsDonate(){
		return donatedCredits;
	}
}
