package com.mendix.recipe.repository;

import java.util.List;
import java.util.UUID;

import com.mendix.recipe.api.model.Ingredient;
import com.mendix.recipe.api.model.IngredientItems;

public interface IngredientItemRepository {

	List<IngredientItems> getAvailableIngredientItems();

	void createIngredientItems(List<Ingredient> ingredients);

	List<IngredientItems> getRecipeIngredientItem(Iterable<UUID> iterable);
}
