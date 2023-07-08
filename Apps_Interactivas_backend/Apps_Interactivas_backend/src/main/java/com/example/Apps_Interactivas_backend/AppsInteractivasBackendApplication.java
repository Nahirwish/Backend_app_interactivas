package com.example.Apps_Interactivas_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AppsInteractivasBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsInteractivasBackendApplication.class, args);
	}

}

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setPort(8080);
	}
}

