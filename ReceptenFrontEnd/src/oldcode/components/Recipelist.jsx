import React from "react";
import { useState, useEffect } from "react";
import Ingredients from "./Ingredients";

export default function Recipelist() {
  const [recipes, setRecipe] = useState([]);

  const allRecipes = async (url) => {
    const response = await fetch(url, {
      method: "GET",
      headers: {
        Accept: "application/json",
      },
      mode: "cors",
      cache: "default",
    });
    return response.json();
  };

  useEffect(() => {
    const fetchItem = async () => {
      const response = await allRecipes(
        "http://localhost:8080/api/v1/recipe/all"
      );
      console.log(response);
      setRecipe(response);
    };
    fetchItem();
  }, []);

  return (
    <div>
      {recipes.map((item) => (
        <div key={item.id}>
          {item.title}
          <div>
            {item.recipeIngredients.map((ingredient) => (
              <Ingredients
                key={ingredient.id}
                ingredient={ingredient.ingredient}
                measureUnit={ingredient.measureUnit}
                quantity={ingredient.quantity}
              />
            ))}
          </div>
        </div>
      ))}
    </div>
  );
}
