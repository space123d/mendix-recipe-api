package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.api.model.Ingredient;
import com.mendix.recipe.dal.relational.model.IngredientDao;
import com.mendix.recipe.dal.relational.repository.RelationalIngredientRepository;
import com.mendix.recipe.repository.IngredientsRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class IngredientsRepositoryImpl implements IngredientsRepository {

	RelationalIngredientRepository repository;

	@Override
	public List<Ingredient> getAvailableIngredients() {

		List<IngredientDao> ingredientDaoList = repository.findAll();
		return getIngredientData(ingredientDaoList);
	}

	private List<Ingredient> getIngredientData(List<IngredientDao> ingredientDaoList) {

		List<Ingredient> output = new ArrayList<>();

		for (IngredientDao dao : ingredientDaoList) {
			Ingredient ingredient = new Ingredient();
			ingredient.setIngredientId(Utilities.byteArrayToUUID(dao.getIngredientId()));
		}

		return output;
	}

}
