package GUI;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import transaction.Sale;

import java.sql.SQLException;
import java.util.Properties;

@SuppressWarnings("serial")
public class SaleGUI extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem backMenuItem;
	private JMenuItem logoutMenuItem;
	private JPanel contentPane;
	private JPanel salesPanel;
	private JScrollPane scrollPanel;
	private JPanel resultPanel;
	private JButton searchButton;
	private JTable salesTable;
	private JTable table;
	private JTextField startDateTextField;
	private JTextField endDateTextField;

	private String fontStyle = "Times New Roman";
	
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
		 WindowEvent winClosingEvent = 
				 new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().
		 		getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public SaleGUI() {
		
		setResizable(false);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Menu Bar ==========================================================
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 21);
		contentPane.add(menuBar);
		
		menu = new JMenu("Menu");
		menuBar.add(menu);
		
		backMenuItem = new JMenuItem("Back");
		menu.add(backMenuItem);
		
		logoutMenuItem = new JMenuItem("Logout");
		menu.add(logoutMenuItem);
		
		//Left panel =========================================================
		salesPanel = new JPanel();
		salesPanel.setBounds(0, 142, 680, 597);
		contentPane.add(salesPanel);
		
		salesTable = new JTable();
		salesTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		salesTable.setBounds(254, 260, 248, -180);
		
		scrollPanel = new JScrollPane(salesTable);
		scrollPanel.setBounds(67, 53, 545, 491);
		salesPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 167, 537, 375);
		salesPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Food", "Quantity", "Total Price"
			}
		));
		scrollPane.setViewportView(table);
		
		startDateTextField = new JTextField();
		startDateTextField.setBounds(71, 73, 124, 20);
		startDateTextField.addActionListener(this);
		salesPanel.add(startDateTextField);
		startDateTextField.setColumns(10);
		
		endDateTextField = new JTextField();
		endDateTextField.setEditable(false);
		endDateTextField.setBounds(71, 114, 124, 20);
		salesPanel.add(endDateTextField);
		endDateTextField.setColumns(10);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(354, 99, 168, 35);
		salesPanel.add(searchButton);
		searchButton.setFont(new Font(fontStyle, Font.BOLD, 35));	
		searchButton.setVisible(true);
		searchButton.addActionListener(this);
		
//		UtilDateModel model = new UtilDateModel();
//		JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);		 
//		salesPanel.add(datePicker);
		
		UtilDateModel model=new UtilDateModel();
		Properties p=new Properties();
		p.put("text.today","Today");
		p.put("text.month","Month");
		p.put("text.year","Year");
		JDatePanelImpl datePanel= new JDatePanelImpl(model,p);
		JDatePickerImpl datePicker= new JDatePickerImpl(datePanel
				,new DateComponentFormatter());
		datePicker.setSize(200,30);
		
		//Right panel =======================================================
		resultPanel = new JPanel();
		resultPanel.setBounds(680, 142, 680, 597);
		contentPane.add(resultPanel);
		resultPanel.setLayout(null);

		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 21, 1360, 119);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel salesLabel = DefaultComponentFactory.getInstance().createTitle("Sales");
		salesLabel.setFont(new Font(fontStyle, Font.BOLD, 60));
		salesLabel.setBounds(591, 35, 177, 49);
		titlePanel.add(salesLabel);
		salesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salesTable.setVisible(true);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backMenuItem){
			TransactionGUI transactionFrame = new TransactionGUI();
			transactionFrame.setVisible(true);
			close();	
		} else if (e.getSource() == logoutMenuItem){
			LoginGUI loginFrame = new LoginGUI();
			loginFrame.setVisible(true);
			close();
		} else if (e.getSource() == searchButton){
			Sale sale = new Sale();
			try {
				sale.displaySales(table);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
