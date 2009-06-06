package domain.querys;

import java.util.Date;

import domain.customers.User;

/**
 * Clase descendiente de transaccion, la cual representa una consulta al sistema
 * 
 */
public class Query implements Comparable<Query> {

	private User user;
	private Date occurrenceDate;

	/**
	 * Agrega una entrada de su mismo tipo a la clase Historial, mediante la
	 * invocacion del metodo correspondiente, previa llamada al constructor de
	 * la clase ancestra que inicializa los aspectos comunes a todas las
	 * transacciones.
	 * 
	 * @param Date
	 *            fecha de consulta
	 * 
	 * @see History
	 */
	public Query(User aUser, Date date) {
		occurrenceDate = new Date();
		this.user = aUser;
		History.getInstance().addQuery(this);
	}

	@Override
	public int compareTo(Query other) {
		int res = this.user.compareTo(other.user);
		if (res != 0)
			return res;
		res = this.occurrenceDate.compareTo(other.occurrenceDate);
		return res;
	}

	public Date getDate() {
		return this.occurrenceDate;
	}

	public User getUser() {
		return user;
	}

}
