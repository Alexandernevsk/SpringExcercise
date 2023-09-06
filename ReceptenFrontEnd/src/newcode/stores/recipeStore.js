import { create } from "zustand";
import axios from "axios";

const recipeStore = create((set, get) => ({
  recipes : [],
  selectedRecipe : null,

  fetchRecipe: async (name) => {
    const response = await axios.get(
      `http://localhost:8080/api/v1/recipe/name/${name}`
    );

    set({
      selectedRecipe: {
        title: response.data.title,
        id: response.data.id,
        ingredients : response.data.recipeIngredients,
      },
    });
  },

  fetchAll: async () => {
    const response = await axios.get(`http://localhost:8080/api/v1/recipe/all`);
    set({recipe : response.data})
  },

  getRecipe: () => {
    return get().recipe;
  },

  getIngredients: () => {
    return get().ingredients;
  },
}));

export default recipeStore;
