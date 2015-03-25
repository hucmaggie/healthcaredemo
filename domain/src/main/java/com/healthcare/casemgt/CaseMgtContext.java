package com.healthcare.casemgt;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class CaseMgtContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String approvalReq;
	
	private String apprverName;
	
	private String approved;

	public String getApprovalReq() {
		return approvalReq;
	}
	@XmlElement
	public void setApprovalReq(String approvalReq) {
		this.approvalReq = approvalReq;
	}

	public String getApprverName() {
		return apprverName;
	}
	@XmlElement
	public void setApprverName(String apprverName) {
		this.apprverName = apprverName;
	}

	
	public String getApproved() {
		return approved;
	}
	@XmlElement
	public void setApproved(String approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "CaseMgtContext [approvalReq=" + approvalReq + ", apprverName="
				+ apprverName + ", approved=" + approved + "]";
	}

	
	

}
