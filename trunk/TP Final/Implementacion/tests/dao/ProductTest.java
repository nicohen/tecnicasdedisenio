package tests.dao;
import junit.framework.TestCase;
import utils.Constants;
import dao.framework.AbstractProviderFactory;
import dao.framework.MockFactory;
import domain.products.Product;
import dto.ProductDto;


public class ProductTest extends TestCase {

	public void testSaveProduct() {
		MockFactory daoFactory = (MockFactory) AbstractProviderFactory.create(Constants.MOCK);
		Product product = new Product(daoFactory.getProductProvider());
		
		ProductDto dto1 = product.getProduct(product.createProduct("Sony", "W50"));
		ProductDto dto2 = product.getProduct(product.createProduct("Canon", "W540"));
		assertEquals("Sony",dto1.getBrand());
		assertEquals("W50",dto1.getModel());
		assertEquals("Canon",dto2.getBrand());
		assertEquals("W540",dto2.getModel());
	}

}
