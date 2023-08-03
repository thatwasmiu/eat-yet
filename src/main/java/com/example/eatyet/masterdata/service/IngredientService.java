package com.example.eatyet.masterdata.service;

import com.example.eatyet.core.CrudService;
import com.example.eatyet.masterdata.model.meal.Ingredient;
import com.example.eatyet.masterdata.repository.meal.IngredientRepo;
import org.springframework.stereotype.Service;

@Service
public class IngredientService extends CrudService<Ingredient, Long> {
    private final IngredientRepo ingredientRepo;

    public IngredientService(IngredientRepo repo) {
        super(repo);
        this.ingredientRepo = repo;
    }
}
