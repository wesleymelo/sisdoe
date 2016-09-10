package br.puc.sisdoe.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.puc.sisdoe.model.AgendamentoDTO;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

	private static final String SERVICE_URL = "https://agendamento-microservice.herokuapp.com/agendamento/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "listFallback")
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AgendamentoDTO>> list() {
		ParameterizedTypeReference<List<AgendamentoDTO>> ptr =
				new ParameterizedTypeReference<List<AgendamentoDTO>>() {};
		ResponseEntity<List<AgendamentoDTO>> responseEntity =
				this.restTemplate.exchange(SERVICE_URL, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}

	@HystrixCommand(fallbackMethod = "getFallback")
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendamentoDTO> findById(@PathVariable("id") Long id) {
		
		ParameterizedTypeReference<AgendamentoDTO> ptr =
				new ParameterizedTypeReference<AgendamentoDTO>() {};
		ResponseEntity<AgendamentoDTO> responseEntity =
				this.restTemplate.exchange(SERVICE_URL+id, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;	
	}
	
	@HystrixCommand(fallbackMethod = "getFallback")
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/doador/{doador}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendamentoDTO> findByIdDoador(@PathVariable("doador") Long idDoador) {
		
		ParameterizedTypeReference<AgendamentoDTO> ptr =
				new ParameterizedTypeReference<AgendamentoDTO>() {};
		ResponseEntity<AgendamentoDTO> responseEntity =
				this.restTemplate.exchange(SERVICE_URL+"doador/"+idDoador, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}

	@HystrixCommand(fallbackMethod = "getFallback")
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AgendamentoDTO> delete(@PathVariable("id") Long id) {
		ParameterizedTypeReference<AgendamentoDTO> ptr =
				new ParameterizedTypeReference<AgendamentoDTO>() {};
		ResponseEntity<AgendamentoDTO> responseEntity =
				this.restTemplate.exchange(SERVICE_URL+id, HttpMethod.DELETE, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}
	
	public ResponseEntity<List<AgendamentoDTO>> listFallback() {
		return new ResponseEntity<List<AgendamentoDTO>>(Collections.emptyList(), HttpStatus.OK);
	}
	
	public ResponseEntity<AgendamentoDTO> getFallback() {
		return new ResponseEntity<AgendamentoDTO>(new AgendamentoDTO(), HttpStatus.OK);
	}

}
