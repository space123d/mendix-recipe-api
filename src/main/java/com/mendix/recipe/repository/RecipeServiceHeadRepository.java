package com.mendix.recipe.repository;

import java.util.List;

import com.mendix.recipe.api.model.RecipeHead;

public interface RecipeServiceHeadRepository {

	List<RecipeHead> getAvailableRecipesHead();

	void createRecipeHead(RecipeHead head);
}
