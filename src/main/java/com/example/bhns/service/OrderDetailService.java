package com.example.bhns.service;

import com.example.bhns.entity.Order;
import com.example.bhns.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    OrderRepository repo;
    public List<Order> listAll(){
        return (List<Order>) repo.findAll();
    }
}
