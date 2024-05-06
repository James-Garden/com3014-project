package uk.ac.surrey.com3014.jg01314.recipeapi.validation;

import java.util.List;

public class ValidationException extends Exception {

  private final transient List<ValidationError> errors;

  public ValidationException(List<ValidationError> errors) {
    this.errors = errors;
  }

  public List<ValidationError> getErrors() {
    return errors;
  }
}
