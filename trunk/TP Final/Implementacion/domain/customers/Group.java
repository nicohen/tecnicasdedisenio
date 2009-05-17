package domain.customers;

import java.util.ArrayList;
import java.util.List;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.InvalidAuctionTypeException;

public class Group extends Bidder {

	private User owner;
	private List<User> members;
	
	public Group(User owner) throws UserAlreadyInGroupException {
		super();
		if (owner.isMemberOfGroup()) throw new UserAlreadyInGroupException();
		this.owner = owner;
		owner.setAsGroupOwner(this);
		this.members = new ArrayList<User>();
	}

	@Override
	public void bid(Auction anAuction) throws NotEnoughMembersInGroupForBidException, InvalidAuctionTypeException, notEnoughPointsToBidException {
		if (members.size() >= 1) {// no puede ofertar un grupo de un solo miembro
			int amount = anAuction.getAmountForNextBid();
			if (super.getPoints() < amount) {
				throw new notEnoughPointsToBidException();
			}
			this.validateAuctionType(anAuction.getType());

			new Bid(this, anAuction, amount);
		} else {
			throw new NotEnoughMembersInGroupForBidException("El grupo no esta apto para ofertar. No tiene miembros");
		}
	}

	public void validateAuctionType(AuctionType type)
			throws InvalidAuctionTypeException {
		if (!type.equals(AuctionType.GROUP)) {
			throw new InvalidAuctionTypeException("El remate deberia ser para grupo");
		}
	}

	public void addMember(User member) {
		this.members.add(member);
	}
	
	public int getAmountOfMembersOfGroup(){
		int amount=1; // El primero es el Owner
		amount+=members.size();
		return amount;
	}

}
