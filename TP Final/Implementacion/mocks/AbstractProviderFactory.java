package mocks;

public abstract class AbstractProviderFactory {

	public static AbstractProviderFactory Create(int providerType) {
		switch (providerType) {
		case Constants.MOCK:
			return new MockFactory();

		default:
			return null;
		}

	}
}
