package br.puc.sisdoe.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.puc.sisdoe.model.DoadorDTO;

@Controller
@RequestMapping("/doador")
public class DoadorController {
	
	private static final String SERVICE_URL = "https://agendamento-microservice.herokuapp.com/doador/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("static-access")
	@HystrixCommand(fallbackMethod = "listFallback")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DoadorDTO>> list() {
		ParameterizedTypeReference<List<DoadorDTO>> ptr =
				new ParameterizedTypeReference<List<DoadorDTO>>() {};
		ResponseEntity<List<DoadorDTO>> responseEntity =
				this.restTemplate.exchange(SERVICE_URL, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}

	@SuppressWarnings("static-access")
	@HystrixCommand(fallbackMethod = "getFallback")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DoadorDTO> findById(@PathVariable("id") Long id) {
		ParameterizedTypeReference<DoadorDTO> ptr =
				new ParameterizedTypeReference<DoadorDTO>() {};
		ResponseEntity<DoadorDTO> responseEntity =
				this.restTemplate.exchange(SERVICE_URL+id, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}
	
	public ResponseEntity<List<DoadorDTO>> listFallback() {
		return new ResponseEntity<List<DoadorDTO>>(Collections.emptyList(), HttpStatus.OK);
	}
	
	public ResponseEntity<DoadorDTO> getFallback() {
		return new ResponseEntity<DoadorDTO>(new DoadorDTO(), HttpStatus.OK);
	}
}
