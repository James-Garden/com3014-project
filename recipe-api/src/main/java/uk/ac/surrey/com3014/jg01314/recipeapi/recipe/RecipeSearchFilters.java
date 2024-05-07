package uk.ac.surrey.com3014.jg01314.recipeapi.recipe;

import java.util.List;

record RecipeSearchFilters(String name, List<String> ingredients, String difficulty, List<String> dietaryRestrictions) {

}