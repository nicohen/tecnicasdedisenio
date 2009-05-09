import domain.products.Product;
import mocks.AbstractProviderFactory;
import mocks.Constants;
import mocks.MockFactory;


public class Test {

	public static void main(String[] args) {
		MockFactory daoFactory = (MockFactory) AbstractProviderFactory.create(Constants.MOCK);
		Product product = new Product(daoFactory.getProductProvider());
		
		System.out.println(product.getProduct(product.createProduct("Sony", "W50")));
	}

}
