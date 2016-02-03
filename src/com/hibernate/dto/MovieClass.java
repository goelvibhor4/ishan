package com.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class MovieClass {
	@Id //@GeneratedValue(strategy = GenerationType.AUTO)
	private long mid;
	private String mname;
	@Column(length=1000)
	private String mcast;
	@Column(length=1000)
	private String mdescription;
	private java.sql.Timestamp releasedate;
	private String genre;
	private String showtype;
	
	public long getMid() {
		return mid;
	}

	public void setMid(long l) {
		this.mid = l;
	}

	
	public String getMcast() {
		return mcast;
	}

	public void setMcast(String mcast) {
		this.mcast = mcast;
	}

	public String getMdescription() {
		return mdescription;
	}

	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}

	public java.sql.Timestamp getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(java.sql.Timestamp releasedate) {
		this.releasedate = releasedate;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getShowtype() {
		return showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}


}
