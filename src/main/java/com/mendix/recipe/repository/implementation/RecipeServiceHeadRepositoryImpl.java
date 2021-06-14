package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.mendix.recipe.api.model.RecipeHead;
import com.mendix.recipe.dal.relational.model.RecipeHeadDao;
import com.mendix.recipe.dal.relational.repository.RelationalRecipeHeadRepository;
import com.mendix.recipe.repository.RecipeServiceHeadRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class RecipeServiceHeadRepositoryImpl implements RecipeServiceHeadRepository {

	RelationalRecipeHeadRepository repository;

	@Override
	public List<RecipeHead> getAvailableRecipesHead() {

		List<RecipeHeadDao> recipeDaoList = repository.findAll();
		return getRecipeData(recipeDaoList);
	}

	private List<RecipeHead> getRecipeData(List<RecipeHeadDao> recipeDaoList) {

		List<RecipeHead> output = new ArrayList<>();

		for (RecipeHeadDao dao : recipeDaoList) {
			RecipeHead recipe = new RecipeHead();
			recipe.setId(Utilities.byteArrayToUUID(dao.getCategoryId()));
		}

		return output;
	}

}
