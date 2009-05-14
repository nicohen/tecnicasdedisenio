package domain.customers;

import java.util.ArrayList;
import java.util.List;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.InvalidAuctionTypeException;
import domain.auctions.InvalidBidException;

public class Group extends Bidder {

	private User owner;
	private List<User> members;

	public Group(User owner) {
		super();
		this.owner = owner;
		this.members = new ArrayList<User>();
	}

	public void bid(Auction anAuction) {
		if (members.size() >= 1) {// no puede ofertar un grupo de un solo
			// miembro
			int amount = anAuction.getAmountForNextBid();
			if (super.getPoints() < amount) {
				throw new IllegalArgumentException(); // TODO: cambiar
				// excepciones
			}
			try {
				this.validateAuctionType(anAuction.getType());
			} catch (InvalidAuctionTypeException e) {
				e.printStackTrace();
				return;
			}

			new Bid(this.owner, anAuction, amount);
		} else {
			throw new InvalidBidException(
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

	public void addMember(User member) {
		this.members.add(member);
	}

}
