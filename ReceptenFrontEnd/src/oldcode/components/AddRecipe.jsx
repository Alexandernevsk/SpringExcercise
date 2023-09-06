import React from "react";
import { useState } from "react";
import AddIngredient from "./AddIngredient";

export default function AddRecipe() {
  const postRecipe = "http://localhost:8080/api/v1/recipe/save";
  const postIngredient = "http://localhost:8080/api/v1/ingredient/save";
  const labelText = "type in the of your recipe!";
  const placeHolderIngredient = {
    name: "add your ingredient!",
    measureUnit: "add your measurement!",
    quantity: "how much?",
  };

  const [ingredient, setIngredient] = useState(placeHolderIngredient);

  const [recipe, setRecipe] = useState({
    title: labelText,
  });

  const RecipePost = async (url, data = {}) => {
    const response = await fetch(url, {
      method: "POST",
      mode: "cors",
      credentials: "same-origin",
      headers: {
        "Content-Type": "application/json",
      },

      body: JSON.stringify(data),
    });
    return response.json;
  };

  const ingredientPost = async (url, data = {}) => {
    const response = await fetch(url, {
      method: "POST",
      mode: "cors",
      credentials: "same-origin",
      headers: {
        "Content-Type": "application/json",
      },

      body: JSON.stringify(data),
    });
    return response.json;
  };

  const handleSubmit = (event) => {
    RecipePost(postRecipe, recipe);
    ingredientPost(postIngredient, ingredient);
    setRecipe({ name: labelText });
    setIngredient(placeHolderIngredient);
    event.preventDefault();
  };

  const handleChange = (event) => {
    setRecipe({ title: event.target.value });
  };

  return (
    <div>
      <h1> Add your Recipe </h1>
      <form onSubmit={handleSubmit}>
        <input type="text" value={recipe.title} onChange={handleChange} />
      </form>
      <AddIngredient ingredient={ingredient} setIngredient={setIngredient} />
    </div>
  );
}
