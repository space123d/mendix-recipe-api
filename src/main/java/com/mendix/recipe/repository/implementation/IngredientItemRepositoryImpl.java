package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.api.model.IngredientItems;
import com.mendix.recipe.dal.relational.model.IngredientItemsDao;
import com.mendix.recipe.dal.relational.repository.RelationalIngredientItemRepository;
import com.mendix.recipe.repository.IngredientItemRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class IngredientItemRepositoryImpl implements IngredientItemRepository {

	RelationalIngredientItemRepository repository;

	@Override
	public List<IngredientItems> getAvailableIngredientItems() {

		List<IngredientItemsDao> ingredientItemsDaoList = repository.findAll();
		return getIngredientItemsData(ingredientItemsDaoList);
	}

	private List<IngredientItems> getIngredientItemsData(List<IngredientItemsDao> ingredientItemsDaoList) {

		List<IngredientItems> output = new ArrayList<>();

		for (IngredientItemsDao dao : ingredientItemsDaoList) {
			IngredientItems ingredientItems = new IngredientItems();
			ingredientItems.setItemId(Utilities.byteArrayToUUID(dao.getItemId()));
		}

		return output;
	}

}
