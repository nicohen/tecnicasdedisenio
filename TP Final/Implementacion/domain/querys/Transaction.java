package domain.querys;

import java.util.Date;

/**
 * La clase Transaction es una generalizacion de todas las transacciones que maneja
 * el sistema. 
 * 
 */
public abstract class Transaction {
	
	protected Date occurrenceDate;
	
	/**
	 * Inicializa la fecha en la cual se produjo la transaccion.
	 *
	 * @param Date
	 *            fecha de transaccion
	 *
	 */
	public Transaction (Date aDate){
		this.occurrenceDate = aDate;
	}
	
	public Date getDate() {
		return this.occurrenceDate;
	}
	
}
