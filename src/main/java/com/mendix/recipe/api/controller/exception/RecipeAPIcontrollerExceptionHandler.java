package com.mendix.recipe.api.controller.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.mendix.recipe.api.controller.mapper.RecipeServiceMapper;
import com.mendix.recipe.api.model.exception.RecipeAPIException;
import com.mendix.recipe.api.model.exception.RecipeNotFoundException;
import com.mendix.recipe.api.model.generated.ErrorObject;


//Here we must deal with the exceptions coming from the recipe API Suite Exceptions...
@ControllerAdvice(basePackages = "com.mendix.recipe.api.controller")
public class RecipeAPIcontrollerExceptionHandler extends BaseAPIControllerExceptionHandler {

	private RecipeServiceMapper mapperService;

	@Autowired
	public RecipeAPIcontrollerExceptionHandler(RecipeServiceMapper mapperService) {
		this.mapperService = mapperService;
	}
	@ExceptionHandler(RecipeNotFoundException.class)
	public final ResponseEntity<Object> handleRecipeNotFoundException(RecipeNotFoundException ex) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String preamble = "Recipe Not Found Exception occured : ";

		logException(preamble, ex);

		return buildErrorResponse(status, ex);
	}

	// Error Response Builder
	private ResponseEntity<Object> buildErrorResponse(HttpStatus httpStatus,
			RecipeAPIException exception) {
		ErrorObject error = mapperService.baseExceptionToErrorResponseObject(exception);
		return new ResponseEntity<>(error, httpStatus);
	}
}