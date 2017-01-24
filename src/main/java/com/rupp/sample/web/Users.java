package com.rupp.sample.web;

import java.util.Date;

public class Users {
	private int id;
	private String email;
	private String password;
	private Date createDate;
	private String urlPhoto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public Users(){
		
	}
	public Users(int id,String email,String password,Date createDate,String urlPhoto){
		this.id=id;
		this.email=email;
		this.password=password;
		this.createDate=createDate;
		this.urlPhoto=urlPhoto;
	}
}
