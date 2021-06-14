package com.mendix.recipe.dal.relational.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipe_directions")
@Getter
@Setter
@NoArgsConstructor
public class RecipeDirectionsDao {

	@Id
	private byte[] id;
	private String step;
}
