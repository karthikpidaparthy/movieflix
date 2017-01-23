package io.movieflix.api.repository;

import java.util.List;

import io.movieflix.api.entity.MovieList;

public interface MovieListRepository {
	public List<MovieList> findAll();
	public MovieList findOne(String id);
	public MovieList create(MovieList mov);
	public MovieList update(MovieList mov);
	public void delete(MovieList mov);
	public MovieList findByImdbId(String imdbId);
	public List<MovieList>  filterBy(String filterBy);
	public List<MovieList>  filterByYear(int yValue);
	public List<MovieList>filterByGenre(String gValue);
	public List<MovieList> typeSortBy(String fValue, String col);
	public List<MovieList> yearSortBy(String fValue, String col);
	public List<MovieList> genreSortBy(String fValue, String col);
	public MovieList getDetails(String listId);
	public MovieList searchByTitle(String titl);
}
