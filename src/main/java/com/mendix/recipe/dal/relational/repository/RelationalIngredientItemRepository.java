package com.mendix.recipe.dal.relational.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.mendix.recipe.dal.relational.model.IngredientItemsDao;

public interface RelationalIngredientItemRepository extends CrudRepository<IngredientItemsDao, UUID> {

	List<IngredientItemsDao> findAll();
}
