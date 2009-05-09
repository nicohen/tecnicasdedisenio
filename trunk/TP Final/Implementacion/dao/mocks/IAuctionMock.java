package dao.mocks;

import domain.auctions.IAuction;

@SuppressWarnings("hiding")
public interface IAuctionMock<IAuction> {

	public void add(IAuction auction);
	public IAuction get(int id);

}
