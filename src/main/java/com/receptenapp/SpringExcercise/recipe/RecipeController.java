package com.receptenapp.SpringExcercise.recipe;

import com.receptenapp.SpringExcercise.ingredient.IngredientRepository;
import com.receptenapp.SpringExcercise.recipe_ingredient.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/recipe")
public class RecipeController {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    @GetMapping("all")
    public List<Recipe> findAllRecipes() {
        System.out.println("Hello recipes");
        return recipeRepository.findAll();
    }

    @PostMapping("save")
    public void saveRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        recipe.getRecipeIngredients().forEach(recipeIngredient -> ingredientRepository.save(recipeIngredient.getIngredient()));
        recipe.getRecipeIngredients().forEach(recipeIngredient -> recipeIngredientRepository.save(recipeIngredient));
        System.out.println("Saved the recipe: " + recipe.getTitle());
    }

    @GetMapping("{id}")
    public Optional<Recipe> findRecipeById(@PathVariable("id") Long id) {
        System.out.println("Fetched: " + recipeRepository.findRecipeById(id).get().getTitle());
        return recipeRepository.findRecipeById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Recipe> findRecipeByName(@PathVariable("name") String name) {
        System.out.println("Fetched: " + recipeRepository.findRecipeByTitle(name).get().getTitle());
        return recipeRepository.findRecipeByTitle(name);
    }

}
