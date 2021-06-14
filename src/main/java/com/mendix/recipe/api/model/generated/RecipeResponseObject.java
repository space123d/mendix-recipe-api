package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mendix.recipe.api.model.generated.IngredientResponseObject;
import com.mendix.recipe.api.model.generated.RecipeResponseObjectDirections;
import com.mendix.recipe.api.model.generated.RecipeResponseObjectHead;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RecipeResponseObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-14T12:54:21.686983+02:00[Europe/Amsterdam]")
public class RecipeResponseObject   {
  @JsonProperty("recipeId")
  private UUID recipeId;

  @JsonProperty("creationTimestamp")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private java.time.Instant creationTimestamp;

  @JsonProperty("head")
  private RecipeResponseObjectHead head;

  @JsonProperty("ingredients")
  @Valid
  private List<IngredientResponseObject> ingredients = null;

  @JsonProperty("directions")
  private RecipeResponseObjectDirections directions;

  public RecipeResponseObject recipeId(UUID recipeId) {
    this.recipeId = recipeId;
    return this;
  }

  /**
   * Get recipeId
   * @return recipeId
  */
  @ApiModelProperty(example = "123e4567-e89b-12d3-a456-426655440000", value = "")

  @Valid

  public UUID getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(UUID recipeId) {
    this.recipeId = recipeId;
  }

  public RecipeResponseObject creationTimestamp(java.time.Instant creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
    return this;
  }

  /**
   * Get creationTimestamp
   * @return creationTimestamp
  */
  @ApiModelProperty(value = "")

  @Valid

  public java.time.Instant getCreationTimestamp() {
    return creationTimestamp;
  }

  public void setCreationTimestamp(java.time.Instant creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }

  public RecipeResponseObject head(RecipeResponseObjectHead head) {
    this.head = head;
    return this;
  }

  /**
   * Get head
   * @return head
  */
  @ApiModelProperty(value = "")

  @Valid

  public RecipeResponseObjectHead getHead() {
    return head;
  }

  public void setHead(RecipeResponseObjectHead head) {
    this.head = head;
  }

  public RecipeResponseObject ingredients(List<IngredientResponseObject> ingredients) {
    this.ingredients = ingredients;
    return this;
  }

  public RecipeResponseObject addIngredientsItem(IngredientResponseObject ingredientsItem) {
    if (this.ingredients == null) {
      this.ingredients = new ArrayList<>();
    }
    this.ingredients.add(ingredientsItem);
    return this;
  }

  /**
   * Get ingredients
   * @return ingredients
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<IngredientResponseObject> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<IngredientResponseObject> ingredients) {
    this.ingredients = ingredients;
  }

  public RecipeResponseObject directions(RecipeResponseObjectDirections directions) {
    this.directions = directions;
    return this;
  }

  /**
   * Get directions
   * @return directions
  */
  @ApiModelProperty(value = "")

  @Valid

  public RecipeResponseObjectDirections getDirections() {
    return directions;
  }

  public void setDirections(RecipeResponseObjectDirections directions) {
    this.directions = directions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeResponseObject recipeResponseObject = (RecipeResponseObject) o;
    return Objects.equals(this.recipeId, recipeResponseObject.recipeId) &&
        Objects.equals(this.creationTimestamp, recipeResponseObject.creationTimestamp) &&
        Objects.equals(this.head, recipeResponseObject.head) &&
        Objects.equals(this.ingredients, recipeResponseObject.ingredients) &&
        Objects.equals(this.directions, recipeResponseObject.directions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipeId, creationTimestamp, head, ingredients, directions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipeResponseObject {\n");
    
    sb.append("    recipeId: ").append(toIndentedString(recipeId)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    head: ").append(toIndentedString(head)).append("\n");
    sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
    sb.append("    directions: ").append(toIndentedString(directions)).append("\n");
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

