package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class TransactionGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ImageIcon cart;
	private JTextField unitPriceTextField;
	private JTextField totalPriceTextField;
	private JTextField tFCash;
	private JTextField tFPayPrice;
	private JTextField tFChange;
	private JTable ItemSoldTable;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TransactionGUI frame = new TransactionGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
	/**
	 * close the current frame and display next frame
	 */
	public void close() {
		 WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
		
		JPanel CartPanel = new JPanel();
		CartPanel.setBounds(341, 31, 338, 708);
		contentPane.add(CartPanel);
		CartPanel.setLayout(null);
		
		JList itemsList = new JList();
		itemsList.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemsList.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		itemsList.setBounds(41, 29, 258, 388);
		CartPanel.add(itemsList);
		
		JPanel confirmPanel = new JPanel();
		confirmPanel.setBounds(41, 448, 258, 218);
		CartPanel.add(confirmPanel);
		confirmPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cash Tendered : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 7, 114, 14);
		confirmPanel.add(lblNewLabel_2);
		
		JLabel lblTotalPricerm = new JLabel("Total Price (RM) :");
		lblTotalPricerm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalPricerm.setBounds(10, 47, 123, 14);
		confirmPanel.add(lblTotalPricerm);
		
		JLabel lblChange = new JLabel("Change : ");
		lblChange.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblChange.setBounds(10, 87, 63, 14);
		confirmPanel.add(lblChange);
		
		tFCash = new JTextField();
		tFCash.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tFCash.setColumns(10);
		tFCash.setBounds(144, 7, 105, 20);
		confirmPanel.add(tFCash);
		
		tFPayPrice = new JTextField();
		tFPayPrice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tFPayPrice.setEditable(false);
		tFPayPrice.setColumns(10);
		tFPayPrice.setBounds(144, 47, 105, 20);
		confirmPanel.add(tFPayPrice);
		
		tFChange = new JTextField();
		tFChange.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tFChange.setEditable(false);
		tFChange.setColumns(10);
		tFChange.setBounds(144, 87, 105, 20);
		confirmPanel.add(tFChange);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnConfirm.setBounds(72, 160, 114, 33);
		confirmPanel.add(btnConfirm);
		
		JPanel receiptPanel = new JPanel();
		receiptPanel.setBounds(682, 31, 678, 708);
		contentPane.add(receiptPanel);
		receiptPanel.setLayout(null);
		
		JLabel lblReceipt = new JLabel("Receipt");
		lblReceipt.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblReceipt.setBounds(259, 21, 162, 75);
		receiptPanel.add(lblReceipt);
		
		JLabel lblNewLabel_3 = new JLabel("BKB Sdn Bhd");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(299, 107, 82, 14);
		receiptPanel.add(lblNewLabel_3);
		
		JLabel lblLestari = new JLabel("No.999, Jalan Ah Cheh, Ayeh Keroh, Melaka");
		lblLestari.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLestari.setBounds(210, 131, 259, 14);
		receiptPanel.add(lblLestari);
		
		JLabel lblinvoice = new JLabel("Invoice#");
		lblinvoice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblinvoice.setBounds(36, 170, 56, 14);
		receiptPanel.add(lblinvoice);
		
		JLabel invoiceNo = new JLabel("Invoice No");
		invoiceNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		invoiceNo.setBounds(105, 170, 69, 14);
		receiptPanel.add(invoiceNo);
		
		ItemSoldTable = new JTable();
		ItemSoldTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ItemSoldTable.setBounds(36, 201, 607, 259);
		receiptPanel.add(ItemSoldTable);
		
		JLabel lblNewLabel_5 = new JLabel("Total Price (RM) : (Incl GST)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(36, 508, 202, 14);
		receiptPanel.add(lblNewLabel_5);
		
		JLabel lblTotalGST = new JLabel("Total Includ 6% GST");
		lblTotalGST.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalGST.setBounds(36, 547, 152, 14);
		receiptPanel.add(lblTotalGST);
		
		JLabel lblCashTendered = new JLabel("Cash Tendered  ");
		lblCashTendered.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCashTendered.setBounds(36, 586, 117, 14);
		receiptPanel.add(lblCashTendered);
		
		JLabel lblChange_1 = new JLabel("Change");
		lblChange_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChange_1.setBounds(36, 628, 202, 14);
		receiptPanel.add(lblChange_1);
		
		JLabel lblTotalPrice = new JLabel("price");
		lblTotalPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalPrice.setBounds(574, 508, 69, 16);
		receiptPanel.add(lblTotalPrice);
		
		JLabel lblTotalGSTPrice = new JLabel("gst");
		lblTotalGSTPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalGSTPrice.setBounds(574, 549, 69, 16);
		receiptPanel.add(lblTotalGSTPrice);
		
		JLabel lblCash = new JLabel("cash");
		lblCash.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCash.setBounds(574, 588, 69, 16);
		receiptPanel.add(lblCash);
		
		JLabel lblReceiptChange = new JLabel("change");
		lblReceiptChange.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblReceiptChange.setBounds(574, 630, 69, 16);
		receiptPanel.add(lblReceiptChange);
		
		JButton btnNewButton_1 = new JButton("Receipt");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(511, 678, 132, 33);
		receiptPanel.add(btnNewButton_1);
		
		JLabel lblDateTime = new JLabel("??/??/???? ??:??:??");
		lblDateTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDateTime.setBounds(511, 171, 132, 14);
		receiptPanel.add(lblDateTime);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(0, 31, 338, 708);
		contentPane.add(itemPanel);
		itemPanel.setLayout(null);
		
		JPanel addItemPanel = new JPanel();
		addItemPanel.setBounds(37, 193, 266, 231);
		itemPanel.add(addItemPanel);
		addItemPanel.setLayout(null);
		
		JLabel itemLabel = new JLabel("Item : ");
		itemLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		itemLabel.setBounds(10, 9, 44, 14);
		addItemPanel.add(itemLabel);
		
		JLabel quantityLabel = new JLabel("Quantity : ");
		quantityLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		quantityLabel.setBounds(10, 48, 69, 14);
		addItemPanel.add(quantityLabel);
		
		JLabel unitPriceLabel = new JLabel("Unit Price (RM) : ");
		unitPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		unitPriceLabel.setBounds(10, 93, 119, 14);
		addItemPanel.add(unitPriceLabel);
		
		JLabel totalPriceLabel = new JLabel("Total Price (RM) :  ");
		totalPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		totalPriceLabel.setBounds(10, 137, 129, 14);
		addItemPanel.add(totalPriceLabel);
		
		JComboBox itemsComboBox = new JComboBox();
		itemsComboBox.setEditable(true);
		itemsComboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		itemsComboBox.setBounds(151, 9, 105, 20);
		addItemPanel.add(itemsComboBox);
		
		JSpinner quantitySpinner = new JSpinner();
		quantitySpinner.setFont(new Font("Times New Roman", Font.BOLD, 16));
		quantitySpinner.setBounds(151, 48, 105, 20);
		addItemPanel.add(quantitySpinner);
		
		unitPriceTextField = new JTextField();
		unitPriceTextField.setEditable(false);
		unitPriceTextField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		unitPriceTextField.setBounds(151, 93, 105, 20);
		addItemPanel.add(unitPriceTextField);
		unitPriceTextField.setColumns(10);
		
		totalPriceTextField = new JTextField();
		totalPriceTextField.setEditable(false);
		totalPriceTextField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		totalPriceTextField.setBounds(151, 137, 105, 20);
		addItemPanel.add(totalPriceTextField);
		totalPriceTextField.setColumns(10);
		
		JButton btnAddToCart = new JButton("Add To Cart");
		btnAddToCart.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAddToCart.setBounds(117, 178, 139, 39);
		addItemPanel.add(btnAddToCart);
		
		JButton showButton = new JButton("Show Sales");
		showButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				SaleGUI saleFrame = new SaleGUI();
				saleFrame.setVisible(true);
			}
		});
		showButton.setBounds(10, 541, 103, 29);
		itemPanel.add(showButton);
		
		JLabel shoppingCartLabel = new JLabel("Shopping Cart");
		shoppingCartLabel.setBounds(10, 57, 310, 71);
		itemPanel.add(shoppingCartLabel);
		shoppingCartLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmShowSales = new JMenuItem("Show Sales");
		mnNewMenu.add(mntmShowSales);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
	}

	/**
	 * This method will perform all action on button
	 */
	@Override
	public void actionPerformed(ActionEvent action) {
	}
}
