package br.puc.sisdoe.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import br.puc.sisdoe.model.LocalDoacao;

@Transactional
public interface LocalDoacaoRepository extends CrudRepository<LocalDoacao, Long>, LocalDoacaoRepositoryCustom {
	
}
