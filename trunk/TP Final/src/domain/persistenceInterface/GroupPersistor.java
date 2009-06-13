package domain.persistenceInterface;

import domain.customers.Group;

public interface GroupPersistor {

	public Group getGroup(String ownerNickName);

	public void saveGroup(Group savingGroup);

	public void deleteGroup(String ownerNickName);

}
