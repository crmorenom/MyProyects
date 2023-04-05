package com.enterprise.crudusers.service.request;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno

 */

public class UserRequest {
	@JsonProperty
	private int uuid;
	@JsonProperty
	@NotNull(message="El campo nombre no puede ser vacio")
	private String name;
	@JsonProperty
	@NotNull(message="El campo token no puede ser vacio")
	private String token;
	@JsonProperty
	private boolean isActive;
	@JsonProperty
	@NotNull(message="El campo mail no puede ser vacio")
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
                 message="El campo mail es invalido")
	private String mail;
	@JsonProperty
	@NotNull(message="El campo pass no puede ser vacio")
	private String pass;
	@JsonProperty
	List<PhoneRequest> phones;
	
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<PhoneRequest> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneRequest> phones) {
		this.phones = phones;
	}
}