package com.example.java_springboot.service;

import com.example.java_springboot.entity.Order;
import com.example.java_springboot.entity.Product;
import com.example.java_springboot.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order save(Order grade){
        orderRepository.save(grade);
        return grade;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(int orderId) {
        return orderRepository.findById(orderId);
    }

}
