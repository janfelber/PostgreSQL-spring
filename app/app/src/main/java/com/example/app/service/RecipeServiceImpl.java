package com.example.app.service;

import com.example.app.module.Category;
import com.example.app.module.Recipe;
import com.example.app.module.User;
import com.example.app.repository.CategoryRepository;
import com.example.app.repository.RecipeRepository;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository pastryRepository, UserRepository userRepository,
                             CategoryRepository categoryRepository){
        this.recipeRepository = pastryRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Recipe> getAllRecipes() {

        return recipeRepository.findAll();
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        var dbRecipe = recipeRepository.findById(recipe.getId());
        User user = userRepository.findById(1).orElse(null);
        Category category = categoryRepository.findById(1).orElse(null);
        if (user != null) { // Check if the user is found
            if (dbRecipe.isEmpty()) {
                recipe.setUser(user);
                recipe.setCategory(category);
                return recipeRepository.save(recipe);
            }
            recipe.setIngredients(dbRecipe.get().getIngredients());
            return recipeRepository.save(recipe);
        } else {
            // Handle the case where the user with ID 1 is not found
            return null;
        }
    }

    @Override
    public Recipe getRecipe(int id) {
        return recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found"
        ));
    }


}
