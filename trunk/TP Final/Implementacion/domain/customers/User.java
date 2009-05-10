package domain.customers;

import java.util.Date;

public class User {
	private int Dni;
	private String Name;
	private String LastName;
	private Date BirthDate;
	private int Points;

	public User createUser(int dni, String name, String lastName, Date birthDate) {
		this.setDni(dni);
		this.Name=name;
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
		return this;
	}

	public void addPoints(int points) {
		this.setPoints(points);
	}

	public void acceptGroupInvitation(int idGrupo) {

	}
	public String getName(){
		return Name;
	}

	public void declineGroupInvitation(int idGrupo) {

	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setPoints(int points) {
		Points = points;
	}

	public int getPoints() {
		return Points;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setDni(int dni) {
		Dni = dni;
	}

	public int getDni() {
		return Dni;
	}
}
