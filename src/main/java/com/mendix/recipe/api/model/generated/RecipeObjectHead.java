package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mendix.recipe.api.model.generated.CategoryObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RecipeObjectHead
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-14T15:43:43.575715+02:00[Europe/Amsterdam]")
public class RecipeObjectHead   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("yield")
  private Integer yield;

  @JsonProperty("categories")
  @Valid
  private List<CategoryObject> categories = null;

  public RecipeObjectHead title(String title) {
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

  public RecipeObjectHead yield(Integer yield) {
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

  public RecipeObjectHead categories(List<CategoryObject> categories) {
    this.categories = categories;
    return this;
  }

  public RecipeObjectHead addCategoriesItem(CategoryObject categoriesItem) {
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

  public List<CategoryObject> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryObject> categories) {
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
    RecipeObjectHead recipeObjectHead = (RecipeObjectHead) o;
    return Objects.equals(this.title, recipeObjectHead.title) &&
        Objects.equals(this.yield, recipeObjectHead.yield) &&
        Objects.equals(this.categories, recipeObjectHead.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, yield, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipeObjectHead {\n");
    
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

