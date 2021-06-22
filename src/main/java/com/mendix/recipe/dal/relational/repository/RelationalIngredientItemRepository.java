package com.mendix.recipe.dal.relational.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mendix.recipe.dal.relational.model.IngredientItemsDao;

public interface RelationalIngredientItemRepository extends CrudRepository<IngredientItemsDao, UUID> {

	List<IngredientItemsDao> findAll();

	@Query(value = Queries.QUERY_GET_INGREDIENTITEMS_BY_RECIPE_ID, nativeQuery = true)
	Iterable<IngredientItemsDao> findByRecipeId(@Param("recipeId") List<byte[]> recipeId);
}
