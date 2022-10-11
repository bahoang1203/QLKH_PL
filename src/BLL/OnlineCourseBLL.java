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
}
