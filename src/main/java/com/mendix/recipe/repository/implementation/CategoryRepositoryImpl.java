package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.api.model.Category;
import com.mendix.recipe.dal.relational.model.CategoryDao;
import com.mendix.recipe.dal.relational.repository.RelationalCategoryRepository;
import com.mendix.recipe.repository.CategoryRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	RelationalCategoryRepository repository;

	@Override
	public List<Category> getAvailableCategories() {

		List<CategoryDao> categoryDaoList = repository.findAll();
		return getCategoryData(categoryDaoList);
	}

	private List<Category> getCategoryData(List<CategoryDao> categoryDaoList) {

		List<Category> output = new ArrayList<>();

		for (CategoryDao dao : categoryDaoList) {
			Category category = new Category();
			category.setCategoryId(Utilities.byteArrayToUUID(dao.getCategoryId()));
		}

		return output;
	}

}
