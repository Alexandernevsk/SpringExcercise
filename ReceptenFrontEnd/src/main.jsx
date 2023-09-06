import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from "./newcode/pages/HomePage";
import RecipePage from "./newcode/pages/RecipePage";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route index element={<HomePage />} />
        <Route path="/recipe" element = {<RecipePage/>} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);
