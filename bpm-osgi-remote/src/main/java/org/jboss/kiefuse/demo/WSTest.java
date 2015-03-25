package org.jboss.kiefuse.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.bind.JAXBContext;

public class WSTest {
	
	public void restclinet(){
		String uri=null;
		try {
			uri = "http://localhost:8080/CustomerService/rest/customers/1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			URL url=null;
			try {
				url = new URL(uri);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpURLConnection connection=null;
			try {
				connection = (HttpURLConnection) url.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.setRequestMethod("GET");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection.setRequestProperty("Accept", "application/xml");

			//JAXBContext jc = JAXBContext.newInstance(WSTest.class);
			//InputStream xml = connection.getInputStream();
			//Customer customer =
			//    (Customer) jc.createUnmarshaller().unmarshal(xml);

			connection.disconnect();
	}

}
