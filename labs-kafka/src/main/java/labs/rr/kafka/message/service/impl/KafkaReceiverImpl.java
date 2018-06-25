package labs.rr.kafka.message.service.impl;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import labs.rr.kafka.message.service.MessageReceiver;
import labs.rr.kafka.message.service.exception.MessageException;

/**
 * Recebe a mensagem do topico
 * 
 * @author regis.rocha
 *
 */
@Service
public class KafkaReceiverImpl implements MessageReceiver {

	
	/**
	 * LOG
	 */
	private static final Logger LOG = LoggerFactory.getLogger(KafkaReceiverImpl.class);
	
	/**
	 * 
	 */
	private CountDownLatch latch = new CountDownLatch(1);
	
	/**
	 * Recebe a mensagem postada no topico
	 * 
	 * @param consumerRecord - ConsumerRecord<?, ?>
	 * 			
	 * @throws MessageException
	 */
	@Override
	@KafkaListener(topics = {"labs.rr.topic"})
	public void receive(final ConsumerRecord<?, ?> consumerRecord) throws MessageException {
		try {
			LOG.info("Recebendo mesangem: " + consumerRecord.toString());
			
		    latch.countDown();
		} catch (Exception e) {
			LOG.error("", e);
			throw new MessageException(e);
		}
	}

	/**
	 * @return the latch
	 */
	@Override
	public CountDownLatch getLatch() {
		return latch;
	}
}
