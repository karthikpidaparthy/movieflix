package io.movieflix.api.repository;

import java.util.List;

import io.movieflix.api.entity.Rating;

public interface RatingRepository {
	public double getAverageRating(String listId);
	public void rateTitle(Rating rating, String mlId);
	public List<Rating> getComments(String mlId);
	public void giveComments(Rating rating, String mlId);
}
