package br.puc.sisdoe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.puc.sisdoe.model.Doador;
import br.puc.sisdoe.repository.DoadorRepository;
import br.puc.sisdoe.util.CollectionUtil;

@Service
public class DoadorService {
	
	@Autowired
	private DoadorRepository doadorRepository;
	
	public List<Doador> findAll(){
        return CollectionUtil.iterableToList(doadorRepository.findAll());
    }
 
    public Doador findById(Long id){
        return doadorRepository.findOne(id);
    }
 
    public Doador save(Doador doador){
        return doadorRepository.save(doador);
    }
    
    public void delete(Doador doador){
    	doadorRepository.delete(doador);
    }
	
}
