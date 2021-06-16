package com.mendix.recipe.repository;

import java.util.List;

import com.mendix.recipe.api.model.Recipe;

public interface RecipeServiceRepository {

	List<Recipe> getAvailableRecipes();

	void createRecipe(Recipe recipe);
}
