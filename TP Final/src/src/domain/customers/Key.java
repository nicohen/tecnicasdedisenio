package src.domain.customers;

import src.domain.exceptions.AlreadyUsedKeyException;

/**
 * Clase usada en la mecánica de obtención de puntos. es la responsable de
 * registrar si una clave ya se utilizó o no. Se usa para la instanciación de
 * transacciones de canje de claves.
 */
public class Key {

	private String code;
	private int points;
	private boolean used;

	/**
	 * Inicializa la estructura y registra la clave en lacolección de todas las
	 * claves
	 * 
	 * @param code
	 *            string alfanumérico que identifica unívocamente a la clave
	 * @param points
	 *            puntos que vale a la hora de canjearse
	 */
	public Key(String code, int points) {
		this.code = code;
		this.points = points;
		this.used = false;
		// add a KEYS
		Keys.getInstance().addKey(this);
	}

	/**
	 * Devuelve los puntos que vale si es que no fue usada todavía
	 * 
	 * @return los puntos que vale
	 * @throws AlreadyUsedKeyException
	 *             se lanza si ya se usó la clave
	 */
	public final int getPointsToExchange() throws AlreadyUsedKeyException {
		if (!used) {
			this.used = true;
			return this.points;
		} else
			throw new AlreadyUsedKeyException();
	}

	/**
	 * Devuelve el string alfanumérico que la identifica
	 * 
	 * @return string alfanumérico identificador
	 */
	public final String getCode() {
		return code;
	}
}
