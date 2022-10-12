package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import BLL.CourseBLL;
import BLL.OnlineCourseBLL;
import BLL.OnsiteCourseBLL;
import DAL.Course;
import DAL.CourseDAL;
import DAL.OnlineCourse;
import DAL.OnsiteCourse;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.util.Date;
import java.util.Calendar;

public class ThemDuLieu_Onsite extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtDep;
	private JTextField txtCre;
	JCheckBox chMon = new JCheckBox();
	JCheckBox chTu = new JCheckBox();
	JCheckBox chWe = new JCheckBox();
	JCheckBox chTh = new JCheckBox();
	JCheckBox chFr = new JCheckBox();
	JCheckBox chSa = new JCheckBox();
	CourseBLL cBLL = new CourseBLL();
	JSpinField spin2 = new JSpinField();
	JSpinField spin = new JSpinField();
	
	OnsiteCourseBLL OsCBLL = new OnsiteCourseBLL();
	private final JLabel lblLocation = new JLabel("Location");
	private JTextField txtLo;

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
		setBounds(100, 100, 498, 412);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBackground(new Color(0, 255, 255));
		lblDays.setBounds(41, 189, 45, 20);
		contentPane.add(lblDays);
		
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
		btnSave.setIcon(new ImageIcon(ThemDuLieu_Onsite.class.getResource("/IMG/Custom-Icon-Design-Flatastic-9-Save.png")));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setForeground(new Color(0, 100, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBackground(new Color(102, 153, 255));
		btnSave.setBounds(41, 287, 98, 50);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Tho\u00E1t");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(ThemDuLieu_Onsite.class.getResource("/IMG/back.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setForeground(new Color(139, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(new Color(102, 153, 255));
		btnExit.setBounds(312, 287, 133, 50);
		contentPane.add(btnExit);
		
		chMon.setText("Mo");
		chMon.setBackground(SystemColor.inactiveCaption);
		chMon.setBounds(142, 188, 97, 23);
		contentPane.add(chMon);
		
		chTu.setText("Tu");
		chTu.setBackground(SystemColor.inactiveCaption);
		chTu.setBounds(241, 188, 97, 23);
		contentPane.add(chTu);
		
		chWe.setText("We");
		chWe.setBackground(SystemColor.inactiveCaption);
		chWe.setBounds(340, 188, 97, 23);
		contentPane.add(chWe);
		
		chTh.setText("Th");
		chTh.setBackground(SystemColor.inactiveCaption);
		chTh.setBounds(142, 218, 97, 23);
		contentPane.add(chTh);
		
		chFr.setText("Fr");
		chFr.setBackground(SystemColor.inactiveCaption);
		chFr.setBounds(241, 218, 97, 23);
		contentPane.add(chFr);
		
		chSa.setText("Sa");
		chSa.setBackground(SystemColor.inactiveCaption);
		chSa.setBounds(340, 218, 97, 23);
		contentPane.add(chSa);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBackground(Color.CYAN);
		lblTime.setBounds(41, 256, 45, 20);
		contentPane.add(lblTime);
		spin.setValue(6);
		
		
		spin.setMaximum(20);
		spin.setMinimum(6);
		spin.setBounds(142,256,60,19);
		contentPane.add(spin);
		
		
		spin2.setMaximum(59);
		spin2.setMinimum(0);
		spin2.setBounds(218,256,60,19);
		contentPane.add(spin2);
		
		JLabel lblNewLabel = new JLabel("::");
		lblNewLabel.setBounds(207, 256, 8, 14);
		contentPane.add(lblNewLabel);
		lblLocation.setBackground(Color.CYAN);
		lblLocation.setBounds(41, 151, 45, 20);
		
		contentPane.add(lblLocation);
		
		txtLo = new JTextField();
		txtLo.setColumns(10);
		txtLo.setBounds(142, 150, 242, 19);
		contentPane.add(txtLo);
		
	}
	public void btn_Add() {
		if(txtTitle.getText().length()!=0 && txtCre.getText().length()!=0 && txtDep.getText().length()!=0 && txtLo.getText().length()!=0) {
			Course c = new Course();
			int a = Integer.parseInt(txtCre.getText());
			int b = Integer.parseInt(txtDep.getText());
			c.setTitle(txtTitle.getText());		
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
			OnsiteCourse OsC = new OnsiteCourse();
			OsC.setCourseID(CourseDAL.idvalue);
			String temp = "";
			if(chMon.isSelected()) {
				temp = temp + "M";
			}if(chTu.isSelected()) {
				temp = temp + "T";
			}if(chWe.isSelected()) {
				temp = temp + "W";
			}if(chTh.isSelected()) {
				temp = temp + "H";
			}if(chFr.isSelected()) {
				temp = temp + "F";
			}if(chSa.isSelected()) {
				temp = temp + "S";
			}		
			String t = spin.getValue()+":"+spin2.getValue();
			OsC.setLocation(txtLo.getText());
			OsC.setDays(temp);
			OsC.setTime(t);
			try {
				if(OsCBLL.addOsC(OsC)>0) {
					JOptionPane.showMessageDialog(this, "Complete add", "Message", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "Error add", "Message", JOptionPane.ERROR_MESSAGE);
				}			
			}catch(SQLException ex) {
				Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
			}
		}else {
			JOptionPane.showMessageDialog(null, "xin hãy nhập đầy đủ thông tin");
		}
	}
}
