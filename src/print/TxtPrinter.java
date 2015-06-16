package print;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
	
	private static DecimalFormat decimalPattern = new DecimalFormat("#.00");
	private static String datePattern = "yyyy-MM-dd HH-mm-ss";
	private static SimpleDateFormat dateFormatter = 
			new SimpleDateFormat(datePattern);
	
	private static java.util.Date date= new java.util.Date();
	private static String dateTime = 
			dateFormatter.format(new Timestamp(date.getTime()));
	
	
	private static String pathOfReceiptTxt = "./bin/Txt/Receipt/receipt_" 
			+ dateTime + ".txt";
	private static String pathOfSalesTxt = "./bin/Txt/Sales/sales_" + 
			dateTime + ".txt";
	private static Properties property = new Properties();

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
	        }
            
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + 
                    pathOfSalesTxt);
            
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * print receipt into txt file.
     * @param receipt
     */
    public static void printReceipt(Document receipt) {
		try {
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
            w.write("RECEIPT" + newLine);
            w.write("Date : " + dateTime + newLine);
            w.write("Cashier : " + property.getProperty("fullName") + newLine);
            w.write("--------------------------------------------------------"
            		+ "------------------" + newLine);
            w.write("Food\t\tQuantity\tUnit Price (RM)\t"
            		+ "SubTotal Price (RM)" + newLine);
            w.write("--------------------------------------------------------"
            		+ "------------------" + newLine);
            
            w.write("TOTAL PRICE (RM)" + newLine);
            w.write("Total 6% GST :" + newLine);
            w.write("Cash Tendered :" + newLine);
            w.write("Change :" + newLine);
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
	}
}


