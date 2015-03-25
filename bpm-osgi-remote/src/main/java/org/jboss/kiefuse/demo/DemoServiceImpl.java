package org.jboss.kiefuse.demo;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.order.process.Order;




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
    
    @WebMethod(operationName = "validateIP")
    public String validateIP(@WebParam(name = "order") Order order) {

    	String response=null;
    	logger.info(" service validate ip request", order);
    	
    	String request = order.getIpAddress();
    	if(request != null && !request.startsWith("00")) {
		response = "Success";
	}else{
		response = "Failed";
	}   	
    	
    	System.out.println("web service validate ip completed");

        return response;
    }
    @WebMethod(operationName = "validateIP")
    public String validateInventory(@WebParam(name = "order") Order order) {

    	String response=null;
    	logger.info(" service validate ip request", order);
    	
    	String request = order.getProdcutName();
    	if(request != null && !request.startsWith("Z")) {
		response = "Success";
	}else{
		response = "Failed";
	}   	
    	
    	System.out.println("web service validate inventory completed");

        return response;
    }
       
   
    
}
