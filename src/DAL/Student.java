package DAL;

import java.sql.Date;

public class Student {
	String firstname, lastname;
    int personId;
    Date enrollmentDate;
    
    public Student(String firstname, String lastname, int personId, Date enrollmentDate) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.personId = personId;
        this.enrollmentDate = enrollmentDate;
    }
    public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstname() {
	return firstname;
    }
    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }
    public String getLastname() {
	return lastname;
    }
    public void setLastname(String lastname) {
	this.lastname = lastname;
    }
    public int getPersonId() {
	return personId;
    }
    public void setPersonId(int personId) {
	this.personId = personId;
    }
    public Date getEnrollmentDate() {
	return enrollmentDate;
    }
    public void setEnrollmentDate(Date enrollmentDate) {
	this.enrollmentDate = enrollmentDate;
    }
}
