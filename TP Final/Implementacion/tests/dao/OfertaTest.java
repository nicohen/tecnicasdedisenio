package tests.dao;

import com.sun.org.apache.bcel.internal.Constants;

import dao.framework.AbstractProviderFactory;
import dao.framework.MockFactory;
import domain.products.Product;
import dto.AuctionDto;
import dto.ProductDto;
import dto.UserDto;
import junit.framework.TestCase;

public class OfertaTest extends TestCase {
	public void testBid() {
		MockFactory daoFactory = (MockFactory) AbstractProviderFactory
				.create(Constants.AALOAD);
		Product product = new Product(daoFactory.getProductProvider());

		ProductDto dto1 = product.getProduct(product.createProduct("Sony",
				"W50"));

		AuctionDto auction;
		auction = new AuctionDto(dto1);

		UserDto user;
		user = new UserDto("nacho", "nacho", 333, 100, 1, 1, 1, 1, 0);

		ofertar(user, auction, 20);
		// EL ofertar deberia hacer las validaciones de puntos
		// En el ofertar agarro alguna excepcion si las validaciones no dan ok
		// Este puede dar ok, y hacer otro donde los puntos que se necesitan
		// sean mayores a
		// los puntos que tiene disponible el usuario

		// assertEquals();

	}

	private void ofertar(UserDto user, AuctionDto auction, int i) {
		// TODO Auto-generated method stub

	}

	// private void assertEquals(String string, String brand) {
	// TODO Auto-generated method stub

	// }
}
