package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
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

import BLL.CourseBLL;
import BLL.OnlineCourseBLL;
import DAL.Course;
import DAL.OnlineCourse;
import java.awt.event.MouseAdapter;

public class KH_Online extends JFrame {

	private JPanel contentPane;
	private JTextField txtFind;
	private List<OnlineCourse> OlCs;
	public static int courseid;
	public static int selectedIndex;
	JTable table = new JTable();
	CourseBLL cBLL = new CourseBLL();
	OnlineCourseBLL OlCBLL = new OnlineCourseBLL();
	/**
	 * Launch the application.
	 */
	public static void KH_Onlineform(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLGV frame = new QLGV();
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
	public KH_Online() {
		try {
			listOlC();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 681);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemDuLieu_Online themonsite = new ThemDuLieu_Online();
				themonsite.show();
			}
		});
		btnThem.setBackground(new Color(102, 153, 255));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setHorizontalAlignment(SwingConstants.LEFT);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/add.png")));
		btnThem.setBounds(29, 536, 119, 50);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBackground(new Color(102, 153, 255));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaDuLieu_Online suaonsite = new SuaDuLieu_Online();
				suaonsite.show();
			}
		});
		btnSua.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/edit.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(171, 536, 101, 50);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				btn_del();
			}
		});
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(102, 153, 255));
		btnXoa.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/delete.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(313, 536, 101, 50);
		contentPane.add(btnXoa);
		
		JButton btnExit = new JButton("Quay l\u1EA1i");
		btnExit.setForeground(new Color(128, 0, 0));
		btnExit.setBackground(SystemColor.inactiveCaptionBorder);
		btnExit.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/back.png")));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.show();				
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(755, 571, 126, 50);
		contentPane.add(btnExit);
		
		JButton btnFind = new JButton("T\u00ECm ki\u1EBFm");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Find();
			}
		});
		btnFind.setIcon(new ImageIcon(QLGV.class.getResource("/IMG/search.png")));
		btnFind.setForeground(new Color(102, 153, 255));
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBackground(SystemColor.inactiveCaptionBorder);
		btnFind.setBounds(700, 39, 139, 37);
		contentPane.add(btnFind);
		
		txtFind = new JTextField();
		txtFind.setBounds(249, 43, 404, 37);
		contentPane.add(txtFind);
		txtFind.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp th\u00F4ng tin:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(133, 43, 106, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 911, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(QLGV.class.getResource("/IMG/logo1.png")));
		lblNewLabel_1.setBounds(25, 21, 96, 73);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 145, 840, 350);
		contentPane.add(scrollPane);		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cellClick();
			}
		});
		
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listOlC();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBackground(new Color(102, 153, 255));
		btnRefresh.setBounds(455, 536, 101, 50);
		contentPane.add(btnRefresh);
	}
	

	protected void btn_del() {
		// TODO Auto-generated method stub
		Course c = new Course();
		OnlineCourse OlC = new OnlineCourse();
		OlC.setCourseID((int) table.getValueAt(selectedIndex, 1));
		c.setCourseID((int) table.getValueAt(selectedIndex, 1));
		try {
			if(OlCBLL.delOlC(OlC)>0&&cBLL.delCourse(c)>0) {
				JOptionPane.showMessageDialog(this, "Complete delete", "Message", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Error delete", "Message", JOptionPane.ERROR_MESSAGE);
						
			}
		} catch (SQLException e) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	protected void btn_Find() {
		// TODO Auto-generated method stub
		try {
			String Title = txtFind.getText();			
			if(Title.isBlank()==false) {
				List list = OlCBLL.findOlC(Title);
				DefaultTableModel model = convertOlC(list);
				table.setModel(model);
			}else {
				JOptionPane.showMessageDialog(this, "title is empty", "Message",JOptionPane.ERROR_MESSAGE);
			}
		}catch(SQLException e) {
			Logger.getLogger(KH_Online.class.getName()).log(Level.SEVERE,null, e);
		}
		
	}

	public void listOlC() throws SQLException{
		List list = OlCBLL.loadOlC(1);
		DefaultTableModel model = convertOlC(list);
		table.setModel(model);
		
	}
	private DefaultTableModel convertOlC(List list) {
		String[] columnNames = { "TT", "CourseID","Title", "Credits", "DepartmentID", "URL" };
		Object[][] data = new Object[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			OnlineCourse OlC = (OnlineCourse) list.get(i);
			data[i][0] = i + 1;
			data[i][1] = OlC.getCourseID();
			data[i][2] = OlC.getTitle();
			data[i][3] = OlC.getCredits();
			data[i][4] = OlC.getDepartmentID();
			data[i][5] = OlC.getUrl();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		return model;
	}
	private void cellClick() {
		// TODO Auto-generated method stub
		selectedIndex = table.getSelectedRow();		
		courseid = (int) table.getValueAt(selectedIndex, 1);
		
	}
}
