package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.border.LineBorder;
import javax.swing.UIManager;

import user.db.UserController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField userNameField;
	private JTextField textField_9;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginGUI frame = new LoginGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * close the current frame and display next frame
	 */
	public void close(){
		 WindowEvent winClosingEvent = 
				 new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().
		 		postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setResizable(false);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 169, 679, 570);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(260, 30, 130, 70);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblLogin.setVerticalAlignment(SwingConstants.TOP);
		lblLogin.setAlignmentY(CENTER_ALIGNMENT);
		lblLogin.setAlignmentY(0.5f);
		panelLeft.add(lblLogin);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		passwordField.setBounds(300, 287, 250, 40);
		panelLeft.add(passwordField);
		
		userNameField = new JTextField();
		userNameField.setToolTipText("");
		userNameField.setHorizontalAlignment(SwingConstants.LEFT);
		userNameField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		userNameField.setBounds(300, 200, 250, 40);
		panelLeft.add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblUsername.setBounds(162, 203, 123, 35);
		panelLeft.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPassword.setBounds(162, 291, 123, 33);
		panelLeft.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				TransactionGUI transactionFrame = new TransactionGUI();
				transactionFrame.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setBounds(443, 455, 107, 33);
		panelLeft.add(btnLogin);
		
		// perform login function
		
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final String userName = userNameField.getText();
				final String password = String.valueOf(
						passwordField.getPassword());
				
				UserController userCtrl = new UserController();
				userCtrl.validateLogin(userName, password);
//				System.out.println(userName + " A " + password);	
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(679, 382, 1, 2);
		panelLeft.add(separator);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(681, 169, 679, 570);
		contentPane.add(panelRight);
		panelRight.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setBounds(203, 30, 274, 70);
		lblRegistration.setVerticalAlignment(SwingConstants.TOP);
		lblRegistration.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblRegistration.setAlignmentY(0.5f);
		panelRight.add(lblRegistration);
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBounds(145, 97, 389, 381);
		panelRight.add(panelRegister);
		
		panelRegister.setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail : ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEmail.setBounds(10, 330, 95, 20);
		panelRegister.add(lblEmail);
		
		JLabel lblTelno = new JLabel("Tel.No : ");
		lblTelno.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTelno.setBounds(10, 287, 95, 17);
		panelRegister.add(lblTelno);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAddress.setBounds(10, 194, 114, 18);
		panelRegister.add(lblAddress);
		
		JLabel lblIcno = new JLabel("IC.No :");
		lblIcno.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblIcno.setBounds(10, 148, 71, 20);
		panelRegister.add(lblIcno);
		
		JLabel lblNewLabel = new JLabel("Full Name : ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 105, 132, 18);
		panelRegister.add(lblNewLabel);
		
		JLabel lblPassword_1 = new JLabel("Password : ");
		lblPassword_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblPassword_1.setBounds(10, 61, 114, 17);
		panelRegister.add(lblPassword_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textField_9.setBounds(150, 7, 229, 34);
		panelRegister.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Username : ");
		lblUsername_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblUsername_1.setBounds(10, 14, 114, 20);
		panelRegister.add(lblUsername_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(150, 97, 229, 34);
		panelRegister.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(150, 141, 229, 34);
		panelRegister.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textField_6.setColumns(10);
		textField_6.setBounds(150, 278, 229, 34);
		panelRegister.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textField_7.setColumns(10);
		textField_7.setBounds(150, 323, 229, 34);
		panelRegister.add(textField_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea.setBounds(150, 194, 229, 73);
		panelRegister.add(textArea);
		textArea.setBorder(new LineBorder(new Color(160, 160, 160)));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		passwordField_1.setBounds(150, 52, 229, 31);
		panelRegister.add(passwordField_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRegister.setBounds(288, 509, 104, 31);
		panelRight.add(btnRegister);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 1360, 169);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblFoodOrderSystem = new JLabel("Food Order System");
		lblFoodOrderSystem.setBounds(475, 59, 410, 51);
		lblFoodOrderSystem.setFont(new Font("Minion Pro SmBd", 
				lblFoodOrderSystem.getFont().getStyle() | Font.BOLD, 50));
		lblFoodOrderSystem.setVerticalAlignment(SwingConstants.TOP);
		lblFoodOrderSystem.setAlignmentY(CENTER_ALIGNMENT);
		panelTitle.add(lblFoodOrderSystem);
	}

}
