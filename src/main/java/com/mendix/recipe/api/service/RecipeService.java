package com.mendix.recipe.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mendix.recipe.api.model.Recipe;
import com.mendix.recipe.api.model.RecipeHead;
import com.mendix.recipe.api.model.generated.RecipeObject;
import com.mendix.recipe.repository.RecipeServiceHeadRepository;
import com.mendix.recipe.repository.RecipeServiceRepository;

@Service
public class RecipeService {

	private RecipeServiceRepository recipeServiceRepository;
	private RecipeServiceHeadRepository recipeServiceHeadRepository;

	public List<Recipe> getAvailableRecipes() {

		List<Recipe> recipeList = recipeServiceRepository.getAvailableRecipes();
		List<RecipeHead> recipeHeadList = recipeServiceHeadRepository.getAvailableRecipesHead();

		return recipeList;

	}
}
