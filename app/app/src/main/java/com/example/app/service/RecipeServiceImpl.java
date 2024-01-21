package com.example.app.service;

import com.example.app.module.Recipe;
import com.example.app.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository pastryRepository) {
        this.recipeRepository = pastryRepository;
    }


    @Override
    public List<Recipe> getAllRecipes() {

        return recipeRepository.findAll();
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        var dbRecipe = recipeRepository.findById(recipe.getId());
        if (dbRecipe.isEmpty()) {
            return recipeRepository.save(recipe);
        }
        recipe.setIngredients(dbRecipe.get().getIngredients());
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipe(int id) {
        return recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found"
        ));
    }


}
