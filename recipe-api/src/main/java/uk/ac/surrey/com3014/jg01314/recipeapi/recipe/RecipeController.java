package uk.ac.surrey.com3014.jg01314.recipeapi.recipe;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RecipeController {

  private final RecipeService recipeService;

  @Autowired
  RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping("/recipes")
  List<Recipe> getRecipes() {
    return recipeService.getAllRecipes();
  }

}
