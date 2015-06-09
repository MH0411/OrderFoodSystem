package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.EventObject;

import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField userNameField;
	private JTextField registerUserNameField;
	private JTextField registerFullNameField;
	private JTextField icNoTextField;
	private JTextField telNoTextField;
	private JTextField emailTextField;
	private JPasswordField registerPasswordField;
	private JButton loginButton;
	private JButton registerButton; 
	private JTextArea addressTextArea;

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
	public void close() {
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
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 169, 680, 570);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setBounds(275, 34, 130, 70);
		loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		loginLabel.setVerticalAlignment(SwingConstants.TOP);
		loginLabel.setAlignmentY(CENTER_ALIGNMENT);
		loginLabel.setAlignmentY(0.5f);
		loginPanel.add(loginLabel);
		
		JPanel loginInputpanel = new JPanel();
		loginInputpanel.setBounds(123, 167, 433, 251);
		loginPanel.add(loginInputpanel);
		loginInputpanel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 97, 250, 40);
		loginInputpanel.add(passwordField);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		userNameField = new JTextField();
		userNameField.setBounds(168, 8, 250, 40);
		loginInputpanel.add(userNameField);
		userNameField.setToolTipText("");
		userNameField.setHorizontalAlignment(SwingConstants.LEFT);
		userNameField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		userNameField.setColumns(10);
		
		JLabel userNameLabel = new JLabel("Username : ");
		userNameLabel.setBounds(10, 11, 123, 35);
		loginInputpanel.add(userNameLabel);
		userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		JLabel passwordLabel = new JLabel("Password : ");
		passwordLabel.setBounds(10, 101, 123, 33);
		loginInputpanel.add(passwordLabel);
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		loginButton = new JButton("Login");
		loginButton.setBounds(311, 204, 107, 33);
		loginInputpanel.add(loginButton);
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		// call addActionListener when loginButton is clicked
		loginButton.addActionListener(this);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBounds(680, 169, 680, 570);
		contentPane.add(registerPanel);
		registerPanel.setLayout(null);
		
		JLabel registrationLabel = new JLabel("Registration");
		registrationLabel.setBounds(203, 30, 274, 70);
		registrationLabel.setVerticalAlignment(SwingConstants.TOP);
		registrationLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		registrationLabel.setAlignmentY(0.5f);
		registerPanel.add(registrationLabel);
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBounds(145, 97, 389, 435);
		registerPanel.add(panelRegister);
		
		panelRegister.setLayout(null);
		
		JLabel emailLabel = new JLabel("E-mail : ");
		emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		emailLabel.setBounds(10, 330, 95, 20);
		panelRegister.add(emailLabel);
		
		JLabel telNoLabel = new JLabel("Tel.No : ");
		telNoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		telNoLabel.setBounds(10, 287, 95, 17);
		panelRegister.add(telNoLabel);
		
		JLabel addressLabel = new JLabel("Address : ");
		addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		addressLabel.setBounds(10, 194, 114, 18);
		panelRegister.add(addressLabel);
		
		JLabel icNoLabel = new JLabel("IC.No :");
		icNoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		icNoLabel.setBounds(10, 148, 71, 20);
		panelRegister.add(icNoLabel);
		
		JLabel fullNameLabel = new JLabel("Full Name : ");
		fullNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		fullNameLabel.setBounds(10, 105, 132, 18);
		panelRegister.add(fullNameLabel);
		
		JLabel registerPasswordLabel = new JLabel("Password : ");
		registerPasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN,
				24));
		registerPasswordLabel.setBounds(10, 61, 114, 17);
		panelRegister.add(registerPasswordLabel);
		
		JLabel registerUserNameLabel = new JLabel("Username : ");
		registerUserNameLabel.setFont(new Font("Times New Roman", Font.PLAIN,
				24));
		registerUserNameLabel.setBounds(10, 14, 114, 20);
		panelRegister.add(registerUserNameLabel);
		
		registerUserNameField = new JTextField();
		registerUserNameField.setFont(new Font("Times New Roman", Font.PLAIN,
				24));
		registerUserNameField.setBounds(150, 7, 229, 34);
		panelRegister.add(registerUserNameField);
		registerUserNameField.setColumns(10);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setFont(new Font("Times New Roman", Font.BOLD,
																																																																																																	24));
		registerPasswordField.setBounds(150, 52, 229, 31);
		panelRegister.add(registerPasswordField);
		
		registerFullNameField = new JTextField();
		registerFullNameField.setFont(new Font("Times New Roman", Font.PLAIN,
				24));
		registerFullNameField.setColumns(10);
		registerFullNameField.setBounds(150, 97, 229, 34);
		panelRegister.add(registerFullNameField);
		
		JFormattedTextField icField = new JFormattedTextField();
		icField.setColumns(2);
		
		
		icNoTextField = new JTextField();
		icNoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		icNoTextField.setColumns(10);
		icNoTextField.setBounds(150, 141, 229, 34);
		icNoTextField.addKeyListener(this);
		panelRegister.add(icNoTextField);
		
		telNoTextField = new JTextField();
		telNoTextField.setToolTipText("xxx-xxxxxxx");
		telNoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		telNoTextField.setColumns(1);
		telNoTextField.setBounds(150, 278, 229, 34);
		telNoTextField.addKeyListener(this);
		panelRegister.add(telNoTextField);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		emailTextField.setColumns(10);
		emailTextField.setBounds(150, 323, 229, 34);
		panelRegister.add(emailTextField);
		
		addressTextArea = new JTextArea();
		addressTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addressTextArea.setBounds(150, 194, 229, 73);
		panelRegister.add(addressTextArea);
		addressTextArea.setBorder(new LineBorder(new Color(160, 160, 160)));
		
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		registerButton.setBounds(149, 368, 104, 31);
		panelRegister.add(registerButton);
		registerButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 1360, 169);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel foodOrderSystemLabel = new JLabel("Food Order System");
		foodOrderSystemLabel.setBounds(475, 59, 410, 51);
		foodOrderSystemLabel.setFont(new Font("Minion Pro SmBd", 
				foodOrderSystemLabel.getFont().getStyle() | Font.BOLD, 50));
		foodOrderSystemLabel.setVerticalAlignment(SwingConstants.TOP);
		foodOrderSystemLabel.setAlignmentY(CENTER_ALIGNMENT);
		titlePanel.add(foodOrderSystemLabel);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		Object actionSource = action.getSource();
		// if login button is clicked
		if (actionSource == loginButton) {
			final String userName = userNameField.getText().trim();
			final String password = String.valueOf(
					passwordField.getPassword()).trim();
			
			UserController userCtrl = new UserController();
			try {
				if (userCtrl.validateLogin(userName, password)) {
					close();
					TransactionGUI transactionFrame = new TransactionGUI();
					transactionFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, 
							"Incorrect username or password.");
				}
			} catch (HeadlessException | ClassNotFoundException |
					SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (actionSource == registerButton) {
			final String userName = registerUserNameField.getText().trim();
			final String password = String.valueOf(
					registerPasswordField.getPassword()).trim();
			final String comfirmPassword;
			final String fullName = registerFullNameField.getText().trim();
			final String ic = icNoTextField.getText().trim();
			final String address = addressTextArea.getText().trim();
//			for (String address: addressTextArea.getText().split("\\n")) {
//				addressTextArea.append(address);
//			}
			final String telNo = telNoTextField.getText().trim();
			final String email = emailTextField.getText().trim();
			
			UserController userCtrl = new UserController();
			try {
				if (validateRegisterRequiredField()) {
					if (userCtrl.validateRegister(userName, password, fullName, 
							ic, address, telNo, email)) {
						JOptionPane.showMessageDialog(null, 
								"Register successfully!");
					} else {
						JOptionPane.showMessageDialog(null, 
								"The username is used.");
					}
				} else {
					JOptionPane.showMessageDialog(null, 
							"Please fill in all text field.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * Override method in KeyListener
	 */
	@Override
	public void keyPressed(KeyEvent e) {}
	/**
	 * Override method in KeyListener
	 */
	@Override
	public void keyReleased(KeyEvent e) {}
	/**
	 * Override method in KeyListener
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!(Character.isDigit(c) || (c == KeyEvent.VK_MINUS)) || 
				(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
			e.consume();
		}
	}
	
	/**
	 * this method is used to validate whether all the fields in register are 
	 * filled up or not
	 * @return
	 */
	public boolean validateRegisterRequiredField() {
		return !(registerUserNameField.getText().length() == 0 || String
				.valueOf(registerPasswordField.getPassword()).length() == 0 || 
				registerFullNameField.getText().length() == 0 || 
				icNoTextField.getText().length() == 0 || 
				addressTextArea.getText().length() == 0 || 
				telNoTextField.getText().length() == 0 || 
				emailTextField.getText().length() == 0);
	}
	
	/**
	 * this method is used to validate whether all the fields in login are
	 * filled up or not
	 * @return
	 */
	public boolean validateLoginRequiredField() {
		return !(userNameField.getText().length() == 0 ||
				String.valueOf(passwordField.getPassword()).length() == 0);
	}

}
