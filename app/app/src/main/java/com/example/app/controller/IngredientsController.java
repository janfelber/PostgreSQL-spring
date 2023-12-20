package com.example.app.controller;


import com.example.app.module.Category;
import com.example.app.module.Ingredients;
import com.example.app.service.CategoryService;
import com.example.app.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService){
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/ingredients/{id}")
    public Ingredients getIngredients(@PathVariable int id) {
        return ingredientsService.getIngredients(id);
    }
}
