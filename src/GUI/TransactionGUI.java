package GUI;

import item.db.ComboItem;
import item.db.ItemController;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class TransactionGUI extends JFrame 
		implements ActionListener, DocumentListener{

	private JPanel contentPane;
	private JTextField unitPriceTextField;
	private JTextField subTotalPriceTextField;
	private JTextField cashTextField;
	private JTextField totalPriceTextField;
	private JTextField changeTextField;
	private JTable itemListTable;
	private JTextField quantityTextField;
	private JButton addItemButton;
	private JButton confirmButton;
	private JButton receiptButton;
	JComboBox<ComboItem> itemsComboBox;
	
	private ItemController itemCtrl = new ItemController();
	private String fontStyle = "Times New Roman";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionGUI frame = new TransactionGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Close the current frame
	 */
	public void close() {
		 WindowEvent winClosingEvent = new WindowEvent
				 (this, WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().
		 		postEvent(winClosingEvent);
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public TransactionGUI() {
		setResizable(false);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Menu bar==========================================================
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem showSaleMenuItem = new JMenuItem("Show Sales");
		menu.add(showSaleMenuItem);
		
		JMenuItem LogoutMenuItem = new JMenuItem("Logout");
		menu.add(LogoutMenuItem);
		
		//Left==============================================================
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(0, 31, 338, 708);
		contentPane.add(itemPanel);
		itemPanel.setLayout(null);
		
		JPanel addItemPanel = new JPanel();
		addItemPanel.setBounds(36, 270, 266, 289);
		itemPanel.add(addItemPanel);
		addItemPanel.setLayout(null);
		
		JLabel itemLabel = new JLabel("Item : ");
		itemLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		itemLabel.setBounds(10, 9, 44, 14);
		addItemPanel.add(itemLabel);
		
		JLabel quantityLabel = new JLabel("Quantity : ");
		quantityLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		quantityLabel.setBounds(10, 48, 69, 14);
		addItemPanel.add(quantityLabel);
		
		JLabel unitPriceLabel = new JLabel("Unit Price (RM) : ");
		unitPriceLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		unitPriceLabel.setBounds(10, 93, 119, 14);
		addItemPanel.add(unitPriceLabel);
		
		JLabel subTotalPriceLabel = new JLabel("Total Price (RM) :  ");
		subTotalPriceLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		subTotalPriceLabel.setBounds(10, 137, 129, 14);
		addItemPanel.add(subTotalPriceLabel);
		
		itemsComboBox = new JComboBox<ComboItem>();
		itemsComboBox.setEditable(true);
		itemsComboBox.setFont(new Font(fontStyle, Font.BOLD, 16));
		itemsComboBox.setBounds(151, 9, 105, 20);
		itemsComboBox.addActionListener(this);
		addItemPanel.add(itemsComboBox);
		
		try {
			itemCtrl.fillComboBox(itemsComboBox);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		quantityTextField = new JTextField();
		quantityTextField.setBounds(151, 46, 105, 20);
		quantityTextField.getDocument().addDocumentListener(this);
		quantityTextField.putClientProperty("quantity", "Text Field");
		addItemPanel.add(quantityTextField);
		
		unitPriceTextField = new JTextField();
		unitPriceTextField.setEditable(false);
		unitPriceTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		unitPriceTextField.setBounds(151, 93, 105, 20);
		addItemPanel.add(unitPriceTextField);
		
		subTotalPriceTextField = new JTextField();
		subTotalPriceTextField.setEditable(false);
		subTotalPriceTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		subTotalPriceTextField.setBounds(151, 137, 105, 20);
		addItemPanel.add(subTotalPriceTextField);
		
		addItemButton = new JButton("Add To Cart");
		addItemButton.setFont(new Font(fontStyle, Font.BOLD, 18));
		addItemButton.setBounds(63, 239, 139, 39);
		addItemPanel.add(addItemButton);
		
		JLabel shoppingCartLabel = new JLabel("Shopping Cart");
		shoppingCartLabel.setBounds(10, 57, 310, 71);
		itemPanel.add(shoppingCartLabel);
		shoppingCartLabel.setFont(new Font(fontStyle, Font.BOLD, 48));
		
		//Mid================================================================
		JPanel CartPanel = new JPanel();
		CartPanel.setBounds(341, 31, 338, 708);
		contentPane.add(CartPanel);
		CartPanel.setLayout(null);
		
		JList<?> itemsList = new JList<Object>();
		itemsList.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemsList.setFont(new Font(fontStyle, Font.PLAIN, 14));
		itemsList.setBounds(41, 29, 258, 388);
		CartPanel.add(itemsList);
		
		JPanel confirmPanel = new JPanel();
		confirmPanel.setBounds(40, 452, 258, 218);
		CartPanel.add(confirmPanel);
		confirmPanel.setLayout(null);
		
		JLabel cashLabel = new JLabel("Cash Tendered : ");
		cashLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		cashLabel.setBounds(10, 7, 114, 14);
		confirmPanel.add(cashLabel);
		
		JLabel totalPriceLabel = new JLabel("Total Price (RM) :");
		totalPriceLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		totalPriceLabel.setBounds(10, 47, 123, 14);
		confirmPanel.add(totalPriceLabel);
		
		JLabel changeLabel = new JLabel("Change : ");
		changeLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		changeLabel.setBounds(10, 87, 63, 14);
		confirmPanel.add(changeLabel);
		
		cashTextField = new JTextField();
		cashTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		cashTextField.setColumns(10);
		cashTextField.setBounds(144, 7, 105, 20);
		confirmPanel.add(cashTextField);
		
		totalPriceTextField = new JTextField();
		totalPriceTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		totalPriceTextField.setEditable(false);
		totalPriceTextField.setColumns(10);
		totalPriceTextField.setBounds(144, 47, 105, 20);
		confirmPanel.add(totalPriceTextField);
		
		changeTextField = new JTextField();
		changeTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		changeTextField.setEditable(false);
		changeTextField.setColumns(10);
		changeTextField.setBounds(144, 87, 105, 20);
		confirmPanel.add(changeTextField);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font(fontStyle, Font.BOLD, 20));
		confirmButton.setBounds(72, 160, 114, 33);
		confirmButton.addActionListener(this);
		confirmPanel.add(confirmButton);
		
		//Right===============================================================
		JPanel receiptPanel = new JPanel();
		receiptPanel.setBounds(682, 31, 678, 708);
		contentPane.add(receiptPanel);
		receiptPanel.setLayout(null);
		
		JLabel receiptLabel = new JLabel("Receipt");
		receiptLabel.setFont(new Font(fontStyle, Font.BOLD, 48));
		receiptLabel.setBounds(259, 21, 162, 75);
		receiptPanel.add(receiptLabel);
		
		JLabel companyLabel = new JLabel("BKB Sdn Bhd");
		companyLabel.setFont(new Font(fontStyle, Font.PLAIN, 14));
		companyLabel.setBounds(299, 107, 82, 14);
		receiptPanel.add(companyLabel);
		
		JLabel addressLabel = new JLabel("No.999, Jalan Ah Cheh, "
				+ "Ayeh Keroh, Melaka");
		addressLabel.setFont(new Font(fontStyle, Font.PLAIN, 14));
		addressLabel.setBounds(210, 131, 259, 14);
		receiptPanel.add(addressLabel);
		
		JLabel invoiceLabel = new JLabel("Invoice#");
		invoiceLabel.setFont(new Font(fontStyle, Font.PLAIN, 14));
		invoiceLabel.setBounds(36, 170, 56, 14);
		receiptPanel.add(invoiceLabel);
		
		JLabel invoiceNoLabel = new JLabel("Invoice No");
		invoiceNoLabel.setFont(new Font(fontStyle, Font.PLAIN, 14));
		invoiceNoLabel.setBounds(105, 170, 69, 14);
		receiptPanel.add(invoiceNoLabel);
		
		JLabel dataTimeLabel = new JLabel("??/??/???? ??:??:??");
		dataTimeLabel.setFont(new Font(fontStyle, Font.PLAIN, 14));
		dataTimeLabel.setBounds(511, 171, 132, 14);
		receiptPanel.add(dataTimeLabel);
		
		itemListTable = new JTable();
		itemListTable.setFont(new Font(fontStyle, Font.PLAIN, 12));
		itemListTable.setBounds(36, 201, 607, 259);
		receiptPanel.add(itemListTable);
		
		JLabel receiptTotalPriceLabel = new JLabel("Total Price (RM) : "
				+ "(Incl GST)");
		receiptTotalPriceLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		receiptTotalPriceLabel.setBounds(36, 508, 202, 14);
		receiptPanel.add(receiptTotalPriceLabel);
		
		JLabel totalGSTLabel = new JLabel("Total Includ 6% GST");
		totalGSTLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		totalGSTLabel.setBounds(36, 547, 152, 14);
		receiptPanel.add(totalGSTLabel);
		
		JLabel receiptCashLabel = new JLabel("Cash Tendered  ");
		receiptCashLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		receiptCashLabel.setBounds(36, 586, 117, 14);
		receiptPanel.add(receiptCashLabel);
		
		JLabel receiptChangeLabel = new JLabel("Change");
		receiptChangeLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		receiptChangeLabel.setBounds(36, 628, 202, 14);
		receiptPanel.add(receiptChangeLabel);
		
		JLabel totalPriceValueLabel = new JLabel("price");
		totalPriceValueLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		totalPriceValueLabel.setBounds(574, 508, 69, 16);
		receiptPanel.add(totalPriceValueLabel);
		
		JLabel totalGSTValueLabel = new JLabel("gst");
		totalGSTValueLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		totalGSTValueLabel.setBounds(574, 549, 69, 16);
		receiptPanel.add(totalGSTValueLabel);
		
		JLabel cashValueLabel = new JLabel("cash");
		cashValueLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		cashValueLabel.setBounds(574, 588, 69, 16);
		receiptPanel.add(cashValueLabel);
		
		JLabel changeValueLabel = new JLabel("change");
		changeValueLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		changeValueLabel.setBounds(574, 630, 69, 16);
		receiptPanel.add(changeValueLabel);
		
		receiptButton = new JButton("Receipt");
		receiptButton.setFont(new Font(fontStyle, Font.BOLD, 20));
		receiptButton.setBounds(511, 678, 132, 33);
		receiptPanel.add(receiptButton);
		
	}

	/**
	 * This method will perform all action on button
	 */
	@Override
	public void actionPerformed(ActionEvent action) {
		if(action.getSource() == addItemButton) {
			//Add selected item to cart
		}else if (action.getSource() == confirmButton) {
			//Proceed to receipt
		}else if (action.getSource() == receiptButton) {
			//Print receipt in PDF/TXT file
		}else if (action.getSource() == itemsComboBox) {
			itemsComboBox.getSelectedItem();
			
		} 
	}

	/**
	 * Override method in DocumentListener
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		updateValue(e, "inserted into");
	}
	/**
	 * Override method in DocumentListener
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		updateValue(e, "removed from");	
	}
	/**
	 * Override method in DocumentListener
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		//Plain text components do not fire these events
	}
	
	/**
	 * Auto calculate sub total of a item.
	 * @param e
	 * @param action
	 */
	public void updateValue(DocumentEvent e, String action) {	
        double unitPrice = Double.parseDouble(unitPriceTextField.getText());
		int quantity = Integer.parseInt(quantityTextField.getText());
		double subTotalPrice = unitPrice * quantity;
        subTotalPriceTextField.setText(String.valueOf(subTotalPrice));
    }
}
