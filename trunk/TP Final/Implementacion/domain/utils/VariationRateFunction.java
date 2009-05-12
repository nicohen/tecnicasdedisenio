package domain.utils;

public class VariationRateFunction {

	public VariationRateFunction(String functionExpression) {}
	
	public int nextDelta () {
		return (int) Math.round(Math.random()*100);
	}
}
