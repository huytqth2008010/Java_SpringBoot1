package com.example.java_springboot.respository;

import com.example.java_springboot.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Integer> {
}
