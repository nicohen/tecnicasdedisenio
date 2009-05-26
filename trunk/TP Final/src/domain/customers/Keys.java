package domain.customers;

import java.util.HashMap;
import java.util.Map;

/**
 * Colecci�n de claves implementada con el patr�n Singleton, accesible desde
 * todos lados para poder obtener cualquier clave viva en el sistema
 */
public class Keys {
	private Map<String, Key> keyMap;
	// SINGLETON
	static private Keys keys = new Keys();

	/**
	 * Inicializa la colecci�n
	 */
	private Keys() {
		this.keyMap = new HashMap<String, Key>();
	}

	/**
	 * Punto de acceso a la �nica instancia; devuelve la instancia creada de la
	 * colecci�n de claves
	 * 
	 * @return instancia de Keys
	 */
	public static Keys getInstance() {
		return keys;
	}

	/**
	 * Chequea la existencia de una clave en el negocio
	 * 
	 * @param code
	 *            string alfanum�rico que identifica la clave buscada
	 * @return valor de verdad de la existencia de la clave
	 */
	public boolean containsKey(String code) {
		return this.keyMap.containsKey(code);
	}

	/**
	 * Devuelve la clave solicitada para ser usuada o null si no existe
	 * 
	 * @param code
	 *            string alfanum�rico que identifica la clave pedida
	 * @return la Key solicitada
	 */
	public Key getKeyForExchange(String code) {
		return this.keyMap.get(code);
	}

	/**
	 * Registra una clave nueva en la colecci�n
	 * 
	 * @param key
	 *            instancia de la clase {@link Key} a agregar a la colecci�n
	 */
	public void addKey(Key key) {
		this.keyMap.put(key.getCode(), key);
	}
}
