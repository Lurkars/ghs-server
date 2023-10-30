/**
 * 
 */
package de.champonthis.ghs.server.controller;

import java.time.Instant;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * The Class ControllerResponseEntityExceptionHandler.
 */
@ControllerAdvice
public class ControllerResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private Gson gson = new Gson();

	/**
	 * Handle response entity status exception.
	 *
	 * @param exception the exception
	 * @param request   the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = { ResponseStatusException.class })
	protected ResponseEntity<Object> handleResponseEntityStatusException(ResponseStatusException exception,
			WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JsonObject errorResponse = new JsonObject();
		errorResponse.addProperty("timestamp", Instant.now().toString());
		errorResponse.addProperty("status", exception.getStatusCode().value());
		// errorResponse.addProperty("error", exception.getStatus().getReasonPhrase());
		if (StringUtils.hasText(exception.getReason())) {
			errorResponse.addProperty("reason", exception.getReason());
		}

		return handleExceptionInternal(exception, gson.toJson(errorResponse), headers, exception.getStatusCode(),
				request);
	}

}
