package uk.ac.surrey.com3014.jg01314.recipeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorisedException extends RuntimeException {

}
