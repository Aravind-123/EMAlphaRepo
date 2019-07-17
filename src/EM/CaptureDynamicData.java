package EM;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/*Description: This class File captures the dynamic data from the application during execution according to the input given in test case sheet.
 			   It stores the captured data in CaptureData.xls File.*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CaptureDynamicData 
{
	static String ID;
	static String date1;
	
	@SuppressWarnings({ "deprecation", "resource" })
	public static String cap_Dyn_Data(String Module,WebDriver driver,String ID,String DataSelection,HSSFWorkbook TestCaseWorkbookIN,FileInputStream TestCaseExcelIN,FormulaEvaluator evaluator) throws InterruptedException, FileNotFoundException, IOException
	{
		Actions action=new Actions(driver);
		WebDriverWait waitwin=new WebDriverWait(driver,2);
		String Flag = null;
		evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
		//HSSFWorkbook wbB = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
		HSSFWorkbook wbB = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
		HSSFWorkbook wbB = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
	    Map<String, FormulaEvaluator> workbooks = new HashMap<String, FormulaEvaluator>();
	    workbooks.put("EM_Automation_Test Case.xls", evaluator);
	    workbooks.put("CaptureData.xls", wbB.getCreationHelper().createFormulaEvaluator());
	    evaluator.setupReferencedWorkbooks(workbooks);
		try{
		switch(Module)
	{
		
		case "security_warning":
			break;
		case "Wait_2S":
			Thread.sleep(2000);
			break;
		case "Wait_1S":
			Thread.sleep(1000);
			break;
		case "scrolldown":
			MainScript.scrolldown();
			break;
		case "Wait_5S":
			Thread.sleep(5000);
			break;
	case "AEImageClick":
			Window_Frame_Handling.window(waitwin,2,driver,"eHospital information system");
			driver.switchTo().frame("content");
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("AEMPSearchResultFrame");
			List<WebElement>ee=driver.findElements(By.tagName("img"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println(ee.size());
			js.executeScript("arguments[0].click();", ee.get(ee.size()-1));
<<<<<<< HEAD
		break;
		case "ESCKey":
				Thread.sleep(2000);
=======
		
			break;
		case "ESCKey":
				Thread.sleep(2000); 
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_CANCEL);
				r.keyPress(KeyEvent.VK_ESCAPE);
			break;
<<<<<<< HEAD
=======
		case "Clickdd"://desktop dialog
	         Robot robot = new Robot();   
    	    robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
      break;
		case "Clickdd1"://desktop dialog
			Thread.sleep(2000);
	         Robot robot1 = new Robot();   
   	    robot1.keyPress(KeyEvent.VK_SHIFT);
           robot1.keyPress(KeyEvent.VK_CONTROL);
           robot1.keyPress(KeyEvent.VK_S);
           robot1.keyRelease(KeyEvent.VK_S);
           robot1.keyRelease(KeyEvent.VK_CONTROL);
           robot1.keyRelease(KeyEvent.VK_SHIFT);
              break;

>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		case "Wait_1M":
			Thread.sleep(60000);
			break;
			
<<<<<<< HEAD
=======
	
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		case "ConsentDetailsWindowactivate":
				String win=driver.getWindowHandle();
				JavascriptExecutor jsExecutor1 = (JavascriptExecutor)driver;
				/*jsExecutor1.executeScript("var elem=arguments[0]; setTimeout(function() {elem.onclick();}, 500)",ele);
				Thread.sleep(5000);*/
				Robot r1=new Robot();
				r1.keyPress(KeyEvent.VK_ENTER);
				try{
					driver.switchTo().alert().accept();
					}
					catch(Exception e){}
				Thread.sleep(5000);
				
			
				/*String url="http://cscdbche754:7777/HIS/eOR/jsp/ConsentDetailsFrameset.jsp?";
				//String script = "window.location = \'"+url+"\'";
				String script ="window.focus(\'"+url+"\')";
				jsExecutor1.executeScript(script);
				System.out.println(driver.getTitle());
				try{
				driver.switchTo().alert().accept();
				}
				catch(Exception e){}
				String url2="http://cscdbche754:7777/HIS/eOR/jsp/ConsentDetailsFrameset.jsp?";
				//String script2 = "window.location = \'"+url2+"\'";
				String script2 ="window.focus(Consent Details - -)";
				jsExecutor1.executeScript(script2);*/
			break;	
			
		case "TabOut":
			/*action.sendKeys(Keys.TAB);*/
			WebElement body_element = driver.findElement(By.tagName("body"));
			//action.sendKeys(body_element,Keys.TAB).perform();
			body_element.click();
			break;
<<<<<<< HEAD
		case "TabOut1":
            WebElement body_element1 = driver.findElement(By.tagName("body"));
            body_element1.click();
            Robot robot2= new Robot();  
       robot2.keyPress(KeyEvent.VK_TAB);    
       robot2.keyRelease(KeyEvent.VK_TAB);   
       break;

		case "Clickdd1"://desktop dialog
            Thread.sleep(2000);
       Robot robot1 = new Robot();   
     robot1.keyPress(KeyEvent.VK_SHIFT);
  robot1.keyPress(KeyEvent.VK_CONTROL);
  robot1.keyPress(KeyEvent.VK_S);
  robot1.keyRelease(KeyEvent.VK_S);
  robot1.keyRelease(KeyEvent.VK_CONTROL);
  robot1.keyRelease(KeyEvent.VK_SHIFT);
  robot1.keyPress(KeyEvent.VK_ENTER);
  robot1.keyRelease(KeyEvent.VK_ENTER);
 
