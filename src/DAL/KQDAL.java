package DAL;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BLL.StudentBLL;


public class KQDAL extends MyDatabaseManager {
	public KQDAL () {
		this.connectDB();
	}
	//lay danh sach
	public ArrayList readKQ () throws SQLException {
		String query = "SELECT * FROM studentgrade";
		ResultSet rs = KQDAL.doReadQuery(query);
		ArrayList list =  new ArrayList();
		
		if (rs != null) {
			int i = 1;
			while (rs.next()) {
				Ketqua kq = new Ketqua();
				kq.setEnrollmentID(rs.getInt("EnrollmentID"));
				kq.setCourseID(rs.getInt("CourseID"));
				kq.setStudentID(rs.getInt("StudentID"));
				kq.setGrade(rs.getBigDecimal("Grade"));
				if (rs.getInt("Grade") <= 1) {
					kq.setResult("D");
				} else if (rs.getInt("Grade") > 1 && rs.getInt("Grade") <= 2 ) {
					kq.setResult("C");
				} else if (rs.getInt("Grade") > 2 && rs.getInt("Grade") <= 3) {
					kq.setResult("B");
				} else if (rs.getInt("Grade") > 3) {
					kq.setResult("A");
				}
				list.add(kq);
			}
		}
		return list;
	}
	//them
	public int insertKQ(Ketqua kq) throws SQLException {
		String query = "INSERT studentgrade (CourseID, StudentID, Grade) VALUES (?,?,?)";
		PreparedStatement p =  c.prepareStatement(query);
		p.setString(1, Integer.toString(kq.getCourseID()));
		p.setString(2, Integer.toString(kq.getStudentID()));
		p.setString(3, kq.getGrade().toString());
		int result =  p.executeUpdate();
		return result;
	}
	
	//lay 1 hang by student id va course id
	public ArrayList read1Record (int cID, int sID) throws SQLException {
		String query = "SELECT * FROM studentgrade WHERE CourseID ='"+cID+"'" + "AND StudentID ='"+sID+"'";
		ResultSet rs = KQDAL.doReadQuery(query);
		ArrayList list =  new ArrayList();
		
		if (rs != null) {
			int i = 1;
			while (rs.next()) {
				Ketqua kq = new Ketqua();
				kq.setEnrollmentID(rs.getInt("EnrollmentID"));
				kq.setCourseID(rs.getInt("CourseID"));
				kq.setStudentID(rs.getInt("StudentID"));
				kq.setGrade(rs.getBigDecimal("Grade"));
				list.add(kq);
			}
		}
		return list;
	}
	//lay 1 hang by enrollmentid
	public ArrayList read1RecordByEnroll (int enrollmentid) throws SQLException {
		String query = "SELECT * FROM studentgrade WHERE EnrollmentID ='"+enrollmentid+"'";
		ResultSet rs = KQDAL.doReadQuery(query);
		ArrayList list =  new ArrayList();
		
		if (rs != null) {
			int i = 1;
			while (rs.next()) {
				Ketqua kq = new Ketqua();
				kq.setEnrollmentID(rs.getInt("EnrollmentID"));
				kq.setCourseID(rs.getInt("CourseID"));
				kq.setStudentID(rs.getInt("StudentID"));
				kq.setGrade(rs.getBigDecimal("Grade"));
				list.add(kq);
			}
		}
		return list;
	}
	//sua
    public int updateKQ(Ketqua kq) throws SQLException {
        String query = "UPDATE `studentgrade` SET `CourseID`=?,`StudentID`= ? ,`Grade`= ? WHERE `EnrollmentID`= ?";
        PreparedStatement p = KQDAL.getConnection().prepareStatement(query);
        p.setInt(1, kq.getCourseID());
        p.setInt(2, kq.getStudentID());
        p.setString (3, kq.getGrade().toString());
        p.setInt(4, kq.getEnrollmentID());
        int result = p.executeUpdate();
        return result;
    }

	//xoa
	public int deletebyCourseID (int cID, int sID ) throws SQLException {
		String query = "Delete From studentgrade Where CourseID = ? AND StudentID =?";
		PreparedStatement p =  c.prepareStatement(query);
		p.setString(1, Integer.toString(cID));
		p.setString(2, Integer.toString(sID));
		int result =  p.executeUpdate();
		return result;
	}
	//tim kiem
	public List findKQbyCourseId (String courseID) throws SQLException {
		String query = "SELECT * FROM studentgrade WHERE CourseID="+courseID;
		ResultSet rs = KQDAL.doReadQuery(query);
		List list = new ArrayList();
		
		if (rs != null) {
			int i = 1;
			
			while (rs.next()) {
				Ketqua kq = new Ketqua();
				kq.setCourseID(rs.getInt("CourseID"));
				kq.setStudentID(rs.getInt("StudentID"));
				kq.setGrade(rs.getBigDecimal("Grade"));
				if (rs.getDouble("Grade") <= 1) {
					kq.setResult("D");
				} else if (rs.getDouble("Grade") > 1 && rs.getInt("Grade") <= 2 ) {
					kq.setResult("C");
				} else if (rs.getDouble("Grade") > 2 && rs.getInt("Grade") <= 3) {
					kq.setResult("B");
				} else if (rs.getDouble("Grade") > 3) {
					kq.setResult("A");
				}
				list.add(kq);
			}
		}
		return list;
	}
	public List findKQbyStudentID (String studentID) throws SQLException {
		String query = "SELECT * FROM studentgrade WHERE StudentID="+studentID;
		ResultSet rs = KQDAL.doReadQuery(query);
		List list = new ArrayList();
		
		if (rs != null) {
			int i = 1;
			
			while (rs.next()) {
				Ketqua kq = new Ketqua();
				kq.setCourseID(rs.getInt("CourseID"));
				kq.setStudentID(rs.getInt("StudentID"));
				kq.setGrade(rs.getBigDecimal("Grade"));
				if (rs.getDouble("Grade") <= 1) {
					kq.setResult("D");
				} else if (rs.getDouble("Grade") > 1 && rs.getInt("Grade") <= 2 ) {
					kq.setResult("C");
				} else if (rs.getDouble("Grade") > 2 && rs.getInt("Grade") <= 3) {
					kq.setResult("B");
				} else if (rs.getDouble("Grade") > 3) {
					kq.setResult("A");
				}
				list.add(kq);
			}
		}
		return list;
	}
	//lay 1 cot, du lieu course Id
	public ArrayList readCourseID () throws SQLException {
		String query = "SELECT CourseID FROM course";
		ResultSet rs = KQDAL.doReadQuery(query);
		ArrayList list =  new ArrayList();
		if (rs != null) {
			int i = 1;
			while (rs.next()) {
				Course course = new Course();
				course.setCourseID(rs.getInt("CourseID"));
				list.add(course);
			}
		}
		return list;
	}
	public ArrayList readStudentID () throws SQLException {
		String query = "SELECT * FROM Person WHERE EnrollmentDate >0";
		ResultSet rs = KQDAL.doReadQuery(query);
		ArrayList list =  new ArrayList();
		if (rs != null) {
			int i = 1;
			while (rs.next()) {
				Student student = new Student ();
				student.setPersonId(rs.getInt("PersonID"));
				list.add(student);
			}
		}
		return list;
	}
}
