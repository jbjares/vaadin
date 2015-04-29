package eu.insight.nhsdashboard.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class HelloBean{
    public String getMessage() {
    	
    	StringBuilder result = new StringBuilder();
    	 try {
    		 
    			DefaultHttpClient httpClient = new DefaultHttpClient();
    			HttpGet getRequest = new HttpGet(
    				"http://localhost:3000/users");
    			getRequest.addHeader("accept", "application/json");
    	 
    			HttpResponse response = httpClient.execute(getRequest);
    	 
    			if (response.getStatusLine().getStatusCode() != 200) {
    				throw new RuntimeException("Failed : HTTP error code : "
    				   + response.getStatusLine().getStatusCode());
    			}
    	 
    			BufferedReader br = new BufferedReader(
    	                         new InputStreamReader((response.getEntity().getContent())));
    	 
    			String output;
    			System.out.println("Output from Server .... \n");
    			while ((output = br.readLine()) != null) {
    				result.append(output);
    			}
    	 
    			httpClient.getConnectionManager().shutdown();
    	 
    		  } catch (ClientProtocolException e) {
    	 
    			e.printStackTrace();
    	 
    		  } catch (IOException e) {
    	 
    			e.printStackTrace();
    		  }
    	 
        return "Hello from bean " + result;
    }
}
