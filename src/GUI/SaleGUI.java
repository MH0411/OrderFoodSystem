package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Button;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

public class SaleGUI extends JFrame {

	private JPanel contentPane;
	
	
	String [] columnNames ={"Item","Quantity","Total Price","GST"};
	String [][] data ={{"Burger","30","150.00","9.00"}};
	private JTable table;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 118, 680, 621);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,50));
		table.setBounds(254, 260, 248, -180);
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(53, 114, 574, 399);
		panel.add(scrollPane);
		
		JButton btnPrintReport = new JButton("Print Report");
		btnPrintReport.setBounds(499, 575, 138, 35);
		btnPrintReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnPrintReport);
		btnPrintReport.setFont(new Font("Segoe Marker", Font.PLAIN, 17));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(680, 0, 680, 739);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(120, 122, 370, 319);
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 680, 119);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 63, 17);
		panel_2.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				TransactionGUI transactionFrame = new TransactionGUI();
				transactionFrame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnBack.setVisible(true);
		
		
		JLabel lblSales = DefaultComponentFactory.getInstance().createTitle("Sales");
		lblSales.setBounds(285, 35, 109, 49);
		panel_2.add(lblSales);
		lblSales.setBackground(Color.CYAN);
		lblSales.setFont(new Font("Tekton Pro", Font.PLAIN, 48));
		lblSales.setForeground(Color.BLUE);
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		btnPrintReport.setVisible(true);
		table.setVisible(true);
				
	}
}
