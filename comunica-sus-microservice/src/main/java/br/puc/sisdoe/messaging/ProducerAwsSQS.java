package br.puc.sisdoe.messaging;

import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import br.puc.sisdoe.model.ResultadoExame;

@Component
public class ProducerAwsSQS {
	
	static final Logger LOG = LoggerFactory.getLogger(ProducerAwsSQS.class);

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(final List<ResultadoExame> resultadosExames) {
		JSONArray resultadosExamesJson = new JSONArray(resultadosExames);
		String url = "https://sqs.us-west-2.amazonaws.com/637248692254/resultados-exames";
		LOG.info("Enviando MSG pra fila URL: ", url);
		AWSCredentials awsCredentials = new AWSCredentials() {
			@Override
			public String getAWSSecretKey() {
				return "AAAAAAAAAAAAAAAAA";
			}
			@Override
			public String getAWSAccessKeyId() {
				return "BBBBBBBBBBBBBBBBBBB";
			}
			
		};
		AmazonSQSClient sqsClient = new AmazonSQSClient(awsCredentials);
		sqsClient.sendMessage(new SendMessageRequest().withQueueUrl(url).withMessageBody(resultadosExamesJson.toString()));
		LOG.info("Mensagem: ", resultadosExamesJson.toString());
	}

}
