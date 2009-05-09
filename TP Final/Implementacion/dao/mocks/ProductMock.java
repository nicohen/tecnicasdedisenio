package dao.mocks;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dto.ProductDto;

public class ProductMock extends ProductDao {

	private static List<ProductDto> productList;

	public ProductMock() {
		productList = new ArrayList<ProductDto>();
	}

	public int add(ProductDto product) {
		productList.add(product);
		return productList.size() - 1;
	}

	public ProductDto get(int productId) {
		return productList.get(productId);
	}

}
