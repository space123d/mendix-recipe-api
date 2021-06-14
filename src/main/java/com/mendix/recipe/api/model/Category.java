package com.mendix.recipe.api.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category {

	private UUID categoryId;
	private String categoryName;
	private UUID recipeId;
}
