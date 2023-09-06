import React from "react";

export default function Ingredients({ ingredient, measureUnit, quantity }) {
  return (
    <div>
      <p>{ingredient.name}</p>
      <p>{measureUnit}</p>
      <p>{quantity}</p>
    </div>
  );
}
