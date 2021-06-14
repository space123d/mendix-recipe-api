package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.api.model.RecipeDirections;
import com.mendix.recipe.dal.relational.model.RecipeDirectionsDao;
import com.mendix.recipe.dal.relational.repository.RelationalRecipeDirectionsRepository;
import com.mendix.recipe.repository.RecipeDirectionsRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class RecipeDirectionsRepositoryImpl implements RecipeDirectionsRepository {

	RelationalRecipeDirectionsRepository repository;

	@Override
	public List<RecipeDirections> getAvailableRecipeDirections() {

		List<RecipeDirectionsDao> recipeDirectionsDaoList = repository.findAll();
		return getRecipeDirectionsData(recipeDirectionsDaoList);
	}

	private List<RecipeDirections> getRecipeDirectionsData(List<RecipeDirectionsDao> recipeDirectionsDaoList) {

		List<RecipeDirections> output = new ArrayList<>();

		for (RecipeDirectionsDao dao : recipeDirectionsDaoList) {
			RecipeDirections recipeDirections = new RecipeDirections();
			recipeDirections.setId(Utilities.byteArrayToUUID(dao.getId()));
		}

		return output;
	}

}
