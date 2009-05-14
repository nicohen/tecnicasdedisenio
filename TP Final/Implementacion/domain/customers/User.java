package domain.customers;

import java.util.Date;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.auctions.InvalidAuctionTypeException;

public class User extends Bidder {
	private int dni;
	private String name;
	private String lastName;
	private Date birthDate;

	public User(int dni, String name, String lastName, Date birthDate) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
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
}
