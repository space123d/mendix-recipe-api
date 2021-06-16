package com.mendix.recipe.repository;

import java.util.List;

import com.mendix.recipe.api.model.Category;

public interface CategoryRepository {

	List<Category> getAvailableCategories();

	void createCategory(List<Category> categories);
}
