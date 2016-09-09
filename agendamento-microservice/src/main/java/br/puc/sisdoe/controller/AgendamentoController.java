package br.puc.sisdoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.puc.sisdoe.model.Agendamento;
import br.puc.sisdoe.service.AgendamentoService;

@CrossOrigin(maxAge = 3600) 
@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@PreAuthorize("hasAuthority('AGENDAMENTO_READ')")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Agendamento>> list() {
		List<Agendamento> agendamentos = agendamentoService.findAll();
		return new ResponseEntity<List<Agendamento>>(agendamentos, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('AGENDAMENTO_READ')")
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Agendamento> findById(@PathVariable("id") Long id) {
		
		Agendamento agendamento = agendamentoService.findById(id);
		
		if(agendamento == null){
			return new ResponseEntity<Agendamento>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Agendamento>(agendamento, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('AGENDAMENTO_READ')")
	@RequestMapping(value = "/doador/{doador}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Agendamento> findByIdDoador(@PathVariable("doador") Long idDoador) {
		
		Agendamento agendamento = agendamentoService.buscaAgendamentoPorDoador(idDoador);
		
		if(agendamento == null){
			return new ResponseEntity<Agendamento>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Agendamento>(agendamento, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('AGENDAMENTO_WRITE')")
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Agendamento> add(@RequestBody Agendamento agendamento) {
		Agendamento agendamentoSalvo = agendamentoService.save(agendamento);
		return new ResponseEntity<Agendamento>(agendamentoSalvo, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('AGENDAMENTO_WRITE')")
	@RequestMapping(method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Agendamento> update(@RequestBody Agendamento agendamento) {
		Agendamento agendamentoEncontrado = agendamentoService.findById(agendamento.getId());
		
		if(agendamentoEncontrado == null){
			return new ResponseEntity<Agendamento>(HttpStatus.NOT_FOUND);
		}

		Agendamento agendamentoSalvo = agendamentoService.save(agendamento);
		return new ResponseEntity<Agendamento>(agendamentoSalvo, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('AGENDAMENTO_WRITE')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Agendamento> delete(@PathVariable("id") Long id) {
		Agendamento agendamentoEncontrado = agendamentoService.findById(id);
		
		if(agendamentoEncontrado == null){
			return new ResponseEntity<Agendamento>(HttpStatus.NOT_FOUND);
		}
		
		agendamentoService.delete(agendamentoEncontrado);
		return new ResponseEntity<Agendamento>(new Agendamento(), HttpStatus.OK);
	}

}
