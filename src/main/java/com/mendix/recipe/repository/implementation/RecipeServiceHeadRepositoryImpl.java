package com.mendix.recipe.repository.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mendix.recipe.api.model.RecipeHead;
import com.mendix.recipe.dal.relational.model.RecipeHeadDao;
import com.mendix.recipe.dal.relational.repository.RelationalRecipeHeadRepository;
import com.mendix.recipe.repository.RecipeServiceHeadRepository;
import com.mendix.recipe.utilities.Utilities;

@Repository
public class RecipeServiceHeadRepositoryImpl implements RecipeServiceHeadRepository {

	RelationalRecipeHeadRepository repository;

	@Autowired
	public RecipeServiceHeadRepositoryImpl(RelationalRecipeHeadRepository repository) {
		this.repository = repository;
	}

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
			recipe.setRecipeId(Utilities.byteArrayToUUID(dao.getRecipeId()));
			recipe.setTitle(dao.getTitle());
			recipe.setYield(dao.getYield());
			output.add(recipe);
		}

		return output;
	}

	@Override
	public void createRecipeHead(RecipeHead head) {
		RecipeHeadDao dao = new RecipeHeadDao();
		dao.setRecipeId(Utilities.UUIDToByteArray(head.getRecipeId()));
		dao.setId(Utilities.UUIDToByteArray(head.getId()));
		dao.setTitle(head.getTitle());
		dao.setYield(head.getYield());

		repository.save(dao);

	}

	@Override
	public List<RecipeHead> getRecipeHead(Iterable<UUID> iterable) {
		List<RecipeHead> outputList = new ArrayList<>();

		List<byte[]> inputList = new ArrayList<>();

		iterable.forEach(a -> {

			byte[] b = Utilities.UUIDToByteArray(a);
			inputList.add(b);
		});
		Iterable<RecipeHeadDao> recipeHeadDao = repository.findByRecipeId(inputList);

		recipeHeadDao.forEach(rd -> {
			RecipeHead recipe = new RecipeHead();
			recipe.setRecipeId(Utilities.byteArrayToUUID(rd.getRecipeId()));
			recipe.setId(Utilities.byteArrayToUUID(rd.getCategoryId()));
			recipe.setRecipeId(Utilities.byteArrayToUUID(rd.getRecipeId()));
			recipe.setTitle(rd.getTitle());
			recipe.setYield(rd.getYield());
			outputList.add(recipe);
		});

		return outputList;
	}

}
