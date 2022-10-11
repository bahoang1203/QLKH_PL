package DAL;

public class Course {
	int CourseID;
	String Title;
	int Credits, DepartmentID;
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int courseID) {
		CourseID = courseID;
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
	public Course(int courseID, String title, int credits, int departmentID) {
		super();
		CourseID = courseID;
		Title = title;
		Credits = credits;
		DepartmentID = departmentID;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
}
