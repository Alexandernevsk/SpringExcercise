import React from "react";
import recipeStore from "../stores/RecipeStore";
import "../../styles/RecipeStyle.scss";
import { useEffect, useState } from "react";

export default function RecipePage() {
  const { fetchAll } = recipeStore();
  const [recipe, setRecipe] = useState([]);
  const [ingredients, setIngredients] = useState([])

  useEffect(() => {
    async function fetchRecipes() {
      const response = await fetchAll();
      setRecipe(response.data);
      setIngredients(response.data.title)
    }

    fetchRecipes();
  }, []);

  console.log(recipe);
  console.log(ingredients)

  return (
    <div className="recipe-layout">
      <h1> My Recipes: </h1>
    </div>
  );
}
