const express = require("express");
import { getAllRecipes, getRecipe } from "../recipe/recipeController";
const router = express.Router();

router.get("/", (req, res) => {
  res.send(getAllRecipes(req));
});

router.get("/:id", (req, res) => {
  res.send(getRecipe(req));
});

module.exports = router;
