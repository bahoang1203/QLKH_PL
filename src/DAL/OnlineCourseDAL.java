package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OnlineCourseDAL extends MyDatabaseManager{
	public OnlineCourseDAL(){
		super();
		this.connectDB();
	}
	public ArrayList<OnlineCourse> readOnlineCourse()throws SQLException{
		ArrayList<OnlineCourse> list = new ArrayList<>();
		String query = "SELECT `course`.`CourseID`,`Title`,`Credits`,`DepartmentID`,`url` FROM `course`,`onlinecourse` WHERE `onlinecourse`.`CourseID` = `course`.`CourseID`;";
		ResultSet rs= OnlineCourseDAL.doReadQuery(query);
	
		if(rs!=null) {
			while(rs.next()) {
				OnlineCourse OlC = new OnlineCourse();
				OlC.setCourseID(rs.getInt("CourseID"));
				OlC.setTitle(rs.getString("Title"));
				OlC.setCredits(rs.getInt("Credits"));
				OlC.setDepartmentID(rs.getInt("DepartmentID"));
				OlC.setUrl(rs.getString("url"));
				list.add(OlC);
			}
		}
		return list;
	}
	public int updateOnlineCourses(OnlineCourse OlC) throws SQLException{
		String query = "Update OnlineCourse Set URL = ? where CourseID = ?";
		PreparedStatement p = c.prepareStatement(query);
		p.setString(1, OlC.getUrl());
		p.setInt(2, OlC.getCourseID());
		int result = p.executeUpdate();
		return result;
	}
	
	public int insertOnlineCourse(OnlineCourse OlC) throws SQLException{
		String query = "Insert OnlineCourse (CourseID,URL) Value (?,?)";
		PreparedStatement p = c.prepareStatement(query);
		p.setInt(1, OlC.getCourseID());
		p.setString(2, OlC.getUrl());
		int result = p.executeUpdate();
		return result;
	}
	public int deleteOnlineCourse(OnlineCourse OlC) throws SQLException{
		String query = "Delete from OnlineCourse where CourseID = ?";
		PreparedStatement p = c.prepareStatement(query);
		p.setInt(1, OlC.getCourseID());
		int result = p.executeUpdate();
		return result;
	}
	public List<OnlineCourse> findOnlineCourse(String title) throws SQLException{
		String query = "SELECT `course`.`CourseID`,`Title`,`Credits`,`DepartmentID`,`url` FROM `course`,`onlinecourse` WHERE `onlinecourse`.`CourseID` = `course`.`CourseID` and  `course`.`Title` = ?";
		PreparedStatement p = c.prepareStatement(query);
		p.setString(1, title);
		ResultSet rs = p.executeQuery();
		List<OnlineCourse> list = new ArrayList<>();
		if(rs!=null) {
			//int i =1;
			while(rs.next()) {
				OnlineCourse OlC = new OnlineCourse();
				OlC.setCourseID(rs.getInt("CourseID"));
				OlC.setTitle(rs.getString("Title"));
				OlC.setCredits(rs.getInt("Credits"));
				OlC.setDepartmentID(rs.getInt("DepartmentID"));
				OlC.setUrl(rs.getString("url"));
				list.add(OlC);
			}
		}
		return list;
	}
	public List<OnlineCourse> load1recordOlC(int courseid) throws SQLException{
		String query = "SELECT `course`.`CourseID`,`Title`,`Credits`,`DepartmentID`,`url` FROM `course`,`onlinecourse` WHERE `onlinecourse`.`CourseID` = `course`.`CourseID`  and `course`.`CourseID` = ?;";
		PreparedStatement p =c.prepareStatement(query);
		p.setInt(1, courseid);		
		ResultSet rs = p.executeQuery();
		List <OnlineCourse> list = new ArrayList<>();
		if(rs!=null) {
			while(rs.next()) {
				OnlineCourse OlC = new OnlineCourse();
				OlC.setCourseID(rs.getInt("CourseID"));
				OlC.setTitle(rs.getString("Title"));
				OlC.setCredits(rs.getInt("Credits"));
				OlC.setDepartmentID(rs.getInt("DepartmentID"));
				OlC.setUrl(rs.getString("URL"));
				list.add(OlC);
			}
		}		
		return list;
	}
}
