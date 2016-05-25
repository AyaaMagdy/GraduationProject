package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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

public class AddNewOffice extends Activity {
TextView tv1;
TextView tv2;
EditText day;
EditText time;
Button addButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_office);
		Log.v("alaa","11");
		day = (EditText)findViewById(R.id.editText1);
		time = (EditText)findViewById(R.id.editText2);
		addButton = (Button)findViewById(R.id.button1);
		Log.v("alaa","12");
		
		
			addButton.setOnClickListener(
			    	new View.OnClickListener() {
				        public void onClick(View view) {
				        	String id = getIntent().getStringExtra("ID");
				    	    AddOfficeController add = new AddOfficeController();
				        	ArrayList<String> depAndName;
							try {
								depAndName = add.SelectDepart(id, AddNewOffice.this);
								String dep = depAndName.get(1);
								String name= depAndName.get(0);
								String typ= depAndName.get(2);
								String getTime = time.getText().toString();
								String getDay =day.getText().toString(); 
								if(getTime.equals("")|| getDay.equals("")){
									Toast.makeText(AddNewOffice.this,"Please Enter Time or Day ..." , Toast.LENGTH_SHORT).show();
								}else{
								add.AddOffice(getTime, getDay, id, name, dep, typ, AddNewOffice.this);
								Log.v("name",name);
								Log.v("dep",dep);
								Toast.makeText(AddNewOffice.this,"DONE ... " , Toast.LENGTH_SHORT).show();
								Intent k = new Intent(AddNewOffice.this,MainActivity.class);
								   //k.putExtra("ID", id);
								  // k.putExtra("name", name);
								startActivity(k);}
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
