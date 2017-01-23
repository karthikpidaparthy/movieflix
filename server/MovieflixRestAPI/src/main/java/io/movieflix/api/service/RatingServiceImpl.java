package io.movieflix.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.movieflix.api.entity.Rating;
import io.movieflix.api.repository.RatingRepository;
@Service
public class RatingServiceImpl implements RatingService {
@Autowired
private RatingRepository ratingRepository;
	@Override
	@Transactional(readOnly=true)
	public double getAverageRating(String listId) {
		// TODO Auto-generated method stub
		double rating=ratingRepository.getAverageRating(listId);
		if(rating!=0)
		{
			return rating;
		}
		else
		{
			throw new EntityNotFoundException("Rating not available");
		}
	}

	@Override
	@Transactional
	public void rateTitle(Rating rating, String mlId) {
		// TODO Auto-generated method stub
		ratingRepository.rateTitle(rating,mlId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Rating> getComments(String mlId) {
		// TODO Auto-generated method stub
		List<Rating> commentList=ratingRepository.getComments(mlId);
		if(commentList!=null && commentList.size()!=0)
		{
			return commentList;
		}
		else
		{
			throw new EntityNotFoundException("Comments not available");
		}
	}

	@Override
	@Transactional
	public void giveComments(Rating rating, String mlId) {
		// TODO Auto-generated method stub
		ratingRepository.giveComments(rating,mlId);
	}

}
