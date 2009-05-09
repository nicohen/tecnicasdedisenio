package dao;

import dao.framework.IDao;
import dto.UserDto;

public abstract class UserDao implements IDao<UserDto> {
	
	public abstract int add(UserDao user);

	public abstract UserDto get(int userId);
}
