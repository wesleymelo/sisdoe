package br.puc.sisdoe.repository;

import javax.transaction.Transactional;

import br.puc.sisdoe.model.Agendamento;

@Transactional
public interface AgendamentoRepositoryCustom{
	
	Agendamento buscaAgendamentoPorDoador(Long idDoador);

}
