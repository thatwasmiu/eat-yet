package com.example.eatyet.masterdata.endpoint;

import com.example.eatyet.core.CrudService;
import com.example.eatyet.core.RestApiEndpoint;
import com.example.eatyet.masterdata.context.EndpointRoute;
import com.example.eatyet.masterdata.model.meal.Ingredient;
import com.example.eatyet.masterdata.service.IngredientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointRoute.INGREDIENT)
@CrossOrigin(value = "*")
public class IngredientEndpoint extends RestApiEndpoint<Ingredient, Long> {
    IngredientService ingredientService;

    public IngredientEndpoint(IngredientService service) {
        super(EndpointRoute.INGREDIENT, service);
        this.ingredientService = service;
    }
}
