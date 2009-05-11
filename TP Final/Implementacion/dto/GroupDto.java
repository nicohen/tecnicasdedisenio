package dto;

import java.util.ArrayList;
import java.util.List;

import domain.customers.User;

public class GroupDto {

	private List<User> users;
	private String nickName;
	private String avatar;
	private int point;
	private int groupId;

	public GroupDto(String avatar, int point, int groupId, String nickName) {
		this.avatar = avatar;
		this.groupId = groupId;
		this.nickName = nickName;
		this.point = point;
		this.users = new ArrayList<User>();
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getNickName() {
		return nickName;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setNickname(String nickname) {
		this.nickName = nickname;
	}

	public List<User> getUsers() {
		return users;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setUsers(List<User> listUsers) {
		this.users = listUsers;
	}
}
