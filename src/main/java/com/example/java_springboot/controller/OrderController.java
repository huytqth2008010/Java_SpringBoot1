package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Category;
import com.example.java_springboot.entity.Order;
import com.example.java_springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/admin")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, path = "/orders")
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/orders")
    public List<Order> findAll(){
        return orderService.findAll();
    }
}
