package com.bci.crudusuarios.repository.response;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 * @Empresa: BCI
 */

/**
 * @author STRAT
 *
 */
public class RepositoryResponse {
	
	private Object data;
	private Integer status;
	private String message;
	
	/**
	 * @return
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}