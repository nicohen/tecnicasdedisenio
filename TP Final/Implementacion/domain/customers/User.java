package domain.customers;

import java.util.Date;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.Donation;
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
	public void bid(Auction anAuction) {

		int amount = anAuction.getAmountForNextBid();
		if (super.getPoints() < amount) {
			throw new IllegalArgumentException(); // TODO: cambiar excepciones
		}
		try { // TODO: Esta excepción debería mandarse para arriba, pero hay que
			// definir las clases excepciones necesarias.
			this.validateAuctionType(anAuction.getType());
		} catch (InvalidAuctionTypeException e) {
			e.printStackTrace();
		}

		new Bid(this, anAuction, amount);
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
	

	public void donate(User user,int points) {
		if (user.isMemberaGroup()){
			Group group=user.getGroupOfUsser();
			//if(group.getAmountOfMembersOfGroup() >= Constants.MinAmountOfGroup){
				if (user.getPoints()>= points){
					new Donation(user, group, points);
					group.addCredits(points);
					user.addPoints(-points);
				}
				else
					throw new InvalidDonationException("El credito es insuficiente para ser donado");
			//}
			//else 
			//	throw new InvalidDonationException("Para poder donar a un grupo deben existir mas de dos integrantes en el mismo");
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
	
	public boolean isMemberaGroup(){
		if(memberGroup != null)
			return true;
		return false;
	}
	
	public Group getGroupOfUsser(){
		return memberGroup;
	}
	
	public void suscribeToGroup(Group group){
		this.memberGroup=group;
		
	}
}
