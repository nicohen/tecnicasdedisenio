package dao;

import dao.framework.IDao;
import dto.AuctionDto;

public abstract class AuctionDao implements IDao<AuctionDto> {

	public abstract int add(AuctionDto product);

	public abstract AuctionDto get(int productId);

}
