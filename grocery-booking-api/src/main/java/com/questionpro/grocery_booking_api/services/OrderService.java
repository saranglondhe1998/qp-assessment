package com.questionpro.grocery_booking_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.grocery_booking_api.entity.GroceryItem;
import com.questionpro.grocery_booking_api.entity.Order;
import com.questionpro.grocery_booking_api.entity.OrderItem;
import com.questionpro.grocery_booking_api.repository.GroceryItemRepository;
import com.questionpro.grocery_booking_api.repository.OrderItemRepository;
import com.questionpro.grocery_booking_api.repository.OrderRepository;

@Service
public class OrderService {

	 @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private OrderItemRepository orderItemRepository;

	    @Autowired
	    private GroceryItemRepository groceryItemRepository;

	    // Place an order (add multiple grocery items)
	    public Order placeOrder(Long userId, List<OrderItem> orderItems) {
	        Order order = new Order();
	        order.setUserId(userId);
	        double totalPrice = 0;
	        
	        // Calculate total price
	        for (OrderItem item : orderItems) {
	            GroceryItem groceryItem = groceryItemRepository.findById(item.getGroceryItemId()).orElse(null);
	            if (groceryItem != null) {
	                item.setPrice(groceryItem.getPrice() * item.getQuantity());
	                totalPrice += item.getPrice();
	            }
	        }
	        
	        // Save order and order items
	        order.setTotalPrice(totalPrice);
	        order = orderRepository.save(order);
	        
	        for (OrderItem orderItem : orderItems) {
	            orderItem.setOrderId(order.getId());
	            orderItemRepository.save(orderItem);
	        }
	        
	        return order;
	    }

	    // Get all orders
	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    // Get orders by user ID
	    public List<Order> getOrdersByUserId(Long userId) {
	        // This can be implemented by adding custom query to OrderRepository
	        return null;
	    }
	}