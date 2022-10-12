package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAL.KQDAL;
import DAL.Ketqua;

public class KQBLL {
	KQDAL kqDAL;
	
	public KQBLL () {
		kqDAL = new KQDAL ();
	}
	//hien thi
    public List LoadKQ(int page) throws SQLException {
        ArrayList list = kqDAL.readKQ();
        int numofrecords = list.size();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
    }
    //tim kiem
    public List findKQ (String keyword) throws SQLException {
    	List list = new ArrayList();
    	if (keyword.length() == 4 ) {
        	list = kqDAL.findKQbyCourseId(keyword);
    	} else {
    		list = kqDAL.findKQbyStudentID(keyword);
    	}
    	return list;
    }
    //xoa 
    public int deleteKQ (int cID, int sID) throws SQLException {
    	int result = kqDAL.deletebyCourseID(cID, sID);
    	return result;
    }
    //them
    public int addKQ (Ketqua kq) throws SQLException {
    	int result = kqDAL.insertKQ(kq);
    	return result;
    }
    //sua
    public int editKQ (Ketqua kq) throws SQLException {
    	int result = kqDAL.updateKQ(kq);
    	return result;
    }
    //lay 1 cot
    public List Load1Colum(int page) throws SQLException {
        ArrayList list = kqDAL.readKQ();
        int numofrecords = list.size();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
    }
    //lay 1 hang 
    public List Load1Record(int page, int enrollmentID) throws SQLException {
        ArrayList list = kqDAL.read1RecordByEnroll(enrollmentID);
        int numofrecords = list.size();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
    }
    public static void main(String[] args) {
        try {
            KQBLL kqBll = new KQBLL();
            List data = kqBll.LoadKQ(1);
            Ketqua s = (Ketqua) data.get(0);
            System.out.println(s.getGrade());
            System.out.println("Nothing");

        } catch (SQLException ex) {
            Logger.getLogger(KQBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
