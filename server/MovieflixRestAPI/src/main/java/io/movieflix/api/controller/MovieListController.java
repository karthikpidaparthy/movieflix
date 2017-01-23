package io.movieflix.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.movieflix.api.entity.MovieList;
import io.movieflix.api.service.MovieListService;



@RestController
@RequestMapping(value="movieslist")
public class MovieListController {
	@Autowired
	private MovieListService movieListService;
@RequestMapping(method=RequestMethod.GET)
	public List<MovieList> findAll()
	{
	return movieListService.findAll();	
	}
@RequestMapping(method=RequestMethod.GET, value="{id}")
	public MovieList findOne(@PathVariable("id") String listId)
	{
		return movieListService.findOne(listId);
	}
	
@RequestMapping(method=RequestMethod.POST)
	public MovieList create(@RequestBody MovieList mov)
	{
		return movieListService.create(mov);
	}

@RequestMapping(method=RequestMethod.PUT, value="{id}")
	
	public MovieList update(@PathVariable("id") String movId, @RequestBody MovieList mov)
	{
		return movieListService.update(movId, mov);
	}
	
@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public void delete(@PathVariable("id") String movId)
	{
		movieListService.delete(movId);
	}

@RequestMapping(method=RequestMethod.GET, value="type/{filterValue}")
public List<MovieList>  filterBy(@PathVariable("filterValue") String fValue)
{
	return movieListService.filterBy(fValue);
}

@RequestMapping(method=RequestMethod.GET, value="year/{yearValue}")
public List<MovieList>  filterByYear(@PathVariable("yearValue") int yValue)
{
	return movieListService.filterByYear(yValue);
}

@RequestMapping(method=RequestMethod.GET, value="genre/{genreValue}")
public List<MovieList>  filterByGenre(@PathVariable("genreValue") String gValue)
{
	return movieListService.filterByGenre(gValue);
}

@RequestMapping(method=RequestMethod.GET, value="type/{filterValue}/sortby/{columnValue}")
public List<MovieList>  sortBy(@PathVariable("filterValue") String fValue,@PathVariable("columnValue") String col)
{
	return movieListService.typeSortBy(fValue,col);
}

@RequestMapping(method=RequestMethod.GET, value="year/{filterValue}/sortby/{columnValue}")
public List<MovieList>  sortByinYear(@PathVariable("filterValue") String fValue,@PathVariable("columnValue") String col)
{
	return movieListService.yearSortBy(fValue,col);
}

@RequestMapping(method=RequestMethod.GET, value="genre/{filterValue}/sortby/{columnValue}")
public List<MovieList>  sortByinGenre(@PathVariable("filterValue") String fValue,@PathVariable("columnValue") String col)
{
	return movieListService.genreSortBy(fValue,col);
}

@RequestMapping(method=RequestMethod.GET, value="{id}")
public MovieList getDetails(@PathVariable("id") String listId)
{
	return movieListService.getDetails(listId);
}

@RequestMapping(method=RequestMethod.GET, value="{name}")
public MovieList searchByTitle(@PathVariable("name") String titl)
{
	return movieListService.searchByTitle(titl);
}
}

