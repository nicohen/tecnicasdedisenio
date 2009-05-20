package domain.customers;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.IllegalBidAmount;
import domain.auctions.InvalidAuctionTypeException;
import domain.auctions.InvalidDonationException;

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
	public void bid(Auction anAuction) throws notEnoughPointsToBidException,
			InvalidAuctionTypeException {

		int amount = anAuction.getAmountForNextBid();
		if (super.getPoints() < amount) {
			throw new notEnoughPointsToBidException();
		}
		this.validateAuctionType(anAuction.getType());

		try {
			new Bid(this, anAuction, amount);
		} catch (NotEnoughMembersInGroupForBidException e) {
			// Este caso no se se puede dar ya que el bidder es un user y no un
			// group
		} catch (IllegalBidAmount e) {
			// Este caso no se se puede dar ya que la cantidad pasada se acaba
			// de pedir al remate
		}
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

	public String getLastName() {
		return lastName;
	}

	public int getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public boolean isMemberOfGroup() {
		if (memberGroup != null)
			return true;
		return false;
	}

	public Group getGroupOfUser() {
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
			try {
				addPoints(myKey.getPointsToExchange());
			} catch (AlreadyUsedKeyException e) {
				throw e;
			}
		}
	}
}
