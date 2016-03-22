package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import services.OfficeHoursService;
import services.StaffEmailsService;

import android.content.Context;
import android.util.Log;
import model.OfficeHoursModel;
public class OfficeHoursContoller
{
  public ArrayList <OfficeHoursModel> getOfficeHours (String dep,Context ctx) throws JSONException
  {
	  ArrayList<OfficeHoursModel>stuffOfficeHours=new ArrayList<OfficeHoursModel>();
		    OfficeHoursService service=new OfficeHoursService(ctx);  
	     service.execute("http://10.0.2.2/ecom/officeHours.php",dep,"getOfficeHours");
	     String r2=""; 
	     String result="";
	     try {
			result=service.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     JSONArray jarray=new JSONArray(result);
	    // Log.v("testonsize",jarray.length()+"");
	     OfficeHoursModel stuffOH;
	   //  Log.v("test",""+jarray.length());
	    for(int i=0;i<jarray.length();i++)
	     {
	    	stuffOH=new OfficeHoursModel();
	    	JSONObject jobj=jarray.getJSONObject(i);
	   	    
	    	stuffOH.setName((jobj.getString("staff_name")));
		 	stuffOH.setDay(jobj.getString("staff_day"));
		 	stuffOH.setTime(jobj.getString("staff_time"));
		 	    if(jobj.getString("Prof_Dr_TA").equals("1"))
		 	    	stuffOH.setFlag("Prof");
		 	    else if(jobj.getString("Prof_Dr_TA").equals("2"))
		 	    	stuffOH.setFlag("Dr");
		 	    else stuffOH.setFlag("TA");
		 	    
		 	   stuffOfficeHours.add(stuffOH);
	     }	
			return stuffOfficeHours;
			
	  
  }
}
