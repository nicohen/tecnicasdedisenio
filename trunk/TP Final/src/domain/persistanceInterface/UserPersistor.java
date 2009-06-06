package domain.persistanceInterface;

import domain.customers.User;

public interface UserPersistor {

	public User getUser(String name);

	public void saveUser(User savingUser);

	public void deleteUser(String name);

}
