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

import BLL.OnlineCourseBLL;
import DAL.Course;
import DAL.OnlineCourse;
import java.awt.event.MouseAdapter;

public class KH_Online extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<OnlineCourse> OlCs;
	public static int courseid;
	int selectedIndex;
	JTable table = new JTable();
	OnlineCourseBLL OlCBll = new OnlineCourseBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemDuLieu_Onsite themonsite = new ThemDuLieu_Onsite();
				themonsite.show();
			}
		});
		btnNewButton.setBackground(new Color(102, 153, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/add.png")));
		btnNewButton.setBounds(29, 536, 119, 50);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.setForeground(new Color(255, 255, 255));
		btnSa.setBackground(new Color(102, 153, 255));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaDuLieu_Onsite suaonsite = new SuaDuLieu_Onsite();
				suaonsite.frmedit();
			}
		});
		btnSa.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/edit.png")));
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSa.setBounds(171, 536, 101, 50);
		contentPane.add(btnSa);
		
		JButton btnNewButton_1_1 = new JButton("X\u00F3a");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listOlC();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(102, 153, 255));
		btnNewButton_1_1.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/delete.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(313, 536, 101, 50);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Quay l\u1EA1i");
		btnNewButton_1_1_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1_1_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_1_1_1.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/back.png")));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.show();				
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1.setBounds(755, 571, 126, 50);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(QLGV.class.getResource("/IMG/search.png")));
		btnNewButton_1_1_1_1.setForeground(new Color(102, 153, 255));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_1_1_1_1.setBounds(700, 39, 139, 37);
		contentPane.add(btnNewButton_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(249, 43, 404, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
	}
	

	public void listOlC() throws SQLException{
		List list = OlCBll.loadOlC(1);
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
		OnlineCourse c = OlCs.get(selectedIndex);
		courseid = c.getCourseID();		
	}
}
