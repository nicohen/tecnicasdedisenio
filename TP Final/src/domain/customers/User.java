package domain.customers;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.exceptions.AlreadyUsedKeyException;
import domain.exceptions.BidException;
import domain.exceptions.GroupSizeExceededException;
import domain.exceptions.InvalidAuctionTypeException;
import domain.exceptions.InvalidDonationException;
import domain.exceptions.NonExistentKeyException;
import domain.exceptions.NotEnoughPointsToBidException;
import domain.exceptions.UserAlreadyInGroupException;

public class User extends Bidder {
	private int dni;
	private String name;
	private String lastName;
	private Group memberGroup;

	public User(int dni, String name, String lastName) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		memberGroup = null;
	}

	@Override
	public void bid(Auction anAuction) throws BidException,
			InvalidAuctionTypeException {

		int amount = anAuction.getAmountForNextBid();
		if (super.getPoints() < amount) {
			throw new NotEnoughPointsToBidException();
		}
		this.validateAuctionType(anAuction.getType());
		new Bid(this, anAuction, amount);
		this.compromisedPoints += amount;
		this.avaliablePoints -= amount;
	}

	@Override
	public void validateAuctionType(AuctionType type)
			throws InvalidAuctionTypeException {
		if (!type.equals(AuctionType.SINGLE)
				&& !type.equals(AuctionType.REVERSE)) {
			throw new InvalidAuctionTypeException(
					"El Remate no es del tipo correcto");
		}
	}

	public void donate(int points) throws InvalidDonationException {
		if (this.isMemberOfGroup()) {
			Group group = this.getGroupOfUser();
			if (this.getPoints() >= points) {
				new Donation(this, group, points);
			} else
				throw new InvalidDonationException(
						"El credito es insuficiente para ser donado");
		} else
			throw new InvalidDonationException(
					"El usuario no pertenece a ningun grupo");
	}

	public final String getLastName() {
		return lastName;
	}

	public final int getDni() {
		return dni;
	}

	public final String getName() {
		return name;
	}

	public boolean isMemberOfGroup() {
		if (memberGroup != null)
			return true;
		return false;
	}

	public final Group getGroupOfUser() {
		return memberGroup;
	}

	public void suscribeToGroup(Group group)
			throws UserAlreadyInGroupException, GroupSizeExceededException {
		if (this.memberGroup != null)
			throw new UserAlreadyInGroupException();
		try {
			group.addMember(this);
			this.memberGroup = group;
		} catch (GroupSizeExceededException e) {
			throw e;
		}

	}

	void setAsGroupOwner(Group group) {
		this.memberGroup = group;
	}

	public void exchangeKey(String code) throws NonExistentKeyException,
			AlreadyUsedKeyException {
		KeyExchange exchange = new KeyExchange(code, this);
		Key myKey = exchange.getKey();
		if (myKey == null)
			throw new NonExistentKeyException();
		else {
			addPoints(myKey.getPointsToExchange());
		}
	}
}