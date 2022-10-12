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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ThemDuLieu_Online extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtURL;
	private JTextField txtTitle;
	private JTextField txtDep;
	private JTextField txtCre;
	CourseBLL cBLL = new CourseBLL();
	OnlineCourseBLL OlCBLL = new OnlineCourseBLL();

	/**
	 * Launch the application.
	 */
	public static void frmadd() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemDuLieu_Online frame = new ThemDuLieu_Online();
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
	public ThemDuLieu_Online() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 330);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblC = new JLabel("Course ID");
		lblC.setBackground(new Color(240, 240, 240));
		lblC.setBounds(41, 30, 65, 20);
		contentPane.add(lblC);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // if it's not a number, ignore the event
				}
			}
		});
		textField.setBounds(142, 30, 242, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblURL = new JLabel("URL");
		lblURL.setBackground(new Color(0, 255, 255));
		lblURL.setBounds(41, 150, 45, 20);
		contentPane.add(lblURL);
		
		txtURL = new JTextField();
		txtURL.setColumns(10);
		txtURL.setBounds(142, 150, 242, 19);
		contentPane.add(txtURL);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBackground(new Color(240, 240, 240));
		lblTitle.setBounds(41, 60, 45, 20);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txtTitle.setColumns(10);
		txtTitle.setBounds(142, 60, 242, 19);
		contentPane.add(txtTitle);
		
		JLabel lblDep = new JLabel("Department");
		lblDep.setBackground(new Color(0, 255, 255));
		lblDep.setBounds(41, 120, 91, 20);
		contentPane.add(lblDep);
		
		JLabel lblCre = new JLabel("Credits");
		lblCre.setBackground(new Color(240, 240, 240));
		lblCre.setBounds(41, 90, 45, 20);
		contentPane.add(lblCre);
		
		txtDep = new JTextField();
		txtDep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // if it's not a number, ignore the event
				}
			}
		});
		txtDep.setColumns(10);
		txtDep.setBounds(142, 120, 242, 19);
		contentPane.add(txtDep);
		
		txtCre = new JTextField();
		txtCre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // if it's not a number, ignore the event
				}
			}
		});
		txtCre.setColumns(10);
		txtCre.setBounds(142, 90, 242, 19);
		contentPane.add(txtCre);
		
		JButton btnSave = new JButton("L\u01B0u");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Add();
			}
		});
		btnSave.setIcon(new ImageIcon(ThemDuLieu_Online.class.getResource("/IMG/Custom-Icon-Design-Flatastic-9-Save.png")));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setForeground(new Color(0, 100, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBackground(new Color(102, 153, 255));
		btnSave.setBounds(41, 213, 98, 50);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Tho\u00E1t");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(ThemDuLieu_Online.class.getResource("/IMG/back.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setForeground(new Color(139, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(new Color(102, 153, 255));
		btnExit.setBounds(312, 213, 133, 50);
		contentPane.add(btnExit);
	}
	public void btn_Add() {
		Course c = new Course();
		c.setTitle(txtTitle.getText());
		int a = Integer.parseInt(txtCre.getText());
		int b = Integer.parseInt(txtDep.getText());
		c.setCredits(a);
		c.setDepartmentID(b);
		try {
			if(cBLL.addCourse(c)>0) {
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
			if(OlCBLL.addOlC(OlC)>0) {
				JOptionPane.showMessageDialog(this, "Complete add", "Message", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Error add", "Message", JOptionPane.ERROR_MESSAGE);
			}			
		}catch(SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}
