package com.healthcare.casemgt;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Doctor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String gender;
	private String hospital;
	private String groupId;
	private String address;
	private String city;
	private String state;
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	@XmlElement
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHospital() {
		return hospital;
	}
	@XmlElement
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getGroupId() {
		return groupId;
	}
	@XmlElement
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", gender=" + gender + ", hospital="
				+ hospital + ", groupId=" + groupId + ", address=" + address
				+ ", city=" + city + ", state=" + state + "]";
	}
	
	

}
