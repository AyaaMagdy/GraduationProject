package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.OfficeHoursModel;

import org.json.JSONException;

import controller.AddOfficeController;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteOffice extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete_office);
		
		final ArrayList<OfficeHoursModel> office = (ArrayList<OfficeHoursModel>) getIntent().getSerializableExtra("office");
		final String id = getIntent().getStringExtra("ID");
		//final String name = getIntent().getStringExtra("name");
		
		 
		 for (int i = 0; i < office.size(); i++)
		  {
			 LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);
			 LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
			            LinearLayout.LayoutParams.WRAP_CONTENT,
			            LinearLayout.LayoutParams.WRAP_CONTENT);
			 
			 TextView tvs1 = new TextView(this);
		     tvs1.setText("");
		     tvs1.setId(i*200);
		     //tvs1.setBackgroundColor(Color.rgb(100, 100, 30));
		     ll.addView(tvs1);
		     
			 TextView t = new TextView(this);
		     t.setText("Day:");
		     t.setId(i*200);
		     //t.setBackgroundColor(Color.rgb(100, 100, 30));
		     ll.addView(t);
		     
		     TextView tv = new TextView(this);
		     //ed = new EditText(UpdateOfficeHours.this);
		     tv.setText(office.get(i).getDay().toString());
		     tv.setId(i);
		     tv.setBackgroundColor(Color.rgb(50, 100, 90));
		     /*ed.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
		             LayoutParams.WRAP_CONTENT));
		     allDay.add(ed);*/
		     ll.addView(tv);
		    
		     TextView tt = new TextView(this);
		     tt.setText("Time");
		     tt.setId(i*200);
		     //tt.setBackgroundColor(Color.rgb(100, 100, 30));
		     ll.addView(tt);
		     
		     
		     TextView tv2 = new TextView(this);
		    // ed2 = new EditText(UpdateOfficeHours.this);
		     tv2.setText(office.get(i).getTime().toString());
		    // tv2.setMovementMethod(LinkMovementMethod.getInstance());
		     tv2.setId(i*100);
		     tv2.setBackgroundColor(Color.rgb(150, 50, 90));
		     /*ed2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
		             LayoutParams.WRAP_CONTENT));
		     allTime.add(ed2);*/
		     ll.addView(tv2);
		     
		     TextView tvv = new TextView(this);
		     tvv.setText("");
		     tvv.setId(i*200);
		     ll.addView(tvv);
		    
		     
		     LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
			            LinearLayout.LayoutParams.WRAP_CONTENT,
			            LinearLayout.LayoutParams.WRAP_CONTENT);
		        final Button btn = new Button(this);
			    btn.setId(i*9);
			    final int id_ = btn.getId();
			    Log.v("aaaa", id_+" "+i);
			    btn.setText("Delete");
			    btn.setBackgroundColor(Color.rgb(200, 10, 90));
			    //LinearLayout linear = (LinearLayout)findViewById(R.id.buttonlayout);
			    ll.addView(btn,param);
				
			    final int indx= i; 
			   /* Log.v("aaaa", indx+"");*/
			   btn.setOnClickListener(
			    	new View.OnClickListener() {
			        public void onClick(View view) {
						try {
							Log.v("del time",office.get(indx).getTime());
							Log.v("del day",office.get(indx).getDay());
							AddOfficeController of = new AddOfficeController();
							of.deleteOffice(office.get(indx).getTime(), office.get(indx).getDay(), id, DeleteOffice.this);
							Toast.makeText(DeleteOffice.this,"DONE", Toast.LENGTH_SHORT).show();
							Intent k = new Intent(DeleteOffice.this,MainActivity.class);
							  // k.putExtra("update",office.get(indx));
							   //k.putExtra("id", id);
							   //k.putExtra("office", office);
							   //Log.v("jjjjj", office.get(indx).getTime().toString());
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

	
}
