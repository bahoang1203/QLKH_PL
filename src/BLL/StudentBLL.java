package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAL.StudentDAL;

public class StudentBLL {
	StudentDAL stdDal = new StudentDAL();
	public List LoadStudents(int page) throws SQLException{
		int numofrecords = 30;
		ArrayList list = stdDal.readStudents();
		int size = list.size();
		int from, to; 
		from =(page - 1) *numofrecords;
		to = page * numofrecords;
		return list.subList(from, Math.min(to, size));
	}
}
