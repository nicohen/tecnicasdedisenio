package dao.framework;

import dao.mocks.ProductMock;

public class MockFactory extends AbstractProviderFactory {
		
	public ProductMock getProductProvider(){
		return new ProductMock();
	}
	
	
}
//afuera es AbstractProviderFactory.create(MOCK).getProductProvider()