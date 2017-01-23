package io.movieflix.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.movieflix.api.entity.Rating;
import io.movieflix.api.service.RatingService;

@RestController
@RequestMapping(value="movieslist")
public class RatingController {
@Autowired
private RatingService ratingService;
@RequestMapping(method=RequestMethod.GET, value="{id}")
public double getAverageRating(@PathVariable("id") String listId)
{
	return ratingService.getAverageRating(listId);
}

@RequestMapping(method=RequestMethod.POST, value="{id}")
public void rateTitle( Rating rating,@PathVariable("id") String mlId)
{
	 ratingService.rateTitle(rating, mlId);
}

@RequestMapping(method=RequestMethod.GET, value="{id}")
public List<Rating> getComments(@PathVariable("id") String mlId)
{
	return ratingService.getComments(mlId);
}

@RequestMapping(method=RequestMethod.POST,value="{id}")
public void giveComments(Rating rating,@PathVariable("id") String mlId)
{
	 ratingService.giveComments(rating,mlId);
}


}