break; 

		case "Reports":
			Thread.sleep(2000);
Robot robot3 = new Robot();
robot3.keyPress(KeyEvent.VK_CONTROL);
robot3.keyPress(KeyEvent.VK_SHIFT);
robot3.keyPress(KeyEvent.VK_S);
robot3.keyRelease(KeyEvent.VK_S);
robot3.keyRelease(KeyEvent.VK_SHIFT);
robot3.keyRelease(KeyEvent.VK_CONTROL);
driver.close();
break;

			

=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
	case "MP_CapturePatID":
		try
		{
			ID=captureID("font", driver);
		 System.out.println("Patient ID......"+ID);
		 switch(DataSelection)
		 {
		 case "Data1":
			 //SetDataToExcel("Patient ID",0,0,TestCaseWorkbookIN,TestCaseExcelIN);
				//SetDataToExcel("Patient ID",0,0,TestCaseWorkbookIN,TestCaseExcelIN);
			 	SetDataToExcel(ID,0,1,TestCaseWorkbookIN,TestCaseExcelIN);
			 	evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
				//HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
				HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
				HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbooks10 = new HashMap<String, FormulaEvaluator>();
			    workbooks10.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks10.put("CaptureData.xls", wbB10.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks10);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(1);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
				Flag="True";
				break;
		 case "Data2":
			 SetDataToExcel(ID,39,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 //evaluator(TestCaseWorkbookIN,evaluator);
				evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
				//HSSFWorkbook wbB1 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
				HSSFWorkbook wbB1 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
				HSSFWorkbook wbB1 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbooks1 = new HashMap<String, FormulaEvaluator>();
			    workbooks1.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks1.put("CaptureData.xls", wbB1.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks1);
<<<<<<< HEAD
				 HSSFCell cell1 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(16);
=======
				 HSSFCell cell1 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(1);
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
				 evaluator.evaluateFormulaCell(cell1);
				 String value1=cell1.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value1);
				 Flag="True";
				 break;
		 case "Data3":
			 SetDataToExcel(ID,40,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 //evaluator(TestCaseWorkbookIN,evaluator);
				evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
				HSSFWorkbook wbB2 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
				//HSSFWorkbook wbB2 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
=======
				
				HSSFWorkbook wbB2 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbooks2 = new HashMap<String, FormulaEvaluator>();
			    workbooks2.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks2.put("CaptureData.xls", wbB2.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks2);
				 HSSFCell cell2 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(1);
				 evaluator.evaluateFormulaCell(cell2);
				 String value2=cell2.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value2);
				 Flag="True";
				 break;
		 case "Data4":
			 SetDataToExcel(ID,41,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 //evaluator(TestCaseWorkbookIN,evaluator);
				evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
				
<<<<<<< HEAD
				//HSSFWorkbook wbB4 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
				HSSFWorkbook wbB4 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
				HSSFWorkbook wbB4 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbooks4 = new HashMap<String, FormulaEvaluator>();
			    workbooks4.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks4.put("CaptureData.xls", wbB4.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks4);
				 HSSFCell cell4 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(1);
				 evaluator.evaluateFormulaCell(cell4);
				 String value4=cell4.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value4);
				 Flag="True";
				 break;
		 case "Data5":
			 SetDataToExcel(ID,42,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 //evaluator(TestCaseWorkbookIN,evaluator);
				evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
				HSSFWorkbook wbB5 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
				//HSSFWorkbook wbB5 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
=======
				
				HSSFWorkbook wbB5 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbooks5 = new HashMap<String, FormulaEvaluator>();
			    workbooks5.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks5.put("CaptureData.xls", wbB5.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks5);
				 HSSFCell cell5 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(1);
				 evaluator.evaluateFormulaCell(cell5);
				 String value5=cell5.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value5);
				 Flag="True";
				 break;
		 case "Data6":
			 SetDataToExcel(ID,43,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 //evaluator(TestCaseWorkbookIN,evaluator);
				evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
				HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
				//HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
=======
			
				HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbooks6= new HashMap<String, FormulaEvaluator>();
			    workbooks6.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks6.put("CaptureData.xls", wbB6.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks6);
				 HSSFCell cell6= TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(1);
				 evaluator.evaluateFormulaCell(cell6);
				 String value6=cell6.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value6);
				 Flag="True";
				 break;
		 }
			
		 	}
		catch(Exception e){System.out.println(e);}
		Flag="True";
		break;
		
	case "OP_EncounterID":
		try{
			captureID("font", driver);
			System.out.println("OP_EncounterID......"+ID);
			//SetDataToExcel("OP_EncounterID",1,0,TestCaseWorkbookIN,TestCaseExcelIN);
			 SetDataToExcel(ID,1,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 evaluator(TestCaseWorkbookIN,evaluator);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(3);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
		Flag="True";
		break;
		
	case "AE_Bed_Bay_No":
		try{
			ID=driver.findElement(By.name("bay_no")).getAttribute("value");
			System.out.println("AE_Bed_Bay_No......"+ID);
			 SetDataToExcel(ID,46,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 evaluator(TestCaseWorkbookIN,evaluator);
<<<<<<< HEAD
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(121);
=======
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(120);
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
		Flag="True";
		break;
		
	case "AE_Visit_Date_Time":
		try{
			Window_Frame_Handling.window(waitwin,2,driver,"eHospital information system");
			driver.switchTo().frame("content");
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("patientDetailsFrame");
			ID=driver.findElement(By.name("visit_date_time")).getAttribute("value");
			SetDataToExcel(ID,47,1,TestCaseWorkbookIN,TestCaseExcelIN);
			 evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
			//	HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			 HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
				HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbooks6= new HashMap<String, FormulaEvaluator>();
			    workbooks6.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks6.put("CaptureData.xls", wbB6.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks6);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(114);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){System.out.println(e);}
		Flag="True";
		break;
	case "AE_PatientID":
		try{
			Window_Frame_Handling.window(waitwin,2,driver,"eHospital information system");
			driver.switchTo().frame("content");
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("patientFrame");
			ID=driver.findElement(By.name("patient_id")).getAttribute("value");
			SetDataToExcel(ID,48,1,TestCaseWorkbookIN,TestCaseExcelIN);
			 evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
			//	HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			 HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
				HSSFWorkbook wbB6 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbooks6= new HashMap<String, FormulaEvaluator>();
			    workbooks6.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks6.put("CaptureData.xls", wbB6.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks6);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(6);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){System.out.println(e);}
		Flag="True";
		break;
		
		
	case "OA_WaitList_No":
		try
		{
			ID=null;
<<<<<<< HEAD
			Window_Frame_Handling.switchToNewWindow(waitwin,2,driver,"eHospital Information System",Module);
=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("p")).getText();
			String[] waitlist=ID.split("number ");
			System.out.println("OA_WaitList_No......"+waitlist[1]);
			SetDataToExcel(waitlist[1],2,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(12);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "MR_Request_No":
		try
		{
			ID=null;
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("p")).getText();
			String[] Request=ID.split("REQUEST ID: ");
			System.out.println("MR_Request_No......"+Request[1]);
			SetDataToExcel(Request[1],49,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(49);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "NewBorn_ID1":
		try
		{
			ID=null;
			Window_Frame_Handling.window(waitwin,2,driver,"eHospital information system");
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("newborndtls_frame");
			List<WebElement> newborn1=driver.findElements(By.tagName("a"));
			ID=newborn1.get(0).getText();
			//ID=driver.findElement(By.tagName("a")).getText();
			System.out.println("NewBorn_ID1......"+ID);
			//SetDataToExcel("NewBorn_ID1",3,0,TestCaseWorkbookIN,TestCaseExcelIN);
			SetDataToExcel(ID,3,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(81);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "NewBorn_ID2":
		try
		{
			ID=null;
			Window_Frame_Handling.window(waitwin,2,driver,"eHospital information system");
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("newborndtls_frame");
			List<WebElement> newborn2=driver.findElements(By.tagName("a"));
			ID=newborn2.get(2).getText();
			System.out.println("NewBorn_ID2......"+ID);
			//SetDataToExcel("NewBorn_ID2",4,0,TestCaseWorkbookIN,TestCaseExcelIN);
			SetDataToExcel(ID,4,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
			HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(82);
			evaluator.evaluateFormulaCell(cell);
			String value=cell.getStringCellValue();
			System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "IP_NewBorn_ID1":
		try
		{
			ID=null;
			Window_Frame_Handling.window(waitwin,3,driver,"Register New Born");
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("newborndtls_frame");
			List<WebElement> newborn1=driver.findElements(By.tagName("a"));
			ID=newborn1.get(0).getText();
			//ID=driver.findElement(By.tagName("a")).getText();
			System.out.println("IP_NewBorn_ID1......"+ID);
			//SetDataToExcel("NewBorn_ID1",3,0,TestCaseWorkbookIN,TestCaseExcelIN);
			SetDataToExcel(ID,49,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(116);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "IP_NewBorn_ID2":
		try
		{
			ID=null;
			Window_Frame_Handling.window(waitwin,3,driver,"Register New Born");
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("newborndtls_frame");
			List<WebElement> newborn2=driver.findElements(By.tagName("a"));
			ID=newborn2.get(2).getText();
			System.out.println("IP_NewBorn_ID2......"+ID);
			//SetDataToExcel("NewBorn_ID2",4,0,TestCaseWorkbookIN,TestCaseExcelIN);
			SetDataToExcel(ID,50,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
			HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(117);
			evaluator.evaluateFormulaCell(cell);
			String value=cell.getStringCellValue();
			System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "IP_Bed_No":
		try
		{
			ID=null;
			driver.switchTo().window("Assign Bed / Mark Patient Arrival");
		 	driver.switchTo().frame("message");
			ID=driver.findElement(By.name("to_bed_no")).getAttribute("value");
			System.out.println("IP_Bed_No......"+ID);
			//SetDataToExcel("IP_Bed_No",7,0,TestCaseWorkbookIN,TestCaseExcelIN);
			SetDataToExcel(ID,7,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(53);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
		
	case "ST_Issue_Doc_No":
		try
		{
			ID=null;
			Window_Frame_Handling.switchToNewWindow(waitwin,2,driver,"eHospital Information System",Module);
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("p")).getText();
			String[] DocNo=ID.split(": ");
			String iFill_Process_ID1=DocNo[1];
			String[] iFill_Process_ID=iFill_Process_ID1.split("APP");
			String CaptureFillProcess_ID=iFill_Process_ID[0];
			System.out.println("DocNo......"+CaptureFillProcess_ID);
			SetDataToExcel(CaptureFillProcess_ID,8,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(67);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "ST_Sal_Pat_Doc_No":
		try{
			ID=captureIDarr(ID,"P",1,":",driver);
			System.out.println("ST_Sal_Pat_Doc_No......"+ID);
			// SetDataToExcel("ST_Sal_Pat_Doc_No",9,0,TestCaseWorkbookIN,TestCaseExcelIN);
			 SetDataToExcel(ID,9,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 evaluator(TestCaseWorkbookIN,evaluator);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(55);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
		Flag="True";
		break;
		
	case "ST_Req_Doc_No":
		try
		{
			ID=null;
			Window_Frame_Handling.switchToNewWindow(waitwin,2,driver,"eHospital Information System",Module);
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("p")).getText();
			String[] DocNo=ID.split(": ");
			String iFill_Process_ID1=DocNo[1];
			String[] iFill_Process_ID=iFill_Process_ID1.split("APP");
			String CaptureFillProcess_ID=iFill_Process_ID[0];
			System.out.println("DocNo......"+CaptureFillProcess_ID);
			SetDataToExcel(CaptureFillProcess_ID,10,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(57);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
<<<<<<< HEAD
=======
		
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
	case "ST_STOCK_TRF_DOC_NO":
		try
		{
			ID=null;
			Window_Frame_Handling.switchToNewWindow(waitwin,2,driver,"eHospital Information System",Module);
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("p")).getText();
			String[] DocNo=ID.split(": ");
			String iFill_Process_ID1=DocNo[1];
			String[] iFill_Process_ID=iFill_Process_ID1.split("APP");
			String CaptureFillProcess_ID=iFill_Process_ID[0];
			System.out.println("DocNo......"+CaptureFillProcess_ID);
			SetDataToExcel(CaptureFillProcess_ID,11,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(71);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
<<<<<<< HEAD
		
=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
	case "ST_Manufacturing_Req_No":
		try{
			 ID=captureIDarr(ID,"P",1,":",driver);
			 System.out.println("ST_Manufacturing_Req_No......"+ID);
			 SetDataToExcel(ID,12,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 evaluator(TestCaseWorkbookIN,evaluator);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(72);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
		Flag="True";
		break;
	case "ST_Issue_Return_DocNo":
<<<<<<< HEAD
		try
		{
			ID=null;
			Window_Frame_Handling.switchToNewWindow(waitwin,2,driver,"eHospital Information System",Module);
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("p")).getText();
			String[] DocNo=ID.split(": ");
			String iFill_Process_ID1=DocNo[1];
			String[] iFill_Process_ID=iFill_Process_ID1.split("APP");
			String CaptureFillProcess_ID=iFill_Process_ID[0];
			System.out.println("DocNo......"+CaptureFillProcess_ID);
			SetDataToExcel(CaptureFillProcess_ID,13,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(73);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
=======
		try{
			 ID=captureIDarr(ID,"P",1,":",driver);
			 System.out.println("ST_Issue_Return_DocNo......"+ID);
			 SetDataToExcel(ID,13,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 evaluator(TestCaseWorkbookIN,evaluator);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(73);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		Flag="True";
		break;
		
	case "ST_PhyInv_ID":
		try{
			 ID=captureIDarr(ID,"P",1,":",driver);
			 System.out.println("ST_PhyInv_ID......"+ID);
			 SetDataToExcel(ID,14,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 evaluator(TestCaseWorkbookIN,evaluator);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(74);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
		Flag="True";
		break;
		
	case "Referral_ID":
		try{
			captureID("FONT",driver);
			System.out.println("Referral_ID......"+ID);
			 SetDataToExcel(ID,15,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 evaluator(TestCaseWorkbookIN,evaluator);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(75);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
		Flag="True";
		break;
		
		
	case "AM_Room":
		try
		{
			ID=null;
		 	driver.switchTo().frame("f_query_add_mod");
			ID=driver.findElement(By.name("room_num")).getAttribute("value");
			System.out.println("AM_Room......"+ID);
			SetDataToExcel(ID,16,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(84);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
		
	case "MR_ASA_Score":
		try
		{
			ID=null;
		 	driver.switchTo().frame("f_query_add_mod");
			ID=driver.findElement(By.name("asa_score_code")).getAttribute("value");
			System.out.println("MR_ASA_Score......"+ID);
			SetDataToExcel(ID,17,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(89);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "ST_Prod_Trf_Req_No":
		try{
			 ID=captureIDarr(ID,"P",1,":",driver);
			 System.out.println("ST_Prod_Trf_Req_No......"+ID);
			 SetDataToExcel(ID,18,1,TestCaseWorkbookIN,TestCaseExcelIN);
				 evaluator(TestCaseWorkbookIN,evaluator);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(56);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
		Flag="True";
		break;
		
		
	case "IP_Bed_No_Admn_Transfer":
		try
		{
			ID=null;
			System.out.println("test");
			for(String wins:driver.getWindowHandles())
			{
			driver.switchTo().window(wins);
				if(driver.getTitle().equals("Emergency Transfer"))
						{
					System.out.println(driver.getTitle());
					break;
						}
				else
				{
					continue;
				}
			}
			driver.switchTo().frame("Transfer_frame");
			ID=driver.findElement(By.name("to_bed_no")).getAttribute("value");
			System.out.println("IP_Bed_No_Admn_Transfer......"+ID);
			SetDataToExcel(ID,5,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
			//HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
			HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		    Map<String, FormulaEvaluator> workbooks10 = new HashMap<String, FormulaEvaluator>();
		    workbooks10.put("EM_Automation_Test Case.xls", evaluator);
		    workbooks10.put("CaptureData.xls", wbB10.getCreationHelper().createFormulaEvaluator());
		    evaluator.setupReferencedWorkbooks(workbooks10);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(7);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
		
	case "IP_Bed_No_Admn":
		try
		{
			ID=null;
			//driver.switchTo().frame("Main_frame");
			ID=driver.findElement(By.name("bed_no")).getAttribute("value");
			System.out.println("IP_Bed_No_Admn......"+ID);
			SetDataToExcel(ID,20,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
			//HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
			HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		    Map<String, FormulaEvaluator> workbooks10 = new HashMap<String, FormulaEvaluator>();
		    workbooks10.put("EM_Automation_Test Case.xls", evaluator);
		    workbooks10.put("CaptureData.xls", wbB10.getCreationHelper().createFormulaEvaluator());
		    evaluator.setupReferencedWorkbooks(workbooks10);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(90);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "IP_Child1":
		try
		{
			ID=null;
			//driver.switchTo().frame("Main_frame");
			ID=driver.findElement(By.name("bed_no")).getAttribute("value");
			System.out.println("IP_Child1......"+ID);
			SetDataToExcel(ID,51,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
			//HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
			HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		    Map<String, FormulaEvaluator> workbooks10 = new HashMap<String, FormulaEvaluator>();
		    workbooks10.put("EM_Automation_Test Case.xls", evaluator);
		    workbooks10.put("CaptureData.xls", wbB10.getCreationHelper().createFormulaEvaluator());
		    evaluator.setupReferencedWorkbooks(workbooks10);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(118);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "IP_Child2":
		try
		{
			ID=null;
			//driver.switchTo().frame("Main_frame");
			ID=driver.findElement(By.name("bed_no")).getAttribute("value");
			System.out.println("IP_Child2......"+ID);
			SetDataToExcel(ID,52,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
		//HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
			HSSFWorkbook wbB10 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		    Map<String, FormulaEvaluator> workbooks10 = new HashMap<String, FormulaEvaluator>();
		    workbooks10.put("EM_Automation_Test Case.xls", evaluator);
		    workbooks10.put("CaptureData.xls", wbB10.getCreationHelper().createFormulaEvaluator());
		    evaluator.setupReferencedWorkbooks(workbooks10);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(119);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
		
	case "PH_BinCode":
		try
		{
			ID=null;
		 	driver.switchTo().frame("f_query_add_mod");
			ID=driver.findElement(By.name("storage_bin_code0")).getAttribute("value");
			System.out.println("PH_BinCode......"+ID);
			SetDataToExcel(ID,21,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(88);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
		
	case "CaptureFillProcess_ID":
		try
		{
			ID=null;
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("B")).getText();
			String[] waitlist=ID.split(":");
			String iFill_Process_ID1=waitlist[1];
			String[] iFill_Process_ID=iFill_Process_ID1.split("APP");
			String CaptureFillProcess_ID=iFill_Process_ID[0];
			System.out.println("CaptureFillProcess_ID......"+CaptureFillProcess_ID);
			SetDataToExcel(CaptureFillProcess_ID,22,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(4);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "IP_Booking_Ref_No":
		try{
			ID=captureID("FONT",driver);
			System.out.println("IP_Booking_Ref_No......"+ID);
			 SetDataToExcel(ID,23,1,TestCaseWorkbookIN,TestCaseExcelIN);
			 evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
			//HSSFWorkbook wbBs = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			HSSFWorkbook wbBs = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
				HSSFWorkbook wbBs = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbookss = new HashMap<String, FormulaEvaluator>();
			    workbookss.put("EM_Automation_Test Case.xls", evaluator);
			    workbookss.put("CaptureData.xls", wbBs.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks);
				// evaluator(TestCaseWorkbookIN,evaluator);
				 HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(52);
				 evaluator.evaluateFormulaCell(cell);
				 String value=cell.getStringCellValue();
				 System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){}
		Flag="True";
		break;
		
	case "AE_Disaster_PatID":
		try
		{
			ID=null;
<<<<<<< HEAD
			Window_Frame_Handling.switchToNewWindow(waitwin,2,driver,"eHospital Information System",Module);
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("p")).getText();
			String[] iDisasPat=ID.split("APP-AE0089 Patient ID generated ");
			String iDisasPat1=iDisasPat[1];
			String[] iDisasPat2=iDisasPat1.split(" With Encounter ID");
			String AE_Disaster_PatID=iDisasPat2[0];
			System.out.println("AE_Disaster_PatID......"+AE_Disaster_PatID);
			SetDataToExcel(AE_Disaster_PatID,24,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(85);
=======
		 	driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			ID=driver.findElement(By.tagName("P")).getText();
			String[] iDisasPat=ID.split(" generated");
			String iDisasPat1=iDisasPat[0];
			String[] iDisasPat2=iDisasPat1.split("APP-AE0090 Patient ID ");
			String AE_Disaster_PatID=iDisasPat2[1];
			System.out.println("AE_Disaster_PatID......"+AE_Disaster_PatID);
			SetDataToExcel(AE_Disaster_PatID,24,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(1);
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
<<<<<<< HEAD
		break;	
		
	
=======
		break;
		
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
	case "OT_Booking_No":
		try
		{
			captureID("b",driver);
			System.out.println("OT_Booking_No......"+ID);
			SetDataToExcel(ID,25,1,TestCaseWorkbookIN,TestCaseExcelIN);
				evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(14);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
		
	case "Token_No":
		try
		{
			captureID("B",driver);
			System.out.println("Token_No......"+ID);
			SetDataToExcel(ID,26,1,TestCaseWorkbookIN,TestCaseExcelIN);
				evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(42);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "Collect_Date_Value":
		try
		{
			driver.switchTo().window("Status of Medical Report Request");
			driver.switchTo().frame("DetailFrame");
			String Collect_Date_Values=driver.findElement(By.name("collect_date")).getAttribute("value");
			String[] Collect_Date_Valuearr=Collect_Date_Values.split(":");
			String Collect_Date_Value=Collect_Date_Valuearr[0]+":"+Collect_Date_Valuearr[1]+".*";
			
			System.out.println("Collect_Date_Value......"+Collect_Date_Value);
			SetDataToExcel(Collect_Date_Value,27,1,TestCaseWorkbookIN,TestCaseExcelIN);
				evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(106);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "Capture_OrderID":
		try
		{
			driver.switchTo().window("View - View Order");
			driver.switchTo().frame("ViewOrderTop");
			String Capture_OrderID=driver.findElement(By.tagName("B")).getAttribute("text");
			
			System.out.println("Capture_OrderID......"+Capture_OrderID);
			switch(DataSelection)
			{
			case "Data1":
				SetDataToExcel(Capture_OrderID,28,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(31);
					evaluator.evaluateFormulaCell(cell);
					String value=cell.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value);
					Flag="True";
					break;
					
			case "Data2":
				SetDataToExcel(Capture_OrderID,29,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell1 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(32);
					evaluator.evaluateFormulaCell(cell1);
					String value1=cell1.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value1);
					Flag="True";
					break;
			case "Data3":
				SetDataToExcel(Capture_OrderID,30,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell2 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(33);
					evaluator.evaluateFormulaCell(cell2);
					String value2=cell2.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value2);
					Flag="True";
					break;
			case "Data4":
				SetDataToExcel(Capture_OrderID,31,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell3 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(34);
					evaluator.evaluateFormulaCell(cell3);
					String value3=cell3.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value3);
					Flag="True";
					break;
			case "Data5":
				SetDataToExcel(Capture_OrderID,32,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell4 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(35);
					evaluator.evaluateFormulaCell(cell4);
					String value4=cell4.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value4);
					Flag="True";
					break;
			case "Data6":
				SetDataToExcel(Capture_OrderID,33,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell5 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(36);
					evaluator.evaluateFormulaCell(cell5);
					String value5=cell5.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value5);
					Flag="True";
					break;
			case "Data7":
				SetDataToExcel(Capture_OrderID,34,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell6 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(37);
					evaluator.evaluateFormulaCell(cell6);
					String value6=cell6.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value6);
					Flag="True";
					break;
			case "Data8":
				SetDataToExcel(Capture_OrderID,35,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell7 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(38);
					evaluator.evaluateFormulaCell(cell7);
					String value7=cell7.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value7);
					Flag="True";
					break;
			case "Data9":
				SetDataToExcel(Capture_OrderID,36,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell8 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(39);
					evaluator.evaluateFormulaCell(cell8);
					String value8=cell8.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value8);
					Flag="True";
					break;
			case "Data10":
				SetDataToExcel(Capture_OrderID,37,1,TestCaseWorkbookIN,TestCaseExcelIN);
					evaluator(TestCaseWorkbookIN,evaluator);
					HSSFCell cell9 = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(40);
					evaluator.evaluateFormulaCell(cell9);
					String value9=cell9.getStringCellValue();
					System.out.println("reflected ID in TestcaseSheet    "+value9);
					Flag="True";
					break;
					
			}
			
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "IP_EncounterID":
		try
		{
			Window_Frame_Handling.window(waitwin,2,driver,"eHospital information system");
			driver.switchTo().frame("content");
			driver.switchTo().frame("messageFrame");
			List <WebElement>eles=driver.findElements(By.tagName("b"));
			System.out.println(eles.size());
			ID=eles.get(1).getText();
			System.out.println("IP_EncounterID......"+ID);
			SetDataToExcel(ID,38,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
			//HSSFWorkbook wbB1 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			HSSFWorkbook wbB1 = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
			HSSFWorkbook wbB1 = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		    Map<String, FormulaEvaluator> workbooks1 = new HashMap<String, FormulaEvaluator>();
		    workbooks1.put("EM_Automation_Test Case.xls", evaluator);
		    workbooks1.put("CaptureData.xls", wbB1.getCreationHelper().createFormulaEvaluator());
		    evaluator.setupReferencedWorkbooks(workbooks1);
			//HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(2);
		    HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(0);
			evaluator.evaluateFormulaCell(cell);
			String value=cell.getStringCellValue();
			System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Flag="True";
		break;
		
		
	case "IP_Preferred":
		try
		{
			driver.switchTo().frame("f_query_add_mod");
			String Preferred=driver.findElement(By.name("pref_adm_date")).getAttribute("value");
			System.out.println("IP_Preferred......"+Preferred);
			SetDataToExcel(Preferred,6,1,TestCaseWorkbookIN,TestCaseExcelIN);
				evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(109);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "selectAllcheckbox":
		try
		{
			driver.switchTo().window("Customize Icons");
			driver.switchTo().frame("detailFrame");
			List<WebElement> selectAllcheckbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
			for(WebElement checkbox:selectAllcheckbox)
			{
				if(!checkbox.isSelected()){
					checkbox.click();
				}
			}
			
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "UnselectAllcheckbox":
		try
		{
			driver.switchTo().window("Customize Icons");
			driver.switchTo().frame("detailFrame");
			List<WebElement> UnselectAllcheckbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
			for(WebElement checkbox:UnselectAllcheckbox)
			{
				if(checkbox.isSelected()){
					checkbox.click();
				}
			}
			
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "DragDrop1":
		try
		{
			driver.switchTo().window("Configure Display Order");
			WebElement from=driver.findElement(By.id("li1_3"));
			WebElement to=driver.findElement(By.id("li1_4"));
			Actions act=new Actions(driver);
			act.dragAndDrop(from, to).build().perform();
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "DragDrop2":
		try
		{
			driver.switchTo().window("Configure Display Order");
			WebElement from=driver.findElement(By.id("li1_5"));
			WebElement to=driver.findElement(By.id("li1_6"));
			Actions act=new Actions(driver);
			act.dragAndDrop(from, to).build().perform();
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "CA_ClinicalNotes_Spell1":
		try
		{
			date1=Date();
			SetDataToExcel(date1,19,1,TestCaseWorkbookIN,TestCaseExcelIN);
				evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(91);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
				driver.switchTo().frame("RTEditor0");
				driver.findElement(By.tagName("BODY")).sendKeys("Wrg"+date1+"_1");
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "CA_ClinicalNotes_Spell2":
		try
		{
			HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(91);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
				driver.switchTo().frame("RTEditor0");
				driver.findElement(By.tagName("BODY")).sendKeys(value+"spel");
		}
		catch(Exception e){}
		Flag="True";
		break;
		
	case "UploadFile":
		try{
		driver.switchTo().frame("content");
		driver.switchTo().frame("f_query_add_mod");
		driver.switchTo().frame("patient_sub");
		String file="C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg";
		driver.findElement(By.name("doc1image")).sendKeys(file);
		}
		catch(Exception e){}
		
	    break;
		
	case "SchdApp":
		System.out.println("sched app started1");
		String ScheduleTime = null;
		int hr = 0;
		try
		{
			hr = new java.util.Date().getHours();
			int minutes = new java.util.Date().getMinutes();
			
			if(minutes>=00 && minutes<14)
			{
					ScheduleTime=hr+":15";
			}
			else if( minutes>=15 && minutes<29)
			{
					ScheduleTime=hr+":30";
			}
			else if( minutes>=30 && minutes<44)
			{
					ScheduleTime=hr+":45";
			}
			else if(minutes>=45 && minutes<59)
			{
					hr=hr+1;
					ScheduleTime=hr+":00";
			}
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("queries");
				driver.switchTo().frame("result");
				System.out.println("ScheduleTime    "+ScheduleTime);

		}
		catch(Exception e){
		System.out.println(e);
		}
		Flag="True";
		break;
		
<<<<<<< HEAD
	case "Clickdd"://desktop dialog
        Robot robot = new Robot();   
   robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
break;

=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
	case "AE_EncounterID":
		try{
			ID=captureID("font",driver);
			System.out.println("AE_EncounterID......"+ID);
			//SetDataToExcel("AE_EncounterID",45,0,TestCaseWorkbookIN,TestCaseExcelIN);
			 SetDataToExcel(ID,45,1,TestCaseWorkbookIN,TestCaseExcelIN);
			 evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
<<<<<<< HEAD
			//HSSFWorkbook wbBs = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			HSSFWorkbook wbBs = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
				HSSFWorkbook wbBs = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			    Map<String, FormulaEvaluator> workbookss = new HashMap<String, FormulaEvaluator>();
			    workbookss.put("EM_Automation_Test Case.xls", evaluator);
			    workbookss.put("CaptureData.xls", wbBs.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbookss);
			    HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(9);
			    System.out.println(cell);
				evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
				}
			catch(Exception e){
				
			}
		Flag="True";
		break;
	case "MP_PatID1":
		try
		{
			ID=null;
			Window_Frame_Handling.switchToNewWindow(waitwin,2,driver,"eHospital Information System",Module);
			driver.switchTo().frame("content");
			driver.switchTo().frame("f_query_add_mod");
			driver.switchTo().frame("Select_frame");
			ID=driver.findElement(By.name("patient_id")).getAttribute("value");
			System.out.println("MP_PatID1......"+ID);
			SetDataToExcel(ID,0,1,TestCaseWorkbookIN,TestCaseExcelIN);
			evaluator(TestCaseWorkbookIN,evaluator);
			HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(1);
			
			evaluator.evaluateFormulaCell(cell);
				String value=cell.getStringCellValue();
				System.out.println("reflected ID in TestcaseSheet    "+value);
		}
		catch(Exception e){
			System.out.println(e);
		}
		Flag="True";
		break;
		
	}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return Flag;
		
		
	}
	
	@SuppressWarnings({ "resource" })
	public static void SetDataToExcel(String value, int p, int n,HSSFWorkbook TestCaseWorkbookIN,FileInputStream testCaseExcelIN) throws RowsExceededException, WriteException, IOException 
	{
		try{
			FileInputStream inputFile = null;
			HSSFWorkbook workbook = null;
<<<<<<< HEAD
			//String filePath ="Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls";
			String filePath ="Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls";
=======
			String filePath ="C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls";
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			inputFile = new FileInputStream(new File(filePath));
			workbook = new HSSFWorkbook(inputFile);
			HSSFSheet sheet = workbook.getSheetAt(0);
			@SuppressWarnings("unused")
			HSSFCell cell = null;
			//cell = sheet.getRow(p).getCell(0);
			sheet.createRow(p).createCell(n).setCellValue(value);
			FileOutputStream outFile = null;
			outFile = new FileOutputStream(new File(filePath));
			workbook.write(outFile);
			outFile.close();
		}
		catch(Exception e)
		{
			
		}

	}

	@SuppressWarnings("resource")
	public static FormulaEvaluator evaluator(HSSFWorkbook TestCaseWorkbookIN,FormulaEvaluator evaluator) throws FileNotFoundException, IOException
	{
		evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
			
<<<<<<< HEAD
			//HSSFWorkbook wbB = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			HSSFWorkbook wbB = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
=======
			HSSFWorkbook wbB = new HSSFWorkbook(new FileInputStream("C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/CaptureData.xls"));
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		    Map<String, FormulaEvaluator> workbooks = new HashMap<String, FormulaEvaluator>();
		    workbooks.put("EM_Automation_Test Case.xls", evaluator);
		    workbooks.put("CaptureData.xls", wbB.getCreationHelper().createFormulaEvaluator());
		    evaluator.setupReferencedWorkbooks(workbooks);
		    return evaluator;
	}
	public static String captureID(String tagname,WebDriver driver) throws InterruptedException
	{
			ID=null;
			WebDriverWait waitwin=new WebDriverWait(driver,2);
			Window_Frame_Handling.window(waitwin,2,driver,"eHospital information system");
			try{
		 	driver.switchTo().frame("content");
			 driver.switchTo().frame("messageFrame");
			 ID=driver.findElement(By.tagName(tagname)).getText();
			}
			catch(Exception e)
			{
				Window_Frame_Handling.window(waitwin,2,driver,"eHospital information system");
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("patientFrame");
				ID=driver.findElement(By.name("patient_id")).getAttribute("value");
			}
			 return ID;
	}


	public static String captureIDarr(String ID,String tagname,int splitnum,String split,WebDriver driver)
	{
			String[] IDarr;
		 	driver.switchTo().frame("content");
			 driver.switchTo().frame("messageFrame");
			 ID=driver.findElement(By.tagName(tagname)).getText();
			 IDarr=ID.split(split);
			 ID=IDarr[splitnum];
			 System.out.println("IDarr......"+IDarr[splitnum]);
			 return ID;
	}
	public static String Date()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		date1=dateFormat.format(cal);
		 return date1;
	}
}
