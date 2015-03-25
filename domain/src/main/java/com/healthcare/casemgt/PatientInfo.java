package com.healthcare.casemgt;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class PatientInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	private String symbtom;
	private String type;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	public String getName() {
		return name;
	}
	@XmlElement

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	@XmlElement
	public void setAge(Integer age) {
		this.age = age;
	}
	

	
	public String getSymbtom() {
		return symbtom;
	}
	@XmlElement

	public void setSymbtom(String symbtom) {
		this.symbtom = symbtom;
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getAddress() {
		return address;
	}
	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	@XmlElement
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	@XmlElement
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientInfo [name=").append(name).append(", age=")
				.append(age).append(", symbtom=").append(symbtom)
				.append(", type=").append(type).append(", address=")
				.append(address).append(", city=").append(city)
				.append(", state=").append(state).append(", zip=").append(zip)
				.append("]");
		return builder.toString();
	}
	
	
	
	

}
