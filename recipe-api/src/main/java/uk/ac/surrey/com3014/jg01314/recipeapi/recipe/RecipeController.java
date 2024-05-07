package uk.ac.surrey.com3014.jg01314.recipeapi.recipe;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
class RecipeController {

  private final RecipeService recipeService;

  @Autowired
  RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping("/")
  List<Recipe> getRecipes() {
    return recipeService.getAllRecipes();
  }

  @GetMapping("/{id}")
  ResponseEntity<Recipe> getRecipe(@PathVariable @Pattern(regexp = "^[0-9]+$") String id) {
    Optional<Recipe> recipe = recipeService.getRecipeById(Integer.parseInt(id));
    
    if (recipe.isPresent()) {
      return ResponseEntity.ok(recipe.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/search")
  ResponseEntity<List<Recipe>> searchRecipes(@ModelAttribute RecipeSearchFilters filters) {
    List<Recipe> recipes = recipeService.searchRecipes(filters.name(), filters.ingredients(), filters.difficulty(), filters.dietaryRestrictions());
    return ResponseEntity.ok(recipes);
  }

}
