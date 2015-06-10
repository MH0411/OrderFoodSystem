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

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import transaction.Sale;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

@SuppressWarnings("serial")
public class SaleGUI extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem backMenuItem;
	private JMenuItem logoutMenuItem;
	private JPanel contentPane;
	private JPanel salesPanel;
	private JPanel titlePanel;
	private JScrollPane scrollPanel;
	private JScrollPane scrollPane;
	private JPanel resultPanel;
	private JButton searchButton;
	private JTable salesTable;
	private JTable table;
	private JLabel startDateLabel;
	private JLabel endDateLabel;
	private JLabel salesLabel;
	private UtilDateModel startModel = new UtilDateModel();
	private UtilDateModel endModel = new UtilDateModel();
	private Properties start;
	private Properties end;
	private JDatePanelImpl startDatePanel;
	private JDatePickerImpl startDatePicker;
	private JDatePanelImpl endDatePanel;
	private JDatePickerImpl endDatePicker;
	private String datePattern = "yyyy-MM-dd";
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

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
		
		scrollPane = new JScrollPane();
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
		
		searchButton = new JButton("Search");
		searchButton.setBounds(440, 99, 168, 35);
		salesPanel.add(searchButton);
		searchButton.setFont(new Font(fontStyle, Font.BOLD, 35));	
		searchButton.setVisible(true);
		searchButton.addActionListener(this);
			
		start = new Properties();
		start.put("text.today","Today");
		start.put("text.month","Month");
		start.put("text.year","Year");
		
		startDatePanel = new JDatePanelImpl(startModel, start);
		startDatePicker = new JDatePickerImpl(startDatePanel
				,new DateComponentFormatter());
		startDatePicker.setLocation(71, 42);
		startDatePicker.setSize(200,30);
		salesPanel.add(startDatePicker);
		
		end = new Properties();
		end.put("text.today","Today");
		end.put("text.month","Month");
		end.put("text.year","Year");
		endDatePanel = new JDatePanelImpl(endModel, end);
		endDatePicker = new JDatePickerImpl(endDatePanel
				,new DateComponentFormatter());
		endDatePicker.setLocation(71, 119);
		endDatePicker.setSize(200,30);
		salesPanel.add(endDatePicker);
		
		startDateLabel = new JLabel("Start Date : ");
		startDateLabel.setBounds(71, 11, 77, 20);
		salesPanel.add(startDateLabel);
		
		endDateLabel = new JLabel("End Date : ");
		endDateLabel.setBounds(71, 88, 77, 20);
		salesPanel.add(endDateLabel);
		
		//Right panel =======================================================
		resultPanel = new JPanel();
		resultPanel.setBounds(680, 142, 680, 597);
		contentPane.add(resultPanel);
		resultPanel.setLayout(null);

		
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 21, 1360, 119);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		salesLabel = DefaultComponentFactory.getInstance().createTitle("Sales");
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
			
			String startDate;
			String endDate;
			try {
				startDate =valueToString(startDatePicker.getModel().getValue());
				endDate = valueToString(endDatePicker.getModel().getValue());
				System.out.println(startDate + endDate);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
//			try {
//				
//				sale.displaySales(table);
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
		}
	}
 
    public String valueToString(Object value) throws ParseException {
    	return dateFormatter.format(startDatePicker.getModel().getValue());
    }
}
