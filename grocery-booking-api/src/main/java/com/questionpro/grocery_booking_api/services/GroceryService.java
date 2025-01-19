package com.questionpro.grocery_booking_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.grocery_booking_api.entity.GroceryItem;
import com.questionpro.grocery_booking_api.repository.GroceryItemRepository;

@Service
public class GroceryService  {

	 @Autowired
	    private GroceryItemRepository groceryItemRepository;

	    // Add a new grocery item
	    public GroceryItem addGroceryItem(GroceryItem item) {
	        return groceryItemRepository.save(item);
	    }

	    // Update an existing grocery item
	    public GroceryItem updateGroceryItem(GroceryItem item) {
	        return groceryItemRepository.save(item);
	    }

	    // Delete a grocery item
	    public void deleteGroceryItem(Long id) {
	        groceryItemRepository.deleteById(id);
	    }

	    // Get all grocery items
	    public List<GroceryItem> getAllGroceryItems() {
	        return groceryItemRepository.findAll();
	    }

	    // Get a grocery item by ID
	    public GroceryItem getGroceryItemById(Long id) {
	        return groceryItemRepository.findById(id).orElse(null);
	    }
	}