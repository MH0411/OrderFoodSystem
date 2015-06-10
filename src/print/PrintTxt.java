package print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

	public class PrintTxt implements ActionListener{
		
	    public void writing() {
	        try {
	            //Whatever the file path is.
	            File statText = new File("C:/Users/User/Desktop/Testing.txt");
	            FileOutputStream is = new FileOutputStream(statText);
	            OutputStreamWriter osw = new OutputStreamWriter(is);    
	            Writer w = new BufferedWriter(osw);
	            w.write("BKB FOOD ENTERPRISE");
	            w.write("\nNo.18 MITC Mall ,Hang Tuah Jaya\n75450 Ayer Keroh");
	            w.write("\nTel : 06-2313007  Fax : 06-2313070\nGST ID : 001134034944");
	            w.write("\n\n\nRECEIPT");
	            w.write("\nDate");
	            w.write("\nCashier : Micky Ho");
	            w.write("\n-------------------------------------------------------------");
	            w.write("\nTOTAL PRICE (RM)");
	            w.write("\nGST 6% (Incl) :");
	            w.write("\nCash Tendered :");
	            w.write("\nChange :");
	            w.close();
	        } catch (IOException e) {
	            System.err.println("Problem writing to the file statsTest.txt");
	        }
	    }

	    public static void main(String[]args) {
	        PrintTxt write = new PrintTxt();
	        write.writing();
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}


