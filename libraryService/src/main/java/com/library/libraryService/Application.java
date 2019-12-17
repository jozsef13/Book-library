package com.library.libraryService;

import java.util.Collections;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({ "com.library.libraryService.controllers", "com.library.libraryService.services" })
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.library.libraryService.controllers")).build()
				.apiInfo(apiDetails()).genericModelSubstitutes(Optional.class);
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Library API", "Sample API for practice", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Simon Gabriel", "https://www.google.com/",
						"gabriel.simon980@gmail.com"),
				"API License", "https://www.google.com/", Collections.emptyList());
	}
}
