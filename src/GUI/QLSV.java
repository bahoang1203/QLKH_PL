package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class QLSV extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSV frame = new QLSV();
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
	public QLSV() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 681);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
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
			}
		});
		btnSa.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/edit.png")));
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSa.setBounds(171, 536, 101, 50);
		contentPane.add(btnSa);
		
		JButton btnNewButton_1_1 = new JButton("X\u00F3a");
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
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(133, 43, 106, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 911, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(275, 53, 218, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(QLSV.class.getResource("/IMG/logo1.png")));
		lblNewLabel_1.setBounds(23, 21, 96, 73);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 140, 843, 364);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, "", null, null, null, null},
			},
			new String[] {
				"Person ID", "Last Name", "First Name", "Hire Date", "Grade", "Location", "Timetamp", "Enrollment Date"
			}
		));
		scrollPane.setViewportView(table);
	}
	
}
