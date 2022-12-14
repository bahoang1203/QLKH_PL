package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OnsiteCourseDAL extends MyDatabaseManager {
	public OnsiteCourseDAL(){
		super();
		this.connectDB();
	}
	public ArrayList<OnsiteCourse> readOnsiteCourse()throws SQLException{
		String query = "SELECT `course`.`CourseID`,`Title`,`Credits`,`DepartmentID`,`Location`,`Days`,`Time` FROM `course`,`onsitecourse` WHERE `onsitecourse`.`CourseID` = `course`.`CourseID`;";
		ResultSet rs= this.doReadQuery(query);
		ArrayList<OnsiteCourse> list = new ArrayList<>();
		if(rs!=null) {
			while(rs.next()) {
				OnsiteCourse OsC = new OnsiteCourse();
				OsC.setCourseID(rs.getInt("CourseID"));
				OsC.setTitle(rs.getString("Title"));
				OsC.setCredits(rs.getInt("Credits"));
				OsC.setDepartmentID(rs.getInt("DepartmentID"));
				OsC.setLocation(rs.getString("Location"));
				OsC.setDays(rs.getString("Days"));
				OsC.setTime(rs.getString("Time"));
				list.add(OsC);
			}
		}
		return list;
	}
	public int updateOnsiteCourses(OnsiteCourse OsC) throws SQLException{
		String query = "Update OnsiteCourse Set Location = ?, Days = ?, Time = ? where CourseID = ?";
		PreparedStatement p = c.prepareStatement(query);
		p.setString(1, OsC.getLocation());
		p.setString(2, OsC.getDays().toString());
		p.setString(3, OsC.getTime().toString());
		p.setInt(4, OsC.getCourseID());
		int result = p.executeUpdate();
		return result;
	}
	public int insertOnsiteCourses(OnsiteCourse OsC) throws SQLException{
		String query = "Insert OnsiteCourse (CourseID, Location, Days, Time) Value (?,?,?,?)";
		PreparedStatement p = c.prepareStatement(query);
		p.setInt(1, OsC.getCourseID());
		p.setString(2, OsC.getLocation());
		p.setString(3, OsC.getDays());
		p.setString(4, OsC.getTime());
		int result = p.executeUpdate();
		return result;
	}
	public int deleteOnsiteCourse(OnsiteCourse OlC) throws SQLException{
		String query = "Delete from OnsiteCourse where CourseID = ?";
		PreparedStatement p = c.prepareStatement(query);
		p.setInt(1, OlC.getCourseID());
		int result = p.executeUpdate();
		return result;
	}
	public List<OnsiteCourse> findOnsiteCourse(String title) throws SQLException{
		String query = "SELECT `course`.`CourseID`,`Title`,`Credits`,`DepartmentID`,`Location`,`Days`,`Time` FROM `course`,`onsitecourse` WHERE `onsitecourse`.`CourseID` = `course`.`CourseID` and `course`.`Title`= ? ;";
		PreparedStatement p = c.prepareStatement(query);
		p.setString(1, title);
		ResultSet rs = p.executeQuery();
		List<OnsiteCourse> list = new ArrayList<>();
		if(rs!=null) {
			//int i =1;
			while(rs.next()) {
				OnsiteCourse OsC = new OnsiteCourse();
				OsC.setCourseID(rs.getInt("CourseID"));
				OsC.setTitle(rs.getString("Title"));
				OsC.setCredits(rs.getInt("Credits"));
				OsC.setDepartmentID(rs.getInt("DepartmentID"));
				OsC.setLocation(rs.getString("Location"));
				OsC.setDays(rs.getString("Days"));
				OsC.setTime(rs.getString("Time"));
				list.add(OsC);
			}
		}
		return list;
	}
	public List<OnsiteCourse> load1recordOsC(int courseid) throws SQLException{
		String query = "SELECT `course`.`CourseID`,`Title`,`Credits`,`DepartmentID`,`Location`,`Days`,`Time` FROM `course`,`onsitecourse` WHERE `onsitecourse`.`CourseID` = `course`.`CourseID`  and `course`.`CourseID` = ?;";
		PreparedStatement p =c.prepareStatement(query);
		p.setInt(1, courseid);		
		ResultSet rs = p.executeQuery();
		List <OnsiteCourse> list = new ArrayList<>();
		if(rs!=null) {
			while(rs.next()) {
				OnsiteCourse OsC = new OnsiteCourse();
				OsC.setCourseID(rs.getInt("CourseID"));
				OsC.setTitle(rs.getString("Title"));
				OsC.setCredits(rs.getInt("Credits"));
				OsC.setDepartmentID(rs.getInt("DepartmentID"));
				OsC.setLocation(rs.getString("Location"));
				OsC.setDays(rs.getString("Days"));
				OsC.setTime(rs.getString("Time"));
				list.add(OsC);
			}
		}		
		return list;
	}
}
