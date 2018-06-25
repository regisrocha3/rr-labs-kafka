package labs.rr.kafka.message.service;

import labs.rr.kafka.message.data.Message;
import labs.rr.kafka.message.service.exception.MessageException;

/**
 * Envia mensagem 
 * 
 * @author regis.rocha
 *
 */
public interface MessageSender {

	/**
	 * Realiza o envio da mensagem para o topico informado
	 * 
	 * @param message - Message
	 * 			
	 * @throws MessageException
	 */
	void sendMessage(final Message message) throws MessageException;
	
}
