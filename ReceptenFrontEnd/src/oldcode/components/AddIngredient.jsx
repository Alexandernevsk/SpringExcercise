import React from "react";

export default function AddIngredient({ ingredient, setIngredient }) {
  const handleSubmit = (event) => {
    setIngredient(ingredient);
    console.log(ingredient);
    event.preventDefault();
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setIngredient({
      ...ingredient,
      [name]: value,
    });
  };

  return (
    <div>
      <h3> add your ingredients! </h3>
      <form onSubmit={handleSubmit}>
        <input type="text" value={ingredient.name} onChange={handleChange} />
        <input
          type="text"
          value={ingredient.measureUnit}
          onChange={handleChange}
        />
        <input
          type="text"
          value={ingredient.quantity}
          onChange={handleChange}
        />
        <input type="submit" value="submit your ingredient" />
      </form>
    </div>
  );
}
