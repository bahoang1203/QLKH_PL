package DAL;


import java.sql.Time;

public class OnsiteCourse extends Course{
	
	String Location;
	String Days;
	String time;
	
	public OnsiteCourse(int courseID, String title, int credits, int departmentID, String location, String days, String time) {
		super(courseID, title, credits, departmentID);
		Location = location;
		Days = days;
		this.time = time;
	}
	public OnsiteCourse() {
		// TODO Auto-generated constructor stub
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getDays() {
		return Days;
	}
	public void setDays(String days) {
		Days = days;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String t) {
		this.time = t;
	}
	
}
