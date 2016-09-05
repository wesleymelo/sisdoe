package br.puc.sisdoe.controller;

import java.util.ArrayList;
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

import com.google.maps.model.LatLng;

import br.puc.sisdoe.dto.LocalizacaoDTO;
import br.puc.sisdoe.model.LocalDoacao;
import br.puc.sisdoe.service.LocalDoacaoService;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/localDoacao")
public class LocalDoacaoController {
	
	@Autowired
	private LocalDoacaoService localDoacaoService;
	
	@PreAuthorize("hasAuthority('LOCAL_DOACAO_READ')")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocalDoacao>> list() {
		List<LocalDoacao> localDoacaoes = localDoacaoService.findAll();
		return new ResponseEntity<List<LocalDoacao>>(localDoacaoes, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('LOCAL_DOACAO_READ')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocalDoacao> findById(@PathVariable("id") Long id) {
		
		LocalDoacao localDoacao = localDoacaoService.findById(id);
		
		if(localDoacao == null){
			return new ResponseEntity<LocalDoacao>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<LocalDoacao>(localDoacao, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('LOCAL_DOACAO_WRITE')")
	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocalDoacao> add(@RequestBody LocalDoacao localDoacao) {
		LocalDoacao localDoacaoSalvo = localDoacaoService.save(localDoacao);
		return new ResponseEntity<LocalDoacao>(localDoacaoSalvo, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('LOCAL_DOACAO_WRITE')")
	@RequestMapping(method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocalDoacao> update(@RequestBody LocalDoacao localDoacao) {
		LocalDoacao localDoacaoEncontrado = localDoacaoService.findById(localDoacao.getId());
		
		if(localDoacaoEncontrado == null){
			return new ResponseEntity<LocalDoacao>(HttpStatus.NOT_FOUND);
		}

		LocalDoacao localDoacaoSalvo = localDoacaoService.save(localDoacao);
		return new ResponseEntity<LocalDoacao>(localDoacaoSalvo, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('LOCAL_DOACAO_WRITE')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<LocalDoacao> delete(@PathVariable("id") Long id) {
		
		LocalDoacao localDoacaoEncontrado = localDoacaoService.findById(id);
		
		if(localDoacaoEncontrado == null){
			return new ResponseEntity<LocalDoacao>(HttpStatus.NOT_FOUND);
		}
		
		localDoacaoService.delete(localDoacaoEncontrado);
		return new ResponseEntity<LocalDoacao>(localDoacaoEncontrado, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('LOCAL_DOACAO_READ')")
	@RequestMapping(value = "/lat/{latitude}/lng/{longitude}/cep/{cep}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocalizacaoDTO>> buscaLocaisDoacaoProximos(@PathVariable("latitude") Double latitude, @PathVariable("longitude") Double longitude, @PathVariable("cep") String cep) {
		List<LocalizacaoDTO> locaisDoacao = new ArrayList<LocalizacaoDTO>();
		
		if(cep != null && !cep.isEmpty() && !cep.equals("00000000")){
			
			if(cep.length() != 8){
				return new ResponseEntity<List<LocalizacaoDTO>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
			}
			
			LatLng latLng = localDoacaoService.buscaGeocodePorCep(cep);
			if(latLng == null){
				latLng = localDoacaoService.buscaGeocodePorEnderecoAPartirDoCep(cep);
				if(latLng == null){
					return new ResponseEntity<List<LocalizacaoDTO>>(new ArrayList<>(), HttpStatus.NOT_FOUND);					
				}
			}
			
			latitude = latLng.lat;
			longitude = latLng.lng;
		}		
		
		locaisDoacao = localDoacaoService.buscaLocaisDoacaoProximosPorLatLng(latitude, longitude);
		
		if(locaisDoacao == null || locaisDoacao.isEmpty()){
			return new ResponseEntity<List<LocalizacaoDTO>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<LocalizacaoDTO>>(locaisDoacao, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('LOCAL_DOACAO_READ')")
	@RequestMapping(value = "/cep/{cep}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocalizacaoDTO>> buscaLocaisDoacaoProximosPorCep(@PathVariable("cep") String cep) {
		List<LocalizacaoDTO> locaisDoacao = new ArrayList<LocalizacaoDTO>();
		
		Double latitude = null;
		Double longitude = null;
		
		if(cep != null && !cep.isEmpty() && !cep.equals("00000000")){
			
			if(cep.length() != 8){
				return new ResponseEntity<List<LocalizacaoDTO>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
			}
			
			LatLng latLng = localDoacaoService.buscaGeocodePorCep(cep);
			if(latLng == null){
				latLng = localDoacaoService.buscaGeocodePorEnderecoAPartirDoCep(cep);
				if(latLng == null){
					return new ResponseEntity<List<LocalizacaoDTO>>(new ArrayList<>(), HttpStatus.NOT_FOUND);					
				}
			}
			
			latitude = latLng.lat;
			longitude = latLng.lng;
			locaisDoacao = localDoacaoService.buscaLocaisDoacaoProximosPorLatLng(latitude, longitude); 
		}		
		
		if(locaisDoacao == null || locaisDoacao.isEmpty()){
			return new ResponseEntity<List<LocalizacaoDTO>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<LocalizacaoDTO>>(locaisDoacao, HttpStatus.OK);
	}
}
