package src.domain.customers;

import java.util.Date;

import src.domain.querys.History;
import src.domain.querys.Transaction;

/**
 * Clase de transacción que consiste en el canje de una clave por puntos paa las
 * ofertas.
 */
public class KeyExchange extends Transaction {

	private Key myKey;
	private User user;
	private int points;

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
		super(new Date());
		this.user = user;
		myKey = Keys.getInstance().getKeyForExchange(code);
		History.getInstance().addKeyExchange(this);
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
}
