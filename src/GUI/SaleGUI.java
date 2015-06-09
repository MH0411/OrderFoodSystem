package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class SaleGUI extends JFrame {

	private JPanel contentPane;
	
	
	String [] columnNames ={"Food","Quantity","Total Price"};
	private JTable salesTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleGUI frame = new SaleGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void close(){
		 WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public SaleGUI() {
		
		this.setResizable(false);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setVisible(true);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem backMenuItem = new JMenuItem("Back");
		menu.add(backMenuItem);
		
		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		menu.add(logoutMenuItem);
		
		JPanel salesPanel = new JPanel();
		salesPanel.setBounds(0, 142, 680, 597);
		contentPane.add(salesPanel);
		salesPanel.setLayout(null);
		
		Object[][] data = null;
		salesTable = new JTable(data,columnNames);
		salesTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		salesTable.setBounds(254, 260, 248, -180);
		JScrollPane scrollPane=new JScrollPane(salesTable);
		scrollPane.setBounds(67, 53, 545, 491);
		salesPanel.add(scrollPane);
		
		JPanel resultPanel = new JPanel();
		resultPanel.setBounds(680, 142, 680, 597);
		contentPane.add(resultPanel);
		resultPanel.setLayout(null);
		
		JButton PrintButton = new JButton("Print Report");
		PrintButton.setBounds(227, 522, 225, 35);
		resultPanel.add(PrintButton);
		PrintButton.setFont(new Font("Times New Roman", Font.BOLD, 35));
		PrintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		PrintButton.setVisible(true);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 21, 1360, 119);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		
		JLabel salesLabel = DefaultComponentFactory.getInstance().createTitle("Sales");
		salesLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		salesLabel.setBounds(591, 35, 177, 49);
		titlePanel.add(salesLabel);
		salesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salesTable.setVisible(true);
				
	}
}
