package domain.customers;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import domain.auctions.Auction;
import domain.auctions.AuctionType;

public class User implements Bidder {
	private int dni;
	private String name;
	private String lastName;
	private Date birthDate;
	private int points;
	private Set<Auction> wonAuctions;

	public User(int dni, String name, String lastName, Date birthDate) {
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.wonAuctions = new HashSet<Auction>();
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public void spendPoints(int points) {
		if (this.points < points)
			throw new IllegalArgumentException();
		this.points -= points;
	}

	public void acceptGroupInvitation(int idGrupo) {

	}

	public String getName() {
		return name;
	}

	public void declineGroupInvitation(int idGrupo) {

	}

	public Date getBirthDate() {
		return birthDate;
	}

	public int getPoints() {
		return points;
	}

	public String getLastName() {
		return lastName;
	}

	public int getDni() {
		return dni;
	}

	public Set<Auction> getWonAuctions() {
		return wonAuctions;
	}

	public void bid() {
	}

	public void win(Auction auction) {
		this.wonAuctions.add(auction);
	};

	public void validateAuctionType(AuctionType type) throws Throwable {
		if (!type.equals(AuctionType.SINGLE)) {
			// TODO: crear excepcion
			throw new Throwable();
		}
	}

	public boolean isAllowedToWin() {
		return getWonAuctions().isEmpty();
	}
}
