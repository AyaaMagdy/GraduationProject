package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.OfficeHoursModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import services.OfficeService;


import android.content.Context;
import android.util.Log;


public class AddOfficeController {
	public AddOfficeController() {
		//Log.v("test","yraaaaaaaaab");
	}
 
	public ArrayList<OfficeHoursModel> SelectAllOffice(String staffID,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		OfficeService c = new OfficeService(ctx);
		c.execute("http://10.0.2.2/webapp/SelectOfficeHourseTA.php","selectOffice",staffID);
		String result = c.get();
        //Log.v("alaaaaaaaa",result);
        JSONArray jArray=new JSONArray(result);
        String name="";
        String time="";
        String day="";
        ArrayList<OfficeHoursModel> office = new ArrayList<OfficeHoursModel>();
       
        for(int i=0;i<jArray.length();i++)
        {
           JSONObject object=jArray.getJSONObject(i);
           name=object.getString("staff_name");
           time=object.getString("staff_time");
           day=object.getString("staff_day") ;
          // Log.v("test",id);
           office.add(new OfficeHoursModel(name,day,time));
        }
       
        return office;
	}
	
	public ArrayList<String> SelectDepart(String staffID,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		OfficeService c = new OfficeService(ctx);
		c.execute("http://10.0.2.2/webapp/SelectDepartmentOFStaff.php","selectStaffDep",staffID);
		String result = c.get();
        JSONArray jArray=new JSONArray(result);
        String name="";
        String dep="";
        String typ="";
        
        ArrayList<String> staff = new ArrayList<String>();
       
        for(int i=0;i<jArray.length();i++)
        {
           JSONObject object=jArray.getJSONObject(i);
           name=object.getString("name");
           dep=object.getString("dept");
           typ=object.getString("type");
           staff.add(name);
           staff.add(dep);
           staff.add(typ);
        }
       
        return staff;
	}
	
	public void AddOffice(String Time,String Day,String ID,String name,String Dep,String typ,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		OfficeService c = new OfficeService(ctx);
		c.execute("http://10.0.2.2/webapp/InsertOfficeHours.php","addoffice",Time,Day,ID,name,Dep,typ);
		String result = c.get() ;
		Log.v("adddddddd",result);
	}
	
	public void UpdateOffice(String oldTime,String oldDay,String newTime,String newDay
			,String ID,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		OfficeService c = new OfficeService(ctx);
		Log.v("here cont","2");
		c.execute("http://10.0.2.2/webapp/updateSelectedOffice.php","updateoffice",oldTime,oldDay,newTime,newDay,ID);
		String result = c.get();
		Log.v("adddddddd",result);
		Log.v("here cont","2");
	}
	
	public void deleteOffice(String Time,String Day,String ID,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		OfficeService c = new OfficeService(ctx);
		c.execute("http://10.0.2.2/webapp/deletOfficeHoure.php","delete",Time,Day,ID);
		String result = c.get() ;
		//Log.v("adddddddd",result);
	}

}
