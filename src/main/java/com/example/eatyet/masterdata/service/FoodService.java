package com.example.eatyet.masterdata.service;

import com.example.eatyet.core.CrudService;
import com.example.eatyet.masterdata.entity.FoodGeneralInfo;
import com.example.eatyet.masterdata.model.meal.Food;
import com.example.eatyet.masterdata.model.meal.Step;
import com.example.eatyet.masterdata.repository.meal.FoodRepo;
import com.example.eatyet.masterdata.repository.meal.StepRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService extends CrudService<Food, Long> {
    private final FoodRepo foodRepo;
    private final StepRepo stepRepo;
    public FoodService(FoodRepo repo, StepRepo stepRepo) {
        super(repo);
        this.foodRepo = repo;
        this.stepRepo = stepRepo;
    }

    public List<FoodGeneralInfo> generalInfoList() {
        return foodRepo.findAllBy();
    }

    @Override
    protected void beforeCreate(Food food) {
        super.beforeCreate(food);
        food.getSteps().forEach(s -> s.setFood(food));
    }


    @Override
    protected Food compareAndAudit(Food food, Food f) {
        f.setName(food.getName());
        f.setDescr(food.getDescr());
        f.setBannerUrl(food.getBannerUrl());
        List<Step> steps = f.getSteps();
        steps.clear();
        steps.addAll(food.getSteps());
        return f;
    }

    protected void compareAndMutateStep(Step step, Step s) {

    }

}
