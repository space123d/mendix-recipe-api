package com.mendix.recipe.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendix.recipe.api.model.*;
import com.mendix.recipe.repository.*;

@Service
public class RecipeService {

	private RecipeServiceRepository recipeServiceRepository;
	private RecipeServiceHeadRepository recipeServiceHeadRepository;
	private CategoryRepository categoryRepository;
	private RecipeDirectionsRepository recipeDirectionsRepository;
	private IngredientsRepository ingredientRepository;
	private IngredientItemRepository ingredientItemRepository;

	@Autowired
	public RecipeService(RecipeServiceRepository recipeServiceRepository,
			RecipeServiceHeadRepository recipeServiceHeadRepository, CategoryRepository categoryRepository,
			RecipeDirectionsRepository recipeDirectionsRepository, IngredientsRepository ingredientRepository,
			IngredientItemRepository ingredientItemRepository) {
		this.recipeServiceRepository = recipeServiceRepository;
		this.recipeServiceHeadRepository = recipeServiceHeadRepository;
		this.categoryRepository = categoryRepository;
		this.recipeDirectionsRepository = recipeDirectionsRepository;
		this.ingredientRepository = ingredientRepository;
		this.ingredientItemRepository = ingredientItemRepository;
	}

	public List<Recipe> getAvailableRecipes() {

		List<Recipe> recipeList = recipeServiceRepository.getAvailableRecipes();
		List<RecipeHead> recipeHeadList = recipeServiceHeadRepository.getAvailableRecipesHead();
		List<Category> categoryList = categoryRepository.getAvailableCategories();
		List<RecipeDirections> recipeDirectionsList = recipeDirectionsRepository.getAvailableRecipeDirections();
		List<Ingredient> ingredientList = ingredientRepository.getAvailableIngredients();
		List<IngredientItems> ingredientItems = ingredientItemRepository.getAvailableIngredientItems();

		return recipeList;

	}
}
