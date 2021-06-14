package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mendix.recipe.api.model.generated.IngredientItemsResponseObjectAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IngredientItemsResponseObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-14T12:54:21.686983+02:00[Europe/Amsterdam]")
public class IngredientItemsResponseObject   {
  @JsonProperty("amount")
  private IngredientItemsResponseObjectAmount amount;

  @JsonProperty("item")
  private String item;

  public IngredientItemsResponseObject amount(IngredientItemsResponseObjectAmount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @ApiModelProperty(value = "")

  @Valid

  public IngredientItemsResponseObjectAmount getAmount() {
    return amount;
  }

  public void setAmount(IngredientItemsResponseObjectAmount amount) {
    this.amount = amount;
  }

  public IngredientItemsResponseObject item(String item) {
    this.item = item;
    return this;
  }

  /**
   * Get item
   * @return item
  */
  @ApiModelProperty(example = "Onion; large, chopped", value = "")


  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IngredientItemsResponseObject ingredientItemsResponseObject = (IngredientItemsResponseObject) o;
    return Objects.equals(this.amount, ingredientItemsResponseObject.amount) &&
        Objects.equals(this.item, ingredientItemsResponseObject.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IngredientItemsResponseObject {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
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

