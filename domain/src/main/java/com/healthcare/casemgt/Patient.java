package com.healthcare.casemgt;

import java.io.Serializable;

public class Patient implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String symptom;
	private String symptomType;
	private String previousHistory;
	private String BP;	
	private String diagnosisCode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getSymptomType() {
		return symptomType;
	}
	public void setSymptomType(String symptomType) {
		this.symptomType = symptomType;
	}
	public String getPreviousHistory() {
		return previousHistory;
	}
	public void setPreviousHistory(String previousHistory) {
		this.previousHistory = previousHistory;
	}
	public String getBP() {
		return BP;
	}
	public void setBP(String bP) {
		BP = bP;
	}
	public String getDiagnosisCode() {
		return diagnosisCode;
	}
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}
	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", symptom=" + symptom
				+ ", symptomType=" + symptomType + ", previousHistory="
				+ previousHistory + ", BP=" + BP + ", diagnosisCode="
				+ diagnosisCode + "]";
	}
	
	

}
