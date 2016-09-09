package br.puc.sisdoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaServer
@EnableAutoConfiguration
public class MicroserviceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRegistryApplication.class, args);
	}
}
