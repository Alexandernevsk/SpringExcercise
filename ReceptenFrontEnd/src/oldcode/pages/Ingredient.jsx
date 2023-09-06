import React from "react";
import { useState, useEffect } from "react";
import AddIngredient from "../components/AddIngredient";

export default function Ingredient() {
  const [ingredients, setIngredients] = useState([]);

  const fetchAllIngredients = async () => {
    const response = await fetch(
      "http://localhost:8080/api/v1/ingredient/all",
      {
        method: "GET",
        headers: {
          Accept: "application/json",
        },
        mode: "cors",
        cache: "default",
      }
    );
    return response.json();
  };

  useEffect(() => {
    const fetchIngredients = async () => {
      const response = await fetchAllIngredients();
      setIngredients(response);
      console.log(ingredients);
    };

    fetchIngredients();
  }, []);

  return (
    <div>
      <div>
        {ingredients
          ? ingredients.map((item) => <div key={item.id}>{item.name}</div>)
          : "Loading..."}
      </div>
      <AddIngredient />
    </div>
  );
}
