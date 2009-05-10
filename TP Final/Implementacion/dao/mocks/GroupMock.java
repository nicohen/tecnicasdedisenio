package dao.mocks;

import java.util.ArrayList;
import java.util.List;

import dao.GroupDao;
import dto.GroupDto;

public class GroupMock extends GroupDao {
private static List<GroupDto> groupList;
	
	public GroupMock() {
		groupList = new ArrayList<GroupDto>();
	}

	public int add(GroupDto bid) {
		groupList.add(bid);
		return groupList.size()-1;
	}

	public GroupDto get(int bidId) {
		return groupList.get(bidId);
	}
}
