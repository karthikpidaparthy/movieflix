package io.movieflix.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Rating.AverageRating",query="select avg(r.ratedNum) from Rating r where r.movieListId=:uMovId"),
	@NamedQuery(name="Rating.Comments",query="select r.comment from Rating r where r.movieListId=:uMovId"),
@NamedQuery(name="Rating.Check",query="select r.ratedNum from Rating r where r.movieListId=:uMovId and r.userID=:uUserId"),
@NamedQuery(name="Rating.CheckComment",query="select r.comment from Rating r where r.movieListId=:uMovId and r.userID=:uUserId")})
public class Rating {
@Id  
private String ratingId;
private double ratedNum;
private String comment;
public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}
@ManyToOne
@JoinColumn(name ="movieListId")
private MovieList movieList;
@ManyToOne
@JoinColumn(name="userID")
private User user;


public Rating()
{
	this.ratingId=UUID.randomUUID().toString();
}

public String getRatingId() {
	return ratingId;
}
public void setRatingId(String ratingId) {
	this.ratingId = ratingId;
}
public double getRatedNum() {
	return ratedNum;
}
public void setRatedNum(double ratedNum) {
	this.ratedNum = ratedNum;
}
public MovieList getMovieList() {
	return movieList;
}
public void setMovieList(MovieList movieList) {
	this.movieList = movieList;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Override
public String toString() {
	return "Rating [ratingId=" + ratingId + ", ratedNum=" + ratedNum + ", comment=" + comment + ", movieList="
			+ movieList + ", user=" + user + "]";
}


}
