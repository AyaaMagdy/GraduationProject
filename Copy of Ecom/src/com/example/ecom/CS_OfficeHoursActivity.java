package com.example.ecom;

import java.util.ArrayList;
import org.json.JSONException;

import controller.OfficeHoursContoller;
import model.OfficeHoursModel;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CS_OfficeHoursActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cs_office_hours);
		OfficeHoursContoller officeHourseObject= new OfficeHoursContoller();
		OfficeHoursModel officeHours = new OfficeHoursModel();
	
		try{
	    ArrayList<OfficeHoursModel> officeHoursList= officeHourseObject.getOfficeHours("CS",this);
	    ArrayList<OfficeHoursModel> TAOfficeHoursList= new ArrayList<OfficeHoursModel>();
	    Log.v("SIZE",officeHoursList.size()+"");
	    Log.v("DATA",officeHoursList.get(2).getFlag().toString());
	    
		TableLayout attTable = (TableLayout)findViewById(R.id.tblTrans);
		attTable.setStretchAllColumns(true);
		attTable.bringToFront();
		for(int i=0;i<officeHoursList.size();i++)
		{        
			 
			   
		         if(officeHoursList.get(i).getFlag().toString().equals("TA"))
		         {
		        	 Log.v("helloooo","******");
		        	 officeHours.setDay(officeHoursList.get(i).getDay());
		        	 officeHours.setName(officeHoursList.get(i).getName());
		        	 officeHours.setTime(officeHoursList.get(i).getTime());
		        	 TAOfficeHoursList.add(officeHours);
		        	 continue;
		         }
		         TableRow tr =  new TableRow(this);
	    	     //tr.setClickable(true);  //allows you to select a specific row
	    	     TextView col1 = new TextView(this);
		         TextView col2 = new TextView(this);
		         TextView col3 = new TextView(this);
		         col1.setText(officeHoursList.get(i).getFlag().toString()+" "+officeHoursList.get(i).getName().toString());
		         col2.setText("      "+officeHoursList.get(i).getTime().toString());
		         col3.setText("      "+officeHoursList.get(i).getDay().toString());
		         tr.addView(col1);
		         tr.addView(col2);
		         tr.addView(col3);
		         attTable.addView(tr);
		}
		Log.v("TA",TAOfficeHoursList.size()+"");
		for(int i=0;i< TAOfficeHoursList.size();i++)
		{        
			 Log.v("hello","******");
			     Log.v("i",i+"");
			     TableRow tr =  new TableRow(this);
	    
	    	     TextView col1 = new TextView(this);
		         TextView col2 = new TextView(this);
		         TextView col3 = new TextView(this);
		        
		         col1.setText("TA"+" "+officeHoursList.get(i).getName().toString());
		         col2.setText("      "+officeHoursList.get(i).getTime().toString());
		         col3.setText("      "+officeHoursList.get(i).getDay().toString());
		         tr.addView(col1);
		         tr.addView(col2);
		         tr.addView(col3);
		         attTable.addView(tr);
		         
		}
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cs__office_hours, menu);
		return true;
	}

}
