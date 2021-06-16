package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mendix.recipe.api.model.Recipe;
import com.mendix.recipe.dal.relational.model.RecipeItemDao;
import com.mendix.recipe.dal.relational.repository.RelationalRecipeRepository;
import com.mendix.recipe.repository.RecipeServiceRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class RecipeServiceRepositoryImpl implements RecipeServiceRepository {

	RelationalRecipeRepository repository;

	@Autowired
	public RecipeServiceRepositoryImpl(RelationalRecipeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Recipe> getAvailableRecipes() {

		List<RecipeItemDao> recipeDaoList = repository.findAll();
		return getRecipeData(recipeDaoList);
	}

	private List<Recipe> getRecipeData(List<RecipeItemDao> recipeDaoList) {

		List<Recipe> output = new ArrayList<>();

		for (RecipeItemDao dao : recipeDaoList) {
			Recipe recipe = new Recipe();
			recipe.setRecipeId(Utilities.byteArrayToUUID(dao.getRecipeId()));
			output.add(recipe);
		}

		return output;
	}

	@Override
	public void createRecipe(Recipe recipe) {
		RecipeItemDao recipeDao = new RecipeItemDao();
		recipeDao.setCreationTimestamp(recipe.getCreationTimestamp());
		recipeDao.setRecipeId(Utilities.UUIDToByteArray(recipe.getRecipeId()));
		repository.save(recipeDao);

	}

}
