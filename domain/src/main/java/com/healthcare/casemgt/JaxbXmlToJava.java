package com.healthcare.casemgt;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class JaxbXmlToJava {
	
	public Prescription processXmlToJava(String accountNumber) throws JAXBException{
		String fileName = accountNumber +".xml";
		String fileLocation = System.getProperty("inputfile", "/Users/JeyPaulraj/development/bpm-fuse/input/");
		String obsolutePath = fileLocation+fileName;
		JAXBContext jaxbContext=null;
		
		try {
			jaxbContext = JAXBContext.newInstance(Prescription.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	    //We had written this file in marshalling example
	    Prescription account = (Prescription) jaxbUnmarshaller.unmarshal( new File(obsolutePath) );
	   // Account account = (Account) jaxbUnmarshaller.unmarshal( new StringReader("") );
	    
	    System.out.println(account.toString());
	    
	    return account;
		
	}
	public Prescription processXmlStringToJava(String xml) throws JAXBException{
		//String fileName = accountNumber +".xml";
		//String fileLocation = System.getProperty("inputfile", "/Users/JeyPaulraj/poc/broadRidge/input/");
		//String obsolutePath = fileLocation+fileName;
		JAXBContext jaxbContext=null;
		
		try {
			jaxbContext = JAXBContext.newInstance(Prescription.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	    //We had written this file in marshalling example
	   
	    Prescription account = (Prescription) jaxbUnmarshaller.unmarshal( new StringReader(xml) );
	    
	    System.out.println(account.toString());
	    
	    return account;
		
	}
   
	public void processJavaToxml(String accountNumber,Prescription account) throws JAXBException{
		
		String fileName = accountNumber +".xml";
		String fileLocation = System.getProperty("outputfile", "/Users/JeyPaulraj/poc/broadRidge/output/");
		
		
		String obsolutePath = fileLocation+fileName;
		JAXBContext jaxbContext = JAXBContext.newInstance(Prescription.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	     
	    //Marshal the employees list in console
	    jaxbMarshaller.marshal(account, System.out);
	     
	    //Marshal the employees list in file
	    jaxbMarshaller.marshal(account, new File(obsolutePath));
	}
	public static void main(String[] ar){
		String accountNumber = "healthcare";
		JaxbXmlToJava jaxbXmlToJava = new JaxbXmlToJava();
		Prescription prescription =null;
		try {
			//account = jaxbXmlToJava.processXmlToJava(accountNumber);
			 prescription = new Prescription();
			 prescription.setId("1001");
		    Doctor doctor = new Doctor();
		    doctor.setAddress("3018 winter");
		    doctor.setCity("madison");
		    doctor.setGender("M");
		    doctor.setGroupId("UW1001");
		    doctor.setHospital("1001");
		    doctor.setName("jey");
		    doctor.setState("WI");
		    
		    PatientInfo pat = new PatientInfo();
		    pat.setAge(12);
		    pat.setName("jey");
		    pat.setSymbtom("Diabetes Insipidus");
		    pat.setType("Diabetes");
		    pat.setAddress("3108 winter");
		    pat.setCity("madison");
		    pat.setState("WI");
		    
		    Rxdetail rxdetail = new Rxdetail();
		    rxdetail.setDrugName("xx");
		    rxdetail.setOther("red");
		    rxdetail.setQty(11);
		    rxdetail.setRxNum(11);
		    
		    CaseMgtContext cont = new CaseMgtContext();
		    cont.setApprovalReq("N");
		    cont.setApprovalReq("Supervisor");
		    
		    List<Rxdetail> details = new ArrayList<Rxdetail>();
		    details.add(rxdetail);
		    
		    prescription.setDoctor(doctor);
		    prescription.setPatientInfo(pat);
		    prescription.setRxdetails(details);
		    
			jaxbXmlToJava.processJavaToxml(accountNumber, prescription);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//100-00001
}
