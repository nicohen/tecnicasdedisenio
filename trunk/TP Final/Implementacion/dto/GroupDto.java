package dto;

import java.util.ArrayList;
import java.util.List;

import domain.customers.User;

public class GroupDto {
	
	private List <User> listUsers;
	private String nickName;
	private int avatar;
	private int point;
	private int idGroup;
	
	public GroupDto(int avatar,int point,int idGroup,String nickName){
		this.avatar=avatar;
		this.idGroup=idGroup;
		this.nickName=nickName;
		this.point=point;
		this.listUsers= new ArrayList <User>();
	}
	
	public int idGroup(){
		return idGroup;
	}
	
	public void idGroup(int grupo){
		this.idGroup= grupo;
	}
	
	public int getAvatar(){
		return avatar;
	}
	
	public String getNickName(){
		return nickName;
	}
	
	public void changeAvatarGroup(int avatar){
		this.avatar=avatar;
	}
	
	public void changeNickNameGroup(String nickname){
		this.nickName=nickname;
	}
	
	public List <User> getUser(){
		return listUsers;
		
	}
	
	public int getPoint(){
		return point;
	}
	
	public void setPoint(int point){
		this.point=point;
	}
	
	public void setListUsers(List <User> listUsers) {
		this.listUsers = listUsers;
	}
	
	public List <User> getListUsers() {
		return listUsers;
	}
	
	/*public sendInvitationToUser(){
	
	}
	
	public arePlace(){
		
	}*/
}
