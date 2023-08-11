package com.example.eatyet.masterdata.endpoint;

import com.example.eatyet.masterdata.context.EndpointRoute;
import com.example.eatyet.core.RestApiEndpoint;
import com.example.eatyet.masterdata.entity.FoodGeneralInfo;
import com.example.eatyet.masterdata.model.meal.Step;
import com.example.eatyet.masterdata.repository.meal.FoodRepo;
import com.example.eatyet.masterdata.repository.meal.StepRepo;
import com.example.eatyet.masterdata.service.FoodService;
import com.example.eatyet.masterdata.model.meal.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndpointRoute.FOOD)
@CrossOrigin(value = "*")
public class FoodEndpoint extends RestApiEndpoint<Food, Long> {
    private final FoodService foodService;

    @Autowired
    private FoodRepo repo;
    @Autowired
    private StepRepo stepRepo;

    public FoodEndpoint(FoodService foodService) {
        super(EndpointRoute.FOOD, foodService);
        this.foodService = foodService;
    }

    @GetMapping("/info")
    public List<FoodGeneralInfo> getInfo() {
        return foodService.generalInfoList();
    }



    @PostMapping("/update2")
    public Food update2(@RequestBody Food food) {
        Food f = repo.findById(food.getId()).orElseThrow(() -> new RuntimeException(""));
        f.getSteps().addAll(food.getSteps());
        return f;
    }

    @PostMapping("/update3")
    public Food update3(@RequestBody Food food) {
        return repo.save(food);
    }

    @PostMapping("/update4")
    public Food update4(@RequestBody Food food) {
        Food f = repo.findById(food.getId()).orElseThrow(() -> new RuntimeException(""));
//        List<Step> steps = stepRepo.findAllByFood(food);
        f.getSteps().clear();
        f.getSteps().addAll(food.getSteps());
        return repo.save(f);
    }

    // What fetching lazy does to a motherfucker
    @PostMapping("/update6")
    public Food update6(@RequestBody Food food) {
        Food f = repo.findById(food.getId()).orElseThrow(() -> new RuntimeException(""));
        f.setName(food.getName() + " test");
        return food;
    }
    @PostMapping("/update1")
    public Food update1(@RequestBody Food food) {
        Food f = repo.findById(food.getId()).orElseThrow(() -> new RuntimeException(""));
        return f;
    }
    ////


    // DA REAL ANSWER
    @PostMapping("/update7")
    public Food update7(@RequestBody Food food) {
        Food f = repo.findById(food.getId()).orElseThrow(() -> new RuntimeException(""));
        Step step0 = f.getSteps().get(0);
        step0.setName(step0.getName() + " test");
        return repo.save(f);
    }

    @PostMapping("/update5")
    public Food update5(@RequestBody Food food) {
        Food f = repo.findById(food.getId()).orElseThrow(() -> new RuntimeException(""));
        f.setName(food.getName() + " test");
        return repo.save(f);
    }
    ////

    @PostMapping("/update10")
    public Food update10(@RequestBody Food food) {
        Food f = repo.findById(food.getId()).orElseThrow(() -> new RuntimeException(""));
        f.setName(food.getName() + " test");
        Step step0 = f.getSteps().get(0);
        step0.setName(step0.getName() + " test");
        return repo.save(f);
    }
}
