package domain.auctions;
import domain.customers.*;



public class Donation {
	private Group beneficiaryGroup;
	private User donorUser;
	private int donateCredits;
	   
	 /** Creates a new instance of Donation */
	 public Donation(User user,Group group,int points) {
	    beneficiaryGroup=group;
	    donorUser=user;
	    donateCredits=points;
	 }
		           
	 public Group getBenefeciary(){
		 return beneficiaryGroup;
	 }
	    
	public User getDonor(){
		return donorUser;
	}
	
	public int getCreditsDonate(){
		return donateCredits;
	}
}
