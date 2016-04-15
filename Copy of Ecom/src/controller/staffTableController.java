package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.OfficeHoursModel;
import model.staffTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import services.staffTableService;
import android.content.Context;
import android.util.Log;

public class staffTableController 
{

	public ArrayList<staffTableModel> getStaffTable
	(String email,String day,Context ctx) throws JSONException, InterruptedException, ExecutionException
    {
		ArrayList<staffTableModel>staffTable=new ArrayList<staffTableModel>();
	   staffTableModel staffObject;
	   	   
        staffTableService c=new staffTableService(ctx);
        
     
       Log.v("test","StartJson");
        c.execute("http://10.0.2.2/ecom/staffTable.php",email,day);
        String result = c.get();
        Log.v("test",result);
        JSONArray jArray=new JSONArray(result);
        String courseName="",group="",place="",slot="";
      //  ArrayList<String> staffTable= new ArrayList<String>();     
        for(int i=0;i<jArray.length();i++)
        {
            JSONObject object=jArray.getJSONObject(i);
            staffObject= new staffTableModel();
            courseName=object.getString("course_name");
            group=object.getString("group_no");
            place=object.getString("place");
            slot=object.getString("slot");
            staffObject.setCourseName(courseName);
            staffObject.setGroupNo(group);
            staffObject.setDay(day);
            staffObject.setPlace(place);
            staffObject.setSlot(slot);
           Log.v("testCourseName",courseName);
           
           staffTable.add(staffObject);    
        }
        
       return staffTable; 
    }
	
}
