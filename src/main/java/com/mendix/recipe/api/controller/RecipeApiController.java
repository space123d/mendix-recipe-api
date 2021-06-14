package com.mendix.recipe.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mendix.recipe.api.controller.generated.RecipeApi;
import com.mendix.recipe.api.model.generated.RecipeResponseObject;

@Controller
@RequestMapping("${openapi.customers.base-path:/}")
public class RecipeApiController implements RecipeApi {

	@Override
	public ResponseEntity<List<RecipeResponseObject>> getAvailableRecipes() {
		// TODO Auto-generated method stub
		return RecipeApi.super.getAvailableRecipes();
	}

}
