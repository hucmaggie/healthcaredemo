package org.jboss.kiefuse.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;



@WebService(serviceName="DemoService")
public interface DemoService {
   
    @WebMethod(operationName = "processRequest")
    public String processRequest(String request) ;
    
      
}
