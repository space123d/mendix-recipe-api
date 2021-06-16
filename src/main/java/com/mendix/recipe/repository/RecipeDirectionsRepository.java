package com.mendix.recipe.repository;

import java.util.List;
import com.mendix.recipe.api.model.RecipeDirections;

public interface RecipeDirectionsRepository {

	List<RecipeDirections> getAvailableRecipeDirections();

	void createRecipeDirections(RecipeDirections directions);
}
