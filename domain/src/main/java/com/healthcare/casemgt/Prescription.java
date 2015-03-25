package com.healthcare.casemgt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Prescription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	
	private Doctor doctor;
	private PatientInfo patientInfo;
	private List<Rxdetail> rxdetails;
	
	public String getId() {
		return id;
	}
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	@XmlElement
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	public PatientInfo getPatientInfo() {
		return patientInfo;
	}
	@XmlElement
	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}
	
	public List<Rxdetail> getRxdetails() {
		return rxdetails;
	}
	@XmlElement
	public void setRxdetails(List<Rxdetail> rxdetails) {
		if (this.rxdetails == null){
			this.rxdetails = new ArrayList<Rxdetail>();
		}
		this.rxdetails.addAll(rxdetails);
		
	}
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", doctor=" + doctor
				+ ", patientInfo=" + patientInfo + ", rxdetails=" + rxdetails
				+ "]";
	}
	
	
	
	

}
