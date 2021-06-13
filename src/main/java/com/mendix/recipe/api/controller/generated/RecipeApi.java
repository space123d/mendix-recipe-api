/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mendix.recipe.api.controller.generated;

import com.mendix.recipe.api.model.generated.RecipeResponseObject;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-13T15:37:40.195987+02:00[Europe/Amsterdam]")
@Validated
@Api(value = "Recipe", description = "the Recipe API")
public interface RecipeApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /v1/recipes : Gets all available recipes
     * Gets all available recipes 
     *
     * @return Returns available recipe (status code 200)
     */
    @ApiOperation(value = "Gets all available recipes", nickname = "getAvailableRecipes", notes = "Gets all available recipes ", response = RecipeResponseObject.class, responseContainer = "List", tags={ "Recipe", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returns available recipe", response = RecipeResponseObject.class, responseContainer = "List") })
    @GetMapping(
        value = "/v1/recipes",
        produces = { "application/json" }
    )
    default ResponseEntity<List<RecipeResponseObject>> getAvailableRecipes() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"head\" : { \"directions\" : { \"step\" : \"steps...\" }, \"yield\" : 6, \"ingredients\" : [ { \"amount\" : { \"unit\" : \"pound\", \"quantity\" : 6 }, \"item\" : \"Onion; large, chopped\" }, { \"amount\" : { \"unit\" : \"pound\", \"quantity\" : 6 }, \"item\" : \"Onion; large, chopped\" } ], \"categories\" : [ { \"category\" : \"Main dish\" }, { \"category\" : \"Main dish\" } ], \"title\" : \"title\" }, \"creationTimestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"recipeId\" : \"123e4567-e89b-12d3-a456-426655440000\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
