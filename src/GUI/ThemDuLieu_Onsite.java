package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import BLL.CourseBLL;
import BLL.OnlineCourseBLL;
import DAL.Course;
import DAL.CourseDAL;
import DAL.OnlineCourse;

public class ThemDuLieu_Onsite extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtURL;
	private JTextField txtTitle;
	private JTextField txtDep;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtCre;
	CourseBLL cbl = new CourseBLL();
	OnlineCourseBLL olcb = new OnlineCourseBLL();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemDuLieu_Onsite frame = new ThemDuLieu_Onsite();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemDuLieu_Onsite() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 445);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course ID");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(41, 31, 65, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(142, 34, 242, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("URL");
		lblNewLabel_1.setBackground(new Color(0, 255, 255));
		lblNewLabel_1.setBounds(41, 81, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtURL = new JTextField();
		txtURL.setColumns(10);
		txtURL.setBounds(142, 78, 242, 19);
		contentPane.add(txtURL);
		
		JLabel lblNewLabel_1_1 = new JLabel("Title");
		lblNewLabel_1_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1.setBounds(41, 119, 45, 13);
		contentPane.add(lblNewLabel_1_1);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(142, 116, 242, 19);
		contentPane.add(txtTitle);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Department");
		lblNewLabel_1_1_1.setBackground(new Color(0, 255, 255));
		lblNewLabel_1_1_1.setBounds(41, 158, 91, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Location");
		lblNewLabel_1_1_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1_2.setBounds(41, 195, 91, 13);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Date");
		lblNewLabel_1_1_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1_3.setBounds(41, 239, 45, 13);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Time");
		lblNewLabel_1_1_4.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1_4.setBounds(41, 272, 45, 13);
		contentPane.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Credits");
		lblNewLabel_1_1_5.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1_5.setBounds(41, 310, 45, 19);
		contentPane.add(lblNewLabel_1_1_5);
		
		txtDep = new JTextField();
		txtDep.setColumns(10);
		txtDep.setBounds(142, 155, 242, 19);
		contentPane.add(txtDep);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(142, 192, 242, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(142, 269, 242, 19);
		contentPane.add(textField_5);
		
		txtCre = new JTextField();
		txtCre.setColumns(10);
		txtCre.setBounds(142, 310, 242, 19);
		contentPane.add(txtCre);
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Add();
			}
		});
		btnNewButton.setIcon(new ImageIcon(ThemDuLieu_Onsite.class.getResource("/IMG/Custom-Icon-Design-Flatastic-9-Save.png")));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(102, 153, 255));
		btnNewButton.setBounds(41, 348, 98, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tho\u00E1t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ThemDuLieu_Onsite.class.getResource("/IMG/back.png")));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(102, 153, 255));
		btnNewButton_1.setBounds(319, 348, 133, 50);
		contentPane.add(btnNewButton_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(142, 239, 146, 19);
		contentPane.add(dateChooser);
	}
	public void btn_Add() {
		Course c = new Course();
		c.setTitle(txtTitle.getText());
		int a = Integer.parseInt(txtCre.getText());
		int b = Integer.parseInt(txtDep.getText());
		c.setCredits(a);
		c.setDepartmentID(b);
		try {
			if(cbl.addCourse(c)>0) {
				JOptionPane.showMessageDialog(this, "Complete add", "Message", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Error add", "Message", JOptionPane.ERROR_MESSAGE);
			}			
		}catch(SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}
		OnlineCourse OlC = new OnlineCourse();
		OlC.setCourseID(CourseDAL.idvalue);
		OlC.setUrl(txtURL.getText());
		try {
			if(olcb.addOlC(OlC)>0) {
				JOptionPane.showMessageDialog(this, "Complete add", "Message", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Error add", "Message", JOptionPane.ERROR_MESSAGE);
			}			
		}catch(SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}
