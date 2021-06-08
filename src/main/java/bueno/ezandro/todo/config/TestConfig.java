package bueno.ezandro.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import bueno.ezandro.todo.service.DBService;

@Configuration
@Profile(value = "test")
public class TestConfig {

	private DBService dbService;

	@Autowired
	public TestConfig(DBService dbService) {
		this.dbService = dbService;
	}

	@Bean
	public void init() {
		this.dbService.insertDataForTesting();
	}
}
