package tests.dao;

import junit.framework.TestCase;

import com.sun.org.apache.bcel.internal.Constants;

import dao.framework.AbstractProviderFactory;
import dao.framework.MockFactory;
import dto.AuctionDto;
import dto.UserDto;

public class OfertaTest extends TestCase {

	public void testBid() {
		MockFactory daoFactory = (MockFactory) AbstractProviderFactory
				.create(Constants.AALOAD);
		// TODO: ver que hacen estos constructores acaa!!
		// Product product = new Product();
		// ProductDto dto1 =
		// product.getProduct(product.createProduct("Sony","W50"));
		// AuctionDto auction;
		// auction = new AuctionDto(dto1);

		UserDto user1;
		UserDto user2;
		UserDto user3;
		UserDto user4;
		UserDto user5;

		user1 = new UserDto("nacho", "Arribalzaga", 4356 - 7890, 100, 1, 123,
				1902390, 110289);
		user2 = new UserDto("Anibal", "Lovaglio", 4351 - 7680, 190, 1, 223,
				2154356, 230478);
		user3 = new UserDto("Nicolas", "Cohen", 43569087, 230, 3, 100, 323543,
				300888);
		user4 = new UserDto("Berta", "Pancho", 58799087, 25, 5, 243, 65567,
				121188);
		user5 = new UserDto("Agustina", "Bazzano", 46782903, 320, 2, 450,
				324545, 241299);

		//		ofertar(user1, auction, 20);
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
