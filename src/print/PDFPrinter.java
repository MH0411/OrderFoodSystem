package print;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Vector;

import javax.swing.text.DateFormatter;

import transaction.Sale;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * @author JKGan
 *
 */
public class PDFPrinter {
	
	private static String datePattern = "yyyy-MM-dd HH-mm-ss";
	private static SimpleDateFormat dateFormatter = 
			new SimpleDateFormat(datePattern);
	
	static java.util.Date date= new java.util.Date();
	static String dateTime = 
			dateFormatter.format(new Timestamp(date.getTime()));
	
	
	private static String pathOfReceiptPDF = "./bin/PDF/Receipt/receipt_" 
			+ dateTime + ".pdf";
	private static String pathOfSalesPDF = "./bin/PDF/Sales/sales_" + 
			dateTime + ".pdf";
	
	private static Properties property = new Properties();
	private static FileInputStream input;
	
//	public static void main(String[] args) {
//	    try {
//	    
//		  Document printReceipt = new Document(PageSize.A4.rotate());     
//	      PdfWriter.getInstance(printReceipt, new FileOutputStream(pathOfReceiptPDF));
//	      printReceipt.open();
//	      printReceipt(printReceipt);
//	      printReceipt.close();
//	      
//	      Document printSales = new Document(PageSize.A4.rotate());     
//	      PdfWriter.getInstance(printSales, new FileOutputStream(pathOfSalesPDF));
//	      printSales.open();
//	      printSales(printSales);
//	      printSales.close();
//	      
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	    }
//	  }
	
	public static void createSalePDF(Vector<Sale> sales, String startDate,
			String endDate) throws FileNotFoundException, DocumentException {
		
		Document printSales = new Document(PageSize.A4.rotate());     
	    PdfWriter.getInstance(printSales, new FileOutputStream(
	    											pathOfSalesPDF));
	    printSales.open();
	    printSales(printSales, sales, startDate, endDate);
	    printSales.close();
	}
	
	public static void printReceipt(Document printReceipt) {

		try
		{
			input = new FileInputStream("config.properties");
			// load a properties file
			property.load(input);
	        /* Add title with center alignment */
	        Chunk title = new Chunk("BKB FOOD ENTERPRISE", FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 26, Font.BOLD, BaseColor.BLACK));
	        Paragraph para1 = new Paragraph(title);
	        para1.setAlignment(Paragraph.ALIGN_CENTER);
	        para1.setSpacingAfter(5);
	        printReceipt.add(para1);
	        
	
	        /* Add address */
	        Chunk address = new Chunk("No.18 MITC Mall ,Hang Tuah Jaya "
	        		+ "\n75450 Ayer Keroh,Melaka", FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 14, BaseColor.BLACK));
	        Paragraph para2 = new Paragraph(address);
	        para2.setAlignment(Paragraph.ALIGN_CENTER);
	        para2.setSpacingAfter(5);
	        printReceipt.add(para2);
	        
	        /* Add contact number and Fax number */
	        Chunk number = new Chunk("Tel : 06-2313007 Fax : 06-2313070 "
	        		, FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 14, BaseColor.BLACK));
	        Paragraph para3 = new Paragraph(number);
	        para3.setAlignment(Paragraph.ALIGN_CENTER);
	        para3.setSpacingAfter(5);
	        printReceipt.add(para3);
	        
	        /* GST ID */
	        Chunk gst = new Chunk("GST ID : 001134034944 "
	        		, FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 14, BaseColor.BLACK));
	        Paragraph para4 = new Paragraph(gst);
	        para4.setAlignment(Paragraph.ALIGN_CENTER);
	        para4.setSpacingAfter(15);
	        printReceipt.add(para4);
	        
	        /* Receipt word */
	        Chunk receipt = new Chunk("RECEIPT "
	        		, FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 20,Font.BOLD, BaseColor.BLACK));
	        Paragraph para5 = new Paragraph(receipt);
	        para5.setAlignment(Paragraph.ALIGN_CENTER);
	        para5.setSpacingAfter(20);
	        printReceipt.add(para5);
	
	        /* Add date */
	        Chunk date = new Chunk( "Date : "+ new Date(0).toString());
	        Paragraph para6 = new Paragraph(date);
	        para6.setAlignment(Paragraph.ALIGN_LEFT);
	        para6.setSpacingAfter(5);
	        printReceipt.add(para6);
	        
	        /* Add cashier name */
	        Chunk cashier = new Chunk( "Cashier name : " + property.
	        		getProperty("fullName") ,FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK));
	        Paragraph para7 = new Paragraph(cashier);
	        para7.setAlignment(Paragraph.ALIGN_LEFT);
	        para7.setSpacingAfter(5);
	        printReceipt.add(para7);
	        
	        Chunk line = new Chunk( "---------------------------------"
	        		+ "-----------------------------------------------"
	        		+ "-----------------------------");
	        Paragraph para8 = new Paragraph(line);
	        para8.setSpacingAfter(5);
	        printReceipt.add(para8);
	        
	        Chunk line2 = new Chunk( "---------------------------------"
	        		+ "------------------------------------------------"
	        		+ "----------------------------");
	        Paragraph para9 = new Paragraph(line2);
	        para9.setSpacingAfter(5);
	        printReceipt.add(para9);
	        
	        /* Add Total Price */
	        Chunk totalPrice = new Chunk( "TOTAL PRICE (RM) :",FontFactory.
	        		getFont(FontFactory.TIMES_BOLD, 16, Font.BOLD, 
	        				BaseColor.BLACK));
	        Paragraph para10 = new Paragraph(totalPrice);
	        para10.setAlignment(Paragraph.ALIGN_LEFT);
	        para10.setSpacingAfter(5);
	        printReceipt.add(para10);
	        
	        /* Add gst percent */
	        Chunk gstPercent = new Chunk( "GST 6% (Incl) :",FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK));
	        Paragraph para11 = new Paragraph(gstPercent);
	        para11.setAlignment(Paragraph.ALIGN_LEFT);
	        para11.setSpacingAfter(5);
	        printReceipt.add(para11);
	        
	        /* Add cash tendered */
	        Chunk cashTendered = new Chunk( "Cash Tendered :",FontFactory.
	        		getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK));
	        Paragraph para12 = new Paragraph(cashTendered);
	        para12.setAlignment(Paragraph.ALIGN_LEFT);
	        para12.setSpacingAfter(5);
	        printReceipt.add(para12);
	        
	        /* Add change */
	        Chunk change = new Chunk( "Change :",FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK));
	        Paragraph para13 = new Paragraph(change);
	        para13.setAlignment(Paragraph.ALIGN_LEFT);
	        para13.setSpacingAfter(25);
	        printReceipt.add(para13);
	        
	        /* Add phrase */
	        Chunk phrase = new Chunk( "Thank you. Please Come Again !",
	        		FontFactory.getFont(FontFactory.TIMES_BOLD, 20, 
	        				BaseColor.BLACK));
	        Paragraph para14 = new Paragraph(phrase);
	        para14.setAlignment(Paragraph.ALIGN_CENTER);
	        para14.setSpacingAfter(5);
	        printReceipt.add(para14);
	    
	        
	        /* Open pdf file */
	        // for Window
	        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + 
	        		pathOfReceiptPDF);
	        
	        // for Mac
