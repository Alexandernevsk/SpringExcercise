import React from "react";
import { Link } from "react-router-dom";
import Recipelist from "../components/Recipelist";

export default function OldRecipePage() {
 
  return (
    <div className="recipe-head">
      <Link to={"/addrecipe"}> add your recipe! </Link>
      <Recipelist />
    </div>
  );
}
