package domain.customers;

import java.util.Date;

import domain.exceptions.DonationAlreadyInstanciatedException;
import domain.querys.History;

/**
 * Es el tipo de transacción que se utiliza para registrar las donaciones de
 * puntos de un usuario a un grupo. En el momento en que se instancia, se
 * produce la transacción y sus efectos.
 * 
 * @see Transaction
 */
public class Donation implements Comparable<Donation> {

	private Group beneficiaryGroup;
	private User donorUser;
	private int donatedCredits;
	private Date occurrenceDate;

	/**
	 * Al ser una transacción, su lógica fuerte se da al momento de su
	 * instanciación y construcción. Como una donación, es el acto y efecto de
	 * donar puntos, al momento en que esta pasa a existir es que se producen
	 * los movimientos de créditos entre usuario y grupo, se registra la
	 * transacción en el histoial y se registra la fecha en que sucedió
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
		occurrenceDate = new Date();
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

	public Date getDate() {
		return this.occurrenceDate;
	}
	
	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto
	 * Donation que por algún motivo se haya quitado de la memoria
	 */
	private Donation() {}

	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto
	 * Donation que por algún motivo se haya quitado de la memoria
	 * 
	 * @param beneficiaryGroup
	 *            the beneficiaryGroup to set
	 */
	private void setBeneficiaryGroup(Group beneficiaryGroup) {
		this.beneficiaryGroup = beneficiaryGroup;
	}

	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto
	 * Donation que por algún motivo se haya quitado de la memoria
	 * 
	 * @param donorUser
	 *            the donorUser to set
	 */
	private void setDonorUser(User donorUser) {
		this.donorUser = donorUser;
	}

	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto
	 * Donation que por algún motivo se haya quitado de la memoria
	 * 
	 * @param donatedCredits
	 *            the donatedCredits to set
	 */
	private void setDonatedCredits(int donatedCredits) {
		this.donatedCredits = donatedCredits;
	}

	/**
	 * Se utiliza para la reconstrucción de objetos preexistentes. Al tener un
	 * dominio persistible, es necesario poder volver a instanciar un objeto
	 * Donation que por algún motivo se haya quitado de la memoria
	 * 
	 * @param occurrenceDate
	 *            the occurrenceDate to set
	 */
	private void setOccurrenceDate(Date occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}

	/**
	 * Factory method utilizado para la reconstrucción de donaciones que hayan
	 * sido quitadas de la memoria, pero que se necesitan para volver a usarse.
	 * 
	 * @param user
	 * @param group
	 * @param points
	 * @param date
	 * @return
	 * @throws DonationAlreadyInstanciatedException 
	 */
	public static Donation buildExistantDonation(User user, Group group, int points,
			Date date) throws DonationAlreadyInstanciatedException {
		if(History.getInstance().haveDonation(user, group, date)){
			throw new DonationAlreadyInstanciatedException();
		}
		Donation aDonation = new Donation();
		aDonation.setBeneficiaryGroup(group);
		aDonation.setDonorUser(user);
		aDonation.setDonatedCredits(points);
		aDonation.setOccurrenceDate(date);
		return aDonation;
	}

	@Override
	public int compareTo(Donation other) {
		int res = this.beneficiaryGroup.compareTo(other.beneficiaryGroup);
		if(res!=0) return res;
		res = this.donorUser.compareTo(other.donorUser);
		if(res!=0) return res;
		res = this.occurrenceDate.compareTo(other.occurrenceDate);
		return res;
	}
}
