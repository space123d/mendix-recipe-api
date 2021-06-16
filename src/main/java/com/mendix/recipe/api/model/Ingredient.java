package com.mendix.recipe.api.model;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Ingredient {

	private UUID ingredientId;
	private String title;
	private List<IngredientItems> items;
	private UUID recipeId;
}
