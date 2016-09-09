package br.puc.sisdoe.messaging;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import br.puc.sisdoe.model.ResultadoExame;

@Component
public class ProducerRabbitMQ {

	static final Logger LOG = LoggerFactory.getLogger(ProducerAwsSQS.class);
	
	public final static String QUEUE_NAME = "resultados-exames-sisdoe";

	public void sendMessage(final List<ResultadoExame> resultadosExames) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException {
		JSONArray resultadosExamesJson = new JSONArray(resultadosExames);

		String uri = "amqp://ymweczqa:lg8_QYYIB_L1sSBZvNFeuiWfcAIccaek@wildboar.rmq.cloudamqp.com/ymweczqa";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUri(uri);
		factory.setRequestedHeartbeat(30);
		factory.setConnectionTimeout(60);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.basicPublish("", QUEUE_NAME, null, resultadosExamesJson.toString().getBytes("UTF-8"));
		LOG.info("Mensagem: ", resultadosExamesJson.toString());

		channel.close();
		connection.close();
	}

}
