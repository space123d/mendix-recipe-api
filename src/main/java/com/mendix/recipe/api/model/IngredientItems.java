package com.mendix.recipe.api.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientItems {

	private UUID itemId;
	private Integer quantity;
	private String unit;
	private UUID recipeId;
	private UUID ingredientId;
	private String item;
}
