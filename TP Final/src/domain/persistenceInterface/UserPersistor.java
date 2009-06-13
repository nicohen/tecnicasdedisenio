package domain.persistenceInterface;

import domain.customers.User;

public interface UserPersistor {

	public User getUser(String nickName);
	
	public User getUserWithPassword(String nickName, String password);

	public void saveUser(User savingUser);

	public void deleteUser(String nickName);

}
