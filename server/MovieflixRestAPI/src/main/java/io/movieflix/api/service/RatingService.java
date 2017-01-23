package io.movieflix.api.service;

import java.util.List;

import io.movieflix.api.entity.Rating;

public interface RatingService {
	public double getAverageRating(String listId);
	public void rateTitle(Rating rating,String mlId);
	public List<Rating> getComments(String mlId);
	public void giveComments(Rating rating,String mlId);
}
