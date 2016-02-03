package com.hibernate.dto;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id 
	private long userid;
	private String username;
	private String area;
	private String city;
	private String gender;
	private String email;
	private String password;

	private int month;
	private int date;
	private int year;
	private int type; 
	public boolean valid;

	public long getUserid() {
		return userid;
	}
	public void setUserid(long l) {
		
		this.userid = l;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	 public boolean isValid() { return valid; }
	 
	 public void setValid(boolean newValid) { valid = newValid; } 
}
