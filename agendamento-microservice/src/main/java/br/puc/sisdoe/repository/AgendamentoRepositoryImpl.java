package br.puc.sisdoe.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.puc.sisdoe.model.Agendamento;

public class AgendamentoRepositoryImpl implements AgendamentoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

	@Override
	//@Query(value="select a from Agendamento a where a.idDoador = :idDoador and a.dataHora < :dataAtual")
	public Agendamento buscaAgendamentoPorDoador(Long idDoador) {
		List<Agendamento> agendamentos = new ArrayList<>();
    	Calendar calendarAtual = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
		
    	agendamentos = em.createNamedQuery("Agendamento.buscaPorDoadorAndDataAtual", Agendamento.class)
	    		.setParameter("idDoador", idDoador)
	    		.setParameter("dataAtual", calendarAtual.getTime()).getResultList();
		
    	if(agendamentos == null || agendamentos.isEmpty()){
    		return new Agendamento();
    	}
    	
		return agendamentos.get(0);
	}

}
