package com.mendix.recipe.test.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import com.mendix.recipe.api.service.RecipeService;
import com.mendix.recipe.repository.CategoryRepository;

@SpringBootConfiguration
@Profile("ControllerIT")
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@ComponentScan(basePackages = { "com.mendix.recipe.api" })
public class ControllerITConfiguration {

	@MockBean
	private RecipeService recipeService;
	@MockBean
	private CategoryRepository categoryRepository;
}