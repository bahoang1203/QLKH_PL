package DAL;

import java.math.BigDecimal;

public class Ketqua {
	int courseID, studentID, enrollmentID;
	BigDecimal grade;
	String Result;
	public Ketqua () {
		
	}
	public Ketqua (int enrollmentID, int courseID, int studentID, BigDecimal grade, String Result) {
		this.enrollmentID = enrollmentID;
		this.courseID = courseID;
		this.studentID = studentID;
		this.grade = grade;
		this.Result = Result;
	}
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal bigDecimal) {
		this.grade = bigDecimal;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public int getEnrollmentID() {
		return enrollmentID;
	}
	public void setEnrollmentID(int enrollmentID) {
		this.enrollmentID = enrollmentID;
	}
	
}
