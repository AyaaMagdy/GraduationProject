package controller;

import org.json.JSONException;

import services.LoginService;
import services.StaffLoginService;
import android.content.Context;
import android.util.Log;

public class StaffLoginController 
{
	  public void checkLogin(String ID,String Password,Context ctx) throws JSONException
	    {
	        StaffLoginService c=new StaffLoginService(ctx);
	        Log.v("test","StartJson");
	        c.execute("http://10.0.2.2/ecom/stafflogin.php",ID,Password);
	     
	        Log.v("test","FinishJson");
	        
	     
	    }

}
