package domain.auctions;

import java.util.Stack;

import domain.customers.Bidder;
import domain.customers.NotEnoughMembersInGroupForBidException;
import domain.utils.VariationRateFunction;

/**
 * Clase de remate incremental. Su costo ir� subiendo con las sucesivas ofertas.
 */
public class IncrementalAuction extends Auction {

	private int nextBidValue;
	private Stack<Bid> bids;

	/**
	 * Inicializa las estructuras necesarias para la implementaci�n de un remate
	 * incremental, previa llamada al constructor de la clase ancestra que
	 * inicializa los aspectos comunes a todos los remates.
	 * 
	 * @param prize
	 *            {@link Product} a rematar
	 * @param type
	 *            {@link AuctionType} al que pertenece; grupal o single
	 * @param varFunction
	 *            {@link VariationRateFunction} que se usar� para determinar los
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
	 * @throws IllegalBidAmount
	 *             se lanzar� una excepci�n en caso de que el monto ofertado no
	 *             sea el esperado
	 * @see Auction.takeNewBid
	 */
	void takeNewBid(Bid newBid) throws IllegalBidAmount {
		try {
			newBid.getOwner().validateAuctionType(getType());
			// para la primera oferta
			if (!this.bids.isEmpty()) {
				Bid bestBid = this.bids.peek();
				if (newBid.getValue() != this.nextBidValue)
					throw new IllegalBidAmount(
							"El valor ofertado es incorrecto");
				bestBid.getOwner().acknowledgeBidOvercame(bestBid);
			}
			this.bids.push(newBid);
			this.value = this.nextBidValue;
			this.nextBidValue += this.variationRateFunction.nextDelta();
		} catch (InvalidAuctionTypeException e) {
			// Para este entorno, este caso nunca se da. La excepci�n se lanza
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
				 * TODO: esta deber�a ser una llamada as�ncrona, donde el
				 * ganador, como hab�a sido desplazado, debe confirmar si
				 * todav�a quiere y tiene los puntos para obtener este premio.
				 */
				this.setWinner(bidder);
				bidder.win(this, bid);
				/* hasta ac� corresponde el TO-DO anterior */
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
	 * Devuelve el mejor postor hasta el momento o lanza una excepci�n en caso
	 * de no haber ofertas
	 * 
	 * @return el mejor postor
	 * @throws NoBiddersException
	 *             lanza una excepci�n en caso de no habe ofertas
	 */
	public Bidder getHighestBidder() throws NoBiddersException {
		if (this.bids.isEmpty()) {
			throw new NoBiddersException();
		}
		return this.bids.peek().getOwner();
	}

	@Override
	/**
	 * Devuelve la cantidad apropiada para ser ofetada acontinuaci�n.
	 * @return cantidad a ofertar
	 */
	public int getAmountForNextBid() {
		return this.nextBidValue;
	}
}