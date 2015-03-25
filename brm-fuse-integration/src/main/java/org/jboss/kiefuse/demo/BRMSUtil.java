package org.jboss.kiefuse.demo;

import java.util.Calendar;
import java.util.Date;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
//import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

//@ApplicationScoped
public class BRMSUtil {

	private static BRMSUtil util;
	
    private KieContainer kContainer = null;
    private KieServices kServices ;
   // private KieScanner kScanner ;
    
    public static BRMSUtil getInstance(){
    	
    	if(util == null){
    		util = new BRMSUtil();
    	}
    	return util;
    }
    private  BRMSUtil() {	    
    	
    	//System.out.println("BRMSUtil()");
    	
        kServices = KieServices.Factory.get();
    	
    	

		//ReleaseId releaseId = kServices.newReleaseId( "com.healthcare.casemgt", "healthcareRule", "1.0" );
		
		//kContainer = kServices.newKieContainer( releaseId );
        
       //kContainer = kServices.getKieClasspathContainer(this.getClass().getClassLoader());
		//KieScanner 
		//kScanner = kServices.newKieScanner( kContainer );
        
		// Start the KieScanner polling the maven repository every 10 seconds

		//kScanner.start( 10000L );
    }

    
    public StatelessKieSession getStatelessSession() {

        return kContainer.newStatelessKieSession();

    }

    /*
     * KieSession is the new StatefulKnowledgeSession from BRMS 5.3.
     */
    public KieSession getStatefulSession() {
    	//KieBase kbase = kContainer.getKieBase("osgiRule");
        return kContainer.newKieSession("ksessionosgi");
    	//return kbase.newKieSession();

    }


	public KieContainer getkContainer() {
		return kContainer;
	}


	public void setkContainer(KieContainer kContainer) {
		this.kContainer = kContainer;
	}


	public KieServices getkServices() {
		return kServices;
	}


	public void setkServices(KieServices kServices) {
		this.kServices = kServices;
	}
	
	public static void main(String [] ar){
		
		Date currentDate = new Date();
		
		//Date bDate = Calendar.getInstance().getTime();
		Date bDate = new Date("07/06/2014");
		System.out.println("CurrentDate" + currentDate);
		System.out.println("business date" + bDate);
		System.out.println( bDate.after(currentDate) || bDate.equals(currentDate));
	}

}
