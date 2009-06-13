package domain.customers;

import domain.auctions.Auction;
import domain.auctions.AuctionType;
import domain.auctions.Bid;
import domain.exceptions.AlreadyUsedKeyException;
import domain.exceptions.BidException;
import domain.exceptions.GroupSizeExceededException;
import domain.exceptions.InvalidAuctionTypeException;
import domain.exceptions.InvalidDonationException;
import domain.exceptions.NonExistentKeyException;
import domain.exceptions.NotEnoughPointsToBidException;
import domain.exceptions.UserAlreadyInGroupException;

/**
 * Es el tipo de postor atómico; representa a cada uno de los usuarios
 * participantes en el negocio de remates.
 */
public class User extends Bidder {
	private int dni;
	private String nickName;
	private String name;
	private String lastName;
	private String address;
	private String email;
	private String password;
	private Group memberGroup;

	/**
	 * Inicializa la estructura y sus datos y explicita el llamado al
	 * constructor de su parte Bidder.
	 * 
	 * @param dni
	 *            DNI de la persona usuaria
	 * @param name
	 *            Nombre de la persona usuaria
	 * @param lastName
	 *            Apellido de la persona usuaria
	 */
	public User(int dni, String nickName, String lastName) {
		super();
		this.dni = dni;
		this.nickName = nickName;
		memberGroup = null;
	}

	public User(int dni, String nickName, String name, String lastName, String address, String email, String password) {
		super();
		this.dni = dni;
		this.nickName = nickName;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.email = email; 
		this.password = password;
		memberGroup = null;
	}
	@Override
	/*
	 * * Realiza una oferta sobre un remate.
	 * 
	 * @see Bidder.bid
	 */
	public void bid(Auction anAuction) throws BidException,
			InvalidAuctionTypeException {

		int amount = anAuction.getAmountForNextBid();
		if (super.getPoints() < amount) {
			throw new NotEnoughPointsToBidException();
		}
		this.validateAuctionType(anAuction.getType());
		new Bid(this, anAuction, amount);
		this.compromisedPoints += amount;
		this.avaliablePoints -= amount;
	}

	@Override
	/*
	 * * Evalúa si el tipo de remate es el adecuado para este tipo de Bidder y
	 * lanza una excepción en caso de que no sea el apropiado
	 */
	public void validateAuctionType(AuctionType type)
			throws InvalidAuctionTypeException {
		if (!type.equals(AuctionType.SINGLE)
				&& !type.equals(AuctionType.REVERSE)) {
			throw new InvalidAuctionTypeException(
					"El Remate no es del tipo correcto");
		}
	}

	/**
	 * Lanza el evento de donar puntos instanciando una donación
	 * 
	 * @param points
	 *            puntos a donar
	 * @throws InvalidDonationException
	 *             se lanza cuando no se tienen los puntos suficientes o el
	 *             usuario no pertenece a un grupo
	 */
	public void donate(int points) throws InvalidDonationException {
		if (this.isMemberOfGroup()) {
			Group group = this.getGroupOfUser();
			if (this.getPoints() >= points) {
				new Donation(this, group, points);
			} else
				throw new InvalidDonationException(
						"El credito es insuficiente para ser donado");
		} else
			throw new InvalidDonationException(
					"El usuario no pertenece a ningun grupo");
	}

	/**
	 * Devuelve el apellido del usuario
	 * 
	 * @return apellido del usuario
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 * Devuelve el DNI del usuario
	 * 
	 * @return DNI del usuario
	 */
	public final int getDni() {
		return dni;
	}

	/**
	 * Devuelve el nombre del usuario
	 * 
	 * @return nombre del usuario
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Indica si el usuario es miembro de algún grupo
	 * 
	 * @return si es miembro de un grupo
	 */
	public boolean isMemberOfGroup() {
		if (memberGroup != null)
			return true;
		return false;
	}

	/**
	 * Devuelve el grupo al que el usuario pertenece
	 * 
	 * @return el gupo al que el usuario pertenece
	 */
	public final Group getGroupOfUser() {
		return memberGroup;
	}

	/**
	 * Suscribe al usuario en un grupo
	 * 
	 * @param group
	 *            grupo al que se desea suscribir
	 * @throws UserAlreadyInGroupException
	 *             se lanza si el usuario ya es wmiembro de algún grupo; no
	 *             distingue si se le pide que el usuario se sucriba al mismo
	 *             grupo al que ya pertenece.
	 * @throws GroupSizeExceededException
	 *             se lanza cuando el usuario pretende suscribirse a un grupo
	 *             que ya está lleno
	 */
	public void suscribeToGroup(Group group)
			throws UserAlreadyInGroupException, GroupSizeExceededException {
		if (this.memberGroup != null)
			throw new UserAlreadyInGroupException();
		try {
			group.addMember(this);
			this.memberGroup = group;
		} catch (GroupSizeExceededException e) {
			throw e;
		}

	}

	/**
	 * Indica al usuario que se convirtió en el dueño de un grupo, se usa en la
	 * instanciación del grupo
	 * 
	 * @param group
	 *            grupo del que será dueño
	 */
	void setAsGroupOwner(Group group) {
		this.memberGroup = group;
	}

	/**
	 * Canjea una clave por puntos para ofertar; es una {@link Transaction} al
	 * igual que las ofertas y las donaciones
	 * 
	 * @param code
	 *            clave alfanumérica a canjear
	 * @throws NonExistentKeyException
	 *             se lanza si el código no es un código bueno
	 * @throws AlreadyUsedKeyException
	 *             se lanza si la clave es buena pero ya fue utilizada
	 */
	public void exchangeKey(String code) throws NonExistentKeyException,
			AlreadyUsedKeyException {
		KeyExchange exchange = new KeyExchange(code, this);
		Key myKey = exchange.getKey();
		if (myKey == null)
			throw new NonExistentKeyException();
		else {
			addPoints(myKey.getPointsToExchange());
		}
	}

	@Override
	public int compareTo(Bidder other) {
		if(other.getClass() != User.class) throw new IllegalArgumentException();
		User comparingTo = (User) other;
		Integer myValue = new Integer(this.dni);
		Integer itsValue = new Integer(comparingTo.dni);
		return myValue.compareTo(itsValue);
	}
	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getNickName() {
		return this.nickName;
	}

	

}
