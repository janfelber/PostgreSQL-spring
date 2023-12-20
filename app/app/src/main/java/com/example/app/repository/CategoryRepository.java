package com.example.app.repository;

import com.example.app.module.Category;
import com.example.app.module.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
