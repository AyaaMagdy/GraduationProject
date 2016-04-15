package com.example.ecom;

import org.json.JSONException;

import controller.LoginController;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class StudentLoginActivity extends Activity {

	 String s="",s2="";
	 SharedPreferences sharedpreferences;
	 public static final String MyPREFERENCES = "MyPrefs" ;
	 static Context ctx;
	 private CheckBox saveLoginCheckBox;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentLoginActivity.ctx = getApplicationContext();
        setContentView(R.layout.activity_student_login);  
        
   	 EditText mytext=(EditText)findViewById(R.id.ID);
     EditText mytext2=(EditText)findViewById(R.id.Password);
     SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
     
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
        return StudentLoginActivity.ctx;
    }
   

    public void Add(View v) throws JSONException {
    	
    	 EditText mytext=(EditText)findViewById(R.id.ID);
         EditText mytext2=(EditText)findViewById(R.id.Password);
         s=mytext.getText().toString();
         s2=mytext2.getText().toString();
   
         LoginController j=new LoginController();
         Log.v("test", "Before");
         j.insert_Person(s,s2,this);
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
