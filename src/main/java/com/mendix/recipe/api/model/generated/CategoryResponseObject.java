package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mendix.recipe.api.model.generated.CategoryObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CategoryResponseObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-14T14:42:05.910455+02:00[Europe/Amsterdam]")
public class CategoryResponseObject   {
  @JsonProperty("Items")
  private CategoryObject items;

  public CategoryResponseObject items(CategoryObject items) {
    this.items = items;
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @ApiModelProperty(value = "")

  @Valid

  public CategoryObject getItems() {
    return items;
  }

  public void setItems(CategoryObject items) {
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
    CategoryResponseObject categoryResponseObject = (CategoryResponseObject) o;
    return Objects.equals(this.items, categoryResponseObject.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryResponseObject {\n");
    
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

