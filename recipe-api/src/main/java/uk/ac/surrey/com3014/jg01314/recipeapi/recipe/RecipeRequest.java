package uk.ac.surrey.com3014.jg01314.recipeapi.recipe;

public record RecipeRequest(String sessionId, Integer userId, int recipeId) {
  
}
