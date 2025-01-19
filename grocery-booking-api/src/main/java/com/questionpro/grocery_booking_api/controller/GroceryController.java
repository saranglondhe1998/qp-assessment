package com.questionpro.grocery_booking_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.grocery_booking_api.entity.GroceryItem;
import com.questionpro.grocery_booking_api.services.GroceryService;

@RestController
@RequestMapping("/api/grocery")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping("/add")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {
        return groceryService.addGroceryItem(item);
    }

    @GetMapping("/all")
    public List<GroceryItem> getAllGroceryItems() {
        return groceryService.getAllGroceryItems();
    }

    @PutMapping("/update")
    public GroceryItem updateGroceryItem(@RequestBody GroceryItem item) {
        return groceryService.updateGroceryItem(item);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroceryItem(@PathVariable Long id) {
        groceryService.deleteGroceryItem(id);
    }
}