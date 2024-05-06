package uk.ac.surrey.com3014.jg01314.recipeapi.recipe;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

interface RecipeRepository extends CrudRepository<Recipe, Integer> {

  @Override
  List<Recipe> findAll();
}
