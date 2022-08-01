package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Rating;
import com.example.java_springboot.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/admin")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @RequestMapping(method = RequestMethod.GET, path = "/ratings")
    public Page<Rating> getList(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "1") int limit) {
        return ratingService.findAll(page, limit);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/ratings/get-all")
    public List<Rating> getList() {
        return ratingService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/comments")
    public Rating save(@RequestBody Rating rating) {
        ratingService.save(rating);
        return rating;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ratings/{id}")
    public Rating getDetail(@PathVariable Integer id) {
        return ratingService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/ratings/{id}")
    public boolean delete(@PathVariable Integer id) {
        ratingService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/ratings/{id}")
    public Rating update(@PathVariable Integer id, @RequestBody Rating updateRating) {
        Rating existing = ratingService.findById(id).get();
        existing.setRating_star(updateRating.getRating_star());
        existing.setStatus(updateRating.getStatus());
        ratingService.save(existing);
        return updateRating;
    }
}
