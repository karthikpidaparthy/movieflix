package io.movieflix.api.service;

import java.util.List;

import io.movieflix.api.entity.MovieList;

public interface MovieListService {
	public List<MovieList> findAll();
	public MovieList findOne(String id);
	public MovieList create(MovieList mov);
	public MovieList update(String id, MovieList mov);
	public void delete(String id);
	public List<MovieList>filterBy(String fValue);
	public List<MovieList>filterByYear(int yValue);
	public List<MovieList>filterByGenre(String gValue);
public List<MovieList> typeSortBy(String fValue,String col);
public List<MovieList> yearSortBy(String fValue,String col);
public List<MovieList> genreSortBy(String fValue,String col);
public MovieList getDetails(String listId);
public MovieList searchByTitle(String titl);
}
