package com.example.eatyet.masterdata.service;

import com.example.eatyet.core.CrudService;
import com.example.eatyet.masterdata.model.meal.Food;
import com.example.eatyet.masterdata.repository.meal.FoodRepo;
import org.springframework.stereotype.Service;

@Service
public class FoodService extends CrudService<Food, Long> {
    private FoodRepo foodRepo;

    public FoodService(FoodRepo repo) {
        super(repo);
        this.foodRepo = repo;
    }

}
