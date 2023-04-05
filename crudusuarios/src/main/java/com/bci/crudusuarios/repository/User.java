package com.bci.crudusuarios.repository;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 * @Empresa: BCI
 */

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UUID_USER")
	private long uuidUser;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TOKEN")
	private String token;
	@Column(name = "ISACTIVE")
	private boolean isActive;
	@Column(name = "MAIL", unique=true)
	private String mail;
	@Column(name = "PASS")
	private String pass;
	@Column(name = "CREATED")
	private Date created; 
	@Column(name = "MODIFIED")
	private Date modified;
	@Column(name = "LAST_LOGIN")
	private Date lastLogin;
	
	@OneToMany(targetEntity=Phone.class, mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Phone> phones;
	
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
	public long getUuidUser() {
		return uuidUser;
	}
	public void setUuidUser(long uuidUser) {
		this.uuidUser = uuidUser;
	}
	public Set<Phone> getPhones() {
		return phones;
	}
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
}