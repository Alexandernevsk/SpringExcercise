package com.receptenapp.SpringExcercise.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ingredient")
public class IngredientController {
    @Autowired
    IngredientRepository ingredientRepository;

    @PostMapping("save")
    public void saveIngredient(@RequestBody Ingredient ingredient) {
        System.out.println("Ingredient has been saved");
        ingredientRepository.save(ingredient);
    }

    @GetMapping("all")
    public List<Ingredient> findAllIngredients() {
        System.out.println("Ingredients has been queried: " + "time: " + LocalTime.now());
        return ingredientRepository.findAll();
    }

}
