package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.mendix.recipe.api.model.Recipe;
import com.mendix.recipe.dal.relational.model.RecipeItemDao;
import com.mendix.recipe.dal.relational.repository.RelationalRecipeRepository;
import com.mendix.recipe.repository.RecipeServiceRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class RecipeServiceRepositoryImpl implements RecipeServiceRepository {

	RelationalRecipeRepository repository;

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
		}

		return output;
	}

}
