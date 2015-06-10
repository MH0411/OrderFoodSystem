package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import print.PrintPDF;
import transaction.Sale;
import transaction.db.TransactionController;

import com.itextpdf.text.DocumentException;
import com.jgoodies.forms.factories.DefaultComponentFactory;

@SuppressWarnings("serial")
public class SaleGUI extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem backMenuItem;
	private JMenuItem logoutMenuItem;
	private JPanel contentPane;
	private JPanel salesPanel;
	private JPanel titlePanel;
	private JPanel datePanel;
	private JScrollPane scrollPane;
	private JButton searchButton;
	private JButton printButton;
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
	private String startDate;
	private String endDate;
	private String fontStyle = "Times New Roman";
	private DefaultTableCellRenderer centerRenderer;
	private TransactionController transactionCtrl;
	private Vector<Sale> sales = new Vector<Sale>();
	
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
	
	/**
	 * Method to close current frame
	 */
	public void close(){
		 WindowEvent winClosingEvent = 
				 new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().
		 		getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create frame and components
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
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 32, 1360, 108);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		salesLabel = DefaultComponentFactory.getInstance().createTitle("Sales");
		salesLabel.setFont(new Font(fontStyle, Font.BOLD, 60));
		salesLabel.setBounds(591, 22, 177, 49);
		titlePanel.add(salesLabel);
		salesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 21);
		contentPane.add(menuBar);
		
		menu = new JMenu("Menu");
		menuBar.add(menu);
		
		backMenuItem = new JMenuItem("Back");
		backMenuItem.addActionListener(this);
		menu.add(backMenuItem);
		
		logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(this);
		menu.add(logoutMenuItem);
		
		salesPanel = new JPanel();
		salesPanel.setBounds(0, 142, 1360, 597);
		contentPane.add(salesPanel);
		salesPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 37, 905, 549);
		salesPanel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		//Set table column
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"ID", "Food", "Quantity", "Unit Price (RM)", "Total Price (RM)"
			}
		));
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		//Center table content
		for(int index = 0 ; index < 5 ; index++){
	         table.getColumnModel().getColumn(index).
	         	setCellRenderer( centerRenderer );
	    }
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		scrollPane.setViewportView(table);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(1080, 360, 149, 49);
		salesPanel.add(searchButton);
		searchButton.setFont(new Font(fontStyle, Font.BOLD, 35));	
		searchButton.setVisible(true);
		searchButton.addActionListener(this);
		
		printButton = new JButton("PDF");
		printButton.setBounds(1080, 460, 149, 49);
		salesPanel.add(printButton);
		printButton.setFont(new Font(fontStyle, Font.BOLD, 35));	
		printButton.setVisible(true);
		printButton.addActionListener(this);
			
		start = new Properties();
		start.put("text.today","Today");
		start.put("text.month","Month");
		start.put("text.year","Year");
		
		startDatePanel = new JDatePanelImpl(startModel, start);
		
		end = new Properties();
		end.put("text.today","Today");
		end.put("text.month","Month");
		end.put("text.year","Year");
		endDatePanel = new JDatePanelImpl(endModel, end);
		
		datePanel = new JPanel();
		datePanel.setBorder(new LineBorder(new Color(192, 192, 192), 10));
		datePanel.setBounds(1003, 73, 287, 200);
		salesPanel.add(datePanel);
		datePanel.setLayout(null);
		startDatePicker = new JDatePickerImpl(startDatePanel
				,new DateComponentFormatter());
		startDatePicker.setBounds(44, 61, 202, 30);
		datePanel.add(startDatePicker);
		endDatePicker = new JDatePickerImpl(endDatePanel
				,new DateComponentFormatter());
		endDatePicker.setBounds(44, 139, 202, 30);
		datePanel.add(endDatePicker);
		
		endDateLabel = new JLabel("End Date : ");
		endDateLabel.setFont(new Font("fontStyle", Font.BOLD, 18));
		endDateLabel.setBounds(44, 114, 95, 14);
		datePanel.add(endDateLabel);
		
		startDateLabel = new JLabel("Start Date : ");
		startDateLabel.setFont(new Font("fontStyle", Font.BOLD, 18));
		startDateLabel.setBounds(44, 36, 95, 14);
		datePanel.add(startDateLabel);
	}

	/**
	 * Method to access when click event perform.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == backMenuItem){
			
			//Close current frame and go to transaction frame
			TransactionGUI transactionFrame = new TransactionGUI();
			transactionFrame.setVisible(true);
			close();	
			
		} else if (e.getSource() == logoutMenuItem){
			
			//Close current frame and go to login frame
			LoginGUI loginFrame = new LoginGUI();
			loginFrame.setVisible(true);
			close();
			
		} else if (e.getSource() == searchButton) {
			
			//Check empty fields
			if ((startDatePicker.getModel().getValue() != null) 
					&& (endDatePicker.getModel().getValue() != null)) {
				
				//Refresh table
				((DefaultTableModel) table.getModel()).
					getDataVector().removeAllElements();
				
				//Get start and end date from date picker.
				startDate = dateFormatter.format
						(startDatePicker.getModel().getValue());
				endDate = dateFormatter.format
						(endDatePicker.getModel().getValue());
	
				try {
					
					//Display sales of items
					transactionCtrl = new TransactionController();
					sales = transactionCtrl.displaySales(table, startDate, endDate);
					
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			} else {
				
				//Prompt user select dates
				String message = "Please select both dates to search.";
				JOptionPane.showMessageDialog(null, message, "Alert", 
						getDefaultCloseOperation());
			}
		} else if (e.getSource() == printButton) {
			try {
				PrintPDF.createSalePDF(sales);
			} catch (FileNotFoundException | DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
 
}
