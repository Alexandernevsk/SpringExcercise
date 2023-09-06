package com.receptenapp.SpringExcercise.ingredient;

import com.receptenapp.SpringExcercise.recipe.Recipe;
import com.receptenapp.SpringExcercise.recipe_ingredient.RecipeIngredient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
