package io.movieflix.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.movieflix.api.entity.MovieList;
import io.movieflix.api.exceptions.BadRequestException;
import io.movieflix.api.exceptions.EntityNotFoundException;
import io.movieflix.api.repository.MovieListRepository;
import io.movieflix.api.service.MovieListService;
@Service
public class MovieListServiceImpl implements MovieListService {
	@Autowired
	private MovieListRepository movieListRepository;
	@Override
	@Transactional(readOnly=true)
	public List<MovieList> findAll() {
		// TODO Auto-generated method stub
		return movieListRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public MovieList findOne(String id) {
		// TODO Auto-generated method stub
	MovieList mov=movieListRepository.findOne(id);
	if(mov==null)
	{
		throw new EntityNotFoundException("Movie/Series not found");
		
	}
	return mov;
	}

	@Override
	@Transactional
	public MovieList create(MovieList mov) {
		// TODO Auto-generated method stub
		 MovieList movieList=movieListRepository.findByImdbId(mov.getImdbId());
		if(movieList!=null)
		{
			throw new BadRequestException("Movie/Series with this imdb id already exists");
		}
		else
		{
			System.err.println("creating new record");
		return movieListRepository.create(mov);
		}
	}

	@Override
	@Transactional
	public MovieList update(String id, MovieList mov) {
		// TODO Auto-generated method stub
		if(movieListRepository.findOne(id)==null)
		{
			throw new EntityNotFoundException("Movie/Series not found");
		}
		else
		{
	return movieListRepository.update(mov);
	}
	}
	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
MovieList movieList=movieListRepository.findOne(id);
if(movieList==null)
{
	throw new EntityNotFoundException("Movie/Series not found");
}
else
{
	movieListRepository.delete(movieList);
}
	}

	@Override
	public List<MovieList>  filterBy(String fValue) {
		// TODO Auto-generated method stub
		return movieListRepository.filterBy(fValue);
	}

	@Override
	public List<MovieList> filterByYear(int yValue) {
		// TODO Auto-generated method stub
		return movieListRepository.filterByYear(yValue);
	}

	@Override
	public List<MovieList> filterByGenre(String gValue) {
		// TODO Auto-generated method stub
		return movieListRepository.filterByGenre(gValue);
	}

	@Override
	public List<MovieList> typeSortBy(String fValue, String col) {
		// TODO Auto-generated method stub
		return movieListRepository.typeSortBy(fValue,col);
	}

	@Override
	public List<MovieList> yearSortBy(String fValue, String col) {
		// TODO Auto-generated method stub
		return movieListRepository.yearSortBy(fValue,col);
	}
	@Override
	public List<MovieList> genreSortBy(String fValue, String col) {
		// TODO Auto-generated method stub
		return movieListRepository.genreSortBy(fValue,col);
	}

	@Override
	public MovieList getDetails(String listId) {
		// TODO Auto-generated method stub
		return movieListRepository.getDetails(listId); 
	}	
	
	@Override
	public MovieList searchByTitle(String titl) {
		// TODO Auto-generated method stub
		return movieListRepository.searchByTitle(titl); 
	}

}
