package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mendix.recipe.api.model.generated.IngredientObject;
import com.mendix.recipe.api.model.generated.RecipeObjectDirections;
import com.mendix.recipe.api.model.generated.RecipeObjectHead;
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
 * RecipeObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-16T08:58:46.618447+02:00[Europe/Amsterdam]")
public class RecipeObject   {
  @JsonProperty("recipeId")
  private UUID recipeId;

  @JsonProperty("creationTimestamp")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private java.time.Instant creationTimestamp;

  @JsonProperty("head")
  private RecipeObjectHead head;

  @JsonProperty("ingredients")
  @Valid
  private List<IngredientObject> ingredients = null;

  @JsonProperty("directions")
  private RecipeObjectDirections directions;

  public RecipeObject recipeId(UUID recipeId) {
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

  public RecipeObject creationTimestamp(java.time.Instant creationTimestamp) {
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

  public RecipeObject head(RecipeObjectHead head) {
    this.head = head;
    return this;
  }

  /**
   * Get head
   * @return head
  */
  @ApiModelProperty(value = "")

  @Valid

  public RecipeObjectHead getHead() {
    return head;
  }

  public void setHead(RecipeObjectHead head) {
    this.head = head;
  }

  public RecipeObject ingredients(List<IngredientObject> ingredients) {
    this.ingredients = ingredients;
    return this;
  }

  public RecipeObject addIngredientsItem(IngredientObject ingredientsItem) {
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

  public List<IngredientObject> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<IngredientObject> ingredients) {
    this.ingredients = ingredients;
  }

  public RecipeObject directions(RecipeObjectDirections directions) {
    this.directions = directions;
    return this;
  }

  /**
   * Get directions
   * @return directions
  */
  @ApiModelProperty(value = "")

  @Valid

  public RecipeObjectDirections getDirections() {
    return directions;
  }

  public void setDirections(RecipeObjectDirections directions) {
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
    RecipeObject recipeObject = (RecipeObject) o;
    return Objects.equals(this.recipeId, recipeObject.recipeId) &&
        Objects.equals(this.creationTimestamp, recipeObject.creationTimestamp) &&
        Objects.equals(this.head, recipeObject.head) &&
        Objects.equals(this.ingredients, recipeObject.ingredients) &&
        Objects.equals(this.directions, recipeObject.directions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipeId, creationTimestamp, head, ingredients, directions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipeObject {\n");
    
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

