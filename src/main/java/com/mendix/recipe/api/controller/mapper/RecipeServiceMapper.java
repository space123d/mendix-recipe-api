package com.mendix.recipe.api.controller.mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mendix.recipe.api.model.Category;
import com.mendix.recipe.api.model.Ingredient;
import com.mendix.recipe.api.model.IngredientItems;
import com.mendix.recipe.api.model.Recipe;
import com.mendix.recipe.api.model.RecipeDirections;
import com.mendix.recipe.api.model.RecipeHead;
import com.mendix.recipe.api.model.generated.CategoryObject;
import com.mendix.recipe.api.model.generated.CreateRecipeResponseObject;
import com.mendix.recipe.api.model.generated.IngredientItemsObject;
import com.mendix.recipe.api.model.generated.IngredientItemsObjectAmount;
import com.mendix.recipe.api.model.generated.IngredientObject;
import com.mendix.recipe.api.model.generated.RecipeObject;
import com.mendix.recipe.api.model.generated.RecipeObjectDirections;
import com.mendix.recipe.api.model.generated.RecipeObjectHead;

@Service
public class RecipeServiceMapper {

	public List<RecipeObject> toModelObject(List<Recipe> input) {
		return input.stream().map(this::toDetailedResponseObject).collect(Collectors.toList());
	}

	public RecipeObject toDetailedResponseObject(Recipe input) {

		RecipeObject output = new RecipeObject();

		output.setDirections(getDirections(input.getDirections()));
		output.setHead(getHead(input.getHead()));
		output.setCreationTimestamp(input.getCreationTimestamp());
		output.setIngredients(getIngredients(input.getIngredients()));
		output.setRecipeId(input.getRecipeId());

		return output;
	}

	public List<IngredientObject> getIngredients(List<Ingredient> ingredients) {
		List<IngredientObject> ingList = new ArrayList<>();
		ingredients.stream().forEach(i -> {
			IngredientObject ingObj = new IngredientObject();
			ingObj.setItems(getItems(i.getItems()));
			ingObj.setTitle(i.getTitle());
			ingList.add(ingObj);
		});

		return ingList;
	}

	public List<IngredientItemsObject> getItems(List<IngredientItems> list) {

		List<IngredientItemsObject> ingList = new ArrayList<>();
		list.stream().forEach(ingItemL -> {
			IngredientItemsObject ingItemObj = new IngredientItemsObject();
			ingItemObj.setAmount(getAmount(ingItemL, ingItemObj));
			ingList.add(ingItemObj);
		});

		return ingList;
	}

	public IngredientItemsObjectAmount getAmount(IngredientItems ingItemL, IngredientItemsObject ingItemObj) {
		IngredientItemsObjectAmount ingObjAmt = new IngredientItemsObjectAmount();

		ingObjAmt.setQuantity(ingItemL.getQuantity());
		ingObjAmt.setUnit(ingItemL.getUnit());
		ingItemObj.setItem(ingItemL.getItem());

		return ingObjAmt;
	}

	public RecipeObjectHead getHead(RecipeHead head) {
		RecipeObjectHead roh = new RecipeObjectHead();

		roh.setTitle(head.getTitle());
		roh.setYield(head.getYield());
		roh.setCategories(getCategories(head.getCategories()));

		return roh;
	}

	public List<CategoryObject> getCategories(List<Category> categories) {
		List<CategoryObject> catlist = new ArrayList<>();
		categories.stream().forEach(c -> {
			CategoryObject catObj = new CategoryObject();
			catObj.setCategoryId(c.getCategoryId());
			catObj.setCategoryName(c.getCategoryName());
			catlist.add(catObj);
		});

		return catlist;
	}

	public RecipeObjectDirections getDirections(RecipeDirections recipeDirections) {
		RecipeObjectDirections rohd = new RecipeObjectDirections();
		rohd.setStep(recipeDirections.getStep());
		return rohd;
	}

	public Recipe toModelObject(@Valid RecipeObject recipeObject) {
		Recipe output = new Recipe();

		output.setRecipeId(UUID.randomUUID());
		output.setCreationTimestamp(Instant.now());
		output.setDirections(getDirections(recipeObject.getDirections(), output));
		output.setHead(getHead(recipeObject.getHead(), output));
		output.setIngredients(getIngredients(recipeObject.getIngredients(), output));

		return output;
	}

	public List<Ingredient> getIngredients(@Valid List<IngredientObject> ingredients, Recipe output) {

		List<Ingredient> ingList = new ArrayList<>();
		ingredients.stream().forEach(ing -> {
			Ingredient ingr = new Ingredient();
			ingr.setIngredientId(UUID.randomUUID());
			ingr.setRecipeId(output.getRecipeId());
			ingr.setTitle(ing.getTitle());
			ingr.setItems(getItems(ing.getItems(), output, ingr));
			ingList.add(ingr);

		});
		return ingList;
	}

	public List<IngredientItems> getItems(@Valid List<IngredientItemsObject> itemsList, Recipe output,
			Ingredient ingr) {
		List<IngredientItems> ingItemsList = new ArrayList<>();

		itemsList.stream().forEach(itemL -> {
			IngredientItems ingItems = new IngredientItems();
			IngredientItemsObjectAmount ingAmt = itemL.getAmount();
			ingItems.setItem(itemL.getItem());
			ingItems.setItemId(UUID.randomUUID());
			ingItems.setRecipeId(output.getRecipeId());
			ingItems.setQuantity(ingAmt.getQuantity());
			ingItems.setUnit(ingAmt.getUnit());
			ingItems.setIngredientId(ingr.getIngredientId());

			ingItemsList.add(ingItems);

		});

		return ingItemsList;
	}

	public RecipeHead getHead(@Valid RecipeObjectHead head, Recipe output) {
		RecipeHead rh = new RecipeHead();
		rh.setId(UUID.randomUUID());
		rh.setRecipeId(output.getRecipeId());
		rh.setTitle(head.getTitle());
		rh.setYield(head.getYield());
		rh.setCategories(getCategories(head.getCategories(), output, rh));

		return rh;
	}

	public List<Category> getCategories(@Valid List<CategoryObject> categories, Recipe output, RecipeHead rh) {
		List<Category> catList = new ArrayList<>();
		categories.stream().forEach(c -> {
			Category cat = new Category();
			cat.setCategoryId(rh.getId());
			cat.setCategoryName(c.getCategoryName());
			cat.setRecipeId(output.getRecipeId());
			catList.add(cat);

		});

		return catList;
	}

	public RecipeDirections getDirections(@Valid RecipeObjectDirections directions, Recipe output) {
		RecipeDirections rd = new RecipeDirections();
		rd.setId(UUID.randomUUID());
		rd.setRecipeId(output.getRecipeId());
		rd.setStep(directions.getStep());

		return rd;
	}

	public CreateRecipeResponseObject responseObject(Recipe recipe) {
		CreateRecipeResponseObject response = new CreateRecipeResponseObject();

		response.setId(recipe.getRecipeId());

		return response;
	}
}