//	        Runtime.getRuntime().exec("open " + pathOfReceiptPDF);
	        
		} catch (Exception error) {
			System.out.println(error.getMessage());
			error.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void printSales(Document printSales, Vector<Sale> sales, 
			String startDate, String endDate) {

		try {
	        
	        /* Add title with center alignment */
	        Chunk title = new Chunk("SALES REPORT", FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 26, Font.BOLD, BaseColor.BLACK));
	        Paragraph para1 = new Paragraph(title);
	        para1.setAlignment(Paragraph.ALIGN_CENTER);
	        para1.setSpacingAfter(5);
	        printSales.add(para1);
	        
	        /* Add from */
	        Chunk from = new Chunk( "From\t: " + startDate, FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK));
	        Paragraph para2 = new Paragraph(from);
	        para2.setAlignment(Paragraph.ALIGN_LEFT);
	        para2.setSpacingAfter(25);
	        printSales.add(para2);
	        
	        /* Add to */
	        Chunk to = new Chunk( "To\t: " + endDate, FontFactory.getFont
	        		(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK));
	        Paragraph para3 = new Paragraph(to);
	        para3.setAlignment(Paragraph.ALIGN_LEFT);
	        para3.setSpacingAfter(25);
	        printSales.add(para3);
		
	        // a table with three columns
	        PdfPTable table = new PdfPTable(5);
	        
	        // add the title of table
	        table.addCell("ID");
	        table.addCell("Food");
	        table.addCell("Quantity");
	        table.addCell("Unit Price (RM)");
	        table.addCell("Total Price (RM)");
	        
	        for (int index = 0; index < sales.size(); index++) {
	        	table.addCell(sales.get(index).getItemId() + "");
		        table.addCell(sales.get(index).getName());
		        table.addCell(sales.get(index).getQuantity() + "");
		        table.addCell(sales.get(index).getUnitPrice() + "");
		        table.addCell(sales.get(index).getTotalPrice() + "");
	        }
	        printSales.add(table);
	        /* Open pdf file */
	        // for Window
	        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + 
	                    pathOfSalesPDF);
	        
	        // for Mac
//	        Runtime.getRuntime().exec("open " + pathOfSalesPDF);
	        
	        
		} catch (Exception error) {
			System.out.println(error.getMessage());
			error.printStackTrace();
		}	        
	}
}
