package com.mendix.recipe.test;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.mendix.recipe.test.config.ControllerITConfiguration;

@RunWith(SpringRunner.class)
@ActiveProfiles("ControllerIT")
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = { ControllerITConfiguration.class }, properties = {
		"security.basic.enabled = false", "management.security.enabled = false", "spring.datasource.platform = h2",
		"spring.datasource.url = jdbc:h2:mem:test", "spring.datasource.driverClassName = org.h2.Driver",
		"spring.datasource.username = sa", "spring.datasource.password = ",
		"spring.jpa.database-platform = org.hibernate.dialect.H2Dialect", "spring.h2.console.enabled = true",
		"logging.level.org.springframework.jdbc.datasource.init.ScriptUtils =DEBUG"

})
public abstract class ControllerIT {

	protected static String baseUrl;
	protected static String version;

	public ControllerIT(String version) {
		this.version = version;
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	protected int port;

	@Before
	public void setUp() {
		baseUrl = "http://localhost:" + port;
	}

	protected String getURL(String endpoint) {
		return baseUrl + version + "/" + endpoint;
	}

	protected String getActuatorURL(String endpoint) {
		return baseUrl + "/" + endpoint;
	}

	public TestRestTemplate getRestTemplate() {
		return restTemplate.withBasicAuth("spring", "secret");
	}

	public void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
