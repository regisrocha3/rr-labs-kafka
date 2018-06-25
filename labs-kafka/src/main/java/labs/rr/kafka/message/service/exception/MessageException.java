package labs.rr.kafka.message.service.exception;

/**
 * 
 * @author regis.rocha
 *
 */
public class MessageException extends Exception {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -2132080697336148295L;

	/**
	 * Constructor
	 * 
	 * @param message
	 *            - String
	 */
	public MessageException(final String message) {
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 *            - String
	 * 
	 * @param cause
	 *            - Throwable
	 */
	public MessageException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * 
	 * @param cause
	 *            - Throwable
	 */
	public MessageException(final Throwable cause) {
		super(cause);
	}

}
