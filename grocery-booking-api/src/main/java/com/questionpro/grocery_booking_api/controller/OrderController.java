package com.questionpro.grocery_booking_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.grocery_booking_api.entity.Order;
import com.questionpro.grocery_booking_api.entity.OrderItem;
import com.questionpro.grocery_booking_api.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	 @Autowired
	    private OrderService orderService;

	    @PostMapping("/place")
	    public Order placeOrder(@RequestParam Long userId, @RequestBody List<OrderItem> orderItems) {
	        return orderService.placeOrder(userId, orderItems);
	    }

	    @GetMapping("/all")
	    public List<Order> getAllOrders() {
	        return orderService.getAllOrders();
	    }
	}
