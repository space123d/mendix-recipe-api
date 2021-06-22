package com.mendix.recipe.repository;

import java.util.List;
import java.util.UUID;

import com.mendix.recipe.api.model.Ingredient;

public interface IngredientsRepository {

	List<Ingredient> getAvailableIngredients();

	void createIngredient(List<Ingredient> ingredients);

	List<Ingredient> getRecipeIngredient(Iterable<UUID> iterable);
}
