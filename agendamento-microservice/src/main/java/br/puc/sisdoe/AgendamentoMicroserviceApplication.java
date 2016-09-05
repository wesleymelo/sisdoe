package br.puc.sisdoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
//@EnableCircuitBreaker
public class AgendamentoMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgendamentoMicroserviceApplication.class, args);
	}
}	
