package mocks;

public class MockFactory extends AbstractProviderFactory {
		
	public ProductMock getProductProvider(){
		return new ProductMock();
	}
	
	
}
//afuera es AbstractProviderFactory.create(MOCK).getProductProvider()