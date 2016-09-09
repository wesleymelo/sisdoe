package br.puc.sisdoe.config;

import java.util.Arrays;
import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfiguration {

	private static final String DEFAULT_BROKER_URL = "ssl://localhost:61617";
	public static final String ORDER_QUEUE = "resultados-exames-queue";

	@Bean
	public ActiveMQSslConnectionFactory connectionFactory(){
		ActiveMQSslConnectionFactory connectionSSLFactory= new ActiveMQSslConnectionFactory();  
		connectionSSLFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionSSLFactory.setUserName("admin");
		connectionSSLFactory.setPassword("admin");
		connectionSSLFactory.setTrustedPackages(Arrays.asList("br.puc.sisdoe"));
		try {
			connectionSSLFactory.setKeyStore("keys/amq-client.ks");
			connectionSSLFactory.setKeyStorePassword("123456");
			connectionSSLFactory.setTrustStore("keys/amq-client.ts");
			connectionSSLFactory.setTrustStorePassword("123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connectionSSLFactory;
	}
	
	@Bean 
	public JmsTemplate jmsTemplate(){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(ORDER_QUEUE);
		return template;
	}
	
}
