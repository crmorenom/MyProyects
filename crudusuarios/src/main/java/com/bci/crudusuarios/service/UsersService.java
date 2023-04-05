package com.bci.crudusuarios.service;

import com.bci.crudusuarios.service.model.User;
import com.bci.crudusuarios.service.response.Response;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 * @Empresa: BCI
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