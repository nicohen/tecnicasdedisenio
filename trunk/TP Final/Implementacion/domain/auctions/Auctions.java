package domain.auctions;

import java.util.ArrayList;

public class Auctions {

	private static Auctions instance = null;

	private ArrayList<Auction> allAuctions;

	private Auctions() {
		this.allAuctions = new ArrayList<Auction>();
	}

	public static Auctions getAuctions() {
		if (Auctions.instance == null)
			Auctions.instance = new Auctions();
		return Auctions.instance;
	}

	public void addAuction(Auction auction) throws NullPointerException {
		if (auction != null) {
			this.allAuctions.add(auction);
		} else {
			throw new NullPointerException();
		}
	}

	public Auction getAnAuction() {
		return this.allAuctions.get(0); // FIXME
	}

}
