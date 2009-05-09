package dao.mocks;

import java.util.List;

import dto.UserDto;

public class UserMock {
	
private static List<UserDto> userList; 
	
	public int add(UserDto product) {
		userList.add(product);
		return userList.size();
	}

	public UserDto get(int productId) {
		return userList.get(productId);
	}
}
