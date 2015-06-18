package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import user.User;
import user.db.UserController;

/**
 * This class represent GUI of Login and Register page.
 * User can either login or register in this GUI.
 * @author JKGan
 *
 */

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
	private JPasswordField confirmPasswordTextField;
	
	private final String FONT_STYLE = "Times New Roman";

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
		loginLabel.setFont(new Font(FONT_STYLE, Font.BOLD, 50));
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
		passwordField.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		
		userNameField = new JTextField();
		userNameField.setBounds(168, 8, 250, 40);
		loginInputpanel.add(userNameField);
		userNameField.setToolTipText("");
		userNameField.setHorizontalAlignment(SwingConstants.LEFT);
		userNameField.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		userNameField.setColumns(10);
		
		JLabel userNameLabel = new JLabel("Username : ");
		userNameLabel.setBounds(10, 11, 123, 35);
		loginInputpanel.add(userNameLabel);
		userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userNameLabel.setFont(new Font(FONT_STYLE, Font.BOLD, 24));
		
		JLabel passwordLabel = new JLabel("Password : ");
		passwordLabel.setBounds(10, 101, 123, 33);
		loginInputpanel.add(passwordLabel);
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font(FONT_STYLE, Font.BOLD, 24));
		
		loginButton = new JButton("Login");
		loginButton.setBounds(311, 204, 107, 33);
		loginInputpanel.add(loginButton);
		loginButton.setFont(new Font(FONT_STYLE, Font.BOLD, 18));
		// call addActionListener when loginButton is clicked
		loginButton.addActionListener(this);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBounds(680, 169, 680, 570);
		contentPane.add(registerPanel);
		registerPanel.setLayout(null);
		
		JLabel registrationLabel = new JLabel("Registration");
		registrationLabel.setBounds(203, 30, 274, 70);
		registrationLabel.setVerticalAlignment(SwingConstants.TOP);
		registrationLabel.setFont(new Font(FONT_STYLE, Font.BOLD, 50));
		registrationLabel.setAlignmentY(0.5f);
		registerPanel.add(registrationLabel);
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBounds(77, 91, 458, 435);
		registerPanel.add(panelRegister);
		
		panelRegister.setLayout(null);
		
		JLabel emailLabel = new JLabel("E-mail : ");
		emailLabel.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		emailLabel.setBounds(10, 294, 95, 20);
		panelRegister.add(emailLabel);
		
		JLabel telNoLabel = new JLabel("Tel.No : ");
		telNoLabel.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		telNoLabel.setBounds(10, 251, 95, 17);
		panelRegister.add(telNoLabel);
		
		JLabel icNoLabel = new JLabel("IC.No :");
		icNoLabel.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		icNoLabel.setBounds(10, 204, 71, 20);
		panelRegister.add(icNoLabel);
		
		JLabel fullNameLabel = new JLabel("Full Name : ");
		fullNameLabel.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		fullNameLabel.setBounds(10, 160, 132, 18);
		panelRegister.add(fullNameLabel);
		
		JLabel registerPasswordLabel = new JLabel("Password : ");
		registerPasswordLabel.setFont(new Font(FONT_STYLE, Font.PLAIN,
				24));
		registerPasswordLabel.setBounds(10, 61, 114, 17);
		panelRegister.add(registerPasswordLabel);
		
		JLabel registerUserNameLabel = new JLabel("Username : ");
		registerUserNameLabel.setFont(new Font(FONT_STYLE, Font.PLAIN,
				24));
		registerUserNameLabel.setBounds(10, 14, 114, 20);
		panelRegister.add(registerUserNameLabel);
		
		registerUserNameField = new JTextField();
		registerUserNameField.setFont(new Font(FONT_STYLE, Font.PLAIN,
				24));
		registerUserNameField.setBounds(216, 14, 229, 34);
		panelRegister.add(registerUserNameField);
		registerUserNameField.setColumns(10);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setFont(new Font(FONT_STYLE, Font.BOLD,
																																																																																																	24));
		registerPasswordField.setBounds(216, 59, 229, 31);
		panelRegister.add(registerPasswordField);
		
		registerFullNameField = new JTextField();
		registerFullNameField.setFont(new Font(FONT_STYLE, Font.PLAIN,
				24));
		registerFullNameField.setColumns(10);
		registerFullNameField.setBounds(216, 152, 229, 34);
		panelRegister.add(registerFullNameField);
		
		JFormattedTextField icField = new JFormattedTextField();
		icField.setColumns(2);
		
		
		icNoTextField = new JTextField();
		icNoTextField.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		icNoTextField.setColumns(10);
		icNoTextField.setBounds(216, 197, 229, 34);
		icNoTextField.addKeyListener(this);
		panelRegister.add(icNoTextField);
		
		telNoTextField = new JTextField();
		telNoTextField.setToolTipText("xxx-xxxxxxx");
		telNoTextField.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		telNoTextField.setColumns(1);
		telNoTextField.setBounds(216, 242, 229, 34);
		telNoTextField.addKeyListener(this);
		panelRegister.add(telNoTextField);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		emailTextField.setColumns(10);
		emailTextField.setBounds(216, 287, 229, 34);
		panelRegister.add(emailTextField);
		
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		registerButton.setBounds(149, 368, 104, 31);
		panelRegister.add(registerButton);
		registerButton.setFont(new Font(FONT_STYLE, Font.BOLD, 18));
		
		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setFont(new Font(FONT_STYLE, Font.BOLD, 24));
		confirmPasswordTextField.setColumns(10);
		confirmPasswordTextField.setBounds(216, 106, 229, 34);
		panelRegister.add(confirmPasswordTextField);
		
		JLabel confirmPasswordlabel = new JLabel("Confirm Password : ");
		confirmPasswordlabel.setFont(new Font(FONT_STYLE, Font.PLAIN, 24));
		confirmPasswordlabel.setBounds(10, 115, 196, 17);
		panelRegister.add(confirmPasswordlabel);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 1360, 169);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel foodOrderSystemLabel = new JLabel("BKB FOOD ENTERPRISE");
		foodOrderSystemLabel.setBounds(345, 35, 669, 77);
		foodOrderSystemLabel.setFont(new Font(FONT_STYLE, Font.BOLD, 55));
		foodOrderSystemLabel.setVerticalAlignment(SwingConstants.TOP);
		foodOrderSystemLabel.setAlignmentY(CENTER_ALIGNMENT);
		titlePanel.add(foodOrderSystemLabel);
	}

	/**
	 * Method to access when click event perform.
	 */
	@Override
	public void actionPerformed(ActionEvent action) {
		Object actionSource = action.getSource();
		// if login button is clicked
		if (actionSource == loginButton) {
			// Get userName and password from text fields
			final String userName = userNameField.getText().trim();
			final String password = String.valueOf(
					passwordField.getPassword()).trim();
			User user = new User(userName, password);
			
			// Create an UserController object
			UserController userCtrl = new UserController();
			try {
				// will be true if all required fields is filled in
				if (validateLoginRequiredField()) {
					// will be true if userName and password is valid
					if (userCtrl.validateLogin(user)) {
						// close current frame and redirect to TransactionGUI
						close();
						TransactionGUI transactionFrame = new TransactionGUI();
						transactionFrame.setVisible(true);
					} else {
						// Prompt a dialog to explain error
						JOptionPane.showMessageDialog(null, 
								"Incorrect username or password.");
					}
				} else {
					// Prompt a dialog to explain error
					JOptionPane.showMessageDialog(null, "Please fill in all "
							+ "text fields.");
				}
				
			} catch (HeadlessException | ClassNotFoundException |
					SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// if registerButton is clicked
		} else if (actionSource == registerButton) {
			// Create an UserContoller object
			UserController userCtrl = new UserController();
			
			try {
				// will be true if all required fields are filled in
				if (validateRegisterRequiredField()) {
					// Get inputs from all text fields
					final String userName = registerUserNameField.getText().
							trim();
					final String password = String.valueOf(
							registerPasswordField.getPassword()).trim();
					final String comfirmPassword = String.valueOf(
							confirmPasswordTextField.getPassword()).trim();
					final String fullName = registerFullNameField.getText().
							trim();
					final String ic = icNoTextField.getText().trim();
					final String telNo = telNoTextField.getText().trim();
					final String email = emailTextField.getText().trim();
					
					// will be true if password and confirmPassword are same
					if (password.equals(comfirmPassword)) {
						// will be true if userName in valid and haven't been 
						// used and stored user info into database
						User user = new User(userName, fullName, password,
										ic, telNo, email);
						if (userCtrl.validateRegister(user)) {
							// Prompt success message
							JOptionPane.showMessageDialog(null, 
									"Register successfully!");
							registerUserNameField.setText("");
							registerPasswordField.setText("");
							confirmPasswordTextField.setText("");
							registerFullNameField.setText("");
							icNoTextField.setText("");
							telNoTextField.setText("");
							emailTextField.setText("");
						} else {
							JOptionPane.showMessageDialog(null, 
									"The username is used.");
						}
					} else {
						JOptionPane.showMessageDialog(null, 
								"Your password and confirm password are not "
								+ "same.");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, 
							"Please fill in all text fields.");
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
	 * Allow only integer in specific text field
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
