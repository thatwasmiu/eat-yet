package com.example.eatyet.masterdata.endpoint;

import com.example.eatyet.masterdata.context.EndpointRoute;
import com.example.eatyet.core.RestApiEndpoint;
import com.example.eatyet.masterdata.service.MealService;
import com.example.eatyet.masterdata.model.meal.Meal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointRoute.MEAL)
public class MealEndpoint extends RestApiEndpoint<Meal, Long> {
    private MealService mealService;

    public MealEndpoint(MealService service) {
        super(EndpointRoute.MEAL, service);
        this.mealService = service;
    }
}
