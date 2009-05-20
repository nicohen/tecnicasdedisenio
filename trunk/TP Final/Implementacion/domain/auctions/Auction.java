package domain.auctions;

import domain.customers.Bidder;
import domain.exceptions.BidException;
import domain.exceptions.IllegalBidAmountException;
import domain.exceptions.NotEnoughMembersInGroupForBidException;
import domain.utils.VariationRateFunction;

/**
 * La clase remate es una generalización de todos los posibles remates que
 * existen para el modelo de negocio. Implementa toda la funcionalidad común a
 * cada tipo específico y permite la manipulación los mismos en los casos en que
 * no sea necesario distinguir entre cada uno. Es una clase abstracta por lo que
 * no puede ser instanciada.
 */
public abstract class Auction {

	protected Product prize;
	protected Bidder winner;
	protected AuctionStatus status;
	protected VariationRateFunction variationRateFunction;
	protected int value;
	protected AuctionType type;

	/**
	 * Recibe y maneja todos los valores de atributos, e inicializa las
	 * estructuras comunes de los tipos de remates. Estas son: el premio, la
	 * función razón de variación, el tipo y el valor con que se abre el remate.
	 * 
	 * @param prize
	 *            el producto que se va a rematar, de tipo {@link Product}
	 * @param varFunction
	 *            una función que determina los incrementos/decrementos en los
	 *            valores que tendrá un remate; instancia de la clase
	 *            {@link VariationRateFunction}
	 * @param type
	 *            el tipo del remate: enumerado que indica si es un remate
	 *            grupal o individual, incremental o reverso;
	 *            {@link AuctionType}
	 * @param startUpValue
	 *            valor inicial del remate: si fuera incremental, su valor base
	 *            sobre el cual se puede ofertar más, y si fuera reverso, el
	 *            valor máximo del que va a ir bajando hasta cero, o hasta la
	 *            primer oferta.
	 */
	public Auction(Product prize, VariationRateFunction varFunction,
			AuctionType type, int startUpValue) {
		this.prize = prize;
		this.variationRateFunction = varFunction;
		this.winner = null;
		this.status = AuctionStatus.ACTIVE;
		this.value = startUpValue;
		this.type = type;
	}

	/**
	 * Cierra un remate determinando un ganador.
	 */
	public abstract void finish();

	/**
	 * Devuelve el único monto válido que aceptará el remate para la siguiente
	 * oferta.
	 * 
	 * @return monto de la oferta que espera el remate
	 */
	public abstract int getAmountForNextBid();

	/**
	 * Registra un oferta hecha para el remate.
	 * 
	 * @param newBid
	 *            la oferta que se quiere hacer
	 * @throws NotEnoughMembersInGroupForBidException
	 *             en caso de ser un remate grupal, sólo pueden ofertar los
	 *             grupos que tengan miembros aparte de su administrador
	 * @throws IllegalBidAmountException
	 *             se debe chequear que se ofete la cantidad debida
	 * @see Bid
	 */
	abstract void takeNewBid(Bid newBid)
			throws IllegalBidAmountException,BidException;

	/**
	 * De haberse definido un ganador, devuelve el usuario del que se trata, en
	 * su defecto retorna null
	 * 
	 * @return el ganador del remate
	 * @see Bidder
	 */
	public Bidder getWinner() {
		return winner;
	}

	/**
	 * Devuelve el premio del remate, que será de tipo {@link Product}
	 * 
	 * @return el poducto que se remata
	 * @see Product
	 */
	public Product getPrize() {
		return this.prize;
	}

	/**
	 * Devuelve el estado de un remate; puede ser nuevo, activo, cerrado o
	 * pendiente de determinar el ganador
	 * 
	 * @return El estado actual del remate
	 * @see AuctionStatus
	 */
	public AuctionStatus getStatus() {
		return status;
	}

	/**
	 * Devuelve el tipo del remate; enmuerado {@link AuctionType}
	 * 
	 * @return El tipo del remate
	 * @see AuctionType
	 */
	public AuctionType getType() {
		return type;
	}
}