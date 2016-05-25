package com.example.ecom;

import java.util.ArrayList;

import model.Courses;
import model.TableModel;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_day);
		LinearLayout Relative;
        Relative=(LinearLayout)findViewById(R.id.S_Relative);
        ArrayList<TableModel> getResult=(ArrayList<TableModel>) getIntent().getSerializableExtra("DayTable");
       Log.v("ffff",getResult.toString());
       for(int i=0;i<getResult.size();i++)
       {
              
           TextView Mytext=new TextView(this);
           Mytext.setText(getResult.get(i).getTime()+"\n"+getResult.get(i).getCourseName()+"\n"+getResult.get(i).getPlace());
           RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(200, ViewGroup.LayoutParams.WRAP_CONTENT);
           Mytext.setLayoutParams(params);
           LinearLayout Liner=new LinearLayout(this);
           Liner.setOrientation(LinearLayout.HORIZONTAL);
        
           Liner.addView(Mytext);
           LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,200);

                   Liner.setLayoutParams(p);

           Relative.addView(Liner);
       }
       Log.v("test","for end");
	     
	}


}
