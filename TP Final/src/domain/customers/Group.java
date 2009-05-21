package domain.customers;

import java.util.ArrayList;
import java.util.List;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.exceptions.BidException;
import domain.exceptions.GroupSizeExceededException;
import domain.exceptions.InvalidAuctionTypeException;
import domain.exceptions.NotEnoughMembersInGroupForBidException;
import domain.exceptions.NotEnoughPointsToBidException;
import domain.exceptions.UserAlreadyInGroupException;
import domain.utils.BusinessRules;

public class Group extends Bidder {

	private User owner;
	private List<User> members;

	/**
	 * Previa validaci�n del usuario due�o del grupo a crear,inicializa las
	 * estructuras necesarias para la implementaci�n de un grupo
	 * 
	 * @param owner
	 *            due�o del grupo a crear
	 * 
	 * @throws UserAlreadyInGroupException
	 *             se lanzara si el usuario due�o es miembro de otro grupo
	 */
	public Group(User owner) throws UserAlreadyInGroupException {
		super();
		if (owner.isMemberOfGroup())
			throw new UserAlreadyInGroupException();
		this.owner = owner;
		owner.setAsGroupOwner(this);
		this.members = new ArrayList<User>();
	}

	@Override
	public void bid(Auction anAuction) throws InvalidAuctionTypeException,
			BidException, NotEnoughMembersInGroupForBidException {
		if (members.size() > BusinessRules.BID_MINIMUM_GROUP_SIZE - 1) {
			int amount = anAuction.getAmountForNextBid();
			if (super.getPoints() < amount) {
				throw new NotEnoughPointsToBidException();
			}
			this.validateAuctionType(anAuction.getType());
			new Bid(this, anAuction, amount);
		} else {
			throw new NotEnoughMembersInGroupForBidException(
					"El grupo no esta apto para ofertar. No tiene miembros");
		}
	}

	public void validateAuctionType(AuctionType type)
			throws InvalidAuctionTypeException {
		if (!type.equals(AuctionType.GROUP)) {
			throw new InvalidAuctionTypeException(
					"El remate deberia ser para grupo");
		}
	}

	public void addMember(User member) throws GroupSizeExceededException {
		if (this.members.size() >= BusinessRules.MAX_GROUP_SIZE) {
			throw new GroupSizeExceededException(
					"Cantidad m�xima de miembros superada");
		} else
			this.members.add(member);
	}

	public final int getAmountOfMembersOfGroup() {
		int amount = 1; // El primero es el Owner
		amount += members.size();
		return amount;
	}

	public final User getOwner() {
		return owner;
	}
}