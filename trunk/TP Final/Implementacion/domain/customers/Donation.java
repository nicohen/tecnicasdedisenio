package domain.customers;

import java.util.Date;

import domain.querys.History;
import domain.querys.Transaction;

/**
 * Es el tipo de transacción que se utiliza para registrar las donaciones de
 * puntos de un usuario a un grupo. En el momento en que se instancia, se
 * produce la transacción y sus efectos.
 * 
 * @author Matías
 * @see Transaction
 */
public class Donation extends Transaction {

	private Group beneficiaryGroup;
	private User donorUser;
	private int donatedCredits;

	/**
	 * Constructor. Como es de esperarse, al ser una transacción, su lógica
	 * fuerte se da al momento de su instanciación y construcción. Como una
	 * donación, es el acto y efecto de donar puntos, al momento en que esta
	 * pasa a existir es que se producen los movimientos de créditos entre
	 * usuario y grupo, se registra la transacción en el histoial y se registra
	 * la fecha en que sucedió
	 * 
	 * @param user
	 *            el usuario que dona sus puntos
	 * @param group
	 *            el grupo que recibe los puntos de usuario
	 * @param points
	 *            el total de puntos donados
	 * @see History, User, Group
	 */
	public Donation(User user, Group group, int points) {
		super(new Date());
		if (user == null || group == null)
			throw new NullPointerException();
		if (points <= 0)
			throw new IllegalArgumentException();
		beneficiaryGroup = group;
		donorUser = user;
		donatedCredits = points;
		group.addPoints(points);
		user.spendPoints(points);
		History.getInstance().addDonation(this);
	}

	/**
	 * @return el grupo que ecibe los puntos
	 */
	public final Group getBenefeciary() {
		return beneficiaryGroup;
	}

	/**
	 * @return el usuario donor
	 */
	public final User getDonor() {
		return donorUser;
	}

	/**
	 * @return los créditos que se donan
	 */
	public final int getCreditsDonate() {
		return donatedCredits;
	}
}
