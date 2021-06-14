package com.mendix.recipe.api.model;

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
	private IngredientItems items;
}
