package com.example.eatyet.masterdata.service;

import com.example.eatyet.core.CrudService;
import com.example.eatyet.masterdata.model.meal.Meal;
import com.example.eatyet.masterdata.repository.meal.MealRepo;
import org.springframework.stereotype.Service;

@Service
public class MealService extends CrudService<Meal, Long> {
    private MealRepo mealRepo;

    public MealService(MealRepo repo) {
        super(repo);
        this.mealRepo = repo;
    }
}
