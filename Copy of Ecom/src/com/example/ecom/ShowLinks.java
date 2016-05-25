package com.example.ecom;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.MatrialModel;

import org.json.JSONException;

import controller.TermController;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ShowLinks extends Activity {
	 RatingBar ratingBar ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_links);
		final String courseName = getIntent().getStringExtra("links");
//		 Toast.makeText(ShowLinks.this,
//				 courseName, Toast.LENGTH_SHORT)
//                 .show();
		
	     try {
	    	 
	    	 ArrayList<MatrialModel>MLink = new ArrayList<MatrialModel>();
		     TermController TC2 = new TermController();
			 MLink = TC2.SelectMatrialLinks(courseName, ShowLinks.this);
			 boolean flag = true;
			 
			while(flag){
				 flag = false;
				 for(int i=0; i<MLink.size()-1; i++){
				 
					 if(MLink.get(i).getLikesNum()<MLink.get(i+1).getLikesNum()){
					 
						MatrialModel mm =new MatrialModel(MLink.get(i).getTopicName(), MLink.get(i).getLink()
								, MLink.get(i).getLinkID(), MLink.get(i).getLikesNum());
						
						MLink.get(i).setLikesNum(MLink.get(i+1).getLikesNum());
						MLink.get(i).setLink(MLink.get(i+1).getLink());
						MLink.get(i).setLinkID(MLink.get(i+1).getLinkID());
						MLink.get(i).setTopicName(MLink.get(i+1).getTopicName());
						
						MLink.get(i+1).setLikesNum(mm.getLikesNum());
						MLink.get(i+1).setLink(mm.getLink());
						MLink.get(i+1).setLinkID(mm.getLinkID());
						MLink.get(i+1).setTopicName(mm.getTopicName());
						
						flag =true;
						
					 }
				 }
			 }
			
			 LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);
			 
			 LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
			            LinearLayout.LayoutParams.WRAP_CONTENT,
			            LinearLayout.LayoutParams.WRAP_CONTENT);
			 
			    Button btn = new Button(this);
			    btn.setId(50000);
			    int id_ = btn.getId();
			    btn.setText("Add Links");
			    btn.setBackgroundColor(Color.rgb(200, 100, 90));
			    LinearLayout linear = (LinearLayout)findViewById(R.id.buttonlayout);
				ll.addView(btn, params);
			    Button btn1 = ((Button) findViewById(id_));
				//Toast.makeText(ShowLinks.this,"Button clicked index = " + id_, Toast.LENGTH_SHORT).show();
			    btn1.setOnClickListener(
			    	new View.OnClickListener() {
			        public void onClick(View view) {
						   Intent k = new Intent(ShowLinks.this,AddingLinks.class);
						   k.putExtra("courseName", courseName);
						   startActivity(k);
			        }
			    });
			 CheckBox[] check = new CheckBox[MLink.size()];
			    

			 for (int i = 0; i < MLink.size(); i++)
			  {
				 TextView tvs1 = new TextView(this);
			     tvs1.setText("");
			     tvs1.setId(i*200);
			     ll.addView(tvs1);
			     
			     TextView tv = new TextView(this);
			     tv.setText("Useful Link For " + MLink.get(i).getTopicName().toString());
			     tv.setId(i );
			     ll.addView(tv);
			    
			     TextView tv2 = new TextView(this);
			     String dynamicUrl = MLink.get(i).getLink(); // or whatever you want, it's dynamic
			     String linkedText = String.format("<a href=\"%s\">link</a> ", dynamicUrl) ;
			     tv2.setText(Html.fromHtml(linkedText));
			     tv2.setMovementMethod(LinkMovementMethod.getInstance());
			     tv2.setId(i*100);
			     ll.addView(tv2);
			     
			     TextView tv3 = new TextView(this);
			     tv3.setText("Likes Number --> "+MLink.get(i).getLikesNum()+"");
			     tv3.setId(i*10);
			     ll.addView(tv3);
			     
			     
			     check[i]= new CheckBox(this);
			     ll.addView(check[i]);
			     final String linkID = MLink.get(i).getLinkID();
			     check[i].setOnClickListener(
                          new OnClickListener() {
							@Override
							public void onClick(View arg0) {
								SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
						        String studentId=sharedpreferences.getString("ID","empty");
								
								try {
									//String ID = "20120102" ;
									TermController TC3 = new TermController();
									int count =0;
									count = TC3.SelectLinkLiker(linkID , studentId, ShowLinks.this);
									Log.v("count hwa daaaah",count+"");
									if(count ==0){
										TC3.AddLinkLike(linkID, studentId,  ShowLinks.this);
										TC3.UpdateLinkLike(linkID, ShowLinks.this);
									}
									Toast.makeText(ShowLinks.this, count+"", Toast.LENGTH_SHORT).show();
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
