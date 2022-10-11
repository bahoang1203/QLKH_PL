package DAL;

public class OnlineCourse {
	int CourseID;
	String url;
	String Title;
	int Credits;
	int DepartmentID;
	
	public OnlineCourse(int courseID, String url, String title, int credits, int departmentID) {
		super();
		this.CourseID = courseID;
		this.url = url;
		this.Title = title;
		this.Credits = credits;
		this.DepartmentID = departmentID;
	}
	
	
	public OnlineCourse() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
