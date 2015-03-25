package org.jboss.kiefuse.demo;

import com.healthcare.casemgt.Prescription;

public class ProcessShipping {
	
	public void process(Prescription prescription){
		
		System.out.println("Shipping processed for " + prescription.toString());
		
		
	}

}
