package domain.querys;

import java.util.Date;

public abstract class Transaction {
	
	protected Date occurrenceDate;
	
	public Transaction (Date aDate){
		this.occurrenceDate = aDate;
	}
	
	public Date getDate() {
		return this.occurrenceDate;
	}
	
}
