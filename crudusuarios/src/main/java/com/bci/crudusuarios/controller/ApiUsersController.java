package com.bci.crudusuarios.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bci.crudusuarios.service.UsersService;
import com.bci.crudusuarios.service.model.Phone;
import com.bci.crudusuarios.service.model.User;
import com.bci.crudusuarios.service.request.PhoneRequest;
import com.bci.crudusuarios.service.request.UserRequest;
import com.bci.crudusuarios.service.response.Response;
import com.bci.crudusuarios.util.Constants;

import io.swagger.annotations.Api;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 * @Empresa: BCI
 */

@RestController
@CrossOrigin
@RequestMapping(value = Constants.USER_CONTROLLER)
@Api(tags = Constants.USER_API_SWAGGER)
public class ApiUsersController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private Validator validator;

	/**
	 * @param request
	 * @return
	 * @throws ServiceException
	 */
	@PostMapping(Constants.CREATE)
	public ResponseEntity<Response> create(
		/*@Valid*/ @RequestBody UserRequest request){
		Response response = null;
		String validationStr = validationRequest(request);
	    if(validationStr!=null) {
	    	response = new Response();
	    	response.setData(null);
	    	response.setMessage(validationStr);
	    	response.setStatus(HttpStatus.BAD_REQUEST);	
	    }else {
	    	response = this.usersService.create(toModel(request));
	    }
		return new ResponseEntity<>(response, response.getStatus());
	}


	/**
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	@DeleteMapping(Constants.DELETE)
	public ResponseEntity<Response> deleteById(
			@RequestParam(value = "uuid", required=true) Long uuid){
		
		Response response = null;
		String validationStr = validationRequest(uuid);
	    if(validationStr!=null) {
	    	response = new Response();
	    	response.setData(null);
	    	response.setMessage(validationStr);
	    	response.setStatus(HttpStatus.BAD_REQUEST);	
	    }else {
	    	response = this.usersService.deleteById(uuid);
	    }
	
		return new ResponseEntity<>(response, response.getStatus());
	}

	/**
	 * @return
	 * @throws ServiceException
	 */
	@GetMapping(Constants.GET_ALL)
	public ResponseEntity<Response> getAll(){
		Response response = this.usersService.findAll();
		return new ResponseEntity<>(response, response.getStatus());
	}
	
	/**
	 * @param uuid
	 * @return
	 * @throws ServiceException
	 */
	@GetMapping(Constants.GET)
	public ResponseEntity<Response> get(
		@RequestParam(value = "uuid", required=true) Long uuid){
		
		Response response = null;
		String validationStr = validationRequest(uuid);
	    if(validationStr!=null) {
	    	response = new Response();
	    	response.setData(null);
	    	response.setMessage(validationStr);
	    	response.setStatus(HttpStatus.BAD_REQUEST);	
	    }else {
	    	response = this.usersService.findById(uuid);
	    }

		return new ResponseEntity<>(response, response.getStatus());
	}
	/**
	 * @param request
	 * @return
	 */
	private User toModel(UserRequest request) {
		User user = new User();
		user.setUuid(0L);
		user.setMail(request.getMail());
		user.setName(request.getName());
		user.setActive(request.isActive());
		user.setPass(request.getPass());
		user.setToken(request.getToken());

		Set<Phone> phonesSet = new HashSet<Phone>();
		
		for (PhoneRequest phoneRequest : request.getPhones()) {
			Phone phone = new Phone();
			phone.setCitycode(phoneRequest.getCitycode());
			phone.setContrycode(phoneRequest.getContrycode());
			phone.setNumber(phoneRequest.getNumber());
			phone.setUuidPhone(0L);
			phonesSet.add(phone);
		}		
		user.setPhones(phonesSet);
		
		return user;
	}
	
	/**
	 * @param request
	 * @return
	 */
	private String validationRequest(UserRequest request) {
		StringBuilder stringBuilder = null;
		Set<ConstraintViolation<UserRequest>> violations = validator.validate(request);
		for(ConstraintViolation<UserRequest>  violation: violations) {
			if(stringBuilder==null) {
				stringBuilder =new StringBuilder();
			}
			stringBuilder.append(violation.getMessage());
			stringBuilder.append(System.getProperty("line.separator"));
		}
		if(stringBuilder!=null) {
			return stringBuilder.toString();
		}else {
			return null;
		}
	}

	/**
	 * @param uuid
	 * @return
	 */
	private String validationRequest(Long uuid) {
		StringBuilder stringBuilder = null;
	
		if(uuid==null) {
			stringBuilder =new StringBuilder();
			stringBuilder.append("campo uuid no debe ser vacio ");
			stringBuilder.append(System.getProperty("line.separator"));
			return stringBuilder.toString();
		}else {
			return null;
	
		}
	}

}