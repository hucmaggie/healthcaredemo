package org.jboss.kiefuse.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;








//import org.jbpm.examples.ejb.ProcessOperationException;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.services.client.api.RemoteRestRuntimeEngineFactory;

import com.healthcare.casemgt.CaseMgtContext;
import com.healthcare.casemgt.Doctor;
import com.healthcare.casemgt.PatientInfo;
import com.healthcare.casemgt.Prescription;
import com.healthcare.casemgt.Rxdetail;

public class RestApi {

	//String deploymentId = "redhat.demo.demoprocess:demoprocess:1.0";
	String deploymentId = "com.healthcare.casemgt:casemgt:1.0";
	//String deploymentId = "redhat.dgdemo:dgdemo:1.0";
	
    URL deploymentUrl;
    
    String userId = "admin";
    String password = "jboss123$";

    //String userId = "bpm-admin";
    //String password = "JAXGCt7m_wig";
   
	public RestApi()  {
		super();
		 try {
			this.deploymentUrl = new URL("http://localhost:8080/business-central");
	//		 this.deploymentUrl = new URL("http://redhatbpms-brmsdemo.rhcloud.com/business-central");
			 //redhatbpms-brmsdemo.rhcloud.com/business-central
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public RuntimeEngine getRuntimeEngine(){
	RemoteRestRuntimeEngineFactory restSessionFactory 
    = new RemoteRestRuntimeEngineFactory(deploymentId, deploymentUrl, userId, password);
	 // create REST request
    RuntimeEngine engine = restSessionFactory.newRuntimeEngine();
    return engine;
}
	
	
public void startProcess(){
	
	String taskUserId = userId;
    
    RemoteRestRuntimeEngineFactory restSessionFactory 
        = new RemoteRestRuntimeEngineFactory(deploymentId, deploymentUrl, userId, password);

    // create REST request
    RuntimeEngine engine = restSessionFactory.newRuntimeEngine();
    KieSession ksession = engine.getKieSession();
    Map<String, Object> params = new HashMap<String, Object>();
    Prescription prescription = new Prescription();
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
    
   params.put("prescription", prescription);
   params.put("mgtContext", cont);
    ProcessInstance processInstance = ksession.startProcess("casemgt.healthCareCaseMgtProcess", params);
   //ProcessInstance processInstance = ksession.startProcess("onboarding.testpartner", params);
 
   //ksession.fireAllRules();
    System.out.println("process id " + processInstance.getProcessId());
    System.out.println("process id " + processInstance.getId());
   

}	
/*public void sendSignl(long id){
	List<SubSystemRequest> lst = new ArrayList<SubSystemRequest>();
	   SubSystemRequest sys1 = new SubSystemRequest();
	   sys1.setId("1");
	   sys1.setName("test");
	   sys1.setDetails("detail");
	   
	   SubSystemRequest sys2 = new SubSystemRequest();
	   sys2.setId("1");
	   sys2.setName("test");
	   sys2.setDetails("detail");
	   
	   lst.add(sys1);
	   lst.add(sys2);
	   TaskContextRequest cont = new TaskContextRequest();
	   cont.setSubSystems(lst);
	 
	RuntimeEngine engine = getRuntimeEngine();
	KieSession ksession = engine.getKieSession();
	ksession.signalEvent("addTaskSignalRef",cont);
	System.out.println("signal completed..");
}*/
/*
public  void startTask(long taskId, String actorId){
	RuntimeEngine engine = getRuntimeEngine();
	TaskService taskService = engine.getTaskService();
	taskService.start(taskId, actorId);
}
public  Task getTask(long taskId) throws Exception {
    
	 Task task;
    Map<String,Object> content;
    try {
    	
    	RuntimeEngine engine = getRuntimeEngine();
    	TaskService taskService = engine.getTaskService();
    	task  = taskService.getTaskById(taskId);
    	//taskService.getContentById(taskId);
      // task =  (org.kie.services.client.serialization.jaxb.impl.task.JaxbTaskResponse)taskService.getTaskById(taskId);
        //content = ((InternalTaskService) taskService).getTaskContent(taskId);
       
    } catch (Exception e) {
       
        throw new ProcessOperationException("Cannot get task " + taskId, e);
    }
    return task;
}
public List<TaskSummary> getTaskList(String actorId){
	
	RuntimeEngine engine = getRuntimeEngine();
	TaskService taskService = engine.getTaskService();
	List<TaskSummary> list;
    try {
        list = taskService.getTasksAssignedAsPotentialOwner(actorId, "en-UK");
       
       
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return list;
	
}
*/
public void getDeployment(){
	
	
}
public static void main(String[] ar){
	
	RestApi api = new RestApi();
	/*Application application = new Application();
	application.setDownPayment(28000);
	application.setAmortization(10);
	Applicant  applicant = new Applicant();
	applicant.setIncome(80000);
	applicant.setName("jey");
	Integer tt = new Integer(123456789);
	applicant.setSsn(tt);
	
	Property property = new Property();
	property.setPrice(100000);
	property.setAddress("239303");
	
	Appraisal appraisal = new Appraisal();
	application.setApplicant(applicant);
	application.setProperty(property);
	application.setAppraisal(appraisal);
	//RestApi api = new RestApi();
	api.startProcess(application);
	System.out.println("my name is " );
	
	
	List<TaskSummary> list = api.getTaskList("jey");
	*/
	
	/*
	try {
		//org.kie.services.client.serialization.jaxb.impl.task.JaxbTaskResponse tsk = (org.kie.services.client.serialization.jaxb.impl.task.JaxbTaskResponse)api.getTask(2);
		//TaskData dat = tsk.getTaskData();
		List<TaskSummary> list = api.getTaskList("jey");
		TaskSummary sum = list.get(0);
		long id = sum.getId();
		
		RuntimeEngine engine = api.getRuntimeEngine();
    	TaskService taskService = engine.getTaskService();
    	Task task  = taskService.getTaskById(id);
    	TaskData dta = task.getTaskData();
    	System.out.println("test" +  id );
    	Content cont = taskService.getContentById(id);
    	
    	
    	//taskService.getContentById(arg0);
    	//TaskData dt  = task.getTaskData();
    	//long ids = dt.getDocumentContentId();
		System.out.println("test" +  cont );
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
	api.startProcess();
	//api.sendSignl(43);
}
}
