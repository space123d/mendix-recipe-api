package com.mendix.recipe.api.model;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Recipe {

	private UUID recipeId;
	private Instant creationTimestamp;
	private RecipeHead head;
	private Ingredient ingredients;
	private RecipeDirections directions;
}
