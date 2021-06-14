package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RecipeResponseObjectDirections
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-14T12:54:21.686983+02:00[Europe/Amsterdam]")
public class RecipeResponseObjectDirections   {
  @JsonProperty("step")
  private String step;

  public RecipeResponseObjectDirections step(String step) {
    this.step = step;
    return this;
  }

  /**
   * Get step
   * @return step
  */
  @ApiModelProperty(example = "steps...", value = "")


  public String getStep() {
    return step;
  }

  public void setStep(String step) {
    this.step = step;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeResponseObjectDirections recipeResponseObjectDirections = (RecipeResponseObjectDirections) o;
    return Objects.equals(this.step, recipeResponseObjectDirections.step);
  }

  @Override
  public int hashCode() {
    return Objects.hash(step);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipeResponseObjectDirections {\n");
    
    sb.append("    step: ").append(toIndentedString(step)).append("\n");
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

