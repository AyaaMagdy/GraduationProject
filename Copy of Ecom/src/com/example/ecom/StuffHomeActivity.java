package com.example.ecom;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.OfficeHoursModel;

import org.json.JSONException;

import controller.AddOfficeController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StuffHomeActivity extends Activity {
Button add;
Button update;
Button del;


public void tableFun(View v)
{
	 

	Intent mIntent=new Intent(StuffHomeActivity.this ,StaffTableActivity.class);
	startActivity(mIntent);
	
}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stuff_home);
		final String ID = "2012";
		//final String name = "Ibrahim Farag";
		add = (Button)findViewById(R.id.add);
		update = (Button)findViewById(R.id.update);
		del = (Button)findViewById(R.id.del);
		
		try {
			AddOfficeController offi = new AddOfficeController();
			final ArrayList<OfficeHoursModel> office = offi.SelectAllOffice(ID, StuffHomeActivity.this);
			Log.v("sizeeeeeee = ",office.size()+"");
			add.setOnClickListener(
				    	new View.OnClickListener() {
				        public void onClick(View view) {
							   Intent k = new Intent(StuffHomeActivity.this,AddOffice.class);
							   k.putExtra("office", office);
							   k.putExtra("ID", ID);
							  // k.putExtra("name", name);
							   startActivity(k);
				        }
				    });
		 update.setOnClickListener(
				    	new View.OnClickListener() {
				        public void onClick(View view) {
							   Intent k = new Intent(StuffHomeActivity.this,UpdateOfficeHours.class);
							   k.putExtra("office", office);
							   k.putExtra("ID", ID);
							  // k.putExtra("name", name);
							   startActivity(k);
				        }
				    });
		 
		 del.setOnClickListener(
			    	new View.OnClickListener() {
			        public void onClick(View view) {
						   Intent k = new Intent(StuffHomeActivity.this,DeleteOffice.class);
						   k.putExtra("office", office);
						   k.putExtra("ID", ID);
						  // k.putExtra("name", name);
						   startActivity(k);
			        }
			    });
		
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

	

}
