package labs.rr.labs.kafka;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import labs.rr.kafka.LabsKafkaApplication;
import labs.rr.kafka.message.data.Message;
import labs.rr.kafka.message.service.MessageReceiver;
import labs.rr.kafka.message.service.MessageSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {LabsKafkaApplication.class})
public class LabsKafkaApplicationTests {

	private static String BOOT_TOPIC = "labs.rr.topic";

	@Autowired
	private MessageSender sender;

	@Autowired
	private MessageReceiver receiver;

	@ClassRule
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, BOOT_TOPIC);

	@Test
	public void testReceive() throws Exception {
		sender.sendMessage(new Message(BOOT_TOPIC, "Sending message - LABS RR."));

		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		
		Assert.assertEquals(receiver.getLatch().getCount(), 0);
	}
}
