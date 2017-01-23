package io.movieflix.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table
@NamedQueries({
@NamedQuery(name="MovieList.findByImdbId",query="SELECT m from MovieList m where m.imdbId=:userImdbId"),
@NamedQuery(name="MovieList.findAll",query="Select m from MovieList m"),
@NamedQuery(name="MovieList.TopRated",query="select m from MovieList m where m.type=:uType order by m.imdbRating"),
@NamedQuery(name="MovieList.Type",query="select m from MovieList m where m.type=:uType"),
@NamedQuery(name="MovieList.Year",query="select m from MovieList m where m.year=:uYear"),
@NamedQuery(name="MovieList.Genre",query="select m from MovieList m where m.genre=:uGenre"),
@NamedQuery(name="MovieList.Title",query="select m from MovieList m where m.title=:uTitle"),
@NamedQuery(name="MovieList.SortByImdbRatings",query="select m from MovieList m where m.title=:uTitle"),
@NamedQuery(name="MovieList.getDesc",query="select m.runtime,m.year,m.plot,m.actors,m.genre,m.director,m.imdbRating from MovieList m where m.movieListId=:uMovListId"),
@NamedQuery(name="MovieList.findByTitle",query="SELECT m from MovieList m where m.title=:userTitle")})

public class MovieList {
@Id	
private String movieListId;
private String title;
private int year;
private String rated;
private String released;
private String runtime;
private String genre;
private String director;

private String writer;

private String actors;
@Column(columnDefinition="VARCHAR(500)")
private String plot;
private String language;
private String country;
private String awards;

private String poster;
private int metaScore;
private double imdbRating;
private int imdbVotes;
@Column(columnDefinition="VARCHAR(128)", unique=true)
private String imdbId;
private String type;

public MovieList() {
	// TODO Auto-generated constructor stub
	this.movieListId=UUID.randomUUID().toString();
}
@Override
public String toString() {
	return "MovieList [movieListId=" + movieListId + ", title=" + title + ", year=" + year + ", rated=" + rated
			+ ", released=" + released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director
			+ ", writer=" + writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country="
			+ country + ", awards=" + awards + ", poster=" + poster + ", metaScore=" + metaScore + ", imdbRating="
			+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId=" + imdbId + ", type=" + type + "]";
}
public String getMovieListId() {
	return movieListId;
}
public void setMovieListId(String movieListId) {
	this.movieListId = movieListId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getRated() {
	return rated;
}
public void setRated(String rated) {
	this.rated = rated;
}
public String getReleased() {
	return released;
}
public void setReleased(String released) {
	this.released = released;
}
public String getRuntime() {
	return runtime;
}
public void setRuntime(String runtime) {
	this.runtime = runtime;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public String getActors() {
	return actors;
}
public void setActors(String actors) {
	this.actors = actors;
}
public String getPlot() {
	return plot;
}
public void setPlot(String plot) {
	this.plot = plot;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getAwards() {
	return awards;
}
public void setAwards(String awards) {
	this.awards = awards;
}
public String getPoster() {
	return poster;
}
public void setPoster(String poster) {
	this.poster = poster;
}
public int getMetaScore() {
	return metaScore;
}
public void setMetaScore(int metaScore) {
	this.metaScore = metaScore;
}
public double getImdbRating() {
	return imdbRating;
}
public void setImdbRating(double imdbRating) {
	this.imdbRating = imdbRating;
}
public int getImdbVotes() {
	return imdbVotes;
}
public void setImdbVotes(int imdbVotes) {
	this.imdbVotes = imdbVotes;
}
public String getImdbId() {
	return imdbId;
}
public void setImdbId(String imdbId) {
	this.imdbId = imdbId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}






}
