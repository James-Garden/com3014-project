package uk.ac.surrey.com3014.jg01314.recipeapi.recipe;

import java.util.List;
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
}
