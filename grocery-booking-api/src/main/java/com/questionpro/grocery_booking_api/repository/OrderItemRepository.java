package com.questionpro.grocery_booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionpro.grocery_booking_api.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}