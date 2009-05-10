package dto;

import java.util.Date;

import domain.customers.User;

public class BidDto {
	private Date date;
	private User user;
	private int point;
	private int id;
	
	public BidDto(Date date,User user,int point,int id){
		this.date=date;
		this.user=user;
		this.point=point;
		this.id=id;
	}
	
	public Date getDate(){
		return date;
	}
	
	public User getUser(){
		return user;
	}
	
	public int getPoint(){
		return point;
	}
	
	public int getId(){
		return id;
	}
	
	public BidDto getBid(){
		return this;
	}
}
