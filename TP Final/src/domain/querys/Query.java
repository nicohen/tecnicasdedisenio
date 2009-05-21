package domain.querys;

import java.util.Date;

/**
 * Clase descendiente de transaccion, la cual representa una consulta al sistema
 * 
 */
public class Query extends Transaction {

	/**
	 * Agrega una entrada de su mismo tipo a la clase Historial, mediante la invocacion
	 * del metodo correspondiente, previa llamada al constructor de la clase ancestra que
	 * inicializa los aspectos comunes a todas las transacciones.
	 * 
	 * @param Date
	 *            fecha de consulta
	 * 
	 * @see History
	 */
	public Query(Date date) {
		super(new Date());
		History.getInstance().addQuery(this);
	}

}
