package com.receptenapp.SpringExcercise.recipe;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.receptenapp.SpringExcercise.recipe_ingredient.RecipeIngredient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RecipeIngredient> recipeIngredients;

    public Recipe(String title) {
        this.title = title;
    }

    public Recipe(String title, List<RecipeIngredient> recipeIngredients) {
        this.title = title;
        this.recipeIngredients = recipeIngredients;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}
