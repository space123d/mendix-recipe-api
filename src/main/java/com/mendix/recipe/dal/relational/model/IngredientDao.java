package com.mendix.recipe.dal.relational.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredient")
@Getter
@Setter
@NoArgsConstructor
public class IngredientDao {

	@Id
	private byte[] ingredientId;
	private String title;
	private byte[] ingredientItemId;
	private byte[] recipeId;
}
