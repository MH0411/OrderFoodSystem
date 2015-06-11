package main;

import java.awt.EventQueue;

import GUI.LoginGUI;

/**
 * This class represent the main of this application
 * This application is started from here
 * @author JKGan
 *
 */
public class Application {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
