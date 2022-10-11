package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import BLL.CourseBLL;
import BLL.OnlineCourseBLL;
import DAL.OnlineCourse;

import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;

public class SuaDuLieu_Onsite extends JFrame {

	private JPanel contentPane;
	private JTextField txtC;
	private JTextField txtURL;
	private JTextField txtTitle;
	private JTextField txtDep;
	private JTextField txtLo;
	private JTextField txtTime;
	private JTextField txtCre;
	private JTextField txtDate;
	private int viewcourseid;
	private List<OnlineCourse> OlC;
	CourseBLL cBll = new CourseBLL();
	OnlineCourseBLL OlCBll = new OnlineCourseBLL();
	/**
	 * Launch the application.
	 */
	public static void frmedit() {
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
	public SuaDuLieu_Onsite() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 445);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course ID");
		lblCourse.setBackground(new Color(240, 240, 240));
		lblCourse.setBounds(41, 30, 65, 20);
		contentPane.add(lblCourse);
		
		txtC = new JTextField();
		txtC.setEditable(false);
		txtC.setBounds(142, 30, 242, 20);
		contentPane.add(txtC);
		txtC.setColumns(10);
		
		JLabel lblURL = new JLabel("URL");
		lblURL.setBackground(new Color(0, 255, 255));
		lblURL.setBounds(41, 180, 45, 20);
		contentPane.add(lblURL);
		
		txtURL = new JTextField();
		txtURL.setColumns(10);
		txtURL.setBounds(142, 180, 242, 20);
		contentPane.add(txtURL);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBackground(new Color(240, 240, 240));
		lblTitle.setBounds(41, 60, 20, 20);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(142, 60, 242, 20);
		contentPane.add(txtTitle);
		
		JLabel lblDep = new JLabel("Department");
		lblDep.setBackground(new Color(0, 255, 255));
		lblDep.setBounds(41, 120, 91, 20);
		contentPane.add(lblDep);
		
		JLabel lblLo = new JLabel("Location");
		lblLo.setBackground(new Color(240, 240, 240));
		lblLo.setBounds(41, 210, 91, 20);
		contentPane.add(lblLo);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBackground(new Color(240, 240, 240));
		lblTime.setBounds(41, 240, 45, 20);
		contentPane.add(lblTime);
		
		JLabel lblCre = new JLabel("Credits");
		lblCre.setBackground(new Color(240, 240, 240));
		lblCre.setBounds(41, 90, 45, 20);
		contentPane.add(lblCre);
		
		txtDep = new JTextField();
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
		
		txtCre = new JTextField();
		txtCre.setColumns(10);
		txtCre.setBounds(142, 90, 242, 20);
		contentPane.add(txtCre);
		
		JButton btnSave = new JButton("L\u01B0u");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSave.setIcon(new ImageIcon(ThemDuLieu_Onsite.class.getResource("/IMG/Custom-Icon-Design-Flatastic-9-Save.png")));
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
		btnExit.setIcon(new ImageIcon(ThemDuLieu_Onsite.class.getResource("/IMG/back.png")));
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
				}
			}
		});
		radioOnsite.setBounds(275, 150, 109, 23);
		contentPane.add(radioOnsite);
		ButtonGroup group = new ButtonGroup();
		group.add(radioOnline);
		group.add(radioOnsite);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBackground(SystemColor.menu);
		lblDate.setBounds(41, 270, 45, 20);
		contentPane.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(142, 270, 242, 20);
		contentPane.add(txtDate);
	}
	public void load() throws SQLException {
		viewcourseid = KH_Online.courseid;
		OlC = OlCBll.loadOlC(viewcourseid);
		for(OnlineCourse OlCs:OlC) {			
			txtC.setText(OlCs.getCourseID()+"");
			
		}
	}
}
