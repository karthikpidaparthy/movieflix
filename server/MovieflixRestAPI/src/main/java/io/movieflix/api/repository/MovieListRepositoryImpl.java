package io.movieflix.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.movieflix.api.entity.MovieList;
@Repository
public class MovieListRepositoryImpl implements MovieListRepository {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<MovieList> findAll() {
		// TODO Auto-generated method stub
TypedQuery<MovieList> typedQuery=em.createNamedQuery("MovieList.findAll", MovieList.class);
		
		return typedQuery.getResultList();
	}

	@Override
	public MovieList findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(MovieList.class, id);
	}

	@Override
	public MovieList create(MovieList mov) {
		// TODO Auto-generated method stub
		System.err.println("inside create");
	//	System.err.println("mov value is "+mov.toString());
		em.persist(mov);
		System.err.println("finished persist");
			return mov;
	}

	@Override
	public MovieList update(MovieList mov) {
		// TODO Auto-generated method stub
		return em.merge(mov);
	}

	@Override
	public void delete(MovieList mov) {
		// TODO Auto-generated method stub
		em.remove(mov);
	}

	@Override
	public MovieList findByImdbId(String imdbId) {
		// TODO Auto-generated method stub
		TypedQuery<MovieList> typedQuery=em.createNamedQuery("MovieList.findByImdbId", MovieList.class);
		typedQuery.setParameter("userImdbId", imdbId);
		List<MovieList> movieResultList=typedQuery.getResultList();
		if(movieResultList!=null && movieResultList.size()==1)
		{
			return movieResultList.get(0);
		}
		else
		{
			System.err.println("no imdbid present");
			return null;
		}
	}

	@Override
	public List<MovieList>  filterBy(String filterBy) {
		// TODO Auto-generated method stub
		TypedQuery<MovieList> typedQuery=em.createNamedQuery("MovieList.Type", MovieList.class);
		typedQuery.setParameter("uType", filterBy);
		List<MovieList> movieList =typedQuery.getResultList();
		return movieList;
	}

	@Override
	public List<MovieList> filterByYear(int yValue) {
		// TODO Auto-generated method stub
		TypedQuery<MovieList> typedQuery=em.createNamedQuery("MovieList.Year", MovieList.class);
		typedQuery.setParameter("uYear", yValue);
		List<MovieList> movieList =typedQuery.getResultList();
		return movieList;
	}

	@Override
	public List<MovieList> filterByGenre(String gValue) {
		// TODO Auto-generated method stub
		TypedQuery<MovieList> typedQuery=em.createNamedQuery("MovieList.Genre", MovieList.class);
		typedQuery.setParameter("uGenre", gValue);
		List<MovieList> movieList =typedQuery.getResultList();
		return movieList;
	}

	@Override
	public List<MovieList> typeSortBy(String fValue, String col) {
	TypedQuery<MovieList> query=em.createQuery("select m from MovieList m where m.type=:entType order by m."+col+"",MovieList.class);
	query.setParameter("entType", fValue);
	List<MovieList> list=query.getResultList();
	return list;	}

	@Override
	public List<MovieList> yearSortBy(String fValue, String col) {
	TypedQuery<MovieList> query=em.createQuery("select m from MovieList m where m.year=:entYear order by m."+col+"",MovieList.class);
	query.setParameter("entYear", fValue);
	List<MovieList> list=query.getResultList();
	return list;	}

	@Override
	public List<MovieList> genreSortBy(String fValue, String col) {
	TypedQuery<MovieList> query=em.createQuery("select m from MovieList m where m.genre=:entGenre order by m."+col+"",MovieList.class);
	query.setParameter("entGenre", fValue);
	List<MovieList> list=query.getResultList();
	return list;	}

	@Override
	public MovieList getDetails(String listId) {
		// TODO Auto-generated method stub
		TypedQuery< MovieList> typedQuery=em.createNamedQuery("MovieList.getDesc", MovieList.class);
		typedQuery.setParameter("uMovListId", listId);
		return typedQuery.getResultList().get(0);
	}

	@Override
	public MovieList searchByTitle(String titl) {
		// TODO Auto-generated method stub
		TypedQuery< MovieList> typedQuery=em.createNamedQuery("MovieList.findByTitle", MovieList.class);
		typedQuery.setParameter("userTitle", titl);
		return typedQuery.getResultList().get(0);
	}

}
