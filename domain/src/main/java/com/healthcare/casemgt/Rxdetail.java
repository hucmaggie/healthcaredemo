package com.healthcare.casemgt;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Rxdetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer rxNum;
	private String drugName;
	private Integer qty;
	private String other;
	
	public Integer getRxNum() {
		return rxNum;
	}
	@XmlElement
	public void setRxNum(Integer rxNum) {
		this.rxNum = rxNum;
	}
	public String getDrugName() {
		return drugName;
	}
	@XmlElement
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public Integer getQty() {
		return qty;
	}
	@XmlElement
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getOther() {
		return other;
	}
	@XmlElement
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Rxdetail [rxNum=" + rxNum + ", drugName=" + drugName + ", qty="
				+ qty + ", other=" + other + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((drugName == null) ? 0 : drugName.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((rxNum == null) ? 0 : rxNum.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rxdetail other = (Rxdetail) obj;
		if (drugName == null) {
			if (other.drugName != null)
				return false;
		} else if (!drugName.equals(other.drugName))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (rxNum == null) {
			if (other.rxNum != null)
				return false;
		} else if (!rxNum.equals(other.rxNum))
			return false;
		return true;
	}
	
	
	
	
	
}
