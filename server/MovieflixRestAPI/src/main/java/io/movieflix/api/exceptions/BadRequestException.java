package io.movieflix.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = -5423171854177717434L;
	public BadRequestException(String message)
	{
		super(message);
	}

	public BadRequestException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
