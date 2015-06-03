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

@SuppressWarnings("serial")
public class TransactionGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ImageIcon cart;
	private JTextField tFUnitPrice;
	private JTextField tFTotalPrice;
	private JTextField tFCash;
	private JTextField tFPayPrice;
	private JTextField tFChange;
	private JTable ItemSoldTable;
	
	private JButton btnLogout;

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
	
	public void close(){
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
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelShopingCart = new JPanel();
		panelShopingCart.setBounds(341, 158, 338, 581);
		contentPane.add(panelShopingCart);
		panelShopingCart.setLayout(null);
		
		JList CartItems = new JList();
		CartItems.setBorder(new LineBorder(new Color(0, 0, 0)));
		CartItems.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		CartItems.setBounds(41, 28, 258, 232);
		panelShopingCart.add(CartItems);
		
		JPanel panelComfirm = new JPanel();
		panelComfirm.setBounds(41, 326, 258, 218);
		panelShopingCart.add(panelComfirm);
		panelComfirm.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cash Tendered : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 7, 114, 14);
		panelComfirm.add(lblNewLabel_2);
		
		JLabel lblTotalPricerm = new JLabel("Total Price (RM) :");
		lblTotalPricerm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalPricerm.setBounds(10, 47, 123, 14);
		panelComfirm.add(lblTotalPricerm);
		
		JLabel lblChange = new JLabel("Change : ");
		lblChange.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblChange.setBounds(10, 87, 63, 14);
		panelComfirm.add(lblChange);
		
		tFCash = new JTextField();
		tFCash.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tFCash.setColumns(10);
		tFCash.setBounds(144, 7, 105, 20);
		panelComfirm.add(tFCash);
		
		tFPayPrice = new JTextField();
		tFPayPrice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tFPayPrice.setEditable(false);
		tFPayPrice.setColumns(10);
		tFPayPrice.setBounds(144, 47, 105, 20);
		panelComfirm.add(tFPayPrice);
		
		tFChange = new JTextField();
		tFChange.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tFChange.setEditable(false);
		tFChange.setColumns(10);
		tFChange.setBounds(144, 87, 105, 20);
		panelComfirm.add(tFChange);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnConfirm.setBounds(72, 160, 114, 33);
		panelComfirm.add(btnConfirm);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 679, 158);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shopping Cart");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setBounds(185, 43, 310, 71);
		panelTitle.add(lblNewLabel);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(this);
		btnLogout.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLogout.setBounds(0, 0, 73, 17);
		panelTitle.add(btnLogout);
		
		JPanel panelReceipt = new JPanel();
		panelReceipt.setBounds(682, 0, 678, 739);
		contentPane.add(panelReceipt);
		panelReceipt.setLayout(null);
		
		JLabel lblReceipt = new JLabel("Receipt");
		lblReceipt.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblReceipt.setBounds(259, 21, 162, 75);
		panelReceipt.add(lblReceipt);
		
		JLabel lblNewLabel_3 = new JLabel("BKB Sdn Bhd");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(299, 107, 82, 14);
		panelReceipt.add(lblNewLabel_3);
		
		JLabel lblLestari = new JLabel("No.999, Jalan Ah Cheh, Ayeh Keroh, Melaka");
		lblLestari.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLestari.setBounds(210, 131, 259, 14);
		panelReceipt.add(lblLestari);
		
		JLabel lblinvoice = new JLabel("Invoice#");
		lblinvoice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblinvoice.setBounds(36, 170, 56, 14);
		panelReceipt.add(lblinvoice);
		
		JLabel invoiceNo = new JLabel("Invoice No");
		invoiceNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		invoiceNo.setBounds(105, 170, 69, 14);
		panelReceipt.add(invoiceNo);
		
		ItemSoldTable = new JTable();
		ItemSoldTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ItemSoldTable.setBounds(36, 201, 607, 259);
		panelReceipt.add(ItemSoldTable);
		
		JLabel lblNewLabel_5 = new JLabel("Total Price (RM) : (Incl GST)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(36, 508, 202, 14);
		panelReceipt.add(lblNewLabel_5);
		
		JLabel lblTotalGST = new JLabel("Total Includ 6% GST");
		lblTotalGST.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalGST.setBounds(36, 547, 152, 14);
		panelReceipt.add(lblTotalGST);
		
		JLabel lblCashTendered = new JLabel("Cash Tendered  ");
		lblCashTendered.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCashTendered.setBounds(36, 586, 117, 14);
		panelReceipt.add(lblCashTendered);
		
		JLabel lblChange_1 = new JLabel("Change");
		lblChange_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChange_1.setBounds(36, 628, 202, 14);
		panelReceipt.add(lblChange_1);
		
		JLabel lblTotalPrice = new JLabel("price");
		lblTotalPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalPrice.setBounds(574, 508, 69, 16);
		panelReceipt.add(lblTotalPrice);
		
		JLabel lblTotalGSTPrice = new JLabel("gst");
		lblTotalGSTPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalGSTPrice.setBounds(574, 549, 69, 16);
		panelReceipt.add(lblTotalGSTPrice);
		
		JLabel lblCash = new JLabel("cash");
		lblCash.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCash.setBounds(574, 588, 69, 16);
		panelReceipt.add(lblCash);
		
		JLabel lblReceiptChange = new JLabel("change");
		lblReceiptChange.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblReceiptChange.setBounds(574, 630, 69, 16);
		panelReceipt.add(lblReceiptChange);
		
		JButton btnNewButton_1 = new JButton("Receipt");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(511, 678, 132, 33);
		panelReceipt.add(btnNewButton_1);
		
		JLabel lblDateTime = new JLabel("??/??/???? ??:??:??");
		lblDateTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDateTime.setBounds(511, 171, 132, 14);
		panelReceipt.add(lblDateTime);
		
		JPanel panelSelectItem = new JPanel();
		panelSelectItem.setBounds(0, 158, 338, 581);
		contentPane.add(panelSelectItem);
		panelSelectItem.setLayout(null);
		
		JPanel panelAddItem = new JPanel();
		panelAddItem.setBounds(37, 193, 266, 231);
		panelSelectItem.add(panelAddItem);
		panelAddItem.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Item : ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 9, 44, 14);
		panelAddItem.add(lblNewLabel_1);
		
		JLabel lblQuantity = new JLabel("Quantity : ");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(10, 48, 69, 14);
		panelAddItem.add(lblQuantity);
		
		JLabel lblUnitPrice = new JLabel("Unit Price (RM) : ");
		lblUnitPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUnitPrice.setBounds(10, 93, 119, 14);
		panelAddItem.add(lblUnitPrice);
		
		JLabel lblTotal = new JLabel("Total Price (RM) :  ");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotal.setBounds(10, 137, 129, 14);
		panelAddItem.add(lblTotal);
		
		tFUnitPrice = new JTextField();
		tFUnitPrice.setEditable(false);
		tFUnitPrice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tFUnitPrice.setBounds(151, 93, 105, 20);
		panelAddItem.add(tFUnitPrice);
		tFUnitPrice.setColumns(10);
		
		tFTotalPrice = new JTextField();
		tFTotalPrice.setEditable(false);
		tFTotalPrice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tFTotalPrice.setBounds(151, 137, 105, 20);
		panelAddItem.add(tFTotalPrice);
		tFTotalPrice.setColumns(10);
		
		JButton btnAddToCart = new JButton("Add To Cart");
		btnAddToCart.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAddToCart.setBounds(117, 178, 139, 39);
		panelAddItem.add(btnAddToCart);
		
		JComboBox cBoxItemList = new JComboBox();
		cBoxItemList.setEditable(true);
		cBoxItemList.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cBoxItemList.setBounds(151, 9, 105, 20);
		panelAddItem.add(cBoxItemList);
		
		JSpinner Quantity = new JSpinner();
		Quantity.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Quantity.setBounds(151, 48, 105, 20);
		panelAddItem.add(Quantity);
		
		JButton btnShow = new JButton("Show Sales");
		btnShow.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				SaleGUI saleFrame = new SaleGUI();
				saleFrame.setVisible(true);
			}
		});
		btnShow.setBounds(10, 541, 103, 29);
		panelSelectItem.add(btnShow);
		
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		// TODO Auto-generated method stub
		
		if (action.getSource() == btnLogout){
			close();
			LoginGUI loginFrame = new LoginGUI();
			loginFrame.setVisible(true);
		}
		
	}
}
