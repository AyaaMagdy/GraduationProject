package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import controller.TableController;

import model.GradeModel;
import model.TableModel;
import controller.FinalGradesJParser;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TableActivity extends Activity  {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
 
        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
 
        String[] items = new String[] {"Choose Day","Saturday", "Sunday", "Monday","Tuesday","Wednesday","Thursday" };
 
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
 
        dynamicSpinner.setAdapter(adapter);
 
        dynamicSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
            	  ArrayList<String> result = null;
                  ArrayList<TableModel>tableList=new ArrayList<TableModel>();
                Log.v("item", (String) parent.getItemAtPosition(position));
                String day=(String) parent.getItemAtPosition(position);
                SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                //String id="",pass="";
               String studentId=sharedpreferences.getString("ID","empty");
               Log.v("testID", studentId);
               TableController t=new TableController();
               Log.v("test", "Before");
             
			try {
				result = t.getCoursesAndGroups(studentId,TableActivity.this);
				  Log.v("test", "Afteer");
				  Log.v("testttt", result.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
               ////Log.v("0",result.get(0).toString());
              // Log.v("1",result.get(1).toString());
               if(day.equals("Saturday"))
                {
            	   
            	   String url="http://10.0.2.2/ecom/saturday.php";
            	     String  method="dayTable";
                	try {
                		tableList=t.getTable(result, TableActivity.this,url,method);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	Intent in = new Intent(TableActivity.this,DayActivity.class);
	               	in.putExtra("DayTable", tableList);
	               	startActivity(in);
                	
                }
               
               if(day.equals("Sunday"))
               {
           	   String url="http://10.0.2.2/ecom/sunday.php";
           	     String  method="dayTable";
               	try {
               		tableList=t.getTable(result, TableActivity.this,url,method);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		               	Intent in = new Intent(TableActivity.this,DayActivity.class);
		               	in.putExtra("DayTable", tableList);
		               	startActivity(in);
               	
               }
               if(day.equals("Monday"))
               {
           	   String url="http://10.0.2.2/ecom/monday.php";
           	     String  method="dayTable";
               	try {
               		tableList=t.getTable(result, TableActivity.this,url,method);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		               	Intent in = new Intent(TableActivity.this,DayActivity.class);
		               	in.putExtra("DayTable", tableList);
		               	startActivity(in);
               }
               if(day.equals("Tuesday"))
               {
           	   String url="http://10.0.2.2/ecom/tuesday.php";
           	     String  method="dayTable";
               	try {
               		tableList=t.getTable(result, TableActivity.this,url,method);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		               	Intent in = new Intent(TableActivity.this,DayActivity.class);
		               	in.putExtra("DayTable", tableList);
		               	startActivity(in);
               	
               }
               if(day.equals("Wednesday"))
               {
           	   String url="http://10.0.2.2/ecom/wed.php";
           	     String  method="dayTable";
               	try {
               		tableList=t.getTable(result, TableActivity.this,url,method);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		               	Intent in = new Intent(TableActivity.this,DayActivity.class);
		               	in.putExtra("DayTable", tableList);
		               	startActivity(in);
               }
               if(day.equals("Thursday"))
               {
           	   String url="http://10.0.2.2/ecom/thursday.php";
           	     String  method="dayTable";
               	try {
               		tableList=t.getTable(result, TableActivity.this,url,method);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		               	Intent in = new Intent(TableActivity.this,DayActivity.class);
		               	in.putExtra("DayTable", tableList);
		               	startActivity(in);
		               	
               }
               
               
               
              	
            }
            
 
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
}
	


