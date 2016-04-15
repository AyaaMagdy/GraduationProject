package com.example.ecom;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class TATableActivity extends TabActivity {
	
	TabHost mTabHost ;
	
	String TAEmail="n.abdelhameed";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tatable);
		  mTabHost= getTabHost();
		    mTabHost.addTab(mTabHost.newTabSpec("Saturday").setIndicator("Saturday").setContent(new Intent(this ,TASaturdayActivity.class)));
		    mTabHost.addTab(mTabHost.newTabSpec("Sunday").setIndicator("Sunday").setContent(new Intent(this ,TASundayActivity.class )));
		    mTabHost.addTab(mTabHost.newTabSpec("Monday").setIndicator("Monday").setContent(new Intent(this , TAMondayActivity.class )));
		    mTabHost.addTab(mTabHost.newTabSpec("Tuesday").setIndicator("Tuesday").setContent(new Intent(this , TATuesdayActivity.class )));
		    mTabHost.addTab(mTabHost.newTabSpec("Wednesday").setIndicator("Wednesday").setContent(new Intent(this , TAWednesdayActivity.class )));
		    mTabHost.addTab(mTabHost.newTabSpec("Thursday").setIndicator("Thursday").setContent(new Intent(this , TAThursdayActivity.class )));
		    mTabHost.setCurrentTab(0);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tatable, menu);
		return true;
	}

}
