package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mendix.recipe.api.model.generated.IngredientItemsObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IngredientObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-22T13:42:58.760990+02:00[Europe/Amsterdam]")
public class IngredientObject   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("Items")
  @Valid
  private List<IngredientItemsObject> items = null;

  public IngredientObject title(String title) {
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

  public IngredientObject items(List<IngredientItemsObject> items) {
    this.items = items;
    return this;
  }

  public IngredientObject addItemsItem(IngredientItemsObject itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<IngredientItemsObject> getItems() {
    return items;
  }

  public void setItems(List<IngredientItemsObject> items) {
    this.items = items;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IngredientObject ingredientObject = (IngredientObject) o;
    return Objects.equals(this.title, ingredientObject.title) &&
        Objects.equals(this.items, ingredientObject.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IngredientObject {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

