package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.TableModel;

import org.json.JSONException;

import controller.TableController;
import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.AdapterView.OnItemSelectedListener;

public class OfficeHoursActivity extends TabActivity {

	TabHost mTabHost ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_office_hours);
      
	    mTabHost= getTabHost();
	    mTabHost.addTab(mTabHost.newTabSpec("CS").setIndicator("CS").setContent(new Intent(this ,CS_OfficeHoursActivity.class)));
	    mTabHost.addTab(mTabHost.newTabSpec("IS").setIndicator("IS").setContent(new Intent(this ,IS_OfficeHoursActivity.class )));
	    mTabHost.addTab(mTabHost.newTabSpec("DS").setIndicator("DS").setContent(new Intent(this , DS_OfficeHoursActivity.class )));
	    mTabHost.addTab(mTabHost.newTabSpec("IT").setIndicator("IT").setContent(new Intent(this , IT_OfficeHoursActivity.class )));
	    mTabHost.setCurrentTab(0);
	}	
}
	

