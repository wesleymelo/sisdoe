package br.puc.sisdoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
public class ComunicaSusMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunicaSusMicroserviceApplication.class, args);
	}
}
