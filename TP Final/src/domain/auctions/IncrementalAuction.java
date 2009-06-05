package domain.auctions;

import java.util.Stack;

import domain.customers.Bidder;
import domain.exceptions.IllegalBidAmountException;
import domain.exceptions.InvalidAuctionTypeException;
import domain.exceptions.NoBiddersException;
import domain.utils.VariationRateFunction;

/**
 * Clase de remate incremental. Su costo irá subiendo con las sucesivas ofertas.
 */
public class IncrementalAuction extends Auction {

	private int nextBidValue;
	public int getNextBidValue() {
		return nextBidValue;
	}

	private Stack<Bid> bids;

	/**
	 * Inicializa las estructuras necesarias para la implementación de un remate
	 * incremental, previa llamada al constructor de la clase ancestra que
	 * inicializa los aspectos comunes a todos los remates.
	 * 
	 * @param prize
	 *            {@link Product} a rematar
	 * @param type
	 *            {@link AuctionType} al que pertenece; grupal o single
	 * @param varFunction
	 *            {@link VariationRateFunction} que se usará para determinar los
	 *            saltos discretos del valor del remate
	 * @param startUpValue
	 *            valor base para comenzar las ofertas
	 */
	public IncrementalAuction(Product prize, AuctionType type,
			VariationRateFunction varFunction, int startUpValue) {
		super(prize, varFunction, type, 0);
		this.bids = new Stack<Bid>();
		this.nextBidValue = startUpValue;
	}

	/**
	 * Acepta una nueva oferta. Puede lanzar excepciones por inconsistencias en
	 * el monto ofertado
	 * 
	 * @throws IllegalBidAmountException
	 *             se lanzará una excepción en caso de que el monto ofertado no
	 *             sea el esperado
	 * @see Auction.takeNewBid
	 */
	void takeNewBid(Bid newBid) throws IllegalBidAmountException {
		try {
			newBid.getOwner().validateAuctionType(getType());
			// para la primera oferta
			if (!this.bids.isEmpty()) {
				Bid bestBid = this.bids.peek();
				if (newBid.getValue() != this.nextBidValue)
					throw new IllegalBidAmountException(
							"El valor ofertado es incorrecto");
				bestBid.getOwner().acknowledgeBidOvercame(bestBid);
			}
			this.bids.push(newBid);
			this.value = this.nextBidValue;
			this.nextBidValue += this.variationRateFunction.nextDelta();
		} catch (InvalidAuctionTypeException e) {
			// Para este entorno, este caso nunca se da. La excepción se lanza
			// por pura pofilaxis en caso de tener que extender el modelo y
			// agregar nuevas funciones que usen estas cosas
		}
	}

	/**
	 * Intenta cerrar el remate determinando el ganador.
	 */
	public void finish() {
		this.setStatus(AuctionStatus.CLOSED);
		boolean finish = false;
		while (!finish && !this.bids.isEmpty()) {
			Bid bid = this.bids.pop();
			Bidder bidder = bid.getOwner();
			if (bidder.isAllowedToWin()) {
				/*
				 * TODO: esta debería ser una llamada asíncrona, donde el
				 * ganador, como había sido desplazado, debe confirmar si
				 * todavía quiere y tiene los puntos para obtener este premio.
				 */
				this.setWinner(bidder);
				bidder.win(this, bid);
				/* hasta acá corresponde el TO-DO anterior */
				finish = true;
			}
		}
	}

	/**
	 * Modifica el estado actual del remate
	 * 
	 * @param status
	 *            nuevo estado; {@link AuctionStatus}
	 * @see AuctionStatus
	 */
	private void setStatus(AuctionStatus status) {
		this.status = status;

	}

	/**
	 * Establece un {@link Bidder} como ganador del remate. Es privado para que
	 * no pueda alterarse inadecuadamente
	 * 
	 * @param bidder
	 *            ofertor ganador del remate
	 */
	private void setWinner(Bidder bidder) {
		this.winner = bidder;
	}

	/**
	 * Devuelve el mejor postor hasta el momento o lanza una excepción en caso
	 * de no haber ofertas
	 * 
	 * @return el mejor postor
	 * @throws NoBiddersException
	 *             lanza una excepción en caso de no habe ofertas
	 */
	public final Bidder getHighestBidder() throws NoBiddersException {
		if (this.bids.isEmpty()) {
			throw new NoBiddersException();
		}
		return this.bids.peek().getOwner();
	}

	@Override
	/*
	 * * Devuelve la cantidad apropiada para ser ofetada acontinuación.
	 * 
	 * @return cantidad a ofertar
	 */
	public final int getAmountForNextBid() {
		return this.nextBidValue;
	}
}