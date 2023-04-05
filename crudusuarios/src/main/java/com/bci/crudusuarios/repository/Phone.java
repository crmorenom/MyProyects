package com.bci.crudusuarios.repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 * @Empresa: BCI
 */

@Entity
@Table(name="phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UUID_PHONE")
	private long uuidPhone;
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "CITYCODE")
	private String citycode;
	@Column(name = "COUNTRYCODE")
	private String contrycode;
	
	@JoinColumn(name="UUID_USER", referencedColumnName = "UUID_USER")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private User user;
	
	public long getUuidPhone() {
		return uuidPhone;
	}
	public void setUuidPhone(long uuidPhone) {
		this.uuidPhone = uuidPhone;
	}
	public String getNumber() {
		return number;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getContrycode() {
		return contrycode;
	}
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}
	
}