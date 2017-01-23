package io.movieflix.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.movieflix.api.entity.Rating;
import io.movieflix.api.entity.User;
@Repository
public class RatingRepositoryImpl implements RatingRepository {
	@PersistenceContext
	private EntityManager em;
	@Override
	public double getAverageRating(String listId) {
		// TODO Auto-generated method stub
		TypedQuery<Rating> typedQuery=em.createNamedQuery("Rating.AverageRating", Rating.class);
	typedQuery.setParameter("uMovId", listId);
		/*	List<Rating> list=typedQuery.getResultList();
		if(list!=null && list.size()!=0)
		{
		list.
		}
		else
		{
			return 0;
		}*/
		double result=Double.parseDouble(typedQuery.getResultList().toString());
		if(result==0)
		{
			return 0;
		}
		else
		{
			return result;
		}
	}

	@Override
	public void rateTitle(Rating rating, String mlId) {
		// TODO Auto-generated method stub
		TypedQuery<Rating> typedQuery=em.createNamedQuery("Rating.Check", Rating.class);
		User user=new User();
		//MovieList movieList=new MovieList();
typedQuery.setParameter("uMovId", mlId);
typedQuery.setParameter("uUserId", user.getUserID());
List<Rating> list=typedQuery.getResultList();
if(list==null || list.size()==0)
{
	em.persist(rating);
}
else{
	em.merge(rating);
}
	}

	@Override
	public List<Rating> getComments(String mlId) {
		// TODO Auto-generated method stub
		TypedQuery<Rating> typedQuery=em.createNamedQuery("Rating.Comments", Rating.class);
		typedQuery.setParameter("uMovId", mlId);
		List<Rating> list=typedQuery.getResultList();
	if(list!=null && list.size()!=0 )
	{
		return list;
	}
	else
	{
		return null;
	}
		
	}

	@Override
	public void giveComments(Rating rating,String mlId) {
		// TODO Auto-generated method stub
		TypedQuery<Rating> typedQuery=em.createNamedQuery("Rating.CheckComment", Rating.class);
		User user=new User();
		//MovieList movieList=new MovieList();
typedQuery.setParameter("uMovId", mlId);
typedQuery.setParameter("uUserId", user.getUserID());
List<Rating> list=typedQuery.getResultList();
if(list==null || list.size()==0)
{
	em.persist(rating);
}
else{
	em.merge(rating);
}
	}

}
