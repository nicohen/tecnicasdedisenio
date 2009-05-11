package dao.mocks;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import dto.UserDto;

public class UserMock extends UserDao {

	private static List<UserDto> userList;

	public UserMock() {
		userList = new ArrayList<UserDto>();
	}

	public int add(UserDto user) {
		userList.add(user);
		return userList.size() - 1;
	}

	public UserDto get(int userId) {
		return userList.get(userId);
	}
}
