package uk.ac.surrey.com3014.jg01314.validation;

import java.util.List;

public record ValidationFailedResponse(List<ValidationError> errors) {

}
