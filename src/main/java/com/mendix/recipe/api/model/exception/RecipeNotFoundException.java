package com.mendix.recipe.api.model.exception;

public class RecipeNotFoundException extends RecipeAPIException{
	
	private static final long serialVersionUID = -8901866103924109537L;

	public RecipeNotFoundException(String message) {
	        super(message);
	    }

}
