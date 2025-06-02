package de.champonthis.ghs.server.socket.exception;

import java.io.Serial;

public class SendErrorException extends Exception {

	@Serial
	private static final long serialVersionUID = 1L;

	public SendErrorException(String message) {
		super(message);
	}

}
