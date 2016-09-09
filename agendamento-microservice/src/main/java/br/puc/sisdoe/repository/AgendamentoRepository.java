package br.puc.sisdoe.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import br.puc.sisdoe.model.Agendamento;

@Transactional
public interface AgendamentoRepository extends CrudRepository<Agendamento, Long>, AgendamentoRepositoryCustom{

}
