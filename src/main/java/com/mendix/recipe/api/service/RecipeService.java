package com.mendix.recipe.api.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mendix.recipe.api.model.*;
import com.mendix.recipe.repository.*;

@Service
public class RecipeService {

	private RecipeServiceRepository recipeServiceRepository;
	private RecipeServiceHeadRepository recipeServiceHeadRepository;
	private CategoryRepository categoryRepository;
	private RecipeDirectionsRepository recipeDirectionsRepository;
	private IngredientsRepository ingredientRepository;
	private IngredientItemRepository ingredientItemRepository;

	@Autowired
	public RecipeService(RecipeServiceRepository recipeServiceRepository,
			RecipeServiceHeadRepository recipeServiceHeadRepository, CategoryRepository categoryRepository,
			RecipeDirectionsRepository recipeDirectionsRepository, IngredientsRepository ingredientRepository,
			IngredientItemRepository ingredientItemRepository) {
		this.recipeServiceRepository = recipeServiceRepository;
		this.recipeServiceHeadRepository = recipeServiceHeadRepository;
		this.categoryRepository = categoryRepository;
		this.recipeDirectionsRepository = recipeDirectionsRepository;
		this.ingredientRepository = ingredientRepository;
		this.ingredientItemRepository = ingredientItemRepository;
	}

	public List<Recipe> getAvailableRecipes() {

		// fetch records from in-memory
		List<Recipe> recipeList = recipeServiceRepository.getAvailableRecipes();
		List<RecipeHead> recipeHeadList = recipeServiceHeadRepository.getAvailableRecipesHead();
		List<Category> categoryList = categoryRepository.getAvailableCategories();
		List<RecipeDirections> recipeDirectionsList = recipeDirectionsRepository.getAvailableRecipeDirections();
		List<Ingredient> ingredientList = ingredientRepository.getAvailableIngredients();
		List<IngredientItems> ingredientItems = ingredientItemRepository.getAvailableIngredientItems();

		// map each with recipe id
		Map<UUID, RecipeHead> recipeHeadMap = new HashMap<>();
		recipeHeadList.stream().forEach(r -> recipeHeadMap.put(r.getRecipeId(), r));
		Map<UUID, List<Category>> categoryMap = groupCategory(categoryList);

		Map<UUID, RecipeDirections> recipeDirectionsMap = new HashMap<>();
		recipeDirectionsList.stream().forEach(rd -> recipeDirectionsMap.put(rd.getRecipeId(), rd));

		Map<UUID, List<Ingredient>> ingredientMap = groupIngredient(ingredientList);

		Map<UUID, List<IngredientItems>> ingredientItemsMap = groupIngredientItems(ingredientItems);

		// stream recipelist

		recipeList.stream().forEach(r -> {
			// setting head
			RecipeHead rh = recipeHeadMap.get(r.getRecipeId());
			rh.setCategories(categoryMap.get(rh.getRecipeId()));
			r.setHead(rh);

			// setting ingredients
			List<Ingredient> ing = ingredientMap.get(r.getRecipeId());
			ing.forEach(i -> i.setItems(ingredientItemsMap.get(i.getRecipeId())));
			r.setIngredients(ing);

			// setting directions
			r.setDirections(recipeDirectionsMap.get(r.getRecipeId()));

		});

		return recipeList;

	}

	public Map<UUID, List<IngredientItems>> groupIngredientItems(List<IngredientItems> ingredientItems) {

		Map<UUID, List<IngredientItems>> ingredientItemMap = new HashMap<>();

		ingredientItems.forEach(i -> {
			if (ingredientItemMap.containsKey(i.getRecipeId())) {
				ingredientItemMap.get(i.getRecipeId()).add(i);
			} else {
				List<IngredientItems> ingredientItemListOf = new ArrayList<>();
				ingredientItemListOf.add(i);
				ingredientItemMap.put(i.getRecipeId(), ingredientItemListOf);
			}
		});

		return ingredientItemMap;

	}

	public Map<UUID, List<Ingredient>> groupIngredient(List<Ingredient> ingredientList) {

		Map<UUID, List<Ingredient>> ingredientMap = new HashMap<>();

		ingredientList.forEach(i -> {
			if (ingredientMap.containsKey(i.getRecipeId())) {
				ingredientMap.get(i.getRecipeId()).add(i);
			} else {
				List<Ingredient> ingredientListOf = new ArrayList<>();
				ingredientListOf.add(i);
				ingredientMap.put(i.getRecipeId(), ingredientListOf);
			}
		});

		return ingredientMap;

	}

	public Map<UUID, List<Category>> groupCategory(List<Category> categoryList) {
		Map<UUID, List<Category>> categoryMap = new HashMap<>();
		
		categoryList.forEach(c ->{
			if (categoryMap.containsKey(c.getRecipeId())) {
				categoryMap.get(c.getRecipeId()).add(c);
			} else {
				List<Category> categoryListOf = new ArrayList<>();
				categoryListOf.add(c);
				categoryMap.put(c.getRecipeId(), categoryListOf);
			}
		});
		
		
		return categoryMap;
	}
}
