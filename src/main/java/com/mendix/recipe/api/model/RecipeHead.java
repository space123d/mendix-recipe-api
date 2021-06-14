package com.mendix.recipe.api.model;

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
	private Category categories;
}
