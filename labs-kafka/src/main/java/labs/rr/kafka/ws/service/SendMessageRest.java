package labs.rr.kafka.ws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import labs.rr.kafka.message.data.Message;
import labs.rr.kafka.message.service.MessageSender;

/**
 * 
 * @author regis.rocha
 *
 */
@RestController(value = "/message")
public class SendMessageRest {

	/**
	 * LOG
	 */
	private static final Logger LOG = LoggerFactory.getLogger(SendMessageRest.class);
	
	/**
	 * @Inject
	 */
	@Autowired
	private MessageSender messageSender;
	
	
	@GetMapping
	public ResponseEntity<String> sendMessage() {
		LOG.info("Sending message test");
		
		try {
			this.messageSender.sendMessage(new Message("labs.rr.topic", "Message test.............."));
			
			return ResponseEntity.status(HttpStatus.OK).body("Success");
		} catch (Exception e) {
			LOG.error("", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}
	} 
}
