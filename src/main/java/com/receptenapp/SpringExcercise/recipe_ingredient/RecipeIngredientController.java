package com.receptenapp.SpringExcercise.recipe_ingredient;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/recipeIngredient")
public class RecipeIngredientController {
    @PostMapping("save")
    public void saveRecipeIngredient() {

    }

}
