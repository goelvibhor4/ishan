package com.hibernate.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AveragedMovieRating {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int rowid;
	private long movieid;
	private int usertype;
	private Double weightedScore;
	private String showtype;
	
	public long getMovieid() {
		return movieid;
	}
	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public Double getWeightedScore() {
		return weightedScore;
	}
	public void setWeightedScore(Double weightedScore) {
		this.weightedScore = weightedScore;
	}
	public String getShowtype() {
		return showtype;
	}
	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}
	
	
}
