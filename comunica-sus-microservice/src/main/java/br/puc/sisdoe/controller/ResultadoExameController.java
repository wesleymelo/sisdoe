package br.puc.sisdoe.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.puc.sisdoe.model.ResultadoExame;
import br.puc.sisdoe.service.ResultadoExameService;

@CrossOrigin(maxAge = 3600) 
@RestController
@RequestMapping(value = "/resultadoExame")
public class ResultadoExameController {

	@Autowired
	private ResultadoExameService resultadoExameService;
	
	@PreAuthorize("hasAuthority('RESULTADO_EXAME_WRITE')")
	@RequestMapping(value = "/enviaResultadosExamesSUS", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResultadoExame>> enviaResultadosExamesSUS() {
		List<ResultadoExame> resultadosExames = null;
		try {
			resultadosExames = resultadoExameService.enviaResultadoExamesAoSUS();
		} catch (KeyManagementException | NoSuchAlgorithmException | URISyntaxException | IOException e) {
			e.printStackTrace();
			return new ResponseEntity<List<ResultadoExame>>(resultadosExames, HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<List<ResultadoExame>>(resultadosExames, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('RESULTADO_EXAME_WRITE')")
	@RequestMapping(value = "/enviaResultadosExamesSUS", method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResultadoExame>> enviaResultadosExamesSUS(@RequestBody List<ResultadoExame> resultadosExames) {
		List<ResultadoExame> resultadosExamesEnviados;
		try {
			resultadosExamesEnviados = resultadoExameService.enviaResultadoExamesAoSUS(resultadosExames);
		} catch (KeyManagementException | NoSuchAlgorithmException | URISyntaxException | IOException e) {
			e.printStackTrace();
			return new ResponseEntity<List<ResultadoExame>>(resultadosExames, HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<List<ResultadoExame>>(resultadosExamesEnviados, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('RESULTADO_EXAME_READ')")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResultadoExame>> list() {
		List<ResultadoExame> resultadosExames = resultadoExameService.findAll();
		return new ResponseEntity<List<ResultadoExame>>(resultadosExames, HttpStatus.OK);
	}
	
}
