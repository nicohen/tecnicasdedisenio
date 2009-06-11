package domain.customers;

import java.util.Date;

import domain.exceptions.KeyExchangeAlreadyInstanciatedException;
import domain.querys.History;

/**
 * Clase de transacción que consiste en el canje de una clave por puntos paa las
 * ofertas.
 */
public class KeyExchange implements Comparable<KeyExchange> {

	private Key myKey;
	private User user;
	private int points;
	private Date occurrenceDate;
	private long keyExchangeId;

	

	/**
	 * Inicializa los datos, invoca al constructor de la clase ancestra
	 * inicializando la fecha y se registra en el historial
	 * 
	 * @param code
	 *            string alfanumérico que identifica la clave que se está
	 *            canjeando
	 * @param user
	 *            usuario que solicita el canje
	 */
	public KeyExchange(String code, User user) {
		occurrenceDate = new Date();
		this.user = user;
		myKey = Keys.getInstance().getKeyForExchange(code);
		History.getInstance().addKeyExchange(this);
		this.keyExchangeId = System.currentTimeMillis();
	}

	/**
	 * Devuelve la clave a la que refiere
	 * 
	 * @return Key involucrada en la transacción
	 */
	public final Key getKey() {
		return this.myKey;
	}

	/**
	 * Devuelve el usuario que hizo el canje
	 * 
	 * @return usuario involucrada en la transacción
	 */
	public final User getUser() {
		return user;
	}

	/**
	 * Devuelve los puntos que se obtuvieron en el canje
	 * 
	 * @return puntos canjeados
	 */
	public final int getPoints() {
		return points;
	}

	@Override
	public int compareTo(KeyExchange other) {
		return this.myKey.getCode().compareTo(other.myKey.getCode());
	}

	public Date getDate() {
		return this.occurrenceDate;
	}
	
	public long getKeyExchangeId() {
		return keyExchangeId;
	}
	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto
	 * KeyExchange que por algún motivo se haya quitado de la memoria
	 */
	private KeyExchange() {
	}

	/**
	 * @param Key
	 *            the Key to set
	 */
	private void setKey(Key key) {
		this.myKey = key;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	private void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	private void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @param occurrenceDate
	 *            the occurrenceDate to set
	 */
	private void setOccurrenceDate(Date occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}

	// TODO: test methods
	/**
	 * 
	 * @param user
	 * @param key
	 * @param points
	 * @param date
	 * @return
	 * @throws KeyExchangeAlreadyInstanciatedException
	 */
	public static KeyExchange buildExistantKeyExchange(User user, Key key,
			int points, Date date)
			throws KeyExchangeAlreadyInstanciatedException {
		if (History.getInstance().haveKeyExchange(key.getCode())) {
			throw new KeyExchangeAlreadyInstanciatedException();
		}
		KeyExchange aKeyExchange = new KeyExchange();
		aKeyExchange.setKey(key);
		aKeyExchange.setOccurrenceDate(date);
		aKeyExchange.setPoints(points);
		aKeyExchange.setUser(user);
		return aKeyExchange;
	}
}
