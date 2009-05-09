import utils.Constants;
import dao.framework.AbstractProviderFactory;
import dao.framework.MockFactory;
import domain.products.Product;


public class Test {

	public static void main(String[] args) {
		MockFactory daoFactory = (MockFactory) AbstractProviderFactory.create(Constants.MOCK);
		Product product = new Product(daoFactory.getProductProvider());
		
		System.out.println(product.getProduct(product.createProduct("Sony", "W50")));
	}

}
