package com.mendix.recipe.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mendix.recipe.api.model.generated.ErrorMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ErrorObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-14T15:43:43.575715+02:00[Europe/Amsterdam]")
public class ErrorObject   {
  @JsonProperty("errorMessages")
  @Valid
  private List<ErrorMessage> errorMessages = new ArrayList<>();

  public ErrorObject errorMessages(List<ErrorMessage> errorMessages) {
    this.errorMessages = errorMessages;
    return this;
  }

  public ErrorObject addErrorMessagesItem(ErrorMessage errorMessagesItem) {
    this.errorMessages.add(errorMessagesItem);
    return this;
  }

  /**
   * Get errorMessages
   * @return errorMessages
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<ErrorMessage> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(List<ErrorMessage> errorMessages) {
    this.errorMessages = errorMessages;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorObject errorObject = (ErrorObject) o;
    return Objects.equals(this.errorMessages, errorObject.errorMessages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorMessages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorObject {\n");
    
    sb.append("    errorMessages: ").append(toIndentedString(errorMessages)).append("\n");
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

