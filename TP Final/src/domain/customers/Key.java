package domain.customers;

import domain.exceptions.AlreadyUsedKeyException;

/**
 * Clase usada en la mec�nica de obtenci�n de puntos. es la responsable de
 * registrar si una clave ya se utiliz� o no. Se usa para la instanciaci�n de
 * transacciones de canje de claves.
 */
public class Key {

	private String code;
	private int points;
	private boolean used;
	private Long keyId;

	/**
	 * Inicializa la estructura y registra la clave en lacolecci�n de todas las
	 * claves
	 * 
	 * @param code
	 *            string alfanum�rico que identifica un�vocamente a la clave
	 * @param points
	 *            puntos que vale a la hora de canjearse
	 */
	public Key(String code, int points) {
		this.code = code;
		this.points = points;
		this.used = false;
		this.keyId = System.currentTimeMillis();
		// add a KEYS
		Keys.getInstance().addKey(this);
	}

	/**
	 * Devuelve los puntos que vale si es que no fue usada todav�a
	 * 
	 * @return los puntos que vale
	 * @throws AlreadyUsedKeyException
	 *             se lanza si ya se us� la clave
	 */
	public final int getPointsToExchange() throws AlreadyUsedKeyException {
		if (!used) {
			this.used = true;
			return this.points;
		} else
			throw new AlreadyUsedKeyException();
	}

	/**
	 * Devuelve el string alfanum�rico que la identifica
	 * 
	 * @return string alfanum�rico identificador
	 */
	public final String getCode() {
		return code;
	}

	public Long getKeyId() {
		return this.keyId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Key)){
			return false;
		}
		Key cKey = (Key)obj;
		return this.code.equals(cKey.code);
	}
	@Override
	public int hashCode() {
		return this.code.hashCode();
	}
}
