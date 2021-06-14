package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mendix.recipe.api.model.generated.CategoryResponseObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RecipeResponseObjectHead
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-14T12:54:21.686983+02:00[Europe/Amsterdam]")
public class RecipeResponseObjectHead   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("yield")
  private Integer yield;

  @JsonProperty("categories")
  @Valid
  private List<CategoryResponseObject> categories = null;

  public RecipeResponseObjectHead title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @ApiModelProperty(example = "title", value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public RecipeResponseObjectHead yield(Integer yield) {
    this.yield = yield;
    return this;
  }

  /**
   * Get yield
   * @return yield
  */
  @ApiModelProperty(example = "6", value = "")


  public Integer getYield() {
    return yield;
  }

  public void setYield(Integer yield) {
    this.yield = yield;
  }

  public RecipeResponseObjectHead categories(List<CategoryResponseObject> categories) {
    this.categories = categories;
    return this;
  }

  public RecipeResponseObjectHead addCategoriesItem(CategoryResponseObject categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * Get categories
   * @return categories
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<CategoryResponseObject> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryResponseObject> categories) {
    this.categories = categories;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeResponseObjectHead recipeResponseObjectHead = (RecipeResponseObjectHead) o;
    return Objects.equals(this.title, recipeResponseObjectHead.title) &&
        Objects.equals(this.yield, recipeResponseObjectHead.yield) &&
        Objects.equals(this.categories, recipeResponseObjectHead.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, yield, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipeResponseObjectHead {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    yield: ").append(toIndentedString(yield)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

