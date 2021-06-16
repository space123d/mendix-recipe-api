package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mendix.recipe.api.model.Category;
import com.mendix.recipe.dal.relational.model.CategoryDao;
import com.mendix.recipe.dal.relational.repository.RelationalCategoryRepository;
import com.mendix.recipe.repository.CategoryRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	RelationalCategoryRepository repository;

	@Autowired
	public CategoryRepositoryImpl(RelationalCategoryRepository repository) {

		this.repository = repository;
	}

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
			category.setRecipeId(Utilities.byteArrayToUUID(dao.getRecipeId()));
			category.setCategoryName(dao.getCategoryName());
			output.add(category);
		}

		return output;
	}

	@Override
	public void createCategory(List<Category> categories) {
		List<CategoryDao> catDaoList = new ArrayList<>();
		categories.stream().forEach(c -> {
			CategoryDao catDao = new CategoryDao();
			catDao.setCategoryName(c.getCategoryName());
			catDao.setCategoryId(Utilities.UUIDToByteArray(c.getCategoryId()));
			catDao.setRecipeId(Utilities.UUIDToByteArray(c.getRecipeId()));

			catDaoList.add(catDao);

		});

		repository.saveAll(catDaoList);
	}

}
