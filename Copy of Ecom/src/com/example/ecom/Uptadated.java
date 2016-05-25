package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.OfficeHoursModel;

import org.json.JSONException;

import controller.AddOfficeController;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Uptadated extends Activity {
	TextView tv1;
	TextView tv2;
	EditText day;
	EditText time;
	Button updateButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uptadated);
		final OfficeHoursModel office =  (OfficeHoursModel) getIntent().getSerializableExtra("update");
		final ArrayList<OfficeHoursModel> allOff = (ArrayList<OfficeHoursModel>) getIntent().getSerializableExtra("office");
		final String id = getIntent().getStringExtra("id");
		
		day = (EditText)findViewById(R.id.editText1);
		time = (EditText)findViewById(R.id.editText2);
		updateButton = (Button)findViewById(R.id.button1);
		
		final String oldTime = office.getTime();
	    final String oldDay = office.getDay();
	    
		updateButton.setOnClickListener(
		    	new View.OnClickListener() {
			        public void onClick(View view) {
			        	
			        	try {
			        		
			        		String upDay = day.getText().toString();
				        	String upTime = time.getText().toString();
				        	Log.v("upDay= ",upDay);
				        	Log.v("upTime= ",upTime);
				        	
				        	Log.v("id= ",id);
				        	
				    	    Log.v("oldTime= ",oldTime);
				        	Log.v("oldDay= ",oldDay);
				        	
				        	
				        	
				        	AddOfficeController of =new AddOfficeController();
				        	
							of.UpdateOffice(oldTime, oldDay, upTime, upDay, id, Uptadated.this);
							
							
							
							Toast.makeText(Uptadated.this,"DONE", Toast.LENGTH_SHORT).show();
							
							for(int i=0;i<allOff.size();i++)
							{
								if(allOff.get(i).getDay().equals(office.getDay())&& 
										allOff.get(i).getTime().equals(office.getTime()))
								{
									allOff.get(i).setDay(upDay);
									allOff.get(i).setTime(upTime);
								}
							}
							
							Intent k = new Intent(Uptadated.this,UpdateOfficeHours.class) ;
							   k.putExtra("ID", id);
							   k.putExtra("office", allOff);
							   startActivity(k);
							   
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						  
			        }
			    });
	}

	

}
