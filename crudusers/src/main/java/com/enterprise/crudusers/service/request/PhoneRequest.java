package com.enterprise.crudusers.service.request;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno

 */

public class PhoneRequest {
	private long uuidPhone;
	private String number;
	private String citycode;
	private String contrycode;
	public long getUuidPhone() {
		return uuidPhone;
	}
	public void setUuidPhone(long uuidPhone) {
		this.uuidPhone = uuidPhone;
	}
	public String getNumber() {
		return number;
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