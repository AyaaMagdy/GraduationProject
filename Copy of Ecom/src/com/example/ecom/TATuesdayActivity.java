package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.staffTableModel;

import org.json.JSONException;

import controller.staffTableController;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TATuesdayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tatuesday);
		String email="n.abdelhameed";
		String day="tuesday";
		staffTableController staffTAObject= new staffTableController();
		try{
		    ArrayList<staffTableModel> staffTableList=staffTAObject.getStaffTable(email,day,this);
		   // ArrayList<OfficeHoursModel> TAOfficeHoursList= new ArrayList<OfficeHoursModel>();
		    Log.v("SIZE",staffTableList.size()+"");
		    //Log.v("DATA",officeHoursList.get(2).getFlag().toString());
		    
			TableLayout attTable = (TableLayout)findViewById(R.id.tblTrans);
			attTable.setStretchAllColumns(true);
			attTable.bringToFront();
			for(int i=0;i<staffTableList.size();i++)
			{        
				 
				   
			          TableRow tr =  new TableRow(this);
		    	     //tr.setClickable(true);  //allows you to select a specific row
		    	     TextView col1 = new TextView(this);
			         TextView col2 = new TextView(this);
			         TextView col3 = new TextView(this);
			         col1.setText(staffTableList.get(i).getCourseName().toString()+" ");
			         col2.setText("      "+staffTableList.get(i).getPlace().toString());
			         col3.setText("      "+staffTableList.get(i).getSlot().toString());
			 
			         tr.addView(col1);
			         tr.addView(col2);
			         tr.addView(col3);
			         attTable.addView(tr);
			}
			
			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tatuesday, menu);
		return true;
	}

}
