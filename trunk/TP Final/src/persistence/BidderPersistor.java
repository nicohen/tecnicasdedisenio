package persistence;

import java.util.HashMap;
import java.util.Map;

import domain.customers.Group;
import domain.customers.User;
import domain.persistenceInterface.GroupPersistor;
import domain.persistenceInterface.UserPersistor;

public class BidderPersistor implements UserPersistor, GroupPersistor {

	private static BidderPersistor instance = null;

	private Map<String, User> users;
	private Map<String, Group> groups;

	private BidderPersistor() {
		this.users = new HashMap<String, User>();
		this.groups = new HashMap<String, Group>();
	}

	public static BidderPersistor getBidderPersistorInstance() {
		if (BidderPersistor.instance == null) {
			BidderPersistor.instance = new BidderPersistor();
		}
		return BidderPersistor.instance;
	}

	@Override
	public void deleteUser(String nickName) {
		if (this.users.containsKey(nickName)) {
			this.users.remove(nickName);
		}
	}

	@Override
	public User getUser(String nickName) {
		if (!this.users.containsKey(nickName)) {
			return null;
		} else {
			return this.users.get(nickName);
		}
	}

	@Override
	public void saveUser(User savingUser) {
		this.users.put(savingUser.getNickName(), savingUser);
	}

	@Override
	public void deleteGroup(String ownerNickName) {
		if (this.groups.containsKey(ownerNickName)) {
			this.groups.remove(ownerNickName);
		}
	}

	@Override
	public Group getGroup(String ownerNickName) {
		if (!this.groups.containsKey(ownerNickName)) {
			return null;
		} else {
			return this.groups.get(ownerNickName);
		}
	}

	@Override
	public void saveGroup(Group savingGroup) {
		this.groups.put(savingGroup.getOwner().getNickName(), savingGroup);
	}

	@Override
	public User getUserWithPassword(String nickName, String password) {
		if (this.users.containsKey(nickName)) {
			User user = users.get(nickName);
			if (user.getPassword().equals(password))
				return this.users.get(nickName);
			else
				return null;
		} else {
			return null;
		}
	}
}
