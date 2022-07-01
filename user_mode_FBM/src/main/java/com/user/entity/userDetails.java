package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class userDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uId;
	private String name;
	private String gender;
	private Integer age;
	@ManyToOne
	@JoinColumn(name="b_Id")
	private bookingInfo bookingInfo;
	public userDetails(Integer uId, String name, String gender, Integer age) {
		super();
		this.uId = uId;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public userDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public bookingInfo getBookingInfo() {
		return bookingInfo;
	}
	public void setBookingInfo(bookingInfo bookingInfo) {
		this.bookingInfo = bookingInfo;
	}
}
