package br.puc.sisdoe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.puc.sisdoe.model.Agendamento;
import br.puc.sisdoe.repository.AgendamentoRepository;
import br.puc.sisdoe.util.CollectionUtil;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> findAll(){
        return CollectionUtil.iterableToList(agendamentoRepository.findAll());
    }
 
    public Agendamento findById(Long id){
        return agendamentoRepository.findOne(id);
    }
    
    public Agendamento buscaAgendamentoPorDoador(Long idDoador){
        return agendamentoRepository.buscaAgendamentoPorDoador(idDoador);
    }
 
    public Agendamento save(Agendamento agendamento){
        return agendamentoRepository.save(agendamento);
    }
    
    public void delete(Agendamento agendamento){
        agendamentoRepository.delete(agendamento);
    }
	
}
