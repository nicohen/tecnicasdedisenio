package domain.utils;

/**
 * Clase encargada de determinar pasos de variación en los valores de los
 * remates.
 */
public class VariationRateFunction {

	/**
	 * Define la expresión que se ha de utilizar para generar los valores de los
	 * saltos
	 * 
	 * @param functionExpression
	 *            expresión de la función matemática que se utilizará de
	 *            referencia
	 */
	public VariationRateFunction(String functionExpression) {
	}

	/**
	 * Devuelve el valor del siguiente incremento o decremento en el valor del
	 * remate
	 * 
	 * @return el valor del siguiente salto
	 */
	public int nextDelta() {
		return (int) Math.round(Math.random() * 100);
	}
}
