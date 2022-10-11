package DAL;


import java.sql.Time;

public class OnsiteCourse {
	int CourseID;
	String Location;
	String Days;
	Time time;
	String Title;
	int Credits;
	int DepartmentID;
	public OnsiteCourse(int courseID, String location, String days, Time time, String title, int credits,
			int departmentID) {
		super();
		this.CourseID = courseID;
		this.Location = location;
		this.Days = days;
		this.time = time;
		this.Title = title;
		this.Credits = credits;
		this.DepartmentID = departmentID;
	}
	public OnsiteCourse() {
		// TODO Auto-generated constructor stub
	}
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int courseID) {
		CourseID = courseID;
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
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getCredits() {
		return Credits;
	}
	public void setCredits(int credits) {
		Credits = credits;
	}
	public int getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}
	
}
