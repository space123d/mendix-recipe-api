package com.mendix.recipe.dal.relational.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mendix.recipe.dal.relational.model.IngredientDao;

public interface RelationalIngredientRepository extends CrudRepository<IngredientDao, UUID> {

	List<IngredientDao> findAll();

	@Query(value = Queries.QUERY_GET_INGREDIENT_BY_RECIPE_ID, nativeQuery = true)
	Iterable<IngredientDao> findByRecipeId(@Param("recipeId") List<byte[]> recipeId);
}
