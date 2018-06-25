package labs.rr.kafka.message.data;

import java.io.Serializable;

/**
 * Contem conteudo da mensagem
 * 
 * @author regis.rocha
 *
 */
public class Message implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -2240322700910359969L;

	private String topic;

	private String payload;

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic
	 *            the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [topic=" + topic + ", payload=" + payload + "]";
	}

	public Message() {
	}

	/**
	 * @param topic
	 * @param payload
	 */
	public Message(String topic, String payload) {
		this.topic = topic;
		this.payload = payload;
	}

}
