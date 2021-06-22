package com.mendix.recipe.dal.relational.repository;

public class Queries {

	private Queries() {
		throw new IllegalStateException("Utility class");
	}

	public static final String QUERY_GET_CATEGORY_BY_CATEGORY_ID = " SELECT * FROM " + " category  "
			+ " WHERE CATEGORY_ID = :categoryId ";

	public static final String QUERY_GET_RECIPE_BY_RECIPE_ID = " SELECT * FROM " + " recipe  "
			+ " WHERE RECIPE_ID = :recipeId ";

	public static final String QUERY_GET_RECIPEHEAD_BY_RECIPE_ID = " SELECT * FROM " + " recipe_head  "
			+ " WHERE RECIPE_ID = :recipeId ";

	public static final String QUERY_GET_DIRECTIONS_BY_RECIPE_ID = " SELECT * FROM " + " recipe_directions  "
			+ " WHERE RECIPE_ID = :recipeId ";

	public static final String QUERY_GET_INGREDIENT_BY_RECIPE_ID = " SELECT * FROM " + " ingredient  "
			+ " WHERE RECIPE_ID = :recipeId ";

	public static final String QUERY_GET_INGREDIENTITEMS_BY_RECIPE_ID = " SELECT * FROM " + " ingredient_items  "
			+ " WHERE RECIPE_ID = :recipeId ";
}
