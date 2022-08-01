package com.example.java_springboot.service;

import com.example.java_springboot.entity.Comment;
import com.example.java_springboot.entity.Rating;
import com.example.java_springboot.respository.CommentRepository;
import com.example.java_springboot.respository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public Page<Rating> findAll(int page, int limit) {
        return ratingRepository.findAll(
                PageRequest.of(page - 1, limit));
    }

    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findById(Integer id) {
        return ratingRepository.findById(id);
    }

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void deleteById(Integer id) {
        ratingRepository.deleteById(id);
    }
}
