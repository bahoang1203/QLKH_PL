package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAL.Course;
import DAL.CourseDAL;

public class CourseBLL {
	CourseDAL cDAL = new CourseDAL();
	public List LoadCourse(int page) throws SQLException {
        ArrayList list = cDAL.readCourse();
        int numofrecords = list.size();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
    }
	public int addCourse(Course c) throws SQLException{
		int result = cDAL.insertCourse(c);
		return result;
	}
	public int updCourse(Course c) throws SQLException{
		int result = cDAL.updateCourse(c);
		return result;
	}
	public int delCourse(Course c) throws SQLException{
		int result = cDAL.deleteCourse(c);
		return result;
	}
}
