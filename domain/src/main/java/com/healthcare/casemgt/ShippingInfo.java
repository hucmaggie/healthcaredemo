package com.healthcare.casemgt;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ShippingInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prescriptionId;
	private String correlationId;	
	private String customerName;
	private String address;
	private String city;
	private String state;
	
	public String getPrescriptionId() {
		return prescriptionId;
	}
	@XmlElement
	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public String getCustomerName() {
		return customerName;
	}
	@XmlElement
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	
	public String getCorrelationId() {
		return correlationId;
	}
	@XmlElement
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShippingInfo [prescriptionId=").append(prescriptionId)
				.append(", correlationId=").append(correlationId)
				.append(", customerName=").append(customerName)
				.append(", address=").append(address).append(", city=")
				.append(city).append(", state=").append(state).append("]");
		return builder.toString();
	}
	
	
	
}
