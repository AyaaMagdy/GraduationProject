package com.example.ecom;

import org.json.JSONException;

import controller.LoginController;
import controller.StaffLoginController;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class StuffLoginActivity extends Activity
{

	 String s="",s2="";
	 SharedPreferences sharedpreferences;
	 public static final String MyPREFERENCES = "StuffPref" ;
	 static Context ctx;
	 private CheckBox saveLoginCheckBox;
	
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       StuffLoginActivity.ctx = getApplicationContext();
       setContentView(R.layout.activity_staff_login);  
       
  	 EditText mytext=(EditText)findViewById(R.id.ID);
    EditText mytext2=(EditText)findViewById(R.id.Password);
    SharedPreferences sharedpreferences = getSharedPreferences("StuffPref", Context.MODE_PRIVATE);
    
    String id="",pass="";
    id=sharedpreferences.getString("ID","empty");
    pass=sharedpreferences.getString("Password","empty");
    if(!id.equals("empty"))
    {
   	 mytext.setText(id);
   	 mytext2.setText(pass);
    }

    
      
   }
   public static  Context getAppContext() {
       return StuffLoginActivity.ctx;
   }
  

   public void staffLogin(View v) throws JSONException {
   	
   	 EditText mytext=(EditText)findViewById(R.id.ID);
        EditText mytext2=(EditText)findViewById(R.id.Password);
        s=mytext.getText().toString();
        s2=mytext2.getText().toString();
  
        StaffLoginController j=new StaffLoginController();
        Log.v("test", "Before");
        j.checkLogin(s,s2,this);
        saveLoginCheckBox=(CheckBox) findViewById(R.id.saveLoginCheckBox);
    	if(saveLoginCheckBox.isChecked())
    	{
    	 sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    	 SharedPreferences.Editor editor = sharedpreferences.edit();
    	 editor.putString("ID",s);
    	 editor.putString("Password", s2);
    	 editor.commit();
    	}

 }

 
}
