package model;

import java.io.Serializable;

public class OfficeHoursModel implements Serializable
{
	 public OfficeHoursModel() {
		
		
	}
	String name;
	 String day;
	 String time;
	 String flag;

	 public OfficeHoursModel(String name,String day,String time) {
		 this.name=name;
		 this.day=day;
		 this.time=time;
		
	}
	public String getName() {
		return name;
	}

	public  void setName(String n) {
		name = n;
	}

	public String getDay() {
		return day;
	}

	public  void setDay(String d) {
		day = d;
	}

	public String getTime() {
		return time;
	}

	public  void setTime(String t) {
		time = t;
	}
	public String getFlag() {
		return flag;
	}public void setFlag(String flag) {
		this.flag = flag;
	}
	

}
