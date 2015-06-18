package print;

import item.OrderedItem;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import com.itextpdf.text.Document;

import transaction.Sale;

/**
 * This class enable user to print either receipt or sales into txt file.
 * @author JKGan
 *
 */
public class TxtPrinter {
	
	private static DecimalFormat decimalPattern = new DecimalFormat("0.00");
	private static String datePattern = "yyyy-MM-dd HH-mm-ss";
	private static String datepattern1 = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat dateFormatter = 
			new SimpleDateFormat(datePattern);
	private static SimpleDateFormat dateFormatter1 = 
			new SimpleDateFormat(datepattern1);
	
	private static java.util.Date date= new java.util.Date();
	private static Timestamp currentTime = new Timestamp(date.getTime());
	private static String dateTime = dateFormatter.format(currentTime);
	private static String dateTime1 = dateFormatter1.format(currentTime);
	
	private static String pathOfReceiptTxt = "./bin/Txt/Receipt/receipt_" 
			+ dateTime + ".txt";
	private static String pathOfSalesTxt = "./bin/Txt/Sales/sales_" + 
			dateTime + ".txt";
	
	private static Properties property = new Properties();
	private static FileInputStream input;
	private static double totalSalePrice = 0;
	
	/**
	 * Method to print Sales report into txt file.
	 * @param sales
	 * @param startDate
	 * @param endDate
	 */
    public static void printSales(Vector<Sale> sales, String startDate, 
    		String endDate) {
    	
        try {
        	File statText = new File(pathOfSalesTxt);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            String newLine = System.lineSeparator();
            w.write("BKB FOOD ENTERPRISE" + newLine);
            w.write("No.18 MITC Mall ,Hang Tuah Jaya" + newLine); 
            w.write("75450 Ayer Keroh" + newLine);
            w.write("Tel : 06-2313007  Fax : 06-2313070" + newLine);
            w.write("Sale Report" + newLine);
            w.write("From : " + startDate + newLine);
            w.write("To   : " + endDate + newLine);
            w.write("--------------------------------------------------------"
            		+ "------------------" + newLine);
            w.write("ItemId\tFood\t\tQuantity\tUnit Price (RM)\t"
            		+ "Total Price (RM)" + newLine);
            w.write("--------------------------------------------------------"
            		+ "------------------" + newLine);
            for (int index = 0; index < sales.size(); index++) {
	        	w.write(sales.get(index).getItemId() + "\t");
	        	w.write(sales.get(index).getName() + "\t");
	        	if (sales.get(index).getName().length() < 7){
	        		w.write("\t");
	        	} 
	        	w.write(sales.get(index).getQuantity() + "\t\t");
	        	w.write(decimalPattern.format(sales.get(index).getUnitPrice()) 
	        			+ "\t\t");
	        	w.write(decimalPattern.format(sales.get(index).getTotalPrice()) 
	        			+ newLine);
	        	totalSalePrice += sales.get(index).getTotalPrice();
	        }
            
            w.write("--------------------------------------------------------"
            		+ "------------------" + newLine);
            w.write("Total Sales (RM) : " 
            		+ decimalPattern.format(totalSalePrice) + newLine);
            
//            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + 
//                    pathOfSalesTxt);
            
            w.close();
            
            File file = new File(pathOfSalesTxt);
	        Desktop desktop = Desktop.getDesktop();
	        desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * print receipt into txt file.
     * @param receipt
     * @param orderedItems 
     * @param changeValue 
     * @param cashValue 
     * @param gstValue 
     * @param totalPriceValue 
     */
    public static void printReceipt(Document receipt, 
    		ArrayList<OrderedItem> orderedItems, String totalPriceValue,
    		String gstValue, String cashValue, String changeValue) {
    	
		try {
			input = new FileInputStream("bin/config/config.properties");
			// load a properties file
			property.load(input);
        	File statText = new File(pathOfReceiptTxt);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            String newLine = System.lineSeparator();
            w.write("BKB FOOD ENTERPRISE" + newLine);
            w.write("No.18 MITC Mall ,Hang Tuah Jaya" + newLine); 
            w.write("75450 Ayer Keroh" + newLine);
            w.write("Tel : 06-2313007  Fax : 06-2313070" + newLine);
            w.write("GST ID : 001134034944" + newLine);
            w.write("RECEIPT" + newLine + newLine);
            w.write("Date : " + dateTime1 + newLine);
            w.write("Cashier : " + property.getProperty("fullName") + newLine);
            w.write("--------------------------------------------------------"
            		+ "------------------" + newLine);
            w.write("ID\tFood\t\tQuantity\tUnit Price (RM)\t"
            		+ "SubTotal Price (RM)" + newLine);
            w.write("--------------------------------------------------------"
            		+ "------------------" + newLine);
            
            for (int index = 0; index < orderedItems.size(); index++) {
	        	w.write(orderedItems.get(index).getItemId() + "\t");
	        	w.write(orderedItems.get(index).getName() + "\t");
	        	if (orderedItems.get(index).getName().length() < 7){
	        		w.write("\t");
	        	} 
	        	w.write(orderedItems.get(index).getQuantity() + "\t\t");
	        	w.write(decimalPattern.format(orderedItems.get(index).
	        			getUnitPrice()) + "\t\t");
	        	w.write(decimalPattern.format(orderedItems.get(index).
	        			getSubTotalPrice()) + newLine);	        	
	        }
            
            w.write("--------------------------------------------------------"
            		+ "------------------" + newLine);
            w.write("TOTAL PRICE (RM) : " + totalPriceValue + newLine);
            w.write("Total 6% GST     : " + gstValue + newLine);
            w.write("Cash Tendered    : " + cashValue + newLine);
            w.write("Change           : " + changeValue + newLine);
            w.close();
            
            File file = new File(pathOfReceiptTxt);
	        Desktop desktop = Desktop.getDesktop();
	        desktop.open(file);
	        
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
	}
}


