package br.puc.sisdoe.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.puc.sisdoe.messaging.ProducerRabbitMQ;
import br.puc.sisdoe.model.ResultadoExame;
import br.puc.sisdoe.repository.ResultadoExameRepository;

@Service
public class ResultadoExameService{

	static final Logger LOG = LoggerFactory.getLogger(ResultadoExameService.class);
	
	@Autowired
	ProducerRabbitMQ messageSender;
	
	@Autowired
	private ResultadoExameRepository resultadoExameRepository;
	
	public List<ResultadoExame> findAll() {
		return resultadoExameRepository.findAll();
	}

	public List<ResultadoExame> enviaResultadoExamesAoSUS() throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException {
		List<ResultadoExame> resultadoExames = resultadoExameRepository.findAll(); 
		messageSender.sendMessage(resultadoExames);
		return resultadoExames;
	}
	
	public List<ResultadoExame> enviaResultadoExamesAoSUS(List<ResultadoExame> resultadoExames) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException {
		messageSender.sendMessage(resultadoExames);
		return resultadoExames;
	}
	
	
	/*
	public static void main(String[] args) {
		
		ProducerRabbitMQ producer = new ProducerRabbitMQ();
		List<ResultadoExame> resultadoExames = new ResultadoExameRepository().findAll();
		try {
			producer.sendMessage(resultadoExames);
		} catch (KeyManagementException | NoSuchAlgorithmException | URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		
	}
	*/
	
}
