package com.mendix.recipe.dal.relational.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mendix.recipe.dal.relational.model.IngredientDao;
import com.mendix.recipe.dal.relational.model.RecipeDirectionsDao;

public interface RelationalRecipeDirectionsRepository extends CrudRepository<RecipeDirectionsDao, UUID> {

	List<RecipeDirectionsDao> findAll();

	@Query(value = Queries.QUERY_GET_DIRECTIONS_BY_RECIPE_ID, nativeQuery = true)
	Iterable<RecipeDirectionsDao> findByRecipeId(@Param("recipeId") List<byte[]> recipeId);
}
