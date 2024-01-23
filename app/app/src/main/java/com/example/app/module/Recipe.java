package com.example.app.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recipe", schema = "App")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private int id;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "title")
    private String title;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "category_id_category", referencedColumnName = "id_category")
    private Category category;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user")
    private User user;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "description")
    private String description;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "instructions")
    private String instructions;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "recipe_has_ingredients", schema = "app",joinColumns = @JoinColumn(name = "recipe_id_recipe"), inverseJoinColumns = @JoinColumn(name = "ingredients_id_ingredients"))
    @JsonIgnoreProperties("recipes")
    private List<Ingredients> ingredients;

}
