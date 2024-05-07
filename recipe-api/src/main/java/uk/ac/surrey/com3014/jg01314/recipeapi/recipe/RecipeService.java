package uk.ac.surrey.com3014.jg01314.recipeapi.recipe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RecipeService {

  private final RecipeRepository recipeRepository;

  @Autowired
  RecipeService(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  List<Recipe> getAllRecipes() {
    return recipeRepository.findAll();
  }

  Optional<Recipe> getRecipeById(int id) {
    return recipeRepository.findById(id);
  }

  List<Recipe> searchRecipes(String name, List<String> ingredients, String difficulty, List<String> dietaryRestrictions) {
    List<Recipe> recipes = recipeRepository.findAll();
    List<Recipe> filtered = recipes.stream().filter(r -> (name == null || r.getName().toLowerCase().contains(name.toLowerCase())) && 
                                 (ingredients == null || Arrays.asList(r.getIngredients().split(", ")).containsAll(ingredients)) && 
                                 (difficulty == null || r.getDifficulty().contains(difficulty)) && 
                                 (dietaryRestrictions == null || Arrays.asList(r.getDietaryRestrictions().split(", ")).containsAll(dietaryRestrictions))).collect(Collectors.toList());
    return filtered;
  }
}
