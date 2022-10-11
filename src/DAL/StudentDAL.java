package DAL;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAL extends MyDatabaseManager {
	public StudentDAL(){
        super();
        this.connectDB();
    }
    public ArrayList<Student> readStudents() throws SQLException{
        String query = "SELECT * FROM Person WHERE EnrollmentDate >0";
        ResultSet rs = this.doReadQuery(query);
        ArrayList<Student> list = new ArrayList<Student>();
        if(rs!=null){
            int i = 1;
            while(rs.next()){
            	Student s = new Student();
            	s.setPersonId(rs.getInt("PersonID"));
            	s.setFirstname(rs.getString("FirstName"));
            	s.setLastname(rs.getString("LastName"));
            	list.add(s);
            }
        }
        return list;
    }
    public int updateStudent(Student s) throws SQLException{
        String query = "Update Person SET FirstName = ? , LastName = ? "+ " WHERE PersonID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstname());
        p.setString(2, s.getLastname());
        p.setInt(3, s.getPersonId());
        int result= p.executeUpdate();
        return result;
    }
    public int insertStudent(Student s) throws SQLException{
    	String query = "Insert Person (Firstname, Lastname, EnrollmentDate) VALUE(?,?,?)";
    	PreparedStatement p = c.prepareStatement(query);
    	p.setString(1, s.getFirstname());
    	p.setString(2, s.getLastname());
    	p.setString(3, s.getEnrollmentDate().toString());
    	int result = p.executeUpdate();
    	return result;
    }
    public int deleteStudent(Student s) throws SQLException{
    	String query = "Delete from Person where PersonID = ?";
    	PreparedStatement p = c.prepareStatement(query);
    	p.setInt(1, s.getPersonId());
    	int result = p.executeUpdate();
    	return result;
    }
    public static void main(String args[]){
        
    }

    
    
    
}
