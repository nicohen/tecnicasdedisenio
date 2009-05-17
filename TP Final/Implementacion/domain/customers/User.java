package domain.customers;

import java.util.Date;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.InvalidAuctionTypeException;
import domain.auctions.InvalidDonationException;


public class User extends Bidder {
	private int dni;
	private String name;
	private String lastName;
	private Date birthDate;
	private Group memberGroup;

	public User(int dni, String name, String lastName, Date birthDate) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		memberGroup=null;
	}

	@Override
	public void bid(Auction anAuction) throws notEnoughPointsToBidException, InvalidAuctionTypeException {

		int amount = anAuction.getAmountForNextBid();
		if (super.getPoints() < amount) {
			throw new notEnoughPointsToBidException();
		}
		this.validateAuctionType(anAuction.getType());

		try {
			new Bid(this, anAuction, amount);
		} catch (NotEnoughMembersInGroupForBidException e) {
			// Este caso no se se puede dar ya que el bidder es un user y no un group
		}
		this.compromisedPoints += amount;
		this.avaliablePoints -= amount;
	}

	@Override
	public void validateAuctionType(AuctionType type)
			throws InvalidAuctionTypeException {
		if (!type.equals(AuctionType.SINGLE)
				&& !type.equals(AuctionType.REVERSE)) {
			throw new InvalidAuctionTypeException("El Remate no es del tipo correcto");
		}
	}
	

	public Donation donate(int points) throws InvalidDonationException {
		if (this.isMemberOfGroup()){
			Group group=this.getGroupOfUser();
			if (this.getPoints()>= points){
				return new Donation(this, group, points);
			}
			else
				throw new InvalidDonationException("El credito es insuficiente para ser donado");
		}
		else 
			throw new InvalidDonationException("El usuario no pertenece a ningun grupo"); 
	}


	public Date getBirthDate() {
		return birthDate;
	}

	public String getLastName() {
		return lastName;
	}

	public int getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}
	
	public boolean isMemberOfGroup(){
		if(memberGroup != null)
			return true;
		return false;
	}
	
	public Group getGroupOfUser(){
		return memberGroup;
	}
	
	public void suscribeToGroup(Group group) throws UserAlreadyInGroupException{
		if(this.memberGroup != null) throw new UserAlreadyInGroupException();
		group.addMember(this);
		this.memberGroup=group;
	}
	
	void setAsGroupOwner(Group group) {
		this.memberGroup = group;
	}
}
