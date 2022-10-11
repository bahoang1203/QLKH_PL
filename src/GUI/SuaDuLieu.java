package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class SuaDuLieu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemDuLieu frame = new ThemDuLieu();
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
	public SuaDuLieu() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 78, 242, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Title");
		lblNewLabel_1_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1.setBounds(41, 119, 45, 13);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(142, 116, 242, 19);
		contentPane.add(textField_2);
		
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(142, 155, 242, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(142, 192, 242, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(142, 269, 242, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(142, 310, 242, 19);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.setIcon(new ImageIcon(ThemDuLieu.class.getResource("/IMG/Custom-Icon-Design-Flatastic-9-Save.png")));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(102, 153, 255));
		btnNewButton.setBounds(41, 348, 98, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tho\u00E1t");
		btnNewButton_1.setIcon(new ImageIcon(ThemDuLieu.class.getResource("/IMG/back.png")));
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
}
