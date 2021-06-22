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
import com.mendix.recipe.api.model.Category;
import com.mendix.recipe.api.model.Recipe;
import com.mendix.recipe.api.model.generated.CategoryObject;
import com.mendix.recipe.api.model.generated.CreateRecipeResponseObject;
import com.mendix.recipe.api.model.generated.RecipeObject;
import com.mendix.recipe.api.service.CategoryService;
import com.mendix.recipe.api.service.RecipeService;

@Controller
@RequestMapping("${openapi.recipe.base-path:/}")
public class RecipeApiController implements RecipeApi {
	
	private RecipeService recipeService;
	private CategoryService categoryService;
	private RecipeServiceMapper mapper;


	@Autowired
	public RecipeApiController(RecipeService recipeService, RecipeServiceMapper mapper,
			CategoryService categoryService) {
		this.recipeService = recipeService;
		this.mapper = mapper;
		this.categoryService = categoryService;
	}

	@Override
	public ResponseEntity<List<RecipeObject>> getAvailableRecipes() {
		
		List<Recipe> recipelist = recipeService.getAvailableRecipes();
		List<RecipeObject> response = mapper.toModelObject(recipelist);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
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
		List<Category> categoryList = categoryService.getAvailableCategories();
		List<CategoryObject> response = mapper.toModelObjectCategory(categoryList);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<RecipeObject>> getRecipe(UUID categoryId) {

		List<Recipe> recipeByCategory = recipeService.getRecipeByCategory(categoryId);
		List<RecipeObject> response = mapper.toModelObject(recipeByCategory);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RecipeObject> getRecipeByName(@NotNull @Valid String recipeName,
			@Valid Optional<String> categoryName) {
		// TODO Auto-generated method stub
		return RecipeApi.super.getRecipeByName(recipeName, categoryName);
	}

}
