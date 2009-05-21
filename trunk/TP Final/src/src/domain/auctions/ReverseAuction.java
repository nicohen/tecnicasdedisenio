package src.domain.auctions;

import java.util.Date;

import src.domain.customers.Bidder;
import src.domain.exceptions.BidException;
import src.domain.exceptions.IllegalBidAmountException;
import src.domain.exceptions.NotEnoughMembersInGroupForBidException;
import src.domain.utils.VariationRateFunction;

/**
 * Tipo de remate inverso. Consiste en un remate que comienza con un valor base
 * que se va decrementando, esperando recibir una oferta válida en algún momento
 * de su camino hasta el valor 0. El primer postor que oferta y está habilitado,
 * lo gana
 */
public class ReverseAuction extends Auction {

	/**
	 * La cantidad de minutos que esperará para cada decremento en su valor
	 */
	public static int STEP_SIZE_IN_MINUTES = 1;

	private Bid firstBid;
	private Date startingDate;
	private Date lastCheckedDate;
	private int startingValue;

	/**
	 * Constructor. Inicializa las particularidades del tipo de remate propio
	 * como la fecha en que arranca. Invoca al construtor de la clase ancestra
	 * para la inicialización de los atributos generales.
	 * 
	 * @param prize
	 *            Producto rematado
	 * @param varFunction
	 *            Función razón de decremento por cada paso.
	 * @param startUpValue
	 *            Costo inicial del que empezar a disminuir
	 * @see Auction
	 * @see VariationRateFunction
	 * @see Product
	 */
	public ReverseAuction(Product prize, VariationRateFunction varFunction,
			int startUpValue) {
		super(prize, varFunction, AuctionType.REVERSE, startUpValue);
		this.firstBid = null;
		this.lastCheckedDate = this.startingDate = new Date();
		this.startingValue = startUpValue;
	}

	@Override
	/*
	 * * Finaliza el remate
	 * 
	 * @see Auction.finish
	 */
	public void finish() {
		this.status = AuctionStatus.CLOSED;
		Bidder bidder = this.firstBid.getOwner();
		bidder.win(this, this.firstBid);
		this.winner = this.firstBid.getOwner();
	}

	@Override
	/*
	 * * Devuelve la cantidad a ofertar necesaria para que la oferta sea válida
	 * 
	 * @see Auction.getAmountForNextBid
	 */
	public final int getAmountForNextBid() {
		// TODO: Se debería tener un objeto Syncronizer, en un thread aparte,
		// que dispare los eventos de actualización de este tipo de casos.
		long startingMS = this.lastCheckedDate.getTime();
		this.lastCheckedDate = new Date();
		long actualMS = this.lastCheckedDate.getTime();
		long diff = (actualMS - startingMS) / 60000;
		diff /= ReverseAuction.STEP_SIZE_IN_MINUTES;

		for (long i = 0; (i < diff) && (this.value > 0); i++) {
			int tmp = this.variationRateFunction.nextDelta();
			this.value = (tmp < this.value) ? this.value - tmp : 0;
		}
		return this.value;
	}

	@Override
	/*
	 * * Acepta una nueva oferta. Puede lanzar excepciones por inconsistencias
	 * en el monto ofertado
	 * 
	 * @throws IllegalBidAmount se lanzará una excepción en caso de que el monto
	 * ofertado no sea el esperado
	 * 
	 * @see Auction.takeNewBid
	 */
	void takeNewBid(Bid newBid) throws IllegalBidAmountException, BidException {
		if (newBid.getValue() != this.value)
			throw new IllegalBidAmountException(
					"El valor ofertado es incorrecto");
		if (!newBid.getOwner().isAllowedToWin()) {
			throw new NotEnoughMembersInGroupForBidException(
					"El usuario no esta habilitado para ofertar");
		}
		this.firstBid = newBid;
		this.finish();
	}

	/**
	 * Devuelve la fecha, de tipo {@link Date} en que se dio de alta el remate
	 * 
	 * @return la fecha en que el remate fue creado
	 */
	public final Date getStartingDate() {
		return startingDate;
	}

	/**
	 * Devuelve el valor inicial que tenía el remate
	 * 
	 * @return el monto inicial del remate
	 */
	public final int getStartingValue() {
		return startingValue;
	}
}
