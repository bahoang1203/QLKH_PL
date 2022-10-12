package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAL.OnsiteCourse;
import DAL.OnsiteCourseDAL;

public class OnsiteCourseBLL {
	OnsiteCourseDAL OsCDAL = new OnsiteCourseDAL();	
	public List loadOsC(int page) throws SQLException{
		int numofrecords = 30;
		ArrayList list = OsCDAL.readOnsiteCourse();
		int size = list.size();
		int from, to; 
		from =(page - 1) *numofrecords;
		to = page * numofrecords;
		return list.subList(from, Math.min(to, size));
	}
	public int addOsC(OnsiteCourse OsC) throws SQLException{
		int result = OsCDAL.insertOnsiteCourses(OsC);
		return result;
	}
	public int updateOsC(OnsiteCourse OsC) throws SQLException{
		int result = OsCDAL.updateOnsiteCourses(OsC);
		return result;
	}
	public int delOsC(OnsiteCourse OsC) throws SQLException{
		int result = OsCDAL.deleteOnsiteCourse(OsC);
		return result;
	}
	public List findOsC(String title) throws SQLException{
		List list = new ArrayList();
		list = OsCDAL.findOnsiteCourse(title);
		return list;
	}
	public List load1banOsC(int courseid) throws SQLException{
		List list = new ArrayList();
		list = OsCDAL.load1recordOsC(courseid);
		return list;
	}
}
