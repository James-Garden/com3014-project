const express = require("express");
const router = express.Router();

const controller = require("../recipe/recipeController");

router.get("/", controller.getAllRecipes);

router.get("/:id", controller.getRecipe);

router.get("/search", controller.searchRecipe);

router.get("/saved", controller.getSavedRecipes);

router.get("/save", controller.searchRecipe);

router.get("/search", controller.searchRecipe);

module.exports = router;
