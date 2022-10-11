package BLL;

import java.sql.SQLException;

import DAL.Course;
import DAL.CourseDAL;

public class CourseBLL {
	CourseDAL cDAL = new CourseDAL();
	public int addCourse(Course c) throws SQLException{
		int result = cDAL.insertCourse(c);
		return result;
	}
}
