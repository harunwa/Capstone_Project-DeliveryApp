package com.example.capstonebackend.controllers;

import com.example.capstonebackend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    OrderService orderService;




}
