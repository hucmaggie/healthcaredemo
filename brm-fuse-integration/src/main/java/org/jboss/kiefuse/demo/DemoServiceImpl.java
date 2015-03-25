package org.jboss.kiefuse.demo;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@WebService(serviceName="DemoService")
public class DemoServiceImpl implements  DemoService{
    
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    @WebMethod(operationName = "processRequest")
    public String processRequest(@WebParam(name = "request") String request) {

    	String response=null;
    	logger.info(" service request", request);
    	
	if(request != null && !request.startsWith("Z")) {
		response = "Success";
	}else{
		response = "Failed";
	}   	
    	
    	System.out.println("web service completed");

        return response;
    }

       
   
    
}
