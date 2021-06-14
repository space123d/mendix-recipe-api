package com.mendix.recipe.repository;

import java.util.List;

import com.mendix.recipe.api.model.IngredientItems;

public interface IngredientItemRepository {

	List<IngredientItems> getAvailableIngredientItems();
}
