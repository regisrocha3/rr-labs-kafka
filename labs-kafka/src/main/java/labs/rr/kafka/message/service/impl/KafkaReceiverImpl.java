package labs.rr.kafka.message.service.impl;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
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
	@KafkaListener(topics = {"labs.rr.topic"}, group = "labs-rr", topicPartitions = @TopicPartition(topic = "labs.rr.topic",
			  partitionOffsets = {
					    @PartitionOffset(partition = "0", initialOffset = "0"), 
					    @PartitionOffset(partition = "1", initialOffset = "0")
					}))
	public void receive(final ConsumerRecord<?, ?> consumerRecord) throws MessageException {
		try {
			LOG.info("Consumer 1 - Recebendo mesangem : " + this.getClass().getName() + " : " + consumerRecord.toString());
			
		    latch.countDown();
		} catch (Exception e) {
			LOG.error("", e);
			throw new MessageException(e);
		}
	}
	
	
	/**
	 * Recebe a mensagem postada no topico
	 * 
	 * @param consumerRecord - ConsumerRecord<?, ?>
	 * 			
	 * @throws MessageException
	 */
	@KafkaListener(topics = {"labs.rr.topic"}, group = "labs-rr", topicPartitions = @TopicPartition(topic = "labs.rr.topic",
			  partitionOffsets = {
					    @PartitionOffset(partition = "2", initialOffset = "0") 
					}))
	public void receive2(final ConsumerRecord<?, ?> consumerRecord) throws MessageException {
		try {
			LOG.info("Consumer 2 - Recebendo mesangem : " + this.getClass().getName() + " : " + consumerRecord.toString());
			
		    latch.countDown();
		} catch (Exception e) {
			LOG.error("", e);
			throw new MessageException(e);
		}
	}
	
	/**
	 * Recebe a mensagem postada no topico
	 * 
	 * @param consumerRecord - ConsumerRecord<?, ?>
	 * 			
	 * @throws MessageException
	 */
	@KafkaListener(topics = {"labs.rr.topic"}, group = "labs-rr", topicPartitions = @TopicPartition(topic = "labs.rr.topic",
			  partitionOffsets = {
					    @PartitionOffset(partition = "3", initialOffset = "0")
					}))
	public void receive3(final ConsumerRecord<?, ?> consumerRecord) throws MessageException {
		try {
			LOG.info("Consumer 3 - Recebendo mesangem : " + this.getClass().getName() + " : " + consumerRecord.toString());
			
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
