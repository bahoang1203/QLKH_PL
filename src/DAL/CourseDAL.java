package DAL;

import java.sql.*;
public class CourseDAL extends MyDatabaseManager{
	public static int idvalue = 0;
	public CourseDAL(){
		super();
		this.connectDB();
	}
	public int insertCourse(Course course) throws SQLException{
		String query = "Insert Course (Title, Credits, DepartmentID) VALUE (?,?,?)";
		PreparedStatement p = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		p.setString(1,course.getTitle());
		p.setInt(2, course.getCredits());
		p.setInt(3, course.getDepartmentID());
		int result = p.executeUpdate();
		ResultSet rs = p.getGeneratedKeys();		
		if(rs.next()) {
			idvalue = rs.getInt(1);
		}		
		return result;
		
	}
	public int updateCourse(Course course) throws SQLException{
		String query = "Update Course Set Title = ?, Credits = ?, DepartmentID = ? where courseID = ?";
		PreparedStatement p = c.prepareStatement(query);
		p.setString(1, course.getTitle());
		p.setInt(2, course.getCredits());
		p.setInt(3, course.getDepartmentID());
		p.setInt(4, course.getCourseID());
		int result = p.executeUpdate();
		return result;
	}
	public int deleteCourse(Course course) throws SQLException{
		String query = "Delete from Course where CourseID = ?";
		PreparedStatement p = c.prepareStatement(query);
		p.setInt(1, course.getCourseID());
		int result = p.executeUpdate();
		return result;
	}
}
