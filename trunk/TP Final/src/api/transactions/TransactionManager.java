package api.transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

	
	public static int TOTAL_TX = 30;
	public static int AVAILABLE = 0;
	public static int BUSY = 0;
	
	private static List<TransactionManager> pool;
	private static List<TransactionManager> busy;
	
	{
		pool = new ArrayList<TransactionManager>();
		busy = new ArrayList<TransactionManager>();
		
		for (int i= 0; i < TOTAL_TX; i++){
			pool.add(new TransactionManager());
		}
	}
	
	private int status;
	private TransactionManager(){
		this.status = TransactionManager.AVAILABLE;
	}
	
	public static TransactionManager getTransactionManager(){
		return null;
	}
}
