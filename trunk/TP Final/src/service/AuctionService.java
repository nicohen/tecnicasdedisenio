package service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import persistence.AuctionPersistorImplementation;
import domain.auctions.IncrementalAuction;

public class AuctionService implements Runnable {

	ScheduledExecutorService ses;

	public void programar() {
		ses = Executors.newScheduledThreadPool(1);
		// Ejecutar dentro de 13 milisegundos, repetir cada 3 segundos
		ses
				.scheduleAtFixedRate(this, 1 * 1000, 3 * 1000,
						TimeUnit.MILLISECONDS);
	}

	void detener() {
		ses.shutdown();
	}

	public AuctionService() {
	}

	@Override
	public void run() {
		List<IncrementalAuction> auctions = AuctionPersistorImplementation
				.getInstance().getIncrementalAuctions();

		for (IncrementalAuction incrementalAuction : auctions) {
			if (incrementalAuction.getEndDate().getTime() < new Date()
					.getTime()) {
				incrementalAuction.finish();
			}
		}
	}
}
