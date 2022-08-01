package com.example.java_springboot.service;

import com.example.java_springboot.entity.Rating;
import com.example.java_springboot.entity.Reply;
import com.example.java_springboot.respository.RatingRepository;
import com.example.java_springboot.respository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    public Page<Reply> findAll(int page, int limit) {
        return replyRepository.findAll(
                PageRequest.of(page - 1, limit));
    }

    public List<Reply> getAll() {
        return replyRepository.findAll();
    }

    public Optional<Reply> findById(Integer id) {
        return replyRepository.findById(id);
    }

    public Reply save(Reply reply) {
        return replyRepository.save(reply);
    }

    public void deleteById(Integer id) {
        replyRepository.deleteById(id);
    }
}
