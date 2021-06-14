package com.mendix.recipe.repository;

import java.util.List;

import com.mendix.recipe.api.model.Ingredient;

public interface IngredientsRepository {

	List<Ingredient> getAvailableIngredients();
}
