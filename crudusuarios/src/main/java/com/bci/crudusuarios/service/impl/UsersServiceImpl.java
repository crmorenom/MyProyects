package com.bci.crudusuarios.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bci.crudusuarios.repository.User;
import com.bci.crudusuarios.repository.UserRepository;
import com.bci.crudusuarios.service.UsersService;
import com.bci.crudusuarios.service.response.Response;
import com.bci.crudusuarios.util.Constants;
 
/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 * @Empresa: BCI
 */

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired 
	UserRepository userRepository;
	@Autowired
	private static final Logger logger = LogManager.getLogger(UsersServiceImpl.class);
	
	@Override
	public Response create(com.bci.crudusuarios.service.model.User user){
		logger.debug(Constants.TIME_START, 0);
		long timeStart = System.currentTimeMillis();
		Response serviceResponse = new Response();
		
		try {
			com.bci.crudusuarios.repository.User user2 = this.userRepository.save(modelToRepository(user));
			serviceResponse.setData(null);
			serviceResponse.setMessage("Usuario Creado con Exito con UUID["+user2.getUuidUser()+"]");
			serviceResponse.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			if(!e.getMessage().contains("PUBLIC.USER(MAIL) VALUES 1")) {
				serviceResponse.setData(null);
				serviceResponse.setMessage("Error al crear al Usuario");
				serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				serviceResponse.setData(null);
				serviceResponse.setMessage("Error al crear al Usuario correo ya ha sido asignado a otro Usuario");
				serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} finally {
			long timeEnd = System.currentTimeMillis();
			logger.debug(Constants.TIME_END, (timeEnd-timeStart));
		}		

		return serviceResponse;
	}

	@Override
	public Response deleteById(Long uuid) {
		logger.debug(Constants.TIME_START, 0);
		long timeStart = System.currentTimeMillis();
		Response serviceResponse = new Response();
		
		try {
			Response response = this.findById(uuid);
			if(response.getStatus().equals(HttpStatus.OK)) {
				this.userRepository.deleteById(uuid);
				serviceResponse.setData(null);
				serviceResponse.setMessage("Usuario Eliminado con Exito");
				serviceResponse.setStatus(HttpStatus.OK);
			}else {
				serviceResponse.setData(null);
				serviceResponse.setMessage("Error al eliminar al Usuario");
				serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			serviceResponse.setData(null);
			serviceResponse.setMessage("Error al eliminar al Usuario");
			serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			long timeEnd = System.currentTimeMillis();
			logger.debug(Constants.TIME_END, (timeEnd-timeStart));
		}	

		return serviceResponse;
	}

	@Override
	public Response findById(Long uuid) {
		logger.debug(Constants.TIME_START, 0);
		long timeStart = System.currentTimeMillis();
		Response serviceResponse = new Response();

		try {
			Optional<User> optionalUser = this.userRepository.findById(uuid);

			if (!optionalUser.isPresent()) {
				serviceResponse.setData(null);
				serviceResponse.setMessage("Error al obtener usuario");
				serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				com.bci.crudusuarios.service.model.User userModel  = repositoryToModel(optionalUser.get());
				serviceResponse.setData(userModel);
				serviceResponse.setMessage("Usuario obtenidos con exito");
				serviceResponse.setStatus(HttpStatus.OK);
			}			
		
		} catch (Exception e) {
			serviceResponse.setData(null);
			serviceResponse.setMessage("Error al obtener usuarios");
			serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			long timeEnd = System.currentTimeMillis();
			logger.debug(Constants.TIME_END, (timeEnd-timeStart));
		}		

		return serviceResponse;
	}
	
	@Override
	public Response findAll() {
		logger.debug(Constants.TIME_START, 0);
		long timeStart = System.currentTimeMillis();
		Response serviceResponse = new Response();

		try {
			List<User> users  = this.userRepository.findAll();
			List<com.bci.crudusuarios.service.model.User> userModels  = new ArrayList<com.bci.crudusuarios.service.model.User>();
			for(User user: users) {
				com.bci.crudusuarios.service.model.User userModel  = repositoryToModel(user);
				userModels.add(userModel);
			}
			serviceResponse.setData(userModels);
			
			if(serviceResponse.getData()==null) {
				serviceResponse.setMessage("Error al obtener los usuarios");
				serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				serviceResponse.setMessage("Usuarios obtenidos con exito");
				serviceResponse.setStatus(HttpStatus.OK);
			}
		} catch (Exception e) {
			serviceResponse.setData(null);
			serviceResponse.setMessage("Error al obtener usuarios");
			serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			long timeEnd = System.currentTimeMillis();
			logger.debug(Constants.TIME_END, (timeEnd-timeStart));
		}		

		return serviceResponse;
	}
	
	private com.bci.crudusuarios.repository.User modelToRepository(com.bci.crudusuarios.service.model.User user) {
		com.bci.crudusuarios.repository.User users = new com.bci.crudusuarios.repository.User();
	
		users.setUuidUser(user.getUuid());
		users.setName(user.getName());
		users.setMail(user.getMail());
		users.setPass(user.getPass());
		users.setToken(user.getToken());
		users.setActive(user.isActive());
	    long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);
		users.setCreated(date);
		users.setLastLogin(null);
		users.setModified(null);

		Set<com.bci.crudusuarios.repository.Phone> phonesSet = new HashSet<com.bci.crudusuarios.repository.Phone>();

		for (com.bci.crudusuarios.service.model.Phone phone : user.getPhones()) {
			com.bci.crudusuarios.repository.Phone phoneR = new com.bci.crudusuarios.repository.Phone();
			phoneR.setCitycode(phone.getCitycode());
			phoneR.setContrycode(phone.getContrycode());
			phoneR.setNumber(phone.getNumber());
			phoneR.setUuidPhone(0);
			phoneR.setUser(users);
			phonesSet.add(phoneR);
		}
		
		users.setPhones(phonesSet);
		return users;
	}

	private com.bci.crudusuarios.service.model.User repositoryToModel(com.bci.crudusuarios.repository.User users) {
		
		com.bci.crudusuarios.service.model.User user = new 	com.bci.crudusuarios.service.model.User();
	
		user.setUuid(users.getUuidUser());
		user.setName(users.getName());
		user.setMail(users.getMail());
		user.setPass(users.getPass());
		user.setActive(users.isActive());
		user.setToken(users.getToken());

		Set<com.bci.crudusuarios.service.model.Phone> phonesSet = new HashSet<com.bci.crudusuarios.service.model.Phone>();

		for (com.bci.crudusuarios.repository.Phone phone : users.getPhones()) {
			com.bci.crudusuarios.service.model.Phone phoneR = new com.bci.crudusuarios.service.model.Phone();
			phoneR.setCitycode(phone.getCitycode());
			phoneR.setContrycode(phone.getContrycode());
			phoneR.setNumber(phone.getNumber());
			phoneR.setUuidPhone(phone.getUuidPhone());	
			phonesSet.add(phoneR);
		}
		user.setPhones(phonesSet);
		
		return user;
	}	
}