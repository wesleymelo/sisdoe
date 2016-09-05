package br.puc.sisdoe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.puc.sisdoe.model.Doador;
import br.puc.sisdoe.service.DoadorService;

@Controller
@CrossOrigin(maxAge = 3600) 
@RequestMapping("/doador")
public class DoadorController {
	
	@Autowired
	private DoadorService doadorService;
	
	@PreAuthorize("hasAuthority('DOADOR_READ')")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Doador>> list() {
		List<Doador> doadores = doadorService.findAll();
		return new ResponseEntity<List<Doador>>(doadores, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('DOADOR_READ')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doador> findById(@PathVariable("id") Long id) {
		
		Doador doador = doadorService.findById(id);
		
		if(doador == null){
			return new ResponseEntity<Doador>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Doador>(doador, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('DOADOR_WRITE')")
	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doador> add(@RequestBody Doador doador) {
		Doador doadorSalvo = doadorService.save(doador);
		return new ResponseEntity<Doador>(doadorSalvo, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('DOADOR_WRITE')")
	@RequestMapping(method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doador> update(@RequestBody Doador doador) {
		Doador doadorEncontrado = doadorService.findById(doador.getId());
		
		if(doadorEncontrado == null){
			return new ResponseEntity<Doador>(HttpStatus.NOT_FOUND);
		}

		Doador doadorSalvo = doadorService.save(doador);
		return new ResponseEntity<Doador>(doadorSalvo, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('DOADOR_WRITE')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Doador> delete(@PathVariable("id") Long id) {
		
		Doador doadorEncontrado = doadorService.findById(id);
		
		if(doadorEncontrado == null){
			return new ResponseEntity<Doador>(HttpStatus.NOT_FOUND);
		}
		
		doadorService.delete(doadorEncontrado);
		return new ResponseEntity<Doador>(doadorEncontrado, HttpStatus.OK);
	}

}
