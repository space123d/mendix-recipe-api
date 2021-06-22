package com.mendix.recipe.api.model.exception;

public class RecipeAPIException extends RuntimeException {

	private static final long serialVersionUID = -4979272005411242500L;

	public RecipeAPIException() {
        super();
    }

    public RecipeAPIException(String message) {
        super(message);
    }

    public RecipeAPIException(String message, Throwable cause) {
        super(message, cause);
    }
}