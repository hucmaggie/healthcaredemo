/*
 * Copyright (C) Red Hat, Inc.
 * http://www.redhat.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.kiefuse.demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.services.client.api.RemoteRestRuntimeEngineFactory;

import com.order.process.DeployableService;
import com.order.process.Notification;
import com.order.process.Order;

public class ComcastProcessRestOperation {
  
  private  String deploymentId;
  private  String processId;
  private  String baseUrl;
  private  String username;
  private  String password;

  private RuntimeEngine runtimeEngine;

  public  ComcastProcessRestOperation() {
    this.deploymentId = "com.order.process:process:1.0";
    this.processId = "Orderworkflow.CENOrderProcess";
    this.baseUrl = "http://localhost:8080/business-central";
    this.username = "admin";
    this.password = "jboss123$";
  }

  private synchronized void initRuntimeEngine() {
    if (runtimeEngine == null) {
      try {
    	  RemoteRestRuntimeEngineFactory runtimeEngineFactory = new RemoteRestRuntimeEngineFactory(deploymentId, URI.create(baseUrl).toURL(), username, password);
        this.runtimeEngine = runtimeEngineFactory.newRuntimeEngine();
      } catch (MalformedURLException e) {
        throw new IllegalArgumentException(e);
      }
    }
  }

  public String getDeploymentId() {
    return deploymentId;
  }

  public String getProcessId() {
    return processId;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String startProcess(Order order) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    DeployableService service = order.getService();
    List<Notification> notifications = order.getNotifcation();
    com.order.process.Error error = new com.order.process.Error();
    parameters.put("error",error);
    parameters.put("order",order);
    parameters.put("servie",service);
    parameters.put("ipaddress",order.getIpAddress());
    parameters.put("prodid",order.getProdcutid());
    
    
    for(Notification notification: notifications ){
    	String type = notification.getDepartment();
    	if("CLIPS".equalsIgnoreCase(type));{
    		parameters.put("clips",notification);
    	}
    	if("CSS".equalsIgnoreCase(type));{
    		parameters.put("css",notification);
    	}
    }
    
    
    initRuntimeEngine();
    KieSession kieSession = runtimeEngine.getKieSession();
    ProcessInstance processInstance = kieSession.startProcess(processId, parameters);
    String processInstanceId = Long.toString(processInstance.getId());
    return processInstanceId;
  }

  
  public void cancelOrder(String orderRequestId) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

 }
