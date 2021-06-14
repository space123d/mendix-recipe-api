package com.mendix.recipe.dal.relational.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipe")
@Getter
@Setter
@NoArgsConstructor
public class RecipeItemDao {

	@Id
	private byte[] recipeId;
	private Instant creationTimestamp;
	private byte[] recipeHeadId;
	private byte[] ingredientId;
	private byte[] recipeDirectionsId;

}
