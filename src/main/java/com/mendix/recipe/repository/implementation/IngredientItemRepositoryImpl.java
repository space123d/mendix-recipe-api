package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mendix.recipe.api.model.Ingredient;
import com.mendix.recipe.api.model.IngredientItems;
import com.mendix.recipe.dal.relational.model.IngredientDao;
import com.mendix.recipe.dal.relational.model.IngredientItemsDao;
import com.mendix.recipe.dal.relational.repository.RelationalIngredientItemRepository;
import com.mendix.recipe.repository.IngredientItemRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class IngredientItemRepositoryImpl implements IngredientItemRepository {

	RelationalIngredientItemRepository repository;

	@Autowired
	public IngredientItemRepositoryImpl(RelationalIngredientItemRepository repository) {
		this.repository = repository;
	}

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
			ingredientItems.setRecipeId(Utilities.byteArrayToUUID(dao.getRecipeId()));
			ingredientItems.setItem(dao.getItems());
			ingredientItems.setQuantity(dao.getQuantity());
			ingredientItems.setUnit(dao.getUnit());
			ingredientItems.setIngredientId(Utilities.byteArrayToUUID(dao.getIngredientId()));
			output.add(ingredientItems);
		}

		return output;
	}

	@Override
	public void createIngredientItems(List<Ingredient> ingredients) {
		List<IngredientItemsDao> ingrDao = new ArrayList<>();

		ingredients.stream().forEach(ing -> {

			List<IngredientItems> items = ing.getItems();
			items.stream().forEach(item -> {
				IngredientItemsDao ingdao = new IngredientItemsDao();
				ingdao.setQuantity(item.getQuantity());
				ingdao.setUnit(item.getUnit());
				ingdao.setItems(item.getItem());
				ingdao.setRecipeId(Utilities.UUIDToByteArray(item.getRecipeId()));
				ingdao.setItemId(Utilities.UUIDToByteArray(item.getItemId()));
				ingdao.setIngredientId(Utilities.UUIDToByteArray(item.getIngredientId()));
				ingrDao.add(ingdao);
			});

		});
		repository.saveAll(ingrDao);

	}

}
