package com.mendix.recipe.dal.relational.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mendix.recipe.dal.relational.model.CategoryDao;

public interface RelationalCategoryRepository extends CrudRepository<CategoryDao, UUID> {

	List<CategoryDao> findAll();

	@Query(value = Queries.QUERY_GET_CATEGORY_BY_CATEGORY_ID, nativeQuery = true)
	Optional<CategoryDao> findByCategoryId(@Param("categoryId") byte[] categoryId);
}
