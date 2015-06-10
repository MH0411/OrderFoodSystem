package GUI;

import item.Item;
import item.db.ItemController;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.awt.event.KeyEvent;

import javax.swing.table.DefaultTableModel;

import transaction.Cart;

/**
 * This class control the interface of transaction.
 * Interface activity happen here.
 * @author Ho Zhen Hong
 *
 */
@SuppressWarnings("serial")
public class TransactionGUI extends JFrame 
		implements ActionListener, DocumentListener, KeyListener{

	private JMenuBar menuBar;
	private JMenu menu;
	private JPanel contentPane;
	private JPanel itemPanel;
	private JPanel addItemPanel;
	private JPanel CartPanel;
	private JPanel confirmPanel;
	private JPanel receiptPanel;
	private JScrollPane itemsScrollPane;
	private JScrollPane scrollPane;
	private JTextField unitPriceTextField;
	private JTextField subTotalPriceTextField;
	private JTextField cashTextField;
	private JTextField totalPriceTextField;
	private JTextField changeTextField;
	private JLabel itemLabel;
	private JLabel quantityLabel;
	private JLabel unitPriceLabel;
	private JLabel subTotalPriceLabel;
	private JLabel shoppingCartLabel;
	private JLabel cashLabel;
	private JLabel totalPriceLabel;
	private JLabel changeLabel;
	private JLabel receiptLabel;
	private JLabel companyLabel;
	private JLabel addressLabel;
	private JLabel dataTimeLabel;
	private JLabel receiptTotalPriceLabel;
	private JLabel totalGSTLabel;
	private JLabel receiptCashLabel;
	private JLabel receiptChangeLabel;
	private JLabel totalPriceValueLabel;
	private JLabel totalGSTValueLabel;
	private JLabel cashValueLabel;
	private JLabel changeValueLabel;
	private JLabel addressLabel1;
	private JLabel telLabel;
	private JLabel gstLabel;
	private JLabel gstIdLabel;
	private JFormattedTextField quantityTextField;
	private JButton addItemButton;
	private JButton confirmButton;
	private JButton receiptButton;
	private JMenuItem showSaleMenuItem;
	private JMenuItem logoutMenuItem;
	private JComboBox<Item> itemsComboBox;
	private JTable itemsTable;
	private Calendar calendar;
	private java.util.Date now;
	private JButton removeButton;
	private java.sql.Timestamp currentTimestamp;
	private Cart cart = new Cart();
	DefaultListCellRenderer centerRenderer;
	//Set 2 decimal places.
	private DecimalFormat decimalPattern = new DecimalFormat("#.00");
	private final double GST = 0.06;
	private ItemController itemCtrl = new ItemController();
	private String fontStyle = "Times New Roman";
	private JTable receiptTable;

	
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
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 21);
		contentPane.add(menuBar);
		
		menu = new JMenu("Menu");
		menuBar.add(menu);
		
		showSaleMenuItem = new JMenuItem("Show Sales");
		showSaleMenuItem.addActionListener(this);
		menu.add(showSaleMenuItem);
		
		logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(this);
		menu.add(logoutMenuItem);
		
		//LeftPanel===========================================================
		itemPanel = new JPanel();
		itemPanel.setBounds(0, 31, 338, 708);
		contentPane.add(itemPanel);
		itemPanel.setLayout(null);
		
		addItemPanel = new JPanel();
		addItemPanel.setBounds(36, 270, 266, 289);
		itemPanel.add(addItemPanel);
		addItemPanel.setLayout(null);
		
		itemLabel = new JLabel("Item : ");
		itemLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		itemLabel.setBounds(10, 9, 44, 14);
		addItemPanel.add(itemLabel);
		
		quantityLabel = new JLabel("Quantity : ");
		quantityLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		quantityLabel.setBounds(10, 48, 69, 14);
		addItemPanel.add(quantityLabel);
		
		unitPriceLabel = new JLabel("Unit Price (RM) : ");
		unitPriceLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		unitPriceLabel.setBounds(10, 93, 119, 14);
		addItemPanel.add(unitPriceLabel);
		
		subTotalPriceLabel = new JLabel("Total Price (RM) :  ");
		subTotalPriceLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		subTotalPriceLabel.setBounds(10, 137, 129, 14);
		addItemPanel.add(subTotalPriceLabel);
		
		centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		itemsComboBox = new JComboBox<Item>();
		itemsComboBox.setEditable(true);
		itemsComboBox.setRenderer(centerRenderer);
		itemsComboBox.setFont(new Font(fontStyle, Font.BOLD, 16));
		itemsComboBox.setBounds(151, 9, 105, 20);
		itemsComboBox.setSelectedItem("");;
		itemsComboBox.addActionListener(this);
		addItemPanel.add(itemsComboBox);
		
		//Import items from database to combo box.
		try {
			itemCtrl.getItemsInfo(itemsComboBox);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		quantityTextField = new JFormattedTextField();
		quantityTextField.setEditable(false);
		quantityTextField.setHorizontalAlignment(SwingConstants.CENTER);
		quantityTextField.setBounds(151, 46, 105, 20);
		quantityTextField.addKeyListener(this);
		quantityTextField.getDocument().addDocumentListener(this);
		quantityTextField.putClientProperty("quantity", "Text Field");
		addItemPanel.add(quantityTextField);
		
		unitPriceTextField = new JTextField();
		unitPriceTextField.setEditable(false);
		unitPriceTextField.setHorizontalAlignment(SwingConstants.CENTER);
		unitPriceTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		unitPriceTextField.setBounds(151, 93, 105, 20);
		addItemPanel.add(unitPriceTextField);
		
		subTotalPriceTextField = new JTextField();
		subTotalPriceTextField.setEditable(false);
		subTotalPriceTextField.setHorizontalAlignment(SwingConstants.CENTER);
		subTotalPriceTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		subTotalPriceTextField.setBounds(151, 137, 105, 20);
		addItemPanel.add(subTotalPriceTextField);
		
		addItemButton = new JButton("Add To Cart");
		addItemButton.addActionListener(this);
		addItemButton.setFont(new Font(fontStyle, Font.BOLD, 18));
		addItemButton.setBounds(63, 239, 139, 39);
		addItemPanel.add(addItemButton);
		
		shoppingCartLabel = new JLabel("Shopping Cart");
		shoppingCartLabel.setBounds(10, 57, 310, 71);
		itemPanel.add(shoppingCartLabel);
		shoppingCartLabel.setFont(new Font(fontStyle, Font.BOLD, 48));
		
		//MidPanel===========================================================
		CartPanel = new JPanel();
		CartPanel.setBounds(341, 31, 338, 708);
		contentPane.add(CartPanel);
		CartPanel.setLayout(null);
		
		confirmPanel = new JPanel();
		confirmPanel.setBounds(40, 452, 258, 218);
		CartPanel.add(confirmPanel);
		confirmPanel.setLayout(null);
		
		cashLabel = new JLabel("Cash Tendered : ");
		cashLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		cashLabel.setBounds(10, 7, 114, 14);
		confirmPanel.add(cashLabel);
		
		totalPriceLabel = new JLabel("Total Price (RM) :");
		totalPriceLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		totalPriceLabel.setBounds(10, 47, 123, 14);
		confirmPanel.add(totalPriceLabel);
		
		changeLabel = new JLabel("Change : ");
		changeLabel.setFont(new Font(fontStyle, Font.BOLD, 15));
		changeLabel.setBounds(10, 87, 63, 14);
		confirmPanel.add(changeLabel);
		
		cashTextField = new JTextField();
		cashTextField.setEditable(false);
		cashTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		cashTextField.setColumns(10);
		cashTextField.setBounds(144, 7, 105, 20);
		cashTextField.addKeyListener(this);
		cashTextField.getDocument().addDocumentListener(this);
		cashTextField.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPanel.add(cashTextField);
		
		totalPriceTextField = new JTextField();
		totalPriceTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		totalPriceTextField.setEditable(false);
		totalPriceTextField.setColumns(10);
		totalPriceTextField.setBounds(144, 47, 105, 20);
		totalPriceTextField.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPanel.add(totalPriceTextField);
		
		changeTextField = new JTextField();
		changeTextField.setFont(new Font(fontStyle, Font.BOLD, 16));
		changeTextField.setEditable(false);
		changeTextField.setColumns(10);
		changeTextField.setBounds(144, 87, 105, 20);
		changeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPanel.add(changeTextField);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font(fontStyle, Font.BOLD, 20));
		confirmButton.setBounds(134, 160, 114, 33);
		confirmButton.addActionListener(this);
		confirmPanel.add(confirmButton);
		
		itemsScrollPane = new JScrollPane();
		itemsScrollPane.setBounds(23, 50, 292, 378);
		CartPanel.add(itemsScrollPane);	
		itemsTable = new JTable(){
			@Override
			 public Class<?> getColumnClass(int colIndex) {
				
				 return getValueAt(0, colIndex).getClass();
			 }
			 
			/**
			 * set 1st column editable
			 */
			 @Override
			    public boolean isCellEditable(int row, int col) {
			        return col == 0;
			    }
		};
		itemsTable.setShowVerticalLines(false);
		itemsTable.setShowHorizontalLines(false);
		itemsTable.setShowGrid(false);
		itemsTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"Select", "Food", "Quantity", "Unit Price", "SubTotal"
			}
		));

		itemsScrollPane.setViewportView(itemsTable);
		
		removeButton = new JButton("Remove");
		removeButton.addActionListener(this);
		removeButton.setFont(new Font(fontStyle, Font.BOLD, 20));
		removeButton.setBounds(10, 160, 114, 33);
		confirmPanel.add(removeButton);
		
		//RightPanel==========================================================
		receiptPanel = new JPanel();
		receiptPanel.setBounds(682, 22, 678, 717);
		contentPane.add(receiptPanel);
		receiptPanel.setLayout(null);
		
		receiptLabel = new JLabel("Receipt");
		receiptLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		receiptLabel.setBounds(280, 151, 117, 40);
		receiptPanel.add(receiptLabel);
		
		companyLabel = new JLabel("BKB FOOD ENTERPRISE");
		companyLabel.setFont(new Font("Times New Roman", Font.BOLD, 49));
		companyLabel.setBounds(42, 11, 594, 57);
		receiptPanel.add(companyLabel);
		
		addressLabel = new JLabel("No.18 MITC Mall ,Hang Tuah Jaya");
		addressLabel.setFont(new Font(fontStyle, Font.PLAIN, 14));
		addressLabel.setBounds(230, 79, 217, 14);
		receiptPanel.add(addressLabel);
		
		dataTimeLabel = new JLabel("date time");
		dataTimeLabel.setFont(new Font(fontStyle, Font.PLAIN, 14));
		dataTimeLabel.setBounds(491, 171, 152, 14);
		calendar = Calendar.getInstance();
		now = calendar.getTime();
		currentTimestamp = 
				new java.sql.Timestamp(now.getTime());
		dataTimeLabel.setText(String.valueOf(currentTimestamp));
		receiptPanel.add(dataTimeLabel);
		
		receiptTotalPriceLabel = new JLabel("Total Price (RM) : "
				+ "(Incl GST)");
		receiptTotalPriceLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		receiptTotalPriceLabel.setBounds(36, 477, 202, 14);
		receiptPanel.add(receiptTotalPriceLabel);
		
		totalGSTLabel = new JLabel("Total Includ 6% GST");
		totalGSTLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		totalGSTLabel.setBounds(36, 516, 152, 14);
		receiptPanel.add(totalGSTLabel);
		
		receiptCashLabel = new JLabel("Cash Tendered  ");
		receiptCashLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		receiptCashLabel.setBounds(36, 555, 117, 14);
		receiptPanel.add(receiptCashLabel);
		
		receiptChangeLabel = new JLabel("Change");
		receiptChangeLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		receiptChangeLabel.setBounds(36, 597, 202, 14);
		receiptPanel.add(receiptChangeLabel);
		
		totalPriceValueLabel = new JLabel("PRICE");
		totalPriceValueLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		totalPriceValueLabel.setBounds(574, 477, 69, 16);
		receiptPanel.add(totalPriceValueLabel);
		
		totalGSTValueLabel = new JLabel("GST");
		totalGSTValueLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		totalGSTValueLabel.setBounds(574, 518, 69, 16);
		receiptPanel.add(totalGSTValueLabel);
		
		cashValueLabel = new JLabel("CASH");
		cashValueLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		cashValueLabel.setBounds(574, 557, 69, 16);
		receiptPanel.add(cashValueLabel);
		
		changeValueLabel = new JLabel("CHANGE");
		changeValueLabel.setFont(new Font(fontStyle, Font.BOLD, 14));
		changeValueLabel.setBounds(574, 599, 69, 16);
		receiptPanel.add(changeValueLabel);
		
		receiptButton = new JButton("Receipt");
		receiptButton.setFont(new Font(fontStyle, Font.BOLD, 20));
		receiptButton.setBounds(511, 657, 132, 33);
		receiptPanel.add(receiptButton);
		
		addressLabel1 = new JLabel("75450 Ayer Keroh,Melaka");
		addressLabel1.setBounds(266, 104, 146, 14);
		receiptPanel.add(addressLabel1);
		
		telLabel = new JLabel("Tel : 06-2313007 Fax : 06-2313070");
		telLabel.setBounds(245, 129, 188, 14);
		receiptPanel.add(telLabel);
		
		gstLabel = new JLabel("GST ID #");
		gstLabel.setBounds(40, 171, 57, 14);
		receiptPanel.add(gstLabel);
		
		gstIdLabel = new JLabel("GST ID");
		gstIdLabel.setBounds(107, 171, 46, 14);
		receiptPanel.add(gstIdLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 195, 600, 271);
		receiptPanel.add(scrollPane);
		
		receiptTable = new JTable();
		receiptTable.setShowVerticalLines(false);
		receiptTable.setShowHorizontalLines(false);
		receiptTable.setShowGrid(false);
		receiptTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Food", "Quantity", "Unit Price (RM)", "SubTotal Price (RM)"
			}
		));
		scrollPane.setViewportView(receiptTable);
	}

	/**
	 * This method will perform all action on button
	 */
	@Override
	public void actionPerformed(ActionEvent action) {
		
		if(action.getSource() == showSaleMenuItem) {
			//Close current frame and open sale frame
			close();
			SaleGUI saleFrame = new SaleGUI();
			saleFrame.setVisible(true);
			
		} else if (action.getSource() == logoutMenuItem) {
			//Close current frame and open login frame
			close();
			LoginGUI loginFrame = new LoginGUI();
			loginFrame.setVisible(true);
			
		} else if(action.getSource() == addItemButton) {

			//Add selected item to cart
			cart.addItem((Item) itemsComboBox.getSelectedItem());
			DefaultTableModel item = (DefaultTableModel)itemsTable.getModel();
			item.addRow(new Object[] {
					false,
					itemsComboBox.getSelectedItem(),
					quantityTextField.getText(), 
					unitPriceTextField.getText(),
					subTotalPriceTextField.getText()
			});
			
			//Calculate total price from all selected item
			double subtotalPrice = 
					Double.parseDouble(subTotalPriceTextField.getText());
			double totalPrice;
			
			if (totalPriceTextField.getText().equals("")){
				totalPrice = 0.0;
			} else {
				totalPrice = Double.parseDouble(totalPriceTextField.getText());
			}
			totalPrice += ((subtotalPrice * GST) + subtotalPrice);
			totalPrice = (Math.round(totalPrice - 0.05)) + 0.05;
			totalPriceTextField.setText(String.valueOf(
					decimalPattern.format(totalPrice)));
			cashTextField.setEditable(true);
			
			//Cart cart = new Cart();
			//cart.addItem((Item) itemsComboBox.getSelectedItem());
			
			//Refresh all text fields
			
		}else if (action.getSource() == confirmButton) {
			
			//Refresh recipt table
			((DefaultTableModel) receiptTable.getModel()).
				getDataVector().removeAllElements();
			
			if (cart.getCartItems().isEmpty()){
				
				JOptionPane.showMessageDialog(null, "The cart is empty.");
				
			} else {
				
				if ((cashTextField.getText().equals("")) 
						|| (Double.parseDouble(cashTextField.getText()) 
						< (Double.parseDouble(totalPriceTextField.getText())))){
					
					JOptionPane.showMessageDialog(
							null, "Insufficient cash tendered");
					
				} else {
					
					//Proceed to receipt
					dataTimeLabel.setText(String.valueOf(currentTimestamp));
					
					for (int i = 0 ; i < itemsTable.getRowCount() ; i++) {
						
						DefaultTableModel item = 
								(DefaultTableModel)receiptTable.getModel();
						item.addRow(new Object[]{
								cart.getCartItems().get(i).getName(),
								cart.getCartItems().get(i).getQuantity(),
								cart.getCartItems().get(i).getUnitPrice(),
								cart.getCartItems().get(i).getSubTotalPrice(),
								cart.getCartItems().remove(i)				
						});
					}	
					
					double totalPrice = 
							Double.parseDouble(totalPriceTextField.getText());
					double totalGST =
							(Math.round((totalPrice * GST) - 0.05)) + 0.05;
					double cash = Double.parseDouble(cashTextField.getText());
					
					totalPriceValueLabel.setText(totalPriceTextField.getText());
					totalGSTValueLabel.setText(String.valueOf(totalGST));
					cashValueLabel.setText(String.valueOf(decimalPattern.format(cash)));
					changeValueLabel.setText(changeTextField.getText());
					
					//Refresh cart
					changeTextField.setText("");
					((DefaultTableModel) itemsTable.getModel()).
							getDataVector().removeAllElements();
					cashTextField.setEditable(false);
					cashTextField.setText("");
					totalPriceTextField.setText("");	
				}
			}
			
		}else if (action.getSource() == receiptButton) {
			
			//Print receipt in PDF/TXT file
			
			
		}else if (action.getSource() == itemsComboBox) {
			
			//Get selected item's price
			quantityTextField.setEditable(true);
			Item item = (Item)itemsComboBox.getSelectedItem();
			unitPriceTextField.setText(decimalPattern.format(
					item.getUnitPrice()));
			
		} else if (action.getSource() == removeButton) {
			
			// remove selected rows
			DefaultTableModel item = (DefaultTableModel)itemsTable.getModel();
			for (int i = 0; i < itemsTable.getRowCount(); i++) {
				boolean chked = Boolean.valueOf(itemsTable.getValueAt(i, 0)
				.toString());
				if (chked) {
					cart.getCartItems().remove(i);
					item.removeRow(i--);
				}
			}
		}
	}

	/**
	 * Override method in DocumentListener
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		updateSubTotal(e, "change");
	}
	/**
	 * Override method in DocumentListener
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		updateSubTotal(e, "insert");	
	}
	/**
	 * Override method in DocumentListener
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		updateSubTotal(e, "remove");
	}
	
	/**
	 * Auto calculate sub total price of selected item.
	 * @param e
	 * @param action
	 */
	public void updateSubTotal(DocumentEvent e, String action) {
		//To calculate subtotal price
		double unitPrice = Double.parseDouble(unitPriceTextField.getText());
		int quantity;
		
		if (quantityTextField.getText().equals(""))
			quantity = 0;	
		else 
		quantity = Integer.parseInt(quantityTextField.getText());
		
		double subTotalPrice = unitPrice * quantity;
        subTotalPriceTextField.setText(String.valueOf
        		(decimalPattern.format(subTotalPrice)));
        
        //To calculate the change
        double cash;
        double totalItemsPrice;
        if (cashTextField.getText().equals("")) {
        	cash = 0.0;
        	totalItemsPrice = 0.0;
        }else{
        	cash = Double.parseDouble(cashTextField.getText());
        	totalItemsPrice = Double.parseDouble
				(totalPriceTextField.getText());
        }
        double change =  cash - totalItemsPrice;
        changeTextField.setText(String.valueOf((decimalPattern.format(change))));
	}
	
	/**
	 * Override method in KeyListener
	 */
	@Override
	public void keyPressed(KeyEvent e) {}
	/**
	 * Override method in KeyListener
	 */
	@Override
	public void keyReleased(KeyEvent e) {}
	/**
	 * Override method in KeyListener
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!(Character.isDigit(c) || (c == KeyEvent.VK_PERIOD)) 
				|| (c == KeyEvent.VK_BACK_SPACE) 
				|| (c == KeyEvent.VK_DELETE)) {
			e.consume();
		}

	}
}		
