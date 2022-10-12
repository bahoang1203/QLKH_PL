package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import BLL.CourseBLL;
import BLL.OnlineCourseBLL;
import BLL.OnsiteCourseBLL;
import DAL.Course;
import DAL.OnlineCourse;
import DAL.OnsiteCourse;

import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.SpinnerDateModel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class SuaDuLieu_Onsite extends JFrame {

	private JPanel contentPane;
	private JComboBox cbC = new JComboBox();
	private JTextField txtTitle = new JTextField();
	private JTextField txtDep = new JTextField();
	private JTextField txtLo = new JTextField();;
	private JTextField txtCre = new JTextField();
	JCheckBox chMon = new JCheckBox();
	JCheckBox chTh = new JCheckBox();
	JCheckBox chTu = new JCheckBox();
	JCheckBox chFr = new JCheckBox();
	JCheckBox chWe = new JCheckBox();
	JCheckBox chSa = new JCheckBox();
	JSpinField spin2 = new JSpinField();
	JSpinField spin = new JSpinField();
	private int viewcourseid;	
	CourseBLL cBLL = new CourseBLL();
	OnsiteCourseBLL OsCBLL = new OnsiteCourseBLL();
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
	public SuaDuLieu_Onsite() {
		try {
			loadcombox();
			load();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 391);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.hide();
		lblDate.setBackground(SystemColor.menu);
		lblDate.setBounds(41, 210, 45, 20);
		contentPane.add(lblDate);
		
		JLabel lblCourse = new JLabel("Course ID");
		lblCourse.setBackground(new Color(240, 240, 240));
		lblCourse.setBounds(41, 31, 65, 20);
		contentPane.add(lblCourse);
		
		
		cbC.setEditable(false);
		cbC.setBounds(142, 30, 242, 20);
		contentPane.add(cbC);
		
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
		lblLo.setBounds(41, 150, 91, 20);
		contentPane.add(lblLo);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.hide();
		lblTime.setBackground(new Color(240, 240, 240));
		lblTime.setBounds(41, 180, 45, 20);
		contentPane.add(lblTime);
		
		JLabel lblCre = new JLabel("Credits");
		lblCre.setBackground(new Color(240, 240, 240));
		lblCre.setBounds(41, 90, 45, 20);
		contentPane.add(lblCre);
	
		txtDep.setColumns(10);
		txtDep.setBounds(142, 120, 242, 20);
		contentPane.add(txtDep);
		
		
		txtLo.setColumns(10);
		txtLo.setBounds(142, 150, 242, 20);
		txtLo.hide();
		contentPane.add(txtLo);
		
	
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
		btnSave.setBounds(42, 279, 98, 50);
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
		btnExit.setBounds(320, 279, 133, 50);
		contentPane.add(btnExit);
		ButtonGroup group = new ButtonGroup();
		spin.setValue(6);
		
		spin.setMaximum(20);
		spin.setMinimum(6);
		spin.setBounds(142,180,60,20);
		contentPane.add(spin);
		
		spin2.setMaximum(20);
		spin2.setMinimum(6);
		spin2.setBounds(212,180,60,20);
		contentPane.add(spin2);
		
		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setBounds(206, 180, 9, 14);
		contentPane.add(lblNewLabel);
				
		chMon.setText("Mo");
		chMon.setBackground(SystemColor.inactiveCaption);
		chMon.setBounds(142, 210, 97, 23);
		contentPane.add(chMon);
		
		
		chTh.setText("Th");
		chTh.setBackground(SystemColor.inactiveCaption);
		chTh.setBounds(142, 240, 97, 23);
		contentPane.add(chTh);
		
		
		chTu.setText("Tu");
		chTu.setBackground(SystemColor.inactiveCaption);
		chTu.setBounds(241, 209, 97, 23);
		contentPane.add(chTu);
		
		
		chFr.setText("Fr");
		chFr.setBackground(SystemColor.inactiveCaption);
		chFr.setBounds(241, 240, 97, 23);
		contentPane.add(chFr);
		
		
		chWe.setText("We");
		chWe.setBackground(SystemColor.inactiveCaption);
		chWe.setBounds(340, 209, 97, 23);
		contentPane.add(chWe);
		
		
		chSa.setText("Sa");
		chSa.setBackground(SystemColor.inactiveCaption);
		chSa.setBounds(340, 240, 97, 23);
		contentPane.add(chSa);
		
	}
	public void btn_update() {
		Course c = new Course();
		OnsiteCourse OsC = new OnsiteCourse();
		int i = Integer.parseInt(cbC.getSelectedItem().toString());
		int cr = Integer.parseInt(txtCre.getText());
		int dep = Integer.parseInt(txtDep.getText());
		String t = spin.getValue() + ":" + spin2.getValue();
		c.setCourseID(i);
		c.setTitle(txtTitle.getText());
		c.setCredits(cr);
		c.setDepartmentID(dep);
		OsC.setCourseID(i);
		OsC.setLocation(txtLo.getText());		
		OsC.setTime(t);
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
		OsC.setDays(temp);
		try {
			if(cBLL.updCourse(c)>0&&OsCBLL.updateOsC(OsC)>0) {
				JOptionPane.showMessageDialog(this, "Complete update", "Message", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Error update", "Message", JOptionPane.ERROR_MESSAGE);
			}			
			
		}catch(SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void loadcombox() throws SQLException {
		List list = OsCBLL.loadOsC(1);
		for(int i = 0; i<list.size();i++) {
			OnsiteCourse OlC = (OnsiteCourse) list.get(i);
			cbC.addItem(OlC.getCourseID());
		}
	}
	public void load() throws SQLException {
		viewcourseid = KH_Onsite.courseidOsC;		
		List list = OsCBLL.load1banOsC(viewcourseid);
		for (int i = 0;i<list.size();i++) {
			OnsiteCourse OsC = (OnsiteCourse) list.get(i);
			cbC.setSelectedItem(OsC.getCourseID());
			txtTitle.setText(OsC.getTitle());
			txtDep.setText(OsC.getDepartmentID()+"");
			txtLo.setText(OsC.getLocation());
			txtCre.setText(OsC.getCredits()+"");
			txtLo.setText(OsC.getLocation());
		}
	}
	
}
