package domain.customers;

import java.util.Date;

public class User implements Bidder{
	private int dni;
	private String name;
	private String lastName;
	private Date birthDate;
	private int points;

	public User createUser(int dni, String name, String lastName, Date birthDate) {
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		return this;
	}

	public void addPoints(int points) {
		this.points += points;
	}
	
	public void spendPoints(int points) {
		if(this.points < points) throw new IllegalArgumentException ();
		this.points -= points;
	}

	public void acceptGroupInvitation(int idGrupo) {

	}

	public String getName() {
		return name;
	}

	public void declineGroupInvitation(int idGrupo) {

	}

	public Date getBirthDate() {
		return birthDate;
	}

	public int getPoints() {
		return points;
	}

	public String getLastName() {
		return lastName;
	}

	public int getDni() {
		return dni;
	}

	@Override
	public void bid() {
		// TODO Auto-generated method stub
		
	}
	
}
