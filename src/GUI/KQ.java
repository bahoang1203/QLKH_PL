package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BLL.CourseBLL;
import BLL.KQBLL;
import BLL.StudentBLL;
import DAL.Course;
import DAL.Ketqua;
import DAL.Student;

public class KQ extends JFrame {

	private JPanel contentPane;
	JScrollPane jScrollPane1;
	JTable jTable1 = new JTable();
	JLabel title, lbStatus, lbFind;
	JPanel jpcenter, jptop, jpleft, jpbot;
	JButton jbtnAdd, jbtnUpdate, jbtnEdit, jbtnFind;
	JTextField jtxtFind;
	public static int waitCourseID;
	public static int waitStudentID;
	public static int waitEnrollmentID;
	KQBLL kqd = new KQBLL();

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					KQ frame = new KQ();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	KQ() throws SQLException {
		init();
		try {
			listKQ();
		} catch (SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void main(String[] args) throws SQLException {
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

		KQ f = new KQ();
		f.setVisible(true);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public void init() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 681);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 911, 118);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(102, 153, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/add.png")));
		btnNewButton.setBounds(29, 536, 120, 50);
		btnNewButton.addActionListener((ActionEvent e) -> {
			try {
				btnAdd_Click(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		contentPane.add(btnNewButton);

		JButton btnSa = new JButton("EDIT");
		btnSa.setForeground(new Color(255, 255, 255));
		btnSa.setBackground(new Color(102, 153, 255));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSa.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/edit.png")));
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSa.setBounds(171, 536, 120, 50);
		btnSa.addActionListener((ActionEvent e) -> {
			btnEdit_Click(e);
		});
		contentPane.add(btnSa);

		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(102, 153, 255));
		btnNewButton_1_1.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/delete.png")));
		btnNewButton_1_1.addActionListener((ActionEvent e) -> {
			btnDelete_Click(e);
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(313, 536, 120, 50);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Back");
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

		JLabel lblNewLabel = new JLabel("INFO:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(133, 43, 106, 34);
		contentPane.add(lblNewLabel);

		jtxtFind = new JTextField();
		jtxtFind.setBounds(275, 53, 218, 25);
		panel.add(jtxtFind);

		JButton btnNewButton_1_1_1_1 = new JButton("SEARCH");
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(QLGV.class.getResource("/IMG/search.png")));
		btnNewButton_1_1_1_1.setForeground(new Color(102, 153, 255));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_1_1_1_1.setBounds(700, 39, 139, 37);
		panel.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.addActionListener((ActionEvent e) -> {
			btnFind_Click(e);
		});
		JButton btnNewButton_1_1_1_1_1 = new JButton("REFRESH");
		btnNewButton_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1_1_1_1.setBackground(new Color(102, 153, 255));
		btnNewButton_1_1_1_1_1.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/delete.png")));
		btnNewButton_1_1_1_1_1.addActionListener((ActionEvent e) -> {
			try {
				btnRefresh_Click(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1_1_1.setBounds(455, 536, 130, 50);
		contentPane.add(btnNewButton_1_1_1_1_1);
		

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/logo1.png")));
		lblNewLabel_1.setBounds(23, 21, 96, 73);
		panel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 145, 846, 347);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(jTable1);
	}

	private void btnFind_Click(ActionEvent e) {

		// TODO Auto-generated method stub
		try {
			String courseID = jtxtFind.getText();
			if (courseID.isBlank() == false) {
				List list = kqd.findKQ(courseID);
				DefaultTableModel model = convertKQ(list);
				jTable1.setModel(model);
			} else {
				JOptionPane.showMessageDialog(this, "Course ID is empty", "Message", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException ex) {
			Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void btnAdd_Click(ActionEvent e) throws SQLException {
		// TODO Auto-generated method stub
		AddKQForm addKQ = new AddKQForm();
		addKQ.setVisible(true);
	}

	private void listKQ() throws SQLException {
		List list = kqd.LoadKQ(1);
		DefaultTableModel model = convertKQ(list);
		jTable1.setModel(model);
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				try {
					ClickMouseClicked(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void ClickMouseClicked(MouseEvent evt) throws SQLException {
		int row = jTable1.getSelectedRow();
		waitCourseID = (int) jTable1.getValueAt(row, 2);
		waitStudentID = (int) jTable1.getValueAt(row, 3);
		waitEnrollmentID = (int) jTable1.getValueAt(row, 1);

	}
	public void btnRefresh_Click(ActionEvent e) throws SQLException {
		listKQ();
	}
	public void btnEdit_Click(ActionEvent e) {
		EditKQForm edit = new EditKQForm();
		edit.setVisible(true);
	}
	private void btnDelete_Click(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(this, "Sure? You want to delete?", "Test", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			try {
				if (kqd.deleteKQ(waitCourseID, waitStudentID) > 0) {
					JOptionPane.showMessageDialog(this, "Complete delete", "Message", JOptionPane.INFORMATION_MESSAGE);
					listKQ();
				} else {
					JOptionPane.showMessageDialog(this, "Error delete", "Message", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException ex) {
				Logger.getLogger(KQ.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else if (result == JOptionPane.NO_OPTION) {	
		}
	}
	private DefaultTableModel convertKQ(List list) {
		String[] columnNames = { "TT","EnrollmentID", "Course ID", "Student ID", "Grade", "Result" };
		Object[][] data = new Object[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			Ketqua kq = (Ketqua) list.get(i);
			data[i][0] = i + 1;
			data[i][1] = kq.getEnrollmentID();
			data[i][2] = kq.getCourseID();
			data[i][3] = kq.getStudentID();
			data[i][4] = kq.getGrade();
			data[i][5] = kq.getResult();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		return model;
	}

}

