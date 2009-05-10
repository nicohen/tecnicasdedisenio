package dto;

public class UserDto {
	private String Name;
	private String LastName;
	private int Telephone;
	private int Point;
	private int Avatar;
	private int NickName;
	private int Adress;
	private int DateOfBirth;

	public UserDto(String name,String lastname,int telephone,int tel,int point,int avatar,int nickname,int adress,int dateofbirth){
		this.Name= name;
		this.LastName=lastname;
		this.Telephone= telephone;
		this.Point=point;
		this.Avatar=avatar;
		this.NickName=nickname;
		this.Adress=adress;
		this.DateOfBirth=dateofbirth;
	}
	public String getName(){
		return Name;
	}
	public String getLastName(){
		return LastName;
	}
	public int getTelephone(){
		return Telephone;
	}
	public int getAvatar(){
		return Avatar;
	}
	public int getNickName(){
		return NickName;
	}
	public int getDateOfBirth(){
		return DateOfBirth;
	}
	public int getPoint(){
		return Point;
	}
	public int getAdress(){
		return Adress;
	}
	
	public void setName(String name){
		 this.Name=name;
	}
	public void setLastName(String lastname){
		this.LastName= lastname;
	}
	public void setTelephone(int telephone){
		 this.Telephone= telephone;
	}
	public void setAvatar(int avatar){
		 this.Avatar= avatar;
	}
	public void setNickName(int nickname){
		 this.NickName= nickname;
	}
	public void setDateOfBirth(int dateofbirth){
		 this.DateOfBirth=dateofbirth;
	}
	public void setPoint(int point){
		 this.Point= point;
	}
	public void setAdress(int adr){
		 this.Adress=adr;
	}
	
	
}
