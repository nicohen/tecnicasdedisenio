package domain.customers;

import java.util.Date;

public class User {
	private int dni;
	private String name;
	private String lastName;
	private Date birthDate;
	private int points;

	public User createUser(int dni, String name, String lastName, Date birthDate) {
		this.setDni(dni);
		this.name = name;
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
		return this;
	}

	public void addPoints(int points) {
		this.setPoints(points);
	}

	public void acceptGroupInvitation(int idGrupo) {

	}

	public String getName() {
		return name;
	}

	public void declineGroupInvitation(int idGrupo) {

	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getDni() {
		return dni;
	}
}
