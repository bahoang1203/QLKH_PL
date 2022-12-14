package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAL.OnlineCourse;
import DAL.OnlineCourseDAL;

public class OnlineCourseBLL {
	OnlineCourseDAL OlCDAL = new OnlineCourseDAL();
	public List loadOlC(int page) throws SQLException{
		int numofrecords = 30;
		ArrayList list = OlCDAL.readOnlineCourse();
		int size = list.size();
		int from, to; 
		from =(page - 1) *numofrecords;
		to = page * numofrecords;
		return list.subList(from, Math.min(to, size));
	}
	public int addOlC(OnlineCourse OlC) throws SQLException{
		int result = OlCDAL.insertOnlineCourse(OlC);
		return result;
	}
	public int updateOlC(OnlineCourse OlC) throws SQLException{
		int result = OlCDAL.updateOnlineCourses(OlC);
		return result;
	}
	public int delOlC(OnlineCourse OlC) throws SQLException{
		int result = OlCDAL.deleteOnlineCourse(OlC);
		return result;
	}	
	public List findOlC(String title) throws SQLException{
		List list = new ArrayList();
		list = OlCDAL.findOnlineCourse(title);
		return list;
	}
	public List load1banOlC (int courseid) throws SQLException{
		List list = new ArrayList();
		list = OlCDAL.load1recordOlC(courseid);
		return list;
	}
	
}
