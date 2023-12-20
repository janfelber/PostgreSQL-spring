package com.example.app.service;


import com.example.app.module.Comments;
import com.example.app.module.Favorites;
import com.example.app.repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FavoritesServiceImpl implements FavoritesService{

    private final  FavoritesRepository favoritesRepository;

    @Autowired
    public FavoritesServiceImpl(FavoritesRepository favoritesRepository) {this.favoritesRepository = favoritesRepository;}

    @Override
    public Favorites getFavorite(int id) {
        return favoritesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Favorite with id " + id + " not found"
        ));
    }
}
