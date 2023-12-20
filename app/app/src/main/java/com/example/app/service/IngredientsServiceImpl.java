package com.example.app.service;

import com.example.app.module.Category;
import com.example.app.module.Ingredients;
import com.example.app.repository.CategoryRepository;
import com.example.app.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IngredientsServiceImpl implements IngredientsService{

    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public Ingredients getIngredients(int id) {
        return ingredientsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Ingredient with id " + id + " not found"
        ));
    }
}
