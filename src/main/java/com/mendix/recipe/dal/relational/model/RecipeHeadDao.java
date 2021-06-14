package com.mendix.recipe.dal.relational.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipe_head")
@Getter
@Setter
@NoArgsConstructor
public class RecipeHeadDao {

	@Id
	private byte[] id;
	private String title;
	private Integer yield;
	private byte[] categoryId;
}
