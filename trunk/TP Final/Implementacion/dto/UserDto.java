package dto;

public class UserDto {
	private String name;
	private String lastName;
	private int telephone;
	private int point;
	private int avatar;
	private int nickName;
	private int adress;
	private int dateOfBirth;

	public UserDto(String name,String lastname,int telephone,int tel,int point,int avatar,int nickname,int adress,int dateofbirth){
		this.name= name;
		this.lastName=lastname;
		this.telephone= telephone;
		this.point=point;
		this.avatar=avatar;
		this.nickName=nickname;
		this.adress=adress;
		this.dateOfBirth=dateofbirth;
	}
	public String getName(){
		return name;
	}
	public String getLastName(){
		return lastName;
	}
	public int getTelephone(){
		return telephone;
	}
	public int getAvatar(){
		return avatar;
	}
	public int getNickName(){
		return nickName;
	}
	public int getDateOfBirth(){
		return dateOfBirth;
	}
	public int getPoint(){
		return point;
	}
	public int getAdress(){
		return adress;
	}
	
	public void setName(String name){
		 this.name=name;
	}
	public void setLastName(String lastName){
		this.lastName= lastName;
	}
	public void setTelephone(int telephone){
		 this.telephone= telephone;
	}
	public void setAvatar(int avatar){
		 this.avatar= avatar;
	}
	public void setNickName(int nickName){
		 this.nickName= nickName;
	}
	public void setDateOfBirth(int dateOfBirth){
		 this.dateOfBirth=dateOfBirth;
	}
	public void setPoint(int point){
		 this.point= point;
	}
	public void setAdress(int adr){
		 this.adress=adr;
	}
	
	
}
