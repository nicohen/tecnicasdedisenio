package domain.customers;

import java.util.Date;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;

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

	public void acceptGroupInvitation(int idGrupo){

	}

	public String getName() {
		return name;
	}

	public void declineGroupInvitation(int idGrupo) {

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

	@Override
	public void bid(Auction anAuction) {
		
		int amount = anAuction.getAmountForNextBid();
		if(super.getPoints() < amount){
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
	public void validateAuctionType(AuctionType type) throws Throwable {
		if (!type.equals(AuctionType.SINGLE)) {
			// TODO: crear excepcion
			throw new Throwable();
		}
	}
	
}
