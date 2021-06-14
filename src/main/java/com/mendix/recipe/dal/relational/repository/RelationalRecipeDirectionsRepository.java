package com.mendix.recipe.dal.relational.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.mendix.recipe.dal.relational.model.RecipeDirectionsDao;

public interface RelationalRecipeDirectionsRepository extends CrudRepository<RecipeDirectionsDao, UUID> {

	List<RecipeDirectionsDao> findAll();
}
