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

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class SaleGUI extends JFrame {

	private JPanel contentPane;
	
	
	String [] columnNames ={"Item","Quantity","Total Price","GST"};
	String [][] data ={{"Burger","30","150.00","9.00"}};
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SaleGUI() {
		
		this.setResizable(false);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblSales = DefaultComponentFactory.getInstance().createTitle("Sales");
		lblSales.setBackground(Color.CYAN);
		lblSales.setBounds(5, 5, 730, 41);
		lblSales.setFont(new Font("Tekton Pro", Font.PLAIN, 40));
		lblSales.setForeground(Color.BLUE);
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVisible(true);
		contentPane.add(lblSales);
		
		JButton btnPrintReport = new JButton("Print Report");
		btnPrintReport.setFont(new Font("Segoe Marker", Font.PLAIN, 17));
		btnPrintReport.setBounds(539, 384, 138, 35);
		btnPrintReport.setVisible(true);
		contentPane.add(btnPrintReport);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 17));
		btnBack.setBounds(5, 5, 97, 25);
		btnBack.setVisible(true);
		contentPane.add(btnBack);
		
		table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,50));
		table.setBounds(254, 260, 248, -180);
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setLocation(52, 45);
		scrollPane.setSize(574, 300);
		table.setVisible(true);
		contentPane.add(scrollPane);
		
		
		
	}
	
	
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
}
