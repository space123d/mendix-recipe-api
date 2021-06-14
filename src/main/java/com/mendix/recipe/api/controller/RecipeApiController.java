package com.mendix.recipe.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mendix.recipe.api.controller.generated.RecipeApi;
import com.mendix.recipe.api.model.generated.CategoryObject;
import com.mendix.recipe.api.model.generated.CategoryResponseObject;
import com.mendix.recipe.api.model.generated.CreateRecipeResponseObject;
import com.mendix.recipe.api.model.generated.RecipeObject;

@Controller
@RequestMapping("${openapi.customers.base-path:/}")
public class RecipeApiController implements RecipeApi {

	@Override
	public ResponseEntity<List<RecipeObject>> getAvailableRecipes() {
		// TODO Auto-generated method stub
		return RecipeApi.super.getAvailableRecipes();
	}

	@Override
	public ResponseEntity<CreateRecipeResponseObject> createRecipe(@Valid RecipeObject recipeObject) {
		// TODO Auto-generated method stub
		return RecipeApi.super.createRecipe(recipeObject);
	}

	@Override
	public ResponseEntity<List<CategoryObject>> getAvailableCategories() {
		// TODO Auto-generated method stub
		return RecipeApi.super.getAvailableCategories();
	}

	@Override
	public ResponseEntity<RecipeObject> getRecipe(UUID categoryId) {
		// TODO Auto-generated method stub
		return RecipeApi.super.getRecipe(categoryId);
	}

	@Override
	public ResponseEntity<RecipeObject> getRecipeByName(@NotNull @Valid String recipeName,
			@Valid Optional<String> categoryName) {
		// TODO Auto-generated method stub
		return RecipeApi.super.getRecipeByName(recipeName, categoryName);
	}

}
