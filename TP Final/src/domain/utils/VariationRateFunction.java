package domain.utils;

/**
 * Clase encargada de determinar pasos de variaci�n en los valores de los
 * remates.
 */
public class VariationRateFunction {

	/**
	 * Define la expresi�n que se ha de utilizar para generar los valores de los
	 * saltos
	 * 
	 * @param functionExpression
	 *            expresi�n de la funci�n matem�tica que se utilizar� de
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
