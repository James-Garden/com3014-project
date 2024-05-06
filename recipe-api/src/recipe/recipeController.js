const Recipe = require("recipe.js");
const asyncHandler = require("express-async-handler");

// GET: Return all recipes
exports.getAllRecipes = asyncHandler(async (req, res, next) => {});

// GET: Return a specified recipe by id
exports.getRecipe = asyncHandler(async (req, res, next) => {});

// GET: Search for a recipe
exports.searchRecipes = asyncHandler(async (req, res, next) => {});

// GET: Retrieves saved recipes from Session API
exports.getSavedRecipes = asyncHandler(async (req, res, next) => {});

// POST: Save a recipe to Session API
exports.saveRecipe = asyncHandler(async (req, res, next) => {});

// DELETE: Unsave a recipe in Session API
exports.unsaveRecipe = asyncHandler(async (req, res, next) => {});
