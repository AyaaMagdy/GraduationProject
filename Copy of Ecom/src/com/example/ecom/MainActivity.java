package com.example.ecom;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
public class MainActivity extends Activity {
	
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  }
  
  public void student(View v )
  {
	  Intent mIntent=new Intent(MainActivity.this ,StudentLoginActivity.class);
	  startActivity(mIntent);
  }
  public void teacherAssistant(View v )
  {
	  Intent mIntent=new Intent(MainActivity.this ,StuffLoginActivity.class);
	  startActivity(mIntent); 
  }
  public void exit(View v )
  {
  	moveTaskToBack(true);
  	android.os.Process.killProcess(android.os.Process.myPid());
      System.exit(1);
  }
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }
    
}
