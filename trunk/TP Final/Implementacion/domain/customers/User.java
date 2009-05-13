package domain.customers;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;

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
		return  new HashSet<Auction>(this.wonAuctions);
	}

	@Override
	public void bid(Auction anAuction) {
		
		int amount = anAuction.getAmountForNextBid();
		if(this.points < amount){
			throw new IllegalArgumentException(); // TODO: cambiar excepciones
		}
		try { // TODO: Esta excepción debería mandarse para arriba, pero hay que definir las clases excepciones necesarias.
			this.validateAuctionType(anAuction.getType());
		} catch (Throwable e) {
			e.printStackTrace();
			return;
		}
		
		Bid myBid = new Bid(this, amount);
		anAuction.takeNewBid(myBid);
		
	}

	@Override
	public void win(Auction auction) {
		this.wonAuctions.add(auction);
	};

	@Override
	public void validateAuctionType(AuctionType type) throws Throwable {
		if (!type.equals(AuctionType.SINGLE)) {
			// TODO: crear excepcion
			throw new Throwable();
		}
	}

	@Override
	public boolean isAllowedToWin() {
		return getWonAuctions().isEmpty();
	}
}
