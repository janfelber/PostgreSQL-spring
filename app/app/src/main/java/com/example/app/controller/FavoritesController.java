package com.example.app.controller;


import com.example.app.module.Favorites;
import com.example.app.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FavoritesController {

    private final FavoritesService favoritesService;

    @Autowired
    public FavoritesController(FavoritesService favoritesService) {this.favoritesService = favoritesService;}

    @GetMapping("/favorite/{id}")
    public Favorites getFavorite(@PathVariable int id) {
        return favoritesService.getFavorite(id);
    }
}


