package com.mendix.recipe.dal.relational.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredient_items")
@Getter
@Setter
@NoArgsConstructor
public class IngredientItemsDao {

	@Id
	private byte[] itemId;
	private Integer quantity;
	private String unit;
	private byte[] recipeId;
	private byte[] ingredientId;
	private String items;
}
