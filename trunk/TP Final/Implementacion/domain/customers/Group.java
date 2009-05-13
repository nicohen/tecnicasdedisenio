package domain.customers;

import java.util.ArrayList;
import java.util.List;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;

public class Group extends Bidder {

	private User owner;
	private List<User> members;
		
	public Group(User owner){
		super();
		this.owner = owner;
		this.members = new ArrayList<User>();
	}
	
	public void bid(Auction anAuction) {
		if(members.size()>=1){//no puede ofertar un grupo de un solo miembro
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

			Bid myBid = new Bid(this.owner, amount);
			anAuction.takeNewBid(myBid);
		}//else
			//throw new Throwable();
	}

	public void validateAuctionType(AuctionType type) throws Throwable {
		if (!type.equals(AuctionType.GROUP)) {
			// TODO: crear excepcion
			throw new Throwable();
		}
	}

	public void addMember(User member){
		this.members.add(member);
	}
	
}
