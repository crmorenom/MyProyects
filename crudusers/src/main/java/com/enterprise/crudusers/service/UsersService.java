package com.enterprise.crudusers.service;

import com.enterprise.crudusers.response.Response;
import com.enterprise.crudusers.service.model.User;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno

 */

public interface UsersService {

	/**
	 * @param user
	 * @return
	 */
	public Response create(User user);
	
	/**
	 * @param uuid
	 * @return
	 */
	public Response deleteById(Long uuid);
	
	/**
	 * @return
	 */
	public Response findAll();
	
	/**
	 * @param uuid
	 * @return
	 */
	public Response findById(Long uuid);

}