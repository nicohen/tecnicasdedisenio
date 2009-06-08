package persistance;

import java.util.HashMap;
import java.util.Map;

import domain.customers.Group;
import domain.customers.User;
import domain.persistanceInterface.GroupPersistor;
import domain.persistanceInterface.UserPersistor;

public class BidderPersistor implements UserPersistor, GroupPersistor {

	private static BidderPersistor instance=null;
	
	private Map<String, User> users;
	private Map<String, Group> groups;
	
	private BidderPersistor (){
		this.users = new HashMap<String, User>();
		this.groups = new HashMap<String, Group>();
	}
	
	public BidderPersistor getBidderPersistorInstance(){
		if(BidderPersistor.instance==null){
			BidderPersistor.instance = new BidderPersistor();
		}
		return BidderPersistor.instance;
	}
	
	@Override
	public void deleteUser(String name) {
		if(this.users.containsKey(name)){
			this.users.remove(name);
		}
	}

	@Override
	public User getUser(String name) {
		if(!this.users.containsKey(name)){
			return null;
		}else{
			return this.users.get(name);
		}
	}

	@Override
	public void saveUser(User savingUser) {
		this.users.put(savingUser.getName(), savingUser);
	}

	@Override
	public void deleteGroup(String ownerName) {
		if(this.groups.containsKey(ownerName)){
			this.groups.remove(ownerName);
		}
	}

	@Override
	public Group getGroup(String ownerName) {
		if(!this.groups.containsKey(ownerName)){
			return null;
		}else{
			return this.groups.get(ownerName);
		}
	}

	@Override
	public void saveGroup(Group savingGroup) {
		this.groups.put(savingGroup.getOwner().getName(), savingGroup);
	}

	
}
