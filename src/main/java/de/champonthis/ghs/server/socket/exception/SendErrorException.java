/**
 * 
 */
package de.champonthis.ghs.server.socket.exception;

/**
 * The Class SendErrorException.
 */
public class SendErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new send error exception.
	 *
	 * @param message the message
	 */
	public SendErrorException(String message) {
		super(message);
	}

}
