package com.mendix.recipe.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mendix.recipe.api.controller.generated.RecipeApi;
import com.mendix.recipe.api.controller.mapper.RecipeServiceMapper;
import com.mendix.recipe.api.model.Recipe;
import com.mendix.recipe.api.model.generated.CategoryObject;
import com.mendix.recipe.api.model.generated.CreateRecipeResponseObject;
import com.mendix.recipe.api.model.generated.RecipeObject;
import com.mendix.recipe.api.service.RecipeService;

@Controller
@RequestMapping("${openapi.recipe.base-path:/}")
public class RecipeApiController implements RecipeApi {
	
	private RecipeService recipeService;
	private RecipeServiceMapper mapper;

	@Autowired
	public RecipeApiController(RecipeService recipeService, RecipeServiceMapper mapper) {
		this.recipeService = recipeService;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<RecipeObject>> getAvailableRecipes() {
		
		List<Recipe> recipelist = recipeService.getAvailableRecipes();
		List<RecipeObject> recipeObjectList = mapper.toModelObject(recipelist);
		
		return new ResponseEntity<>(recipeObjectList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CreateRecipeResponseObject> createRecipe(@Valid RecipeObject recipeObject) {

		Recipe recipe = mapper.toModelObject(recipeObject);
		Recipe createdRecipe = recipeService.create(recipe);
		CreateRecipeResponseObject response = mapper.responseObject(createdRecipe);

		return new ResponseEntity<>(response, HttpStatus.OK);
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
