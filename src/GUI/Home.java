package GUI;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		this.setLocationRelativeTo(null);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 681);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 911, 148);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD KH\u00D3A H\u1ECCC");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(178, 33, 309, 87);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/IMG/logo.png")));
		lblNewLabel_1.setBounds(42, 23, 128, 97);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("KH\u00D3A H\u1ECCC ONSITE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KH_Onsite os = new KH_Onsite();
				os.show();
				
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/IMG/onsite.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 153, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(64, 345, 336, 65);
		contentPane.add(btnNewButton);
		
		JButton btnQunLSinh = new JButton("QU\u1EA2N L\u00DD GI\u1EA2NG VI\u00CAN");
		btnQunLSinh.setForeground(Color.WHITE);
		btnQunLSinh.setBackground(new Color(102, 153, 255));
		btnQunLSinh.setIcon(new ImageIcon(Home.class.getResource("/IMG/teacher.png")));
		btnQunLSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQunLSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLGV qlgv = new QLGV();
				qlgv.show();
				
				dispose();
			}
		});
		btnQunLSinh.setBounds(64, 224, 336, 65);
		contentPane.add(btnQunLSinh);
		
		JButton btnPhnCngGing = new JButton("PH\u00C2N C\u00D4NG GI\u1EA2NG D\u1EA0Y");
		btnPhnCngGing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PCGD pcgd = new PCGD();
				pcgd.show();
				
				dispose();
			}
		});
		btnPhnCngGing.setIcon(new ImageIcon(Home.class.getResource("/IMG/assign.png")));
		btnPhnCngGing.setForeground(Color.WHITE);
		btnPhnCngGing.setBackground(new Color(102, 153, 255));
		btnPhnCngGing.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPhnCngGing.setBounds(64, 482, 336, 65);
		contentPane.add(btnPhnCngGing);
		
		JButton btnQunLGing = new JButton("QU\u1EA2N L\u00DD SINH VI\u00CAN");
		btnQunLGing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLSV qlsv = new QLSV();
				qlsv.show();
				
				dispose();
			}
		});
		btnQunLGing.setIcon(new ImageIcon(Home.class.getResource("/IMG/student.png")));
		btnQunLGing.setForeground(Color.WHITE);
		btnQunLGing.setBackground(new Color(102, 153, 255));
		btnQunLGing.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQunLGing.setBounds(532, 224, 336, 65);
		contentPane.add(btnQunLGing);
		
		JButton btnNewButton_3_1 = new JButton("KH\u00D3A H\u1ECCC ONLINE");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KH_Online ol = new KH_Online();
				ol.show();
				
				dispose();
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon(Home.class.getResource("/IMG/online-course.png")));
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setBackground(new Color(102, 153, 255));
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1.setBounds(532, 345, 336, 65);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("K\u1EBET QU\u1EA2 KH\u00D3A H\u1ECCC");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					KQ kq;
					try {
						kq = new KQ();
						kq.show();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				dispose();
			}
		});
		btnNewButton_3_1_1.setIcon(new ImageIcon(Home.class.getResource("/IMG/result.png")));
		btnNewButton_3_1_1.setForeground(Color.WHITE);
		btnNewButton_3_1_1.setBackground(new Color(102, 153, 255));
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_1.setBounds(532, 482, 336, 65);
		contentPane.add(btnNewButton_3_1_1);
	}
}
