package com.example.ecom;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class SecondActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent i1 = new Intent(this , FirstTerm.class ) ;
		i1.putExtra("Year", "two");
		
		Intent i2 = new Intent(this , SecondTerm.class ) ;
		i2.putExtra("Year", "two");
		
	    TabHost mTabHost = getTabHost();
		
	    mTabHost.addTab(mTabHost.newTabSpec("First Term").setIndicator("First Term").setContent(i1));
	    mTabHost.addTab(mTabHost.newTabSpec("Second Term").setIndicator("Second Term").setContent(i2));
	    
	    mTabHost.setCurrentTab(0);
	}



}
