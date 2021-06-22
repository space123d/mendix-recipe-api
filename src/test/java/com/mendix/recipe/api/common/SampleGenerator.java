package com.mendix.recipe.api.common;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mendix.recipe.api.model.Category;
import com.mendix.recipe.api.model.Ingredient;
import com.mendix.recipe.api.model.IngredientItems;
import com.mendix.recipe.api.model.Recipe;
import com.mendix.recipe.api.model.RecipeDirections;
import com.mendix.recipe.api.model.RecipeHead;

public class SampleGenerator {

	public static Recipe createSampleRecipe() {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(UUID.randomUUID());
		UUID ingredientID = UUID.randomUUID();
		// set directions
		RecipeDirections directions = new RecipeDirections();
		directions.setStep("step");
		directions.setRecipeId(recipe.getRecipeId());
		// set category
		Category category = new Category();
		category.setCategoryId(UUID.randomUUID());
		category.setCategoryName("Main dish");
		category.setRecipeId(recipe.getRecipeId());

		List<Category> categories = new ArrayList<>();
		categories.add(category);

		// set recipe head
		RecipeHead head = new RecipeHead();
		head.setRecipeId(recipe.getRecipeId());
		head.setCategories(categories);
		head.setId(UUID.randomUUID());
		head.setTitle("title");
		head.setYield(6);

		// set ingredient items
		IngredientItems item = new IngredientItems();
		item.setIngredientId(ingredientID);
		item.setItemId(UUID.randomUUID());
		item.setItem("item");
		item.setQuantity(10);
		item.setRecipeId(recipe.getRecipeId());
		item.setUnit("10");

		List<IngredientItems> items = new ArrayList<>();
		items.add(item);
		// set ingredients
		Ingredient ingredient = new Ingredient();
		ingredient.setIngredientId(ingredientID);
		ingredient.setRecipeId(recipe.getRecipeId());
		ingredient.setItems(items);
		ingredient.setTitle("ing title");

		List<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(ingredient);
		// set recipe
		recipe.setCreationTimestamp(Instant.now());
		recipe.setDirections(directions);
		recipe.setHead(head);
		recipe.setIngredients(ingredients);

		return recipe;
	}

}
