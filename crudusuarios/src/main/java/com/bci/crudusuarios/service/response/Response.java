package com.bci.crudusuarios.service.response;

import org.springframework.http.HttpStatus;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 * @Empresa: BCI
 */

public class Response {
	
	private Object data;
	private HttpStatus status;
	private String message;

	public Response() {
		super();
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}