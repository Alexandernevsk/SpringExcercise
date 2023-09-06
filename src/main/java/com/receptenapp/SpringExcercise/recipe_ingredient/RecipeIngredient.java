package com.receptenapp.SpringExcercise.recipe_ingredient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.receptenapp.SpringExcercise.ingredient.Ingredient;
import com.receptenapp.SpringExcercise.recipe.Recipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredient {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    private double quantity;
    @Enumerated(EnumType.STRING)
    @Column(name = "measure_unit")
    private measureUnit measureUnit;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;

    public RecipeIngredient(Ingredient ingredient, double quantity, measureUnit measureUnit) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
    }

    public RecipeIngredient(double quantity, measureUnit measureUnit) {
        this.quantity = quantity;
        this.measureUnit = measureUnit;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setMeasureUnit(com.receptenapp.SpringExcercise.recipe_ingredient.measureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
