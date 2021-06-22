package com.mendix.recipe.dal.relational.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mendix.recipe.dal.relational.model.RecipeItemDao;

public interface RelationalRecipeRepository extends CrudRepository<RecipeItemDao, UUID> {

	List<RecipeItemDao> findAll();

	@Query(value = Queries.QUERY_GET_RECIPE_BY_RECIPE_ID, nativeQuery = true)
	Iterable<RecipeItemDao> findByRecipeId(@Param("recipeId") List<byte[]> recipeId);
}
