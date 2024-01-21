package com.example.app.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "ingredients", schema = "App")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredients")
    private int id;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Size(min = 3, max = 255)
    @Column(name = "allergen_info")
    private String allergen_info;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllergen_info() {
        return allergen_info;
    }

    public void setAllergen_info(String allergen_info) {
        this.allergen_info = allergen_info;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "recipe_has_ingredients", schema = "app",joinColumns = @JoinColumn(name = "ingredients_id_ingredients"), inverseJoinColumns = @JoinColumn(name = "recipe_id_recipe"))
    @JsonIgnoreProperties("ingredients")
    private List<Recipe> recipes;
}
