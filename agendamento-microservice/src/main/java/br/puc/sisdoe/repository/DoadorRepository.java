package br.puc.sisdoe.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import br.puc.sisdoe.model.Doador;

@Transactional
public interface DoadorRepository extends CrudRepository<Doador, Long> {
	
	//City findByNameAndCountryAllIgnoringCase(String name, String country);

}
