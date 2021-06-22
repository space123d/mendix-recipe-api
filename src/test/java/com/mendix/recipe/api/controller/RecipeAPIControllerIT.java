package com.mendix.recipe.api.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.mendix.recipe.api.common.SampleGenerator;
import com.mendix.recipe.api.model.Recipe;
import com.mendix.recipe.api.model.generated.RecipeObject;
import com.mendix.recipe.api.service.RecipeService;
import com.mendix.recipe.test.ControllerIT;

public class RecipeAPIControllerIT extends ControllerIT {
	private static final String VERSION = "/v1";

	private static final String GET_RECIPES = "recipes";
	private static final String POST_RECIPES = "recipes";
	private static final String GET_CATEGORIES = "recipes/categories";
	private static final String GET_RECIPES_BY_CATEGORY = "recipes/categories/%s";

	public RecipeAPIControllerIT() {
		super(VERSION);

	}

	@Autowired
	private RecipeService recipeService;

//	@Test
//	public void testGetRecipes() {
//		// Given
//		Recipe input = SampleGenerator.createSampleRecipe();
//		List<Recipe> output = new ArrayList<>();
//		output.add(input);
//
//		when(recipeService.getAvailableRecipes()).thenReturn(output);
//		// When
//		ResponseEntity<List<RecipeObject>> response = getRestTemplate().exchange(getURL(GET_RECIPES), HttpMethod.GET,
//				null, new ParameterizedTypeReference<List<RecipeObject>>() {
//				});
//
//		// Then
//		assertNotNull(response);
//		assertSame(HttpStatus.OK, response.getStatusCode());
//	}

}
