package com.healthcare.casemgt;

import java.io.Serializable;

public class Prescriptiondetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rxNum;
	private String drugName;
	private Integer Qty;
	private String other;
	
	
	
	public Integer getRxNum() {
		return rxNum;
	}



	public void setRxNum(Integer rxNum) {
		this.rxNum = rxNum;
	}



	public String getDrugName() {
		return drugName;
	}



	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}



	public Integer getQty() {
		return Qty;
	}



	public void setQty(Integer qty) {
		Qty = qty;
	}



	public String getOther() {
		return other;
	}



	public void setOther(String other) {
		this.other = other;
	}



	@Override
	public String toString() {
		return "Prescriptiondetails [rxNum=" + rxNum + ", drugName=" + drugName
				+ ", Qty=" + Qty + ", other=" + other + "]";
	}
	
	

}
