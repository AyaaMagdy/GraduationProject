package com.example.ecom;

import java.util.ArrayList;

import model.OfficeHoursModel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddOffice extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_office);
		
		ArrayList<OfficeHoursModel> office = (ArrayList<OfficeHoursModel>) getIntent().getSerializableExtra("office");
		final String id = getIntent().getStringExtra("ID");
		//final String name = getIntent().getStringExtra("name");
		LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);
		 
		 LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
		            LinearLayout.LayoutParams.WRAP_CONTENT,
		            LinearLayout.LayoutParams.WRAP_CONTENT);
		 
		   

		 for (int i = 0; i < office.size(); i++)
		  {
			 TextView tvs1 = new TextView(this);
		     tvs1.setText("");
		     tvs1.setId(i*200);
		     //tvs1.setBackgroundColor(Color.rgb(100, 100, 30));
		     ll.addView(tvs1);
		     
		     TextView tv = new TextView(this);
		     tv.setText("Day:   " + office.get(i).getDay().toString());
		     tv.setId(i );
		     tv.setBackgroundColor(Color.rgb(50, 100, 90));
		     ll.addView(tv);
		    
		     TextView tv2 = new TextView(this);
		     tv2.setText("Time:   " + office.get(i).getTime().toString());
		    // tv2.setMovementMethod(LinkMovementMethod.getInstance());
		     tv2.setId(i*100);
		     tv2.setBackgroundColor(Color.rgb(150, 50, 90));
		     ll.addView(tv2);
		     
		 }
		 TextView tvs1 = new TextView(this);
	     tvs1.setText("");
	     tvs1.setId(2*200);
	     //tvs1.setBackgroundColor(Color.rgb(100, 100, 30));
	     ll.addView(tvs1);
	     
		 Button btn = new Button(this);
		    btn.setId(50000);
		    int id_ = btn.getId();
		    btn.setText("Add office Hours");
		    btn.setBackgroundColor(Color.rgb(100, 100, 90));
		    
		    LinearLayout linear = (LinearLayout)findViewById(R.id.buttonlayout);
			ll.addView(btn, params);
			Log.v("alaa","1");
			Button btn1 = ((Button) findViewById(id_));
			Log.v("alaa","2");
			
			Log.v("alaa","3");
		    btn1.setOnClickListener(
		    	new View.OnClickListener() {
		        public void onClick(View view) {
		        	Log.v("alaa","4");
					   Intent k = new Intent(AddOffice.this,AddNewOffice.class);
					   k.putExtra("ID", id);
					   Log.v("alaa",id);
					  // k.putExtra("name", name);
					   startActivity(k);
		        }
		    });
		    
		    
	}

	

}
