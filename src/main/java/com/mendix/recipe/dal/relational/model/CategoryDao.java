package com.mendix.recipe.dal.relational.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class CategoryDao {

	@Id
	private byte[] categoryId;
	private String categoryName;
	private byte[] recipeId;
}
