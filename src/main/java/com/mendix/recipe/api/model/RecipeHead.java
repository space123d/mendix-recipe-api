package com.mendix.recipe.api.model;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeHead {

	private UUID id;
	private String title;
	private Integer yield;
	private List<Category> categories;
	private UUID recipeId;
}
