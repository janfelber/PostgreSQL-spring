package com.example.app.service;

import com.example.app.module.Recipe;

import java.util.List;

public interface RecipeService {


    List<Recipe> getAllRecipes();

    Recipe addRecipe(Recipe recipe, int categoryId);
    Recipe getRecipe(int id);
}
