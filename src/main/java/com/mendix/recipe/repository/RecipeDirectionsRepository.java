package com.mendix.recipe.repository;

import java.util.List;
import java.util.UUID;

import com.mendix.recipe.api.model.RecipeDirections;

public interface RecipeDirectionsRepository {

	List<RecipeDirections> getAvailableRecipeDirections();

	void createRecipeDirections(RecipeDirections directions);

	List<RecipeDirections> getRecipeDirections(Iterable<UUID> iterable);
}
