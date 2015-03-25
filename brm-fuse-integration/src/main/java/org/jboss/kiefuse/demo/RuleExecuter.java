package org.jboss.kiefuse.demo;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.healthcare.casemgt.CaseMgtContext;
import com.healthcare.casemgt.Doctor;
import com.healthcare.casemgt.PatientInfo;
import com.healthcare.casemgt.Prescription;
import com.healthcare.casemgt.Rxdetail;

public class RuleExecuter {
	
	public void executeRule(Prescription prescription){

		KieRuntimeLogger logger = null;
		BRMSUtil brmsUtil = BRMSUtil.getInstance();
		
		/*KieServices ks = KieServices.Factory.get();
        KieContainer kcont = ks.newKieClasspathContainer();
        KieBase kbase = kcont.getKieBase("osgiRule");

       // this.ksession = kbase.newKieSession();	
		KieSession ksession = kbase.newKieSession();*/	
		KieSession ksession = null;
		try {
							
			// get new session from KnowledgeBase
			ksession = brmsUtil.getStatefulSession();
			
			//enable audit logging
			//KieServices  kieServices = brmsUtil.getkServices();
			//logger = kieServices.getLoggers().newFileLogger(ksession, "/Users/JeyPaulraj/audit");
		
			//Global service that will be used in rule consequence
			//Helper helper =new Helper();
				
			//ksession.setGlobal("helper", helper);
			
			
			//Agenda Listener to trace  rule activation and execution  
			ksession.addEventListener(new DefaultAgendaEventListener() {
				public void afterMatchFired(AfterMatchFiredEvent event) {
					System.out.println("###### Fired: "
							+ event.getMatch().getRule().getName());
				}
				
			});

			ksession.insert(prescription);
			ksession.fireAllRules();
		}finally {
		
			if ( ksession != null ) {
				
				//ksession.dispose();
				//logger.close();
			}
		}	
	}
	
	public static void main(String[] ar){
		RuleExecuter executer = new RuleExecuter();
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
	    pat.setSymbtom("Myocardial Infection");
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
	    
		executer.executeRule(prescription);

	}
}
