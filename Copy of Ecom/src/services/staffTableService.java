package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.os.AsyncTask;

public class staffTableService extends AsyncTask<String,Void,String>
{
	Context ctx;
	staffTableService()  
	   {  
	       
	   }  
	  
	 public staffTableService (Context ctx)  
	   {  
	    this.ctx =ctx; 
	    
	   }

	@Override
	protected String doInBackground(String... params) {
		String response = "" ;
		try {
			URL url = new URL(params[0]);
			String day = params[2];
			
			
			DefaultHttpClient client = new DefaultHttpClient();
			
			HttpPost httpPost= new HttpPost(params[0]);
			
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			
	        param.add(new BasicNameValuePair("email",params[1]));
	        param.add(new BasicNameValuePair("day",day));
	        
	      
	        UrlEncodedFormEntity u=new UrlEncodedFormEntity(param,"UTF-8");
	        
	        httpPost.setEntity(u);
	        
           HttpResponse HttpRes = client.execute(httpPost);
           
           InputStream content = HttpRes.getEntity().getContent();
           
           BufferedReader buffer = new BufferedReader(new InputStreamReader(content)); 
           
           String line = "" ;
           
           while((line = buffer.readLine())!=null){
           	response += line;
           //	Log.v("responceeee",response);
           }
	 
		
	}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
}
}
