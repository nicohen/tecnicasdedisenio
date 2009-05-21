package src.domain.auctions;

/**
 * Clase que modeliza aquello que se va a rematar. Una unidad rematable, que
 * puede constar de todos los objetos reales que quien de de alta un remate
 * desee poner a remate.
 */
public class Product {

	private String description;

	/**
	 * Inicializa la estructura.
	 * 
	 * @param description
	 *            descripci�n del producto a rematar
	 */
	public Product(String description) {
		this.description = description;
	}

	/**
	 * Devuelve la descripci�n del producto
	 * 
	 * @return la descripci�n del producto
	 */
	public final String getDescription() {
		return description;
	}
}
