package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.CourseBLL;
import BLL.KQBLL;
import BLL.StudentBLL;
import DAL.Course;
import DAL.Ketqua;
import DAL.Student;
import GUI.KQ;
public class EditKQForm extends JFrame{
	private JPanel contentPane;
	JScrollPane scrollPane;
	private JTextField textField;
	private JComboBox cb1, cb2;
	int value1, value2;
	JTable jTable;
	KQBLL kqd = new KQBLL();
	CourseBLL cbll = new CourseBLL();
	StudentBLL stBll = new StudentBLL();
	public EditKQForm() {
		// TODO Auto-generated constructor stub
		init();
		try {
			listKQ();
			listCourseID();
			listStudentID();
		} catch (SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public static void main (String [] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(KQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(KQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(KQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(KQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		EditKQForm f = new EditKQForm();
		f.setVisible(true);
	}
	
	public void init () {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 445);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COURSE ID");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(40, 100, 100, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("STUDENT ID");
		lblNewLabel_1.setBackground(new Color(0, 255, 255));
		lblNewLabel_1.setBounds(40, 170, 100, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("GRADE");
		lblNewLabel_1_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1.setBounds(40, 230, 70, 25);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 220, 130, 50);
		contentPane.add(textField);
		

		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setIcon(new ImageIcon(AddKQForm.class.getResource("/IMG/Custom-Icon-Design-Flatastic-9-Save.png")));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(102, 153, 255));
		btnNewButton.setBounds(41, 348, 133, 50);
		btnNewButton.addActionListener((ActionEvent e) -> {
			try {
				btnEdit_Click(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddKQForm.class.getResource("/IMG/back.png")));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(102, 153, 255));
		btnNewButton_1.setBounds(319, 348, 133, 50);
		contentPane.add(btnNewButton_1);
		
		cb1 = new JComboBox();
		cb1.setBounds(140, 85, 130, 50);
		cb2 = new JComboBox();
		cb2.setBounds(140, 155, 130, 50);
		contentPane.add(cb1);
		contentPane.add(cb2);
		jTable = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 10, 450 , 70);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(jTable);
	}
	private void listKQ() throws SQLException {
		List list = kqd.Load1Record(1, KQ.waitEnrollmentID);
		DefaultTableModel model = convertKQ(list);
		jTable.setModel(model);
	}
//	private void listKQnext(Ketqua kq) throws SQLException {
//		List list = kqd.Load1Record(1, kq.getEnrollmentID());
//		DefaultTableModel model = convertKQ(list);
//		jTable.setModel(model);
//	}
	private DefaultTableModel convertKQ(List list) {
		String[] columnNames = { "Course ID", "Student ID", "Grade" };
		Object[][] data = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			Ketqua kq = (Ketqua) list.get(i);
			data[i][0] = kq.getCourseID();
			data[i][1] = kq.getStudentID();
			data[i][2] = kq.getGrade();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		return model;
	}
	private void listCourseID() throws SQLException {
		List list = cbll.LoadCourse(1);

		DefaultComboBoxModel model = convertCourseID(list);
		cb1.setModel(model);
		cb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Object item = cb1.getSelectedItem();
				value1 = (int) item;
			}
		});
	}
	public DefaultComboBoxModel convertCourseID (List list) {
		Object[] data = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Course course = (Course) list.get(i);
			data[i] = course.getCourseID();
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(data);
		return model;
	}
	private void listStudentID() throws SQLException {
		List list = stBll.LoadStudents(1);
		DefaultComboBoxModel model = convertStudentID(list);
		cb2.setModel(model);
		cb2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Object item = cb2.getSelectedItem();
				value2 = (int) item;
			}
		});
	}
	public DefaultComboBoxModel convertStudentID (List list) {
		Object[] data = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Student student = (Student) list.get(i);
			data[i] = student.getPersonId();
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(data);
		return model;
	}
	public void btnEdit_Click (ActionEvent e) throws SQLException {
		List list = kqd.Load1Record(1, KQ.waitEnrollmentID);
		Ketqua kq = (Ketqua) list.get(0);
		if (value1 == 0 && value2 == 0  && textField.getText().isBlank() == false) {
			// neu course id va student id null nhung grade khong null
			kq.setGrade(new BigDecimal(textField.getText())); 
		} else if (value2 == 0  && textField.getText().isBlank() == true && value1 != 0 ) {
			// neu grade va student id null nhung course id khong null
			kq.setCourseID(value1);
		} else if (textField.getText().isBlank() == true && value1 == 0  && value2 != 0 ) {
			// neu course id va grade null nhung student id khong null
			kq.setStudentID(value2);
		} else if (textField.getText().isBlank() == false && value1 != 0  && value2 != 0) {
			//ca 3 khong null
			kq.setCourseID(value1);
			kq.setStudentID(value2);
			kq.setGrade(new BigDecimal(textField.getText()));
		}else if (value1 == 0 && value2 != 0 && textField.getText().isBlank() == false){
			//course id null , student id va grade id khong null
			kq.setStudentID(value2);
			kq.setGrade(new BigDecimal(textField.getText()));
		} else if (value1 != 0 && value2 == 0 && textField.getText().isBlank() == false) {
			//student id null, course id va grade khong null
			kq.setCourseID(value1);
			kq.setGrade(new BigDecimal(textField.getText()));
		}
		else if (value1 != 0 && value2 != 0 && textField.getText().isBlank() == true) {
			//grade null, course id va student id khong null
			kq.setCourseID(value1);
			kq.setStudentID(value2);
		}
		try {
			if (kqd.editKQ(kq) >0 ) {
				JOptionPane.showMessageDialog(this, "Complete update info", "Message", JOptionPane.INFORMATION_MESSAGE);
				listKQ();
			} else {
				JOptionPane.showMessageDialog(this, "Error update", "Message", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}
		dispose();
	}


}
