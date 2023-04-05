package com.enterprise.crudusers.service.model;

import java.util.Set;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno

 */

public class User {
	private Long uuid;
	private String name;
	private String token;
	private boolean isActive;
	private String mail;
	private String pass;
	private Set<com.enterprise.crudusers.service.model.Phone> phones;
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
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
	public Set<com.enterprise.crudusers.service.model.Phone> getPhones() {
		return phones;
	}
	public void setPhones(Set<com.enterprise.crudusers.service.model.Phone> phones) {
		this.phones = phones;
	}

}