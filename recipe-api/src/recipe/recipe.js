function recipe(id, name, ingredients, difficulty, dietaryRestrictions = "") {
  this.id = id;
  this.name = name;
  this.ingredients = ingredients;
  this.difficulty = difficulty;
  this.dietaryRestrictions = dietaryRestrictions;
}

export default recipe;
