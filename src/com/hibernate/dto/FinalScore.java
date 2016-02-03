package com.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FinalScore {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int rowid;
	private long userid;
	private long criticid;
	private Double score;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public long getCriticid() {
		return criticid;
	}
	public void setCriticid(long criticid) {
		this.criticid = criticid;
	}
	
}
