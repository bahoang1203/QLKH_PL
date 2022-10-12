package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
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
import DAL.OnlineCourse;

import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;

public class SuaDuLieu_Online extends JFrame {

	private JPanel contentPane;
	private JTextField txtC = new JTextField();
	private JTextField txtURL = new JTextField();
	private JTextField txtTitle = new JTextField();
	private JTextField txtDep = new JTextField();
	private JTextField txtLo;
	private JTextField txtTime;
	private JTextField txtCre = new JTextField();
	private JTextField txtDate;
	private int viewcourseid;
	private List<OnlineCourse> OlC;
	CourseBLL cBLL = new CourseBLL();
	OnlineCourseBLL OlCBLL = new OnlineCourseBLL();
	/**
	 * Launch the application.
	 */
	public static void frmedit() {
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
	public SuaDuLieu_Online() {
		try {
			load();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 445);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.hide();
		lblDate.setBackground(SystemColor.menu);
		lblDate.setBounds(41, 270, 45, 20);
		contentPane.add(lblDate);
		
		JLabel lblCourse = new JLabel("Course ID");
		lblCourse.setBackground(new Color(240, 240, 240));
		lblCourse.setBounds(41, 31, 65, 20);
		contentPane.add(lblCourse);
		
		
		txtC.setEditable(false);
		txtC.setBounds(142, 30, 242, 20);
		contentPane.add(txtC);
		txtC.setColumns(10);
		
		JLabel lblURL = new JLabel("URL");
		lblURL.setBackground(new Color(0, 255, 255));
		lblURL.setBounds(41, 180, 45, 20);
		contentPane.add(lblURL);
		
		
		txtURL.setColumns(10);
		txtURL.setBounds(142, 180, 242, 20);
		contentPane.add(txtURL);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBackground(new Color(240, 240, 240));
		lblTitle.setBounds(41, 60, 20, 20);
		contentPane.add(lblTitle);
		
//		txtTitle = new JTextField();
		
		txtTitle.setColumns(10);
		txtTitle.setBounds(142, 60, 242, 20);
		contentPane.add(txtTitle);
		
		JLabel lblDep = new JLabel("Department");
		lblDep.setBackground(new Color(0, 255, 255));
		lblDep.setBounds(41, 120, 91, 20);
		contentPane.add(lblDep);
		
		JLabel lblLo = new JLabel("Location");
		lblLo.hide();
		lblLo.setBackground(new Color(240, 240, 240));
		lblLo.setBounds(41, 210, 91, 20);
		contentPane.add(lblLo);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.hide();
		lblTime.setBackground(new Color(240, 240, 240));
		lblTime.setBounds(41, 240, 45, 20);
		contentPane.add(lblTime);
		
		JLabel lblCre = new JLabel("Credits");
		lblCre.setBackground(new Color(240, 240, 240));
		lblCre.setBounds(41, 90, 45, 20);
		contentPane.add(lblCre);
		
		txtDate = new JTextField();
		txtDate.hide();
		txtDate.setColumns(10);
		txtDate.setBounds(142, 270, 242, 20);
		contentPane.add(txtDate);
	
		txtDep.setColumns(10);
		txtDep.setBounds(142, 120, 242, 20);
		contentPane.add(txtDep);
		
		txtLo = new JTextField();
		txtLo.setColumns(10);
		txtLo.setBounds(142, 210, 242, 20);
		txtLo.hide();
		contentPane.add(txtLo);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(142, 240, 242, 20);
		txtTime.hide();
		contentPane.add(txtTime);
		
	
		txtCre.setColumns(10);
		txtCre.setBounds(142, 90, 242, 20);
		contentPane.add(txtCre);
		
		JButton btnSave = new JButton("L\u01B0u");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_update();
			}
		});
		btnSave.setIcon(new ImageIcon(ThemDuLieu_Online.class.getResource("/IMG/Custom-Icon-Design-Flatastic-9-Save.png")));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setForeground(new Color(34, 139, 34));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBackground(new Color(102, 153, 255));
		btnSave.setBounds(41, 348, 98, 50);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Tho\u00E1t");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
			    
			}
		});
		btnExit.setIcon(new ImageIcon(ThemDuLieu_Online.class.getResource("/IMG/back.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setForeground(new Color(139, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(new Color(102, 153, 255));
		btnExit.setBounds(319, 348, 133, 50);
		contentPane.add(btnExit);
		
		JRadioButton radioOnline = new JRadioButton("Online");
		radioOnline.setSelected(true);
		radioOnline.setBackground(SystemColor.inactiveCaption);
		
		radioOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioOnline != null) {
					txtLo.hide();
					txtTime.hide();
					txtDate.hide();
					txtURL.show();
					lblURL.show();
					lblTime.hide();
					lblLo.hide();
					lblDate.hide();
				}
			}
		});
		radioOnline.setBounds(142, 150, 109, 23);
		contentPane.add(radioOnline);
		
		JRadioButton radioOnsite = new JRadioButton("Onsite");
		radioOnsite.setBackground(SystemColor.inactiveCaption);
		radioOnsite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioOnsite != null) {
					txtLo.show();
					txtTime.show();
					txtDate.show();
					txtURL.hide();
					lblURL.hide();
					lblTime.show();
					lblLo.show();
					lblDate.show();				
				}
			}
		});
		radioOnsite.setBounds(275, 150, 109, 23);
		contentPane.add(radioOnsite);
		ButtonGroup group = new ButtonGroup();
		group.add(radioOnline);
		group.add(radioOnsite);
		
		
	}
	public void btn_update() {
		Course c = new Course();
		OnlineCourse OlC = new OnlineCourse();
		int i = Integer.parseInt(txtC.getText());
		int cr = Integer.parseInt(txtCre.getText());
		int dep = Integer.parseInt(txtDep.getText());
		c.setCourseID(i);
		c.setTitle(txtTitle.getText());
		c.setCredits(cr);
		c.setDepartmentID(dep);
		OlC.setCourseID(i);
		OlC.setUrl(txtURL.getText());
		try {
			if(cBLL.updCourse(c)>0&&OlCBLL.updateOlC(OlC)>0) {
				JOptionPane.showMessageDialog(this, "Complete update", "Message", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Error update", "Message", JOptionPane.ERROR_MESSAGE);
			}			
			
		}catch(SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void load() throws SQLException {
		viewcourseid = KH_Online.courseid;		
		List list = OlCBLL.load1banOlC(viewcourseid);
		for (int i = 0;i<list.size();i++) {
			OnlineCourse OlC = (OnlineCourse) list.get(i);
			txtC.setText(OlC.getCourseID()+"");
			txtTitle.setText(OlC.getTitle());
			txtDep.setText(OlC.getDepartmentID()+"");
			txtCre.setText(OlC.getCredits()+"");
			txtURL.setText(OlC.getUrl());
		}
	}
	
}
