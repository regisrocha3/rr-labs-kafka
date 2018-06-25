package labs.rr.kafka.message.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import labs.rr.kafka.message.data.Message;
import labs.rr.kafka.message.service.MessageSender;
import labs.rr.kafka.message.service.exception.MessageException;

/**
 * Envia mensagem ao Kafka
 * 
 * @author regis.rocha
 *
 */
@Service
public class KafkaSenderImpl implements MessageSender {

	/**
	 * LOG
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSenderImpl.class);

	/**
	 * @Inject
	 */
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	/**
	 * Realiza o envio da mensagem para o topico informado
	 * 
	 * @param message - Message
	 * 			
	 * @throws MessageException
	 */
	@Override
	public void sendMessage(final Message message) throws MessageException {
		LOGGER.info("Sending message to topic: " +  message.getTopic());
		
		try {
			kafkaTemplate.send(message.getTopic(), message.getPayload());
			
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new MessageException(e);
		}
	}
}
