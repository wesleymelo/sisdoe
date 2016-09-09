package br.puc.sisdoe.messaging;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

	@SuppressWarnings("rawtypes")
	//@JmsListener(destination = MessagingConfiguration.ORDER_QUEUE)
	public void receiveMessage(final Message message) throws JMSException {
		LOG.info("----------------------------------------------------");
		MessageHeaders headers =  message.getHeaders();
		LOG.info("Application : headers received : {}", headers);
		
		LOG.info("Application : Payload : {}",message.getPayload());	

		LOG.info("----------------------------------------------------");

	}
	
}
