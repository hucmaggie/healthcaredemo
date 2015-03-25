package org.jboss.kiefuse.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.order.process.Order;




@WebService(serviceName="DemoService")
public interface DemoService {
   
    @WebMethod(operationName = "processRequest")
    public String processRequest(String request) ;
   
    @WebMethod(operationName = "validateIP")
    public String validateIP(Order order) ;
   
    @WebMethod(operationName = "validateInventory")
    public String validateInventory(Order order) ;
      
}
