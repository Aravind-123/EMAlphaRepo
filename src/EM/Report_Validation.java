package EM;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/*Description: This class File does the Validation/Verfication functionality.It does both Positive and Negative Verification*/

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.write.WriteException;


public class Report_Validation {

	public static void Reports(String filePath,HSSFWorkbook workbook,String Object1,String ProValue1,WebDriverWait wait,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,int TestScenarioRow,String Parameter1) throws WriteException, IOException {
		  
		   File file = new File("Z:/Enterprise Management/Report_Validation/rwservlet.pdf"); 
		      PDDocument document = PDDocument.load(file); 
		        System.out.println("PDF loaded");
		        PDFTextStripper pdfStripper = new PDFTextStripper();

		        String text = pdfStripper.getText(document);
		        System.out.println(text); 
		        System.out.println("Parameter1******"+Parameter1);
		        try {
		    		
		    		switch (Object1){
		    		case "Patient Id":
		    		WebElement ele=null;
		    		if(ele.getText().equals(ProValue1) || ele.getText().equals(Parameter1))

		    			{
		    			ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Element Exist",TestScenarioRow);
						break;
		    			}
		    				
		    			else
		    			{
		    				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Element does not Exist",TestScenarioRow);
		    				
		    			}
		    			break;
		    		default:
		    			System.out.println("Webedit switchcase default access no matches found in PropertyName");
		    			break;
		    		}
		    		
		    	} 
		    	catch (NoSuchElementException e) {
		    		
		    	}
	 }
}
		    
		    			
		    