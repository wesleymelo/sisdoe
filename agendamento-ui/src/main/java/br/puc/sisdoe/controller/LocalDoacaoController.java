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

import br.puc.sisdoe.model.LocalDoacaoDTO;
import br.puc.sisdoe.model.LocalizacaoDTO;

@RestController
@RequestMapping("/localDoacao")
public class LocalDoacaoController {
	private static final String SERVICE_URL = "https://agendamento-microservice.herokuapp.com/localDoacao/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "listFallback")
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocalDoacaoDTO>> list() {
		ParameterizedTypeReference<List<LocalDoacaoDTO>> ptr =
				new ParameterizedTypeReference<List<LocalDoacaoDTO>>() {};
		ResponseEntity<List<LocalDoacaoDTO>> responseEntity =
				this.restTemplate.exchange(SERVICE_URL, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}

	@HystrixCommand(fallbackMethod = "getFallback")
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocalDoacaoDTO> findById(@PathVariable("id") Long id) {
		ParameterizedTypeReference<LocalDoacaoDTO> ptr =
				new ParameterizedTypeReference<LocalDoacaoDTO>() {};
		ResponseEntity<LocalDoacaoDTO> responseEntity =
				this.restTemplate.exchange(SERVICE_URL+id, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}
	

	@HystrixCommand(fallbackMethod = "listFallback")
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/lat/{latitude}/lng/{longitude}/cep/{cep}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocalizacaoDTO>> buscaLocaisDoacaoProximos(@PathVariable("latitude") Double latitude, @PathVariable("longitude") Double longitude, @PathVariable("cep") String cep) {
		ParameterizedTypeReference<List<LocalizacaoDTO>> ptr =
				new ParameterizedTypeReference<List<LocalizacaoDTO>>() {};
		ResponseEntity<List<LocalizacaoDTO>> responseEntity =
				this.restTemplate.exchange(SERVICE_URL+"lat/"+latitude+"/lng/"+longitude+"/cep/"+cep, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}
	
	
	@HystrixCommand(fallbackMethod = "listFallback")
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/cep/{cep}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<br.puc.sisdoe.model.LocalizacaoDTO>> buscaLocaisDoacaoProximosPorCep(@PathVariable("cep") String cep) {
		ParameterizedTypeReference<List<LocalizacaoDTO>> ptr =
				new ParameterizedTypeReference<List<LocalizacaoDTO>>() {};
		ResponseEntity<List<LocalizacaoDTO>> responseEntity =
				this.restTemplate.exchange(SERVICE_URL+"cep/"+cep, HttpMethod.GET, null, ptr);
		responseEntity.status(HttpStatus.OK);
		return responseEntity;
	}
	
	public ResponseEntity<List<LocalDoacaoDTO>> listFallback() {
		return new ResponseEntity<List<LocalDoacaoDTO>>(Collections.emptyList(), HttpStatus.OK);
	}
	
	public ResponseEntity<LocalDoacaoDTO> getFallback() {
		return new ResponseEntity<LocalDoacaoDTO>(new LocalDoacaoDTO(), HttpStatus.OK);
	}
}
