package com.receptenapp.SpringExcercise;

import com.receptenapp.SpringExcercise.ingredient.Ingredient;
import com.receptenapp.SpringExcercise.ingredient.IngredientRepository;
import com.receptenapp.SpringExcercise.recipe.Recipe;
import com.receptenapp.SpringExcercise.recipe.RecipeRepository;
import com.receptenapp.SpringExcercise.recipe_ingredient.RecipeIngredient;
import com.receptenapp.SpringExcercise.recipe_ingredient.RecipeIngredientRepository;
import com.receptenapp.SpringExcercise.recipe_ingredient.measureUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Seed implements CommandLineRunner {

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;


    @Override
    public void run(String... args) throws Exception {
        seedRecipes();
    }

    public void seedRecipes() {
        if (recipeRepository.count() == 0) {
            // Create Ingredients
            Ingredient parmesanCheese = new Ingredient("Parmesan Cheese");
            Ingredient pasta = new Ingredient("Pasta");
            Ingredient beef = new Ingredient("Beef");
            Ingredient tomatoSauce = new Ingredient("Tomato Sauce");

            List<Ingredient> ingredientsToSave = new ArrayList<>();
            ingredientsToSave.add(parmesanCheese);
            ingredientsToSave.add(pasta);
            ingredientsToSave.add(beef);
            ingredientsToSave.add(tomatoSauce);


            // Create RecipeIngredients
            RecipeIngredient parmesanCheeseIngredient = new RecipeIngredient( 2, measureUnit.G);
            RecipeIngredient pastaIngredient = new RecipeIngredient( 200, measureUnit.G);
            RecipeIngredient beefIngredient = new RecipeIngredient(300, measureUnit.G);
            RecipeIngredient tomatoSauceIngredient = new RecipeIngredient(500, measureUnit.G);

            // Set ingredient to RecipeIngredients because of persistence thing
            parmesanCheeseIngredient.setIngredient(parmesanCheese);
            pastaIngredient.setIngredient(pasta);
            beefIngredient.setIngredient(beef);
            tomatoSauceIngredient.setIngredient(tomatoSauce);

            // Create a list of RecipeIngredients for lasagna
            List<RecipeIngredient> lasagnaIngredients = new ArrayList<>();
            lasagnaIngredients.add(parmesanCheeseIngredient);
            lasagnaIngredients.add(pastaIngredient);
            lasagnaIngredients.add(beefIngredient);
            lasagnaIngredients.add(tomatoSauceIngredient);

            // Create the Lasagna recipe
            Recipe lasagnaRecipe = new Recipe("Lasagna", lasagnaIngredients);

            //Because of persistence i need to manually set this before I save ensuring the same recipe id for all
            lasagnaRecipe.getRecipeIngredients().forEach(recipeIngredient -> recipeIngredient.setRecipe(lasagnaRecipe));


            // Save Recipe (cascade will save RecipeIngredients)
            recipeRepository.save(lasagnaRecipe);
            ingredientRepository.saveAll(ingredientsToSave);
            recipeIngredientRepository.saveAll(lasagnaIngredients);
        }

        System.out.println("Database seeded successfully.");
    }


}


