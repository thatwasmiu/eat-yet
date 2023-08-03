package com.example.eatyet.masterdata.endpoint;

import com.example.eatyet.masterdata.context.EndpointRoute;
import com.example.eatyet.core.RestApiEndpoint;
import com.example.eatyet.masterdata.service.FoodService;
import com.example.eatyet.masterdata.model.meal.Food;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointRoute.FOOD)
@CrossOrigin(value = "*")
public class FoodEndpoint extends RestApiEndpoint<Food, Long> {
    private final FoodService foodService;

    public FoodEndpoint(FoodService foodService) {
        super(EndpointRoute.FOOD, foodService);
        this.foodService = foodService;
    }
}
