package com.mendix.recipe.api.config;

import java.util.Optional;
import javax.servlet.ServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-07-01T08:12:19.819170100+02:00[Europe/Berlin]")

@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class RecipeAPIOpenAPIConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/swagger-ui/");
	}

	private static ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Recipe API")
				.description("Recipe API used to retrieve and publish available recipes")
				.license("Licence usage - Apache 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("URL").version("1.0.0").contact(new Contact("", "", "space12.3d@gmail.com")).build();
	}


	@Bean
	public Docket AMcustomImplementation(ServletContext servletContext) {
		return new Docket(DocumentationType.OAS_30).groupName("Recipe").select()
				.apis(RequestHandlerSelectors.basePackage("com.mendix.recipe")).paths(PathSelectors.any()).build()
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
				.genericModelSubstitutes(Optional.class).apiInfo(apiInfo());
	}

}
