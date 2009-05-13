package domain.auctions;

import java.util.Date;

import domain.products.Product;
import domain.utils.VariationRateFunction;

public class ReverseAuction extends Auction {
	
	public static int STEP_SIZE_IN_MINUTES = 1;
	
	private Bid firstBid;
	private Date startingDate;
	private Date lastCheckedDate;
	private int startingValue;
	
	public ReverseAuction(Product prize, VariationRateFunction varFunction, int startUpValue) {
		super(prize, varFunction, startUpValue);
		this.firstBid = null;
		this.lastCheckedDate = this.startingDate = new Date();
		this.startingValue = startUpValue;
	}
	
	@Override
	public void finish() {
		
	}

	@Override
	public int getAmountForNextBid() {
		// TODO: Se debería tener un objeto Syncronizer, en un thread aparte, que dispare los eventos de actualización de este tipo de casos.
		long startingMS = this.lastCheckedDate.getTime();
		this.lastCheckedDate = new Date();
		long actualMS = this.lastCheckedDate.getTime();
		long diff = (actualMS - startingMS) / 60000; /* esto me da la cantidad de minutos transcurridos desde el comienzo de la subasta */
		diff /= ReverseAuction.STEP_SIZE_IN_MINUTES; /* esto es para cada 15 minutos, meter una variación en el costo de la subasta */
		for (long i = 0; i<diff; i++){
			this.value -= this.variationRateFunction.nextDelta();
		}
		return this.value;
	}
	
	@Override
	public void takeNewBid(Bid newBid) {
		if (newBid.getValue()!=this.value)
			throw new IllegalArgumentException(); // TODO: hacer excepción más particular
		if (!newBid.getOwner().isAllowedToWin()){
			throw new IllegalArgumentException(); // TODO: hacer excepción más particular
		}
		this.firstBid = newBid;
		this.finish();
	}

}
