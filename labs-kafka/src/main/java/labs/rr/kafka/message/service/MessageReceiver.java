package labs.rr.kafka.message.service;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import labs.rr.kafka.message.service.exception.MessageException;

/**
 * Recebe mensagem 
 * 
 * @author regis.rocha
 *
 */
public interface MessageReceiver {

	/**
	 * Recebe a mensagem postada no topico
	 * 
	 * @param consumerRecord - ConsumerRecord<?, ?>
	 * 			
	 * @throws MessageException
	 */
	void receive(ConsumerRecord<?, ?> consumerRecord) throws MessageException;
	
	/**
	 * 
	 * @return CountDownLatch
	 */
	CountDownLatch getLatch();
	
}
