package EM;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/*Description: Access TestCase and TestSet Sheets.
			   Read required TestCase row by row and compare the elements & does action on it.*/


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;
import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;



public class MainScript{
	 //********************Variable declaration************************************
	int ExecuteTotalRows,row = 0,col=0;
	static int ExecuteTotalCol,TestCaseRow,TestScenarioTotalRow,TestScenarioRow,Count,randnum,winnumber,p,n,celltype,p2,p3,p4,p5,modcol=0;
	static String End_Time,Flag,Browserdec,Browsersec;
	static String Start_Time,Password,Username,Facility;
	static String Execute,FolderName,cellvalue,value,Parentframename=null,iframename=null,framename=null,frameinsideframesname=null,parenthandle,date1,TestScenario,Responsibility=null,DataSelection,Module,title,ModFunc,time1,result,Object1,ProName1,ProValue1,AddProname,AddProValue,ID,comments,Parameter1,Input,filePath;
    public static WebDriver driver;
	static Double cellvalueformula;
	static long Elapsed_Time_in_seconds;
	static HSSFSheet Step_Report,Exectimesh,CheckPointsh;
	static HSSFWorkbook workbook,TestCaseWorkbookIN;
	static FormulaEvaluator evaluator;
	static FileInputStream TestCaseExcelIN;
	@SuppressWarnings({ "resource", "unused","rawtypes"})
	
	public static void launch(JComboBox comboBox,JComboBox comboBox_1,JComboBox comboBox_2,JTextField textField,JTextField textField_1,java.awt.Component comp,JTable table_1) throws BiffException, IOException, InterruptedException ,NoAlertPresentException, WriteException
	{
		try
		{
		driver.manage().deleteAllCookies();
		}
		catch(Exception e){}
		String FolderName=comboBox.getSelectedItem().toString();
		String SiteName=comboBox_1.getSelectedItem().toString();
		String Responsibility=comboBox_2.getSelectedItem().toString();
		int TestScenarioRow=Integer.parseInt(textField.getText());
		int TestScenarioEndRow=Integer.parseInt(textField_1.getText());
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		HSSFWorkbook workbook = null;
		java.util.Date date = new java.util.Date();
		String filePath ="C:/Users/aswamy4/workspace/Enterprise Management/Results/ReportExcel.xls";;
		FileInputStream inputFile = new FileInputStream(filePath);
		workbook = new HSSFWorkbook(inputFile);
		HSSFSheet[] Resultsheets=ResultReporting.ReportExcel(filePath,workbook);
		Step_Report=Resultsheets[0];
		CheckPointsh=Resultsheets[1];
		Exectimesh=Resultsheets[2];
		String parentWindow = null;
		System.setProperty("webdriver.ie.driver", "C:/Users/aswamy4/workspace/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
 	   	WebDriverWait wait = new WebDriverWait(driver,10);
 	   	WebDriverWait waitele = new WebDriverWait(driver,5);
 	   	WebDriverWait waitframe=new WebDriverWait(driver,30);
 		WebDriverWait waitwin=new WebDriverWait(driver,2);
 	   	DataFormatter formatter = new DataFormatter();
 	 try
		{
 		 	String testcaseExcel="C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/EM_Automation_Test Case.xls";
 		 	TestCaseExcelIN= new FileInputStream(new File(testcaseExcel));
 		 	TestCaseWorkbookIN= new HSSFWorkbook(TestCaseExcelIN);
 		 	String ScenarioExcel = "C:/Users/aswamy4/workspace/Enterprise Management/InputFiles/EM_Automation_Test_Set.xls";;
			FileInputStream TestScenarioExcelIN= new FileInputStream(new File(ScenarioExcel));
            HSSFWorkbook TestScenarioWorkbookIN= new HSSFWorkbook(TestScenarioExcelIN);
            HSSFSheet TestScenarioSheetIN=TestScenarioWorkbookIN.getSheet(FolderName);
	 		TestScenarioTotalRow=TestScenarioSheetIN.getLastRowNum();
	 		loginPage(Responsibility,parentWindow,wait,"Noppadolth","sihmis","Siriraj Hospital");
	 		//loginPage(Responsibility,parentWindow,wait,"CSCCA","CSCCA","SELAYANG HOSPITALS");
	 		for(int k=TestScenarioRow;k<=TestScenarioEndRow;k++)
	 		{
	 			try{
	 				if(!(TestScenarioSheetIN.getRow(TestScenarioRow).getCell(0).getStringCellValue()==null) && TestScenarioSheetIN.getRow(TestScenarioRow).getCell(0).getStringCellValue().length() != 0)
	 				{
	 					TestScenario = TestScenarioSheetIN.getRow(TestScenarioRow).getCell(0).getStringCellValue();
	 				}
	 			}
	 			catch(Exception e){}
	 			try{
	 				if(!(TestScenarioSheetIN.getRow(TestScenarioRow).getCell(1).getStringCellValue()==null) && TestScenarioSheetIN.getRow(TestScenarioRow).getCell(0).getStringCellValue().length() != 0)
	 				{
	 					Responsibility=TestScenarioSheetIN.getRow(TestScenarioRow).getCell(1).getStringCellValue();
	 				}
	 			}
	 			catch(Exception e){}
	 			try{
	 				if(!(TestScenarioSheetIN.getRow(TestScenarioRow).getCell(2).getStringCellValue()==null) && TestScenarioSheetIN.getRow(TestScenarioRow).getCell(0).getStringCellValue().length() != 0)
	 				{
	 					DataSelection=TestScenarioSheetIN.getRow(TestScenarioRow).getCell(2).getStringCellValue();
	 				}
	 			}
	 			catch(Exception e){}
	 			try{
	 				Username = TestScenarioSheetIN.getRow(TestScenarioRow).getCell(3).getStringCellValue();
	 				if(Username==null || Username.equals(""))
	 				{
	 					Username ="Noppadolth";
	 					//Username ="CSCCA";
	 					
	 				}
	 				
	 			}
	 			catch(Exception e){Username ="Noppadolth";}
	 			//catch(Exception e){Username ="CSCCA";}
	 			try{
	 				Password = TestScenarioSheetIN.getRow(TestScenarioRow).getCell(4).getStringCellValue();
	 				if(Password==null || Password.equals(""))
	 				{
	 					Password ="sihmis";
	 					//Password ="CSCCA";
	 				}
	 				
	 			}
	 			catch(Exception e){Password ="sihmis";}
	 			//catch(Exception e){Password ="CSCCA";}
	 			try{
	 				Facility = TestScenarioSheetIN.getRow(TestScenarioRow).getCell(5).getStringCellValue();
	 				if(Facility==null || Facility.equals(""))
	 				{
	 					Facility ="Siriraj Hospital";
	 					//Facility ="SELAYANG HOSPITALS";
	 				}
	 			}
	 			catch(Exception e){Facility ="Siriraj Hospital";}
	 			//catch(Exception e){Facility ="SELAYANG HOSPITALS";}
	 			
	 			HSSFSheet TestCaseSheetIN=TestCaseWorkbookIN.getSheet(TestScenario);
		        HSSFSheet TestCaseSheetMenu=TestCaseWorkbookIN.getSheet("Menu");
		        int TestcaseTotalRow = TestCaseSheetIN.getPhysicalNumberOfRows();
		 		Start_Time=Starttime();
		 		
		 		switch(TestScenario)
		 		{
		 						case "SwitchResp":
		 							SwitchResp(Responsibility,parentWindow,waitframe);
		 				 			TestScenarioRow=k+1;
		 				 			continue;
		 				 	
		 						case "SwitchUser":
		 							driver.quit();
		 							driver = new InternetExplorerDriver();
		 							loginPage(Responsibility,parentWindow,wait,Username,Password,Facility);
		 							TestScenarioRow=k+1;
		 				 			continue;
		 						case "BrowserClose":
		 							driver.quit();
		 							TestScenarioRow=k+1;
		 				 			continue;
		 				 		
		 						case "ApplicationClose":
		 				 		
		 				 				driver.switchTo().defaultContent();
		 				 			    waitframe.until(ExpectedConditions.numberOfWindowsToBe(2));
		 				 			    Set<String> wind=driver.getWindowHandles();
		 				 			    parentwindow(parentWindow);
		 				 			    driver.switchTo().frame("menucontent");
		 				 			    List<WebElement>Switchresp=(new WebDriverWait(driver,3)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("img")));
		 				 			    Switchresp.get(0).click();
		 				 			    Switchresp.get(0).click();
		 				 			  TestScenarioRow=k+1;
			 				 			continue;
		 				 		
		 				 		case "ApplicationLogin":
		 				 		
		 				 			loginPage(Responsibility,parentWindow,wait,Username,Password,Facility);
		 				 			TestScenarioRow=k+1;
		 				 			continue;
		 						}
		 		//for loop Test case sheet
		 		for(int n=1;n<=TestcaseTotalRow-1;n++)
			 		{
		 			try{
						
						if (TestCaseSheetIN.getRow(n).getCell(0).getStringCellValue()!= null && TestCaseSheetIN.getRow(n).getCell(0).getStringCellValue().length() != 0 ) 
						{ 
							Module=TestCaseSheetIN.getRow(n).getCell(0).getStringCellValue();
							
						}
						}
						catch(Exception e){}
		 			//wincount(n,TestCaseSheetIN);
		 			int Counts = wincount(n,TestCaseSheetIN);
 					int winnum = Counts;
 					
 					try{
		 				if(Count==0 && !TestCaseSheetIN.getRow(n).getCell(2).getStringCellValue().equals("Static")&& !Module.contains("Wait")&& !Module.contains("TabOut") && !Module.contains("WinClose")&& !Module.contains("ESCKey"))
	 					{
						try{
		 				if(TestCaseSheetIN.getRow(n).getCell(2).getStringCellValue()!= null && TestCaseSheetIN.getRow(n).getCell(4).getStringCellValue().equals("eHospital Information System"))
					{
						//Window_Frame_Handling.currentwindow(driver,"eHospital information system",wait,2,Module);
		 					Window_Frame_Handling.switchToNewWindow(wait,2,driver,"eHospital information system",Module);

					}
					}
					catch(Exception e)
		 			{
						title=Window_Frame_Handling.window(waitwin,3,driver,"iSOFT EM ver");
		 				
					}
					}
		 			}
		 			
		 				catch(Exception e1)
		 				{}
 					
 					CaptureDynamicData.cap_Dyn_Data(Module,driver,ID,DataSelection,TestCaseWorkbookIN,TestCaseExcelIN,evaluator);
 					
					try{
					if (TestCaseSheetIN.getRow(n).getCell(1).getStringCellValue()!= null &&  TestCaseSheetIN.getRow(n).getCell(0).getStringCellValue().length() != 0) {
						ModFunc=TestCaseSheetIN.getRow(n).getCell(1).getStringCellValue();
						}
					}
					catch(NullPointerException e){}
				/*	try{
					Flag=CaptureDynamicData.cap_Dyn_Data(Module,driver,ID,DataSelection,TestCaseWorkbookIN,TestCaseExcelIN,evaluator);
					}
					catch(Exception e){}*/
					
					int p1=2;
					
				for(p=p1;p<=40;p++)
				{
					try{
						Object1=null;
						ProName1=null;
						ProValue1=null;
						AddProname=null;
						AddProValue=null;
						
						try{
						if(Flag.equals("True"))
						{
							Parameter1=null;
			 				p=p+4;
			 				break;
						}
						else
						{
							continue;
						}
						}
						catch(Exception e){}
						try{
				 			if(Module.equals("WinClose") && TestCaseSheetIN.getRow(n).getCell(7).getStringCellValue().equals(null))
			 				 {
			 					 try{
			 					String var = driver.getWindowHandle();
			 					String vartitle=driver.switchTo().window(var).getTitle();
			 					
			 					driver.close();
			 					Module=null;
			 					break;
			 					 }
			 					 catch(Exception e)
			 					 {
			 						driver.switchTo().activeElement();
				 					driver.close();
				 					Module=null;
				 					break;
				 					
			 					 }
			 					
			 				 }
				 			else if(Module.equals("WinClose") && TestCaseSheetIN.getRow(n).getCell(7).getStringCellValue()!=null)
				 			{
				 				String win=TestCaseSheetIN.getRow(n).getCell(9).getStringCellValue();
				 				
				 				Window_Frame_Handling.switchToNewWindow(wait,3,driver,win,Module);
				 				System.out.println(driver.getTitle());
				 				driver.close();
				 				Module=null;
				 				break;
				 			}
				 			else if(Module.equals("WinClose4") && TestCaseSheetIN.getRow(n).getCell(7).getStringCellValue()!=null)
				 			{
				 				String win=TestCaseSheetIN.getRow(n).getCell(9).getStringCellValue();
				 				
				 				Window_Frame_Handling.switchToNewWindow(wait,4,driver,win,Module);
		
				 				driver.close();
				 				Module=null;
				 				break;
				 			}
				 			else if(Module.equals("WinClose5") && TestCaseSheetIN.getRow(n).getCell(7).getStringCellValue()!=null)
				 			{
				 				String win=TestCaseSheetIN.getRow(n).getCell(9).getStringCellValue();
				 				
				 				Window_Frame_Handling.switchToNewWindow(wait,5,driver,win,Module);
		
				 				driver.close();
				 				Module=null;
				 				break;
				 			}
							
							else if(Module.equals("WinClose6") && TestCaseSheetIN.getRow(n).getCell(7).getStringCellValue()!=null)
				 			{
				 				String win=TestCaseSheetIN.getRow(n).getCell(9).getStringCellValue();
				 				
				 				Window_Frame_Handling.switchToNewWindow(wait,6,driver,win,Module);
		
				 				driver.close();
				 				Module=null;
				 				break;
				 			}
				 			}
				 			catch(Exception e){}
						
						
						Parameter1=Data_Selection.cellType(p,n,TestCaseSheetIN,TestCaseWorkbookIN);
						if(Parameter1!=null && !Parameter1.isEmpty())
						{
							
							Object1=Parameter1;
						}
						try{
							if (TestCaseSheetIN.getRow(n).getCell(2).getStringCellValue().equals(null) && TestCaseSheetIN.getRow(n).getCell(2).getStringCellValue().length() == 0 && !TestCaseSheetIN.getRow(n).getCell(7).getStringCellValue().equals(null))
							{ 
								break;
							}
							}
							catch(Exception e)
			 				{
								break;
			 				}
							p2 = p+1;
						
							Parameter1=Data_Selection.cellType(p2,n,TestCaseSheetIN,TestCaseWorkbookIN);
						if(Parameter1!=null && !Parameter1.isEmpty())
						{
							
							ProName1=Parameter1;
						}
							p3 = p2+1;
							Parameter1=Data_Selection.cellType(p3,n,TestCaseSheetIN,TestCaseWorkbookIN);
							if(Parameter1.contains(".") && Parameter1.contains("E"))
							{
								Parameter1=Parameter1.replace(".", "");
								try{
								Parameter1=Parameter1.substring(0, 12);
								}
								catch(Exception e)
								{
									Parameter1=Parameter1.substring(0, 8);
								}
							}
						if(Parameter1!=null && !Parameter1.isEmpty())
						{
							
							ProValue1=Parameter1;
						}
							p4 = p3+1;
					
							Parameter1=Data_Selection.cellType(p4,n,TestCaseSheetIN,TestCaseWorkbookIN);
						if(Parameter1!=null && !Parameter1.isEmpty())
						{
							
							AddProname=Parameter1;
						}
							p5 = p4+1;
						
							Parameter1=Data_Selection.cellType(p5,n,TestCaseSheetIN,TestCaseWorkbookIN);
						if(Parameter1!=null && !Parameter1.isEmpty())
						{
							AddProValue=Parameter1;
						}
						
					}
					catch(NullPointerException e)
					{
						break;
					}
				try{					
					if(ProName1.equalsIgnoreCase("attribute/name"))
	 				 {
	 					ProName1="name"; 
	 				 }
					
					if((!Object1.isEmpty())&&(!ProName1.isEmpty())&&(!ProValue1.isEmpty()))
	 				 {
	 				 System.out.println("Object1....."+Object1);
	 				 System.out.println("Object1....."+ProName1);
	 				 System.out.println("Object1....."+ProValue1);
	 				
					if(Object1.equalsIgnoreCase("Browser") && !(ProValue1.equalsIgnoreCase("eHospital Information System")))
	 				 {
									 try{
	 				
	 						winnum=Counts+1;
		 					
				
	 				 }
	 					 catch(Exception e)
	 					 {
	 						 Set<String>winh=driver.getWindowHandles();
	 						 for(String win:winh)
	 						 {
	 							 driver.switchTo().window(win);
	 						 }
	 						 
	 					 }
	 				 }
					
	 				 else if(Object1.equalsIgnoreCase("window"))
	 				  {
	 					/*int Counts = wincount(n,TestCaseSheetIN);
	 					System.out.println("Counts                                                   "+Counts);*/
	 					if(ProValue1.contains(" -- Webpage Dialog"))
	 					{
	 						String ProValue1splt[] = ProValue1.split(" -- Webpage Dialog");
	 						ProValue1=ProValue1splt[0];
	 					}
	 					winnum=winnum+2;
	 					System.out.println("Counts                                                   "+Counts);
	 					if(Count==1)
	 					{
	 						try
	 						{
	 							Window_Frame_Handling.currentwindow(driver,ProValue1,wait,winnum,Module);
	 							if(!driver.getTitle().contains(ProValue1))
	 							{
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 						}
	 						catch(Exception e)
	 						{
	 							Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 						}
	 					
	 					}
	 					else if(Count==2)
	 					{
	 						try
	 						{
	 							Parameter1=Data_Selection.cellType(14,n,TestCaseSheetIN,TestCaseWorkbookIN);
	 							ProValue1=Parameter1;
	 							if(ProValue1.contains(" -- Webpage Dialog"))
	 		 					{
	 		 						String ProValue1splt[] = ProValue1.split(" -- Webpage Dialog");
	 		 						ProValue1=ProValue1splt[0];
	 		 					}
	 							if(Module.equals("arraywindow"))
	 							{
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 							else{
	 							Window_Frame_Handling.currentwindow(driver,ProValue1,wait,winnum,Module);
	 							if(!driver.getTitle().equals(ProValue1))
	 							{
	 								//Window_Frame_Handling.switchToNewWindow(wait,4,driver,ProValue1,Module);
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 							}
	 						}
	 						catch(Exception e)
	 						{
	 							if(Module.equals("arraywindow"))
	 							{
	 								//Window_Frame_Handling.switchToNewWindow(wait,4,driver,ProValue1,Module);
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 							else{
	 							//Window_Frame_Handling.switchToNewWindow(wait,4,driver,ProValue1,Module);
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 						}
	 						p=p+10;
	 						
	 					}
	 					else if(Count==3)
	 					{
	 						try
	 						{
	 							Parameter1=Data_Selection.cellType(19,n,TestCaseSheetIN,TestCaseWorkbookIN);
	 							ProValue1=Parameter1;
	 							if(ProValue1.contains(" -- Webpage Dialog"))
	 		 					{
	 		 						String ProValue1splt[] = ProValue1.split(" -- Webpage Dialog");
	 		 						ProValue1=ProValue1splt[0];
	 		 					}
	 							if(Module.equals("arraywindow"))
	 							{
	 								//Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 							else{
	 							//Window_Frame_Handling.currentwindow(driver,ProValue1,wait,5,Module);
	 								Window_Frame_Handling.currentwindow(driver,ProValue1,wait,winnum,Module);
	 							if(!driver.getTitle().contains(ProValue1))
	 							{
	 								//Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 							}
	 						}
	 						catch(Exception e)
	 						{
	 							if(Module.equals("arraywindow"))
	 							{
	 								//Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 							else{
	 							//Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
	 								Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
	 							}
	 						}
	 						p=p+10;
	 						
	 					}
	 					else if(Count==4)
                        {
                               try
                               {
                                      Parameter1=Data_Selection.cellType(24,n,TestCaseSheetIN,TestCaseWorkbookIN);
                                      ProValue1=Parameter1;
                                      if(ProValue1.contains(" -- Webpage Dialog"))
                                      {
                                             String ProValue1splt[] = ProValue1.split(" -- Webpage Dialog");
                                             ProValue1=ProValue1splt[0];
                                      }
                                      if(Module.equals("arraywindow"))
                                      {
                                             //Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
                                             Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
                                      }
                                      else{
                                      //Window_Frame_Handling.currentwindow(driver,ProValue1,wait,5,Module);
                                             Window_Frame_Handling.currentwindow(driver,ProValue1,wait,winnum,Module);
                                      if(!driver.getTitle().contains(ProValue1))
                                      {
                                             //Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
                                             Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
                                      }
                                      }
                               }
                               catch(Exception e)
                               {
                                      if(Module.equals("arraywindow"))
                                      {
                                             //Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
                                             Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
                                      }
                                      else{
                                      //Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
                                             Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
                                      }
                               }
                               p=p+15;

	 						
	 					}
	 					
	 					else if(Count==5)
                        {
                               try
                               {
                                      Parameter1=Data_Selection.cellType(29,n,TestCaseSheetIN,TestCaseWorkbookIN);
                                      ProValue1=Parameter1;
                                      if(ProValue1.contains(" -- Webpage Dialog"))
                                      {
                                             String ProValue1splt[] = ProValue1.split(" -- Webpage Dialog");
                                             ProValue1=ProValue1splt[0];
                                      }
                                      if(Module.equals("arraywindow"))
                                      {
                                             //Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
                                             Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
                                      }
                                      else{
                                      //Window_Frame_Handling.currentwindow(driver,ProValue1,wait,5,Module);
                                             Window_Frame_Handling.currentwindow(driver,ProValue1,wait,winnum,Module);
                                      if(!driver.getTitle().contains(ProValue1))
                                      {
                                             //Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
                                             Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
                                      }
                                      }
                               }
                               catch(Exception e)
                               {
                                      if(Module.equals("arraywindow"))
                                      {
                                             //Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
                                             Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
                                      }
                                      else{
                                      //Window_Frame_Handling.switchToNewWindow(wait,5,driver,ProValue1,Module);
                                             Window_Frame_Handling.switchToNewWindow(wait,winnum,driver,ProValue1,Module);
                                      }
                               }
                               p=p+20;

	 						
	 					}
	 					//}
	 				  }
	 				  else if(Object1.equalsIgnoreCase("Frame"))
	 				  {
	 					  try{
	 						 Parameter1=Data_Selection.DataSelection(DataSelection,TestCaseSheetIN,n,p,TestCaseWorkbookIN);
	 						 framename=Window_Frame_Handling.framehandle(ProValue1,driver,Parameter1); 
	 					  	}

	 					  catch(Exception e)
	 					  { }
	 				    }
                      else if(Object1.equalsIgnoreCase("RTEditor"))
                      {
                             try{
                                   Parameter1=Data_Selection.DataSelection(DataSelection,TestCaseSheetIN,n,p,TestCaseWorkbookIN);
                                   
                                   if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
           	 					{
           	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
           	 					}
           	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
           	 					{
           	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
           	 					}
                                  }

                             catch(Exception e)
                             { }
                        }

	 				 else if(Object1.equalsIgnoreCase("Windowactivate"))
	 				  {
	 					  try{
	 						 Parameter1=Data_Selection.DataSelection(DataSelection,TestCaseSheetIN,n,p,TestCaseWorkbookIN);
	 						CaptureDynamicData.cap_Dyn_Data(ProValue1,driver,ID,DataSelection,TestCaseWorkbookIN,TestCaseExcelIN,evaluator);
	 					  	}

	 					  catch(Exception e)
	 					  { }
	 				    }
					
	 				 else if(Object1.equalsIgnoreCase("WebElement"))
	 				  {
	 					 try
	 					 {
	 						 try{
	 						Parameter1=Data_Selection.DataSelection(DataSelection,TestCaseSheetIN,n,p,TestCaseWorkbookIN);
	 						 }
	 								catch(Exception e){}
	 					if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
	 					{
	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else
	 					{	
	 					if(!ProName1.equalsIgnoreCase("innerhtml") && AddProValue==null && !ProName1.equalsIgnoreCase("label"))
		 				 {
	 					 List <WebElement> collectWebEle=driver.findElements(By.tagName("font"));
	 					 for(WebElement element:collectWebEle)
	 					 {
	 						 if(element.getText().equals(ProValue1) || element.getText().equals(Parameter1))
	 						 {
	 							element.click();
	 							result="PASS";
		 						 comments="WebElement Clicked";
			 					ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 							break;
	 						 }
	 					 }
	 					
		 				 }
	 					 else if(!(ProName1.equalsIgnoreCase("innerhtml")) && !(AddProValue==null)&& !ProName1.equalsIgnoreCase("label"))
	 					 {
	 						List <WebElement> collectWebEle=driver.findElements(By.tagName("font"));
	 						 WebElement el=collectWebEle.get(0);
		 					 el.click();
		 					result="PASS";
	 						 comments="WebElement Clicked";
		 					ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					 }
	 					
	 					else if(ProName1.equalsIgnoreCase("innerhtml"))
	 					{
	 						 List <WebElement> collectWebEle=driver.findElements(By.tagName("span"));
		 					
		 					 if(!(collectWebEle.size()==0))
		 					 {
		 						 for(int g=0;g<=collectWebEle.size();g++)
		 						 {
		 							 WebElement el=collectWebEle.get(g);
		 							 String text=el.getText();
		 							 if(!text.equals(null) && !text.equals(""))
		 							 {
		 							String textid=el.getAttribute("id");

				 					 if(text.equals(ProValue1) || textid.equals(ProValue1) || text.equals(Parameter1))
				 					 {
				 					 el.click();
				 					result="PASS";
			 						 comments="WebElement Clicked";
				 					ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
				 					 break;
				 					 }
		 							 }
		 						 }
		 						 
		 					 }
		 					
	 					}
	 					else if(ProName1.equalsIgnoreCase("label"))
	 					{
	 						List <WebElement> collectWebEle=driver.findElements(By.tagName("label"));
		 					if(!(collectWebEle.size()==0))
		 					 {
		 						 for(int g=0;g<=collectWebEle.size();g++)
		 						 {
		 							 WebElement el=collectWebEle.get(g);
		 							 String text=el.getText();
				 					 if(text.equals(ProValue1))
				 					 {
				 					 el.click();
				 					 result="PASS";
				 					 comments="WebElement Clicked";
				 					ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
				 					 break;
				 					 }
		 						 }
		 					 }
	 					}
	 					 }
	 					 }
	 					 catch(Exception e)
	 					 {
	 						 result="FAIL";
	 						 comments="WebElement not Clicked";
		 					ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					 }
	 					
	 				  }
					
	 				  else if(Object1.equalsIgnoreCase("link"))
	 				  {
	 					  
	 					  try{
	 							Parameter1=Data_Selection.ModDataSel(Module,TestCaseSheetIN,n,p,TestCaseWorkbookIN,DataSelection);
	 					if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
	 					{
	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);	
	 					}
	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else
	 					{	
	 						Link(filePath,workbook,ProName1,ProValue1,wait,driver,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow,AddProValue);
	 						}
	 					if(Module.equalsIgnoreCase("StaticCheckPoint"))
                        { 
                                       Object1="Static";
                                      ProValue1=Data_Selection.cellType(4,n,TestCaseSheetIN,TestCaseWorkbookIN);
                                      CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,wait,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
                                      isAlertPresent(driver);
                               }
	 					  }
	 					  catch(Exception e)
	 					  {
	 						 result="FAIL";
	 						 comments="Link not Clicked"+ "    "+e;
	 						 ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					  }	  
	 				  }
	 			
	 				 else if(Object1.equalsIgnoreCase("Image"))
	 				  {
	 					 try{
	 					if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
	 					{
	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);	
	 					}
	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else
	 					{
	 					Image(filePath,workbook,ProName1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow,AddProValue);
	 					}
	 				  }
	 					catch(Exception e)
	 					 {
	 						
	 						result="FAIL";
	 						comments="Image not Clicked";
	 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					 }
	 				  }
	 				
					
	 				 else if(Object1.equalsIgnoreCase("WebCheckBox"))
	 				  {
	 					 try{
	 						Parameter1=Data_Selection.ModDataSel(Module,TestCaseSheetIN,n,p,TestCaseWorkbookIN,DataSelection);
	 					 
	 					if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint")|| ModFunc.equalsIgnoreCase("CheckedCheckPoint"))
	 					{
	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else
	 					{
	 						
	 					WebCheckBox(filePath,workbook,ProName1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow,AddProValue,Parameter1);
	 					}

	 					 }
	 					 catch(Exception e)
	 					 {
	 						result="FAIL";
	 						comments="WebCheckBox not Clicked";
	 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					 }
	 					try
						{
		 				isAlertPresent(TestCaseWorkbookIN, TestCaseExcelIN);
						}
							catch(Exception e)
							{
								result="FAIL";
		 						comments="WebButton not clicked";
		 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
							}
	 				  }
					
	 				else if(Object1.equalsIgnoreCase("WebRadioGroup"))
	 				  {
	 					try{
	 						Parameter1=Data_Selection.ModDataSel(Module,TestCaseSheetIN,n,p,TestCaseWorkbookIN,DataSelection);
	 					if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
	 					{
	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else
	 					{
	 					WebRadioGroup(filePath,workbook,ProName1,ProValue1,waitele,Parameter1,driver,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					}
	 				
	 					}
	 					catch(Exception e)
	 					{
	 						result="FAIL";
	 						comments="WebRadioGroup not Selected";
	 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					}
	 				  }
	 				else if(Object1.equalsIgnoreCase("Static"))
	 				  {
	 					try{
	 						Parameter1=Data_Selection.ModDataSel(Module,TestCaseSheetIN,n,p,TestCaseWorkbookIN,DataSelection);
	 					if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
	 					{
	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					}
	 					catch(Exception e)
	 					{
	 						result="FAIL";
	 						comments="Static not Selected";
	 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					}
	 				  }
					
					
	 				 else if(Object1.equalsIgnoreCase("WebEdit"))
	 				  {
	 					try{
	 						
	 						Parameter1=Data_Selection.ModDataSel(Module,TestCaseSheetIN,n,p,TestCaseWorkbookIN,DataSelection);
	 						try{
	 						if(Parameter1.contains("E") && !Parameter1.equals("denture") && !Parameter1.equals("ENT") && !Parameter1.equals("ENT General") && !Parameter1.equals("Examination") && !driver.getTitle().equals("Surgery Type") && !TestCaseSheetIN.getRow(n).getCell(p).getCellFormula().equalsIgnoreCase("Menu!B65536"))
	 						{ 
	 							Parameter1=Parameter1.replace("E", "");
	 						}
	 					}
 						catch(Exception e){}
	 					if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
	 					{
	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else
	 					{
	 					WebEdit(filePath,workbook,ProName1,ProValue1,Parameter1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow,AddProValue,n);
	 					}
	 					if(Module.equalsIgnoreCase("StaticCheckPoint"))
                        { 
                                       Object1="Static";
                                      ProValue1=Data_Selection.cellType(4,n,TestCaseSheetIN,TestCaseWorkbookIN);
                                      CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,wait,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
                                      isAlertPresent(driver);
                               }
	 					}
	 					catch(Exception e)
	 					{
	 						result="FAIL";
	 						comments="WebEdit not Entered";
	 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					}
	 				 }
					
	 				else if(Object1.equalsIgnoreCase("WebList"))
	 				  {
	 					try{
	 						Parameter1=Data_Selection.ModDataSel(Module,TestCaseSheetIN,n,p,TestCaseWorkbookIN,DataSelection);
	 					if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
	 					{
	 						CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);	
	 					}
	 					else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else
	 					{
	 					WebList(filePath,workbook,ProName1,ProValue1,Parameter1,driver,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					}
	 				
	 					}
	 					catch(Exception e)
	 					{
	 						result="FAIL";
	 						comments="WebList not Selected";
	 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
	 					}
	 					if(Module.equalsIgnoreCase("StaticCheckPoint"))
                        { 
                                       Object1="Static";
                                      ProValue1=Data_Selection.cellType(4,n,TestCaseSheetIN,TestCaseWorkbookIN);
                                      CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,wait,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
                                      isAlertPresent(driver);
                               }

	 				  }
					
	 				else if(Object1.equalsIgnoreCase("WinButton"))
	 				 {
	 					isAlertPresent(TestCaseWorkbookIN,TestCaseExcelIN);  
	 					/*driver.switchTo().alert();
	 					  driver.findElement(By.name("OK")).click();
	 					  isAlertPresent(driver);*/
	 					  break;
	 					
	 				 }
					else if(Object1.equalsIgnoreCase("WebButton"))
	 				 {
						try{
						Parameter1=Data_Selection.ModDataSel(Module,TestCaseSheetIN,n,p,TestCaseWorkbookIN,DataSelection);
						if(Module.equalsIgnoreCase("CheckPoint") || ModFunc.equalsIgnoreCase("CheckPoint"))
	 					{
							CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);	
	 					}
						else if(Module.equalsIgnoreCase("NegativeCheckpoint"))
	 					{
	 						CheckPoint.negativeCheckpoint(filePath,workbook,Object1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
	 					}
	 					else
	 					{
	 						WebButton(filePath,workbook,ProName1,ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow,AddProValue);
	 						}
						if(Module.equalsIgnoreCase("StaticCheckPoint"))
                        { 
                                       Object1="Static";
                                      ProValue1=Data_Selection.cellType(4,n,TestCaseSheetIN,TestCaseWorkbookIN);
                                      
                        CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,wait,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
                               isAlertPresent(driver);
                               Module=null;
                               }

						}
						catch(Exception e)
						{
							result="FAIL";
							System.out.println(e);
	 						comments="WebButton not Clicked";
	 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
						}
						try
						{
		 				isAlertPresent(TestCaseWorkbookIN, TestCaseExcelIN);
						}
							catch(Exception e)
							{
								result="FAIL";
		 						comments="WebButton not clicked";
		 						ResultReporting.printresult(filePath,workbook,Step_Report,CheckPointsh,Module,ModFunc,result,comments,TestScenarioRow);
							}
	 				 }
	 	 //********************End Code For objects Link,WebCheckbox,radiobutton,button************************************
	 				Parameter1=null;
	 				p=p+4;
	 				
	 				 }
					
	 				else
	 				{
	 					break;
	 				}
					}
					catch(Exception e){}
	 			
	 				   }
				try{
				if (TestCaseSheetIN.getRow(n+1).getCell(0).getStringCellValue().equals(null) && TestCaseSheetIN.getRow(n+1).getCell(0).getStringCellValue().length() == 0 ) 
				{ 
					break;
					
				}
				}
				catch(Exception e)
 				{
					break;
 				}
				 		}
	 		TestScenarioRow=k+1;
	 		End_Time=Endtime();
	 		Elapsed_Time_in_seconds=Elapsedtime(Start_Time, End_Time);
	 		ResultReporting.printresulttime(filePath,workbook,Exectimesh,TestScenario,Start_Time,End_Time,Elapsed_Time_in_seconds,TestScenarioRow);
	 			 		}
	 		System.exit(0);
	}
 	 catch(Exception e)
		 				{System.out.println(e);}
 
	}
	
	@SuppressWarnings("unused")
	
	public static void SwitchResp(String responsibility,String parentWindow,WebDriverWait waitframe) throws InterruptedException
    {
	try{
		driver.switchTo().defaultContent();
	    waitframe.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Set<String> wind=driver.getWindowHandles();
	    parentwindow(parentWindow);
	    driver.switchTo().frame("menucontent");
	    List<WebElement>Switchresp=(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("img")));
	   
	    Thread.sleep(1000);

	   WebElement switchele=Switchresp.get(1);
	    Actions action = new Actions(driver);
		action.doubleClick(switchele).build().perform();
		
	    Thread.sleep(1000);
	    waitframe.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Set<String> wind1=driver.getWindowHandles();
	    for(String win:wind1)
	{
		String title=driver.switchTo().window(win).getTitle();
		if(title.equals("Switch Responsibility"))
		{
			System.out.println("Switch Responsibility title********************"+title);
			break;
		}
	
	}
	driver.findElement(By.xpath("//input[@class='dhx_combo_input']")).sendKeys(responsibility);
	driver.findElement(By.className("dhx_combo_input")).sendKeys(Keys.DOWN);
	driver.findElement(By.className("dhx_combo_input")).sendKeys(Keys.ENTER);
	driver.findElement(By.id("changeOK")).click();
	}
	catch(Exception e){}
	  }
	
	public static String parentwindow(String parentWindow)
	{
		parentWindow = driver.getWindowHandle();
		return parentWindow;
	}
	
	public static void loginPage(String Responsibility,String parentWindow,WebDriverWait wait,String Username,String Password,String Facility) throws InterruptedException
	{
		try{
			//if(Username==null||Username.equals(""))
			//{
				//Username="support";
				//Password="support";
				//Facility="Siriraj Hospital";
			//}
		
	//driver.navigate().to("http://cscdbche754:7777/HIS/eSM/jsp/login.jsp");
	driver.navigate().to("http://cscdbche754:9999/HIS/eSM/jsp/login.jsp ");
	driver.findElement(By.name("name")).sendKeys(Username);
	driver.findElement(By.name("password")).sendKeys(Password);
	//Thread.sleep(2000);
	WebElement loginbtn = (new WebDriverWait(driver, 5))
  		  .until(ExpectedConditions.elementToBeClickable(By.id("loginID")));
	loginbtn.click();
	parentwindow(parentWindow);

	driver.findElement(By.className("dhx_combo_input")).sendKeys(Responsibility);
	driver.findElement(By.className("dhx_combo_input")).sendKeys(Keys.DOWN);
	driver.findElement(By.className("dhx_combo_input")).sendKeys(Keys.ENTER);
	driver.findElement(By.className("dhx_combo_input")).sendKeys(Keys.TAB);
	driver.findElement(By.id("loginID")).click();
		}
		catch(Exception e){}
}

	@SuppressWarnings("deprecation")
	public static boolean isAlertPresent(HSSFWorkbook TestCaseWorkbookIN,FileInputStream TestCaseExcelIN){
        try{
        	WebDriverWait wait = new WebDriverWait(driver,10);
        	if(Module.equalsIgnoreCase("OA_Appt_ID"))
        	{
        		
        		Alert alert = driver.switchTo().alert();
        		String text=alert.getText();
        		String[] Appt_ID=text.split("No.");
        		System.out.println("Appt_ID     "+Appt_ID[1]);
        		CaptureDynamicData.SetDataToExcel("OA_Appt_ID",9,1,TestCaseWorkbookIN,TestCaseExcelIN);
        		CaptureDynamicData.SetDataToExcel(Appt_ID[1],9,1,TestCaseWorkbookIN,TestCaseExcelIN);
        		CaptureDynamicData.evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(11);
				evaluator.evaluateFormulaCell(cell);
				}
        	else if(Module.equalsIgnoreCase("MR_Request_No"))
        	{
        		String text=driver.switchTo().alert().getText();
        		String[] Req_ID=text.split("ID :");
        		System.out.println("Req_ID     "+Req_ID[1]);
        		CaptureDynamicData.SetDataToExcel(Req_ID[1],6,0,TestCaseWorkbookIN,TestCaseExcelIN);
        		CaptureDynamicData.evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(49);
				evaluator.evaluateFormulaCell(cell);
				}
        	
        	else if(Module.equalsIgnoreCase("OA_Appt_ID_WO_PatID"))
        	{
        		String text=driver.switchTo().alert().getText();
        		String[] OA_Appt_ID_WO_PatID=text.split(". No.");
        		System.out.println("OA_Appt_ID_WO_PatID     "+OA_Appt_ID_WO_PatID[1]);
        		CaptureDynamicData.SetDataToExcel(OA_Appt_ID_WO_PatID[1],6,0,TestCaseWorkbookIN,TestCaseExcelIN);
        		CaptureDynamicData.evaluator(TestCaseWorkbookIN,evaluator);
				HSSFCell cell = TestCaseWorkbookIN.getSheetAt(0).getRow(65535).getCell(11);
				evaluator.evaluateFormulaCell(cell);
				}
        else if(Module.equalsIgnoreCase("RTVDialog"))
        	{
        		try{
        			Thread.sleep(2000);
        		 wait.until(ExpectedConditions.alertIsPresent());
        		Alert alert = driver.switchTo().alert();
        		alert.accept();
        		
           		}
        		catch(Exception e)
        		{
        			 Actions act=new Actions(driver);
            		 act.sendKeys(Keys.RETURN);
            		 act.sendKeys(Keys.ENTER);
            	}
        					
        	}
        else if(Module.equalsIgnoreCase("RTVDialogCancel"))
    	{
    		try{
    			Thread.sleep(2000);
    		 wait.until(ExpectedConditions.alertIsPresent());
    		Alert alert = driver.switchTo().alert();
    		alert.accept();
    		alert.dismiss();
    		
       		}
    		catch(Exception e)
    		{
    			 Actions act=new Actions(driver);
        		 act.sendKeys(Keys.RETURN);
        		 act.sendKeys(Keys.ENTER);
        	}
    					
    	}
        else if(Module.equalsIgnoreCase("RTVDialog2"))
    	{
    		try{
    			Thread.sleep(2000);
    			driver.switchTo().window(AddProValue);
    		 wait.until(ExpectedConditions.alertIsPresent());
    		Alert alert = driver.switchTo().alert();
    		alert.accept();
    		
       		}
    		catch(Exception e)
    		{
    			 Actions act=new Actions(driver);
        		 act.sendKeys(Keys.RETURN);
        		 act.sendKeys(Keys.ENTER);
        	}
    		try{
    			Thread.sleep(2000);
    		 wait.until(ExpectedConditions.alertIsPresent());
    		Alert alert = driver.switchTo().alert();
    		alert.accept();
    		
       		}
    		catch(Exception e)
    		{
    			 Actions act=new Actions(driver);
        		 act.sendKeys(Keys.RETURN);
        		 act.sendKeys(Keys.ENTER);
        	}
    					
    	}
        else if(Module.equalsIgnoreCase("RTVDialog1"))
    	{
    		/*try{
    			driver.navigate().back();
    			
				wait.until(ExpectedConditions.alertIsPresent());
    			//act.sendKeys(Keys.ENTER);
    		Alert alert = driver.switchTo().alert();
    		alert.accept();
    		
       		}
    		catch(Exception e)
    		{
    			 Actions act=new Actions(driver);
        		 act.sendKeys(Keys.RETURN);
        		 act.sendKeys(Keys.ENTER);
        	}
    					
    	}*/
    	
        	((JavascriptExecutor) driver).executeScript("window.confirm = function(APP-ST0115 Unit Cost will be changed based on RTV Cost)"+ " { return true; }");
    	}
        	
        	else if(Module.equalsIgnoreCase("ReschApp"))
        	{
        		driver.getWindowHandle();
        		Set<String>winh=driver.getWindowHandles();
        		for(String win:winh)
        		{
        			driver.switchTo().window(win);
        		}
        		
        		try{
        		Thread.sleep(1000);
        		//WebDriverWait wait = new WebDriverWait(driver,5);
        		wait.until(ExpectedConditions.alertIsPresent());
        		Alert alert = driver.switchTo().alert();
        		alert.accept();
           		driver.getWindowHandle();
        		}
        		catch(Exception e){}
        		}
        	else if(ProValue1.equalsIgnoreCase("Cancel"))
        	{ driver.switchTo().alert().dismiss();
        		}
        	else if(ProValue1.equalsIgnoreCase("Ok"))
            {
           	Set <String>a=driver.getWindowHandles();
           	try{
           	for(String b:a){
           		
           		driver.switchTo().window(b);
           		try{
           			
           		 driver.switchTo().alert().accept();
           		}
           		catch(Exception e){continue;}
           		 break;
           	}
           	}
           	catch(UnhandledAlertException e){
           	
           	}
                   }
        	else if(Module.equalsIgnoreCase("StaticCheckPoint"))
        	{ 
        		CheckPoint.checkpoint(filePath,workbook,Object1,ProValue1,wait,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
        		isAlertPresent(driver);
        		}
        	
        	else
        	{
        		//driver.switchTo().alert().accept();
        		//((JavascriptExecutor) driver).executeScript("window.focus();");
        		//driver = new InternetExplorerDriver();
        		JavascriptExecutor js = (JavascriptExecutor) driver;
				

        		js.executeScript("window.focus();");
        		 driver.switchTo().alert().accept();

        	}
        	 return true;
        }
        catch(Exception e){
        	return false;
        }
        finally
        {}
    }
	
		
	

	
	
	public static boolean isAlertPresent(WebDriver driver)
	{
        try{
            driver.switchTo().alert().accept();
            return true;
        }
        catch(Exception e){
            return false;
        }
        finally
        { }
        
	}
	

	
public static void WebButton(String filePath,HSSFWorkbook workbook,String locatorType, String ProValue1,WebDriverWait waitele,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,String result,String comments,int TestScenarioRow,String AddProValue) throws InterruptedException, WriteException, IOException, AWTException 
{
	try {
		switch (locatorType){
		case "id":
			WebElement ele=waitele.until(ExpectedConditions.elementToBeClickable(By.id(ProValue1)));
			if(ele.isDisplayed())
			{
				
				Actions action = new Actions(driver);
				action.doubleClick(ele).build().perform();
				result="PASS";
				comments="Button Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Button not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
	case "td":
			WebElement element1=null;;
			try{
		 element1=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='"+ProValue1+"' or @tabIndex='"+AddProValue+"']")));
				
	
			}
			catch(Exception e)
			{
					element1=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='"+ProValue1+"']")));
			}
            if(element1.isDisplayed())
            {
                  JavascriptExecutor js1 = (JavascriptExecutor) driver;
                  js1.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",element1);
                  result="PASS";
                  comments="Button Clicked";
            ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                  
            }
            else
            {
                  result="FAIL";
                  comments="Button not Clicked";
            ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
            }
            break;
            
		
               
		case "name":	
			WebElement ele3 = null;
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			try{
				
				ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='"+ProValue1+"' or @value='"+ProValue1+"']")));
			}
			catch(Exception e){
				try{
					ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='"+ProValue1+"']")));
				}
				catch(Exception e1)
				{
					ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@name='"+ProValue1+"' or @value='"+ProValue1+"']")));
				
				}
			}
			
			if(ele3.isDisplayed())
				
			{
				if(ProValue1.equals("Add"))
				{
					ele3.click();
					
				}
				else if(ProValue1.equals("OK"))
				{
					//js.executeScript("arguments[0].click();", ele3);fgh
					js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele3);
				}
				else if(ProValue1.equals("Link Doc"))
				{
					//js.executeScript("arguments[0].click();", ele3);fgh
					js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele3);
				}
				else
				{
				Actions action = new Actions(driver);
				action.moveToElement(ele3).doubleClick(ele3).build().perform();
				}
				result="PASS";
				comments="Button Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				
			}
			else
			{
				result="FAIL";
				comments="Button not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
		case "class":
			WebElement ele1=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='"+ProValue1+"' or @tabIndex='"+AddProValue+"' or @value='"+ProValue1+"']")));
			
			if(ele1.isDisplayed())
			{
				ele1.click();
				result="PASS";
				comments="Button Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				
			}
			else
			{
				result="FAIL";
				comments="Button not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		case "id1":
			WebElement ele8=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='"+ProValue1+"' and contains(@onclick, 'to_bed_no1')]")));
			
			if(ele8.isDisplayed())
			{
				ele8.click();
				result="PASS";
				comments="Button Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				
			}
			else
			{
				result="FAIL";
				comments="Button not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		case "JavaScript":
			WebElement element;
			try{
			element=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='"+ProValue1+"']")));
			}
			catch(Exception e)
			{
				element=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@value='"+ProValue1+"']")));
			}
			
			if(element.isDisplayed())
			{
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				
				//js1.executeScript("arguments[0].click();", element);
				js1.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",element);
				result="PASS";
				comments="Button Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				
			}
			else
			{
				result="FAIL";
				comments="Button not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		
		case "collect":
			
			List<WebElement> ele6=driver.findElements(By.xpath("//input[@type='button']"));
			if(!(ele6.size()==0))
			{
				for(WebElement elet:ele6)
				{
					if(ModFunc.equalsIgnoreCase("index"))
					{
						ele6.get(Integer.parseInt(ProValue1)).click();
						break;
					}
					else{
					String value=elet.getAttribute("value");
					System.out.println(value);
					if(value.equals(ProValue1))
					{
						Actions action = new Actions(driver);
						action.doubleClick(elet).build().perform();
						break;
					}
					}
				}
			}
			break;
	
		default:
			System.out.println("Button switchcase default access no matches found in PropertyName");
			break;
		}
		
	} catch (NoSuchElementException e) {
		result="FAIL";
		comments="Button not Clicked";
		ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
		System.err.format("No Element Found to click link" + e);
	}
}
	
private static Predicate<WebDriver> ExpectedConditions(Object object) {
	// TODO Auto-generated method stub
	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	return null;
}

public static void WebRadioGroup(String filePath,HSSFWorkbook workbook,String locatorType, String ProValue1,
		WebDriverWait waitele,String Parameter,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,String result,String comments,int TestScenarioRow) throws WriteException, IOException, InterruptedException 
{
	try {
		switch (locatorType){
		
		case "name":
			WebElement ele=waitele.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='"+ProValue1+"' or @value='"+ProValue1+"']")));
			try{
 			if(ele.isDisplayed() && !Parameter.equalsIgnoreCase(""))
			{
 				List<WebElement> eles=driver.findElements(By.xpath("//input[@type='radio']"));
 				System.out.println(eles.size());
				for(int b=0;b<=eles.size();b++)
				{
				System.out.println(eles.get(b).getAttribute("value"));
				if(eles.get(b).getAttribute("value").equals(Parameter))
					{
					eles.get(b).click();
						break;
					}
				
				}
				result="PASS";
				comments="RadioButton Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			}
			catch(Exception e)
			{
 			if(ele.isDisplayed())
			{
 				ele.click();
				result="PASS";
				comments="RadioButton Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			
			else
			{
				result="FAIL";
				comments="RadioButton not Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			}
			break;
		case "JavaScript":
			WebElement ele1=waitele.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='"+ProValue1+"' or @value='"+ProValue1+"']")));
			if(ele1.isDisplayed())
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",ele1);
				result="PASS";
				comments="RadioButton Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="RadioButton not Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		case "type":
			WebElement ele2=waitele.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='radio' and @name='"+ProValue1+"' and @value='"+Parameter+"' ]")));
			if(ele2.isDisplayed())
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",ele2);
				result="PASS";
				comments="RadioButton Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="RadioButton not Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		default:
			System.out.println("RadioButton switchcase default access no matches found in PropertyName");
			break;
		}
		
	} catch (NoSuchElementException e) {
		result="FAIL";
		comments="RadioButton not Selected";
		ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
		}
  
}
	
public static void WebEdit(String filePath,HSSFWorkbook workbook,String locatorType, String value,String Parameter1,WebDriverWait waitele,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,String result,String comments,int TestScenarioRow,String AddProValue,int n) throws InterruptedException, WriteException, IOException, AWTException 
{
	System.out.println("Parameter1******"+Parameter1);
	try {
		
		switch (locatorType){
		case "name":
		WebElement ele=waitele.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
			if(ele.isDisplayed())
			{
				ele.clear();
				ele.sendKeys(Parameter1);
				result="PASS";
				comments="WebEdit Entered";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="WebEdit not Entered";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
		case "name1":
			WebElement ele3 = null;
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
		
			try{
				
				ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='"+ProValue1+"' or @value='"+ProValue1+"']")));
			}
			catch(Exception e){
				try{
					ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='"+ProValue1+"']")));
				}
				catch(Exception e1)
				{
					ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@name='"+ProValue1+"' or @value='"+ProValue1+"']")));
				
				}
			}
			
			if(ele3.isDisplayed())
				
			{
				if(ProValue1.equals("Add"))
				{
					ele3.click();
					
				}
				else if(ProValue1.equals("OK"))
				{
					//js.executeScript("arguments[0].click();", ele3);fgh
					js5.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele3);
				}
				else if(ProValue1.equals("MULTI_LIST_DATA_1_C_ALS0000000000021"))
				{
					//js.executeScript("arguments[0].click();", ele3);fgh
					js5.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele3);
				}
				else if(ProValue1.equals("r_addr_line1"))
				{
					//js.executeScript("arguments[0].click();", ele3);fgh
					js5.executeScript("var elem=arguments[0]; setTimeout(function() {elem.sendKeys(Address);}, 100)",ele3);
				}
				else
				{
				Actions action = new Actions(driver);
				action.moveToElement(ele3).doubleClick(ele3).build().perform();
				}
				result="PASS";
				comments="Button Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				
			}
			else
			{
				result="FAIL";
				comments="Button not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		
		case "id":
            WebElement ele2=waitele.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
                  if(ele2.isDisplayed())
                  {
                         ele2.clear();
                         ele2.sendKeys(Parameter1);
                         result="PASS";
                         comments="WebEdit Entered";
                         ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                  }
                  else
                  {
                         result="FAIL";
                         comments="WebEdit not Entered";
                         ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                  }
                  break;

		case "body":
			
				WebElement elebody=waitele.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@tabIndex='"+value+"']")));
				if(elebody.isDisplayed())
				{
					elebody.clear();
					elebody.sendKeys(Parameter1);
					result="PASS";
					comments="WebEdit Entered";
					ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				}
				else
				{
					result="FAIL";
					comments="WebEdit not Entered";
					ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				}
				break;
		case "CntrlV":
            WebElement elev=waitele.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
                  if(elev.isDisplayed())
                  {
                        
                         elev.clear();

                         Robot robot = new Robot();
                         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(Parameter1), null);
                         robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_CONTROL);
                         result="PASS";
                         comments="WebEdit Entered";
                  ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                  }
                  else
                  {
                         result="FAIL";
                         comments="WebEdit not Entered";
                  ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                  }
                  break;
		

		case "textarea":
			WebElement textele1;
			try{
			textele1=waitele.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@tabIndex='"+value+"']")));
			}
			catch(Exception e)
			{
			try{
                textele1=waitele.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//TEXTAREA[@name='"+value+"']")));
                      }
                      catch(Exception e1){
                      textele1=waitele.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='"+value+"']")));//added by shilpa
                      }
                }
		
			if(textele1.isDisplayed())
				{
					textele1.clear();
					//textele.sendKeys(Parameter1);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.setAttribute('value', '"+Parameter1+"');}, 100)",textele1); 
					result="PASS";
					comments="WebEdit Entered";
					ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				}
				else
				{
					result="FAIL";
					comments="WebEdit not Entered";
					ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				}
				break;
			
		case "collect":
			try{
					
					List<WebElement> input=driver.findElements(By.tagName("input"));
					for(WebElement inputele:input)
					{
						String text=inputele.getAttribute("name");
					
						if(text.equals(ProValue1))
						{
						
							JavascriptExecutor js = (JavascriptExecutor) driver;
							
							Actions action = new Actions(driver);
							action.doubleClick(inputele).build().perform();
							js.executeScript("arguments[0].sendKeys(Parameter1);", inputele);
							
							
							break;
						}
					}
					
			}
			catch(Exception e1){}
			break;
		case "JavaScript":
			try{
				WebElement ele1;
				try{
					ele1=driver.findElement(By.name(ProValue1));
				}
				catch(Exception e1){
					ele1=driver.findElement(By.xpath("//*[@value='"+value+"']"));
				}
				
			if(ele1.isEnabled() || ele1.isDisplayed())
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				try{
					ele1.clear();
					ele1.sendKeys(Parameter1);
				}
				catch(Exception e)
				{
					js.executeScript("arguments[0].sendKeys(Parameter1);", ele1);
				
				}
				result="PASS";
				comments="WebEdit Entered";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="WebEdit not Entered";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			}
			catch(Exception e){
				result="FAIL";
			comments="WebEdit not Entered";
			ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);}
			break;
		case "maxlen":
			try{
				WebElement ele1 = null;
				WebElement e3=null;
				try{
					ele1=driver.findElement(By.name(ProValue1));
				}
				catch(Exception e1){
					try{
					ele1=driver.findElement(By.xpath("//*[@value='"+value+"']"));
					}
					catch(Exception e)
					{
						
						 ele1=driver.findElement(By.xpath("//body"));
					}
				}
			
				if(ele1.isEnabled() || ele1.isDisplayed())
				{
						JavascriptExecutor js = (JavascriptExecutor) driver;
						if(ModFunc.equals("maxlencheckpoint"))
						{
						Parameter1 = Parameter1.replace("\n", Keys.chord(Keys.SHIFT, Keys.ENTER));
						js.executeScript("arguments[0].setAttribute('value', '"+Parameter1+"');",ele1);
						Thread.sleep(2000);
						js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.onblur();}, 500)",ele1);
						Thread.sleep(2000);
						ProValue1=TestCaseWorkbookIN.getSheet(TestScenario).getRow(n).getCell(9).getStringCellValue();
						CheckPoint.checkpoint(filePath,workbook,"Static",ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
						js.executeScript("arguments[0].setAttribute('value', '');",ele1);
						}
						else if(ModFunc.equals("maxlencheckpointJS")){
							Parameter1 = Parameter1.replace("\n", Keys.chord(Keys.SHIFT, Keys.ENTER));
							//js.executeScript("arguments[0].sendKeys('');", ele1);
							js.executeScript("arguments[0].setAttribute('innerHTML', '"+Parameter1+"');",ele1);
							Thread.sleep(2000);
							js.executeScript("arguments[0].focus();",ele1);
							js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.onblur();}, 500)",ele1);
							//js.executeScript("arguments[0].\t;", ele1);
							ele1.sendKeys("\t");
							ProValue1=TestCaseWorkbookIN.getSheet(TestScenario).getRow(n).getCell(9).getStringCellValue();
							CheckPoint.checkpoint(filePath,workbook,"Static",ProValue1,waitele,driver,Step_Report,CheckPointsh,Module,ModFunc,TestScenarioRow,Parameter1);
							js.executeScript("arguments[0].setAttribute('innerHTML', '');",ele1);
						}
						else
						{
							Parameter1 = Parameter1.replace("\n", Keys.chord(Keys.SHIFT, Keys.ENTER));
							//js.executeScript("arguments[0].setAttribute('value', '"+Parameter1+"');",ele1);
							js.executeScript("arguments[0].setAttribute('innerHTML', '"+Parameter1+"');",ele1);
						}
						result="PASS";
						comments="WebEdit Entered";
						ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				}
				else
				{
					result="FAIL";
					comments="WebEdit not Entered";
					ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				}
				break;
				}
				catch(Exception e){
					result="FAIL";
				comments="WebEdit not Entered";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);}
				break;
		
			default:
			System.out.println("Webedit switchcase default access no matches found in PropertyName");
			break;
		}
		
	} 
	catch (NoSuchElementException e) {
		result="FAIL";
		comments="WebEdit not Entered";
		ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
		System.err.format("No Element Found to click link" + e);
	}
	
}


	
public static void WebList(String filePath,HSSFWorkbook workbook,String locatorType, String value,String Parameter1,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,String result,String comments,int TestScenarioRow) throws InterruptedException, WriteException, IOException 
{
	try {
		switch (locatorType){
		case "id":
			Select dropdown=new Select(driver.findElement(By.id(value)));
			dropdown.selectByVisibleText(Parameter1);
			break;
		case "name":
			WebElement ele = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.name(value)));
			Select dropdown1=new Select(ele);
			if(ele.isDisplayed())
			{
				try{
				dropdown1.selectByVisibleText(Parameter1);
				}
				catch(Exception e){dropdown1.selectByValue(Parameter1);}
				result="PASS";
				comments="WebList Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="WebList not Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
		case "index":
			WebElement ele3 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.name(value)));
			Select dropdown4=new Select(ele3);
			if(ele3.isEnabled())
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				try{
				js.executeScript("arguments[0].sendKeys(Parameter1);", ele3);
				}
				catch(Exception ee){
				dropdown4.selectByIndex(Integer.parseInt(Parameter1));
				}
				result="PASS";
				comments="WebList Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{	
				result="FAIL";
				comments="WebList not Selected";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
			
		case "xpath":
			
			List<WebElement> dropdown2=driver.findElements(By.xpath("//Select[@name='name_prefix']"));
			Select dropdown3=new Select(dropdown2.get(1));
			dropdown3.selectByVisibleText(Parameter1);
			result="PASS";
			comments="WebList Selected";
			ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			break;
			
	case "collect":
			List<WebElement> tagname=driver.findElements(By.tagName("select"));
			for(WebElement collecttagname:tagname)
			{
						Select options=new Select(collecttagname);
						options.selectByVisibleText(Parameter1);
						result="PASS";
						comments="WebList Selected";
						ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
						break;
					}
				
		default:
			System.out.println("WebList switchcase default access no matches found in PropertyName");
			break;
		}
		
	} catch (NoSuchElementException e) {
		result="FAIL";
		comments="WebList not Selected";
		ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
		System.err.format("No Element Found to click link" + e);
	}
}
	
public static void Link(String filePath,HSSFWorkbook workbook,String locatorType, String value,WebDriverWait waitele,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,String result,String comments,int TestScenarioRow,String AddProValue) throws InterruptedException, WriteException, IOException 
{
	
	try {
		
		if(locatorType.equalsIgnoreCase("text"))
		{
			locatorType="name";
		}
	if(value.contains(".0"))
	{
		value=value.replace(".0", "");
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
		switch (locatorType){
		
		case "name":
			WebElement ele = null;
			try{
			ele=waitele.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
			}catch(Exception e){
				ele=waitele.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(value)));
			
			}
			try{
			if(ele.isDisplayed())
			{
				if(value.contains("Appointment"))
				{
					js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele);
				}
				else
				{
				Actions action = new Actions(driver);
				action.moveToElement(ele).doubleClick(ele).build().perform();
				}
				result="PASS";
				comments="Link Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			}
			catch(Exception e1)
			{
				result="FAIL";
				comments="Link not Clicked"+ "    "+printStackTrace(e1);
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		case "class":
			WebElement ele2=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@tabIndex='"+AddProValue+"' or @class='"+ProValue1+"']")));
			if(ele2.isDisplayed())
			{
				ele2.click();
				result="PASS";
				comments="Link Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Link not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
		
		break;
		
		case "MouseHover":
			WebElement ele11= 	driver.findElement(By.className("gridDataChart"));
			//waitele.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='gridDataChart']")));//findElement(By.className("gridDataChart"));
               if(ele11.isDisplayed())
               {
                      
                      Actions actions = new Actions(driver);
                      actions.moveToElement(ele11);
                      String ToolTipText = ele11.getAttribute("onmouseover");
                      if(ToolTipText.contains(Parameter1))
                      {
                    	result="PASS";
          				comments="Mousehover Available";
          				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);         
                   }
                      else
                      {
                    		result="FAIL";
            				comments="Mousehover not Available";
            				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
            			}
               }
               else
               {	
            	result="FAIL";
				comments="Element not available";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
               break;
               
		case "Mousehover1":
            WebElement ele10=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='"+value+"']")));
            if(ele10.isDisplayed())
            {
                  
                  Actions actions = new Actions(driver);
                  actions.moveToElement(ele10);
                  String Tool=ele10.getAttribute("title");
                  if(Tool.equals(Parameter1))
                  {
                         result="PASS";
                         comments="Link Clicked";
                  ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                  }
                  else
                  {
                         result="FAIL";
                         comments="Link not Clicked";
                  ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                  }
            }
            
            break;

		case "JSClick":
			List<WebElement>dsed=driver.findElements(By.tagName("a"));
			WebElement elel=dsed.get(0);
			if(elel.isEnabled())
			{
				js.executeScript("arguments[0].click();",elel);
				result="PASS";
				comments="Link Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Link not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
		break;
		
		case "id":
			WebElement ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.id(value)));
			if(ele3.isDisplayed())
			{
				ele3.click();
				ele3.click();
				result="PASS";
				comments="Link Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Link not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
		case "JavaScript":
			WebElement ele6=waitele.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
			if(ele6.isDisplayed())
			{
				
				Actions actions = new Actions(driver);
				actions.moveToElement(ele6);
				actions.click();
				actions.perform();
				result="PASS";
				comments="Link Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Link not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
		case "title":
			WebElement ele4=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='"+value+"']")));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",ele4);
			if(ele4.isDisplayed())			
			{
				ele4.click();
				System.out.println("link clicked");
				result="PASS";
				comments="Link Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Link not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
			case "SchdApp":
				WebDriverWait wait = new WebDriverWait(driver,50);
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				WebElement ele68=driver.findElement(By.xpath("//table[@id='results1']//a[text()='"+value+"']"));
				ele68.click();
				ele68.click();
				ele68.click();
			  	WebDriverWait wait1 = new WebDriverWait(driver,50);
				wait1.until(ExpectedConditions.numberOfWindowsToBe(3));
				break;
				
			/*case "Mouseover":
				WebDriverWait wait3 = new WebDriverWait(driver,50);
			wait3.until(ExpectedConditions.numberOfWindowsToBe(2));
				WebElement ele69=driver.findElement(By.xpath("//td[text()='"+value+"']"));
                Actions actions = new Actions(driver);
                actions.moveToElement(ele69);
                actions.click();
                actions.perform();
                String ToolTipText = ele69.getAttribute(ProValue1);
                assertEquals(ToolTipText, "Performed By: Noppadol Thipdeachao");
             Thread.sleep(2000);
             System.out.println("Tooltip value is: " + ToolTipText);                     
             WebDriverWait wait4 = new WebDriverWait(driver,50);
				wait4.until(ExpectedConditions.numberOfWindowsToBe(3));
				break;*/
				                 
			case "index":
				
				List<WebElement> ele7=driver.findElements(By.tagName("a"));
				if(!(ele7.size()==0))
				{
					for(WebElement elet:ele7)
					{
						if(ModFunc.equalsIgnoreCase("index"))
						{
							ele7.get(Integer.parseInt(ProValue1)).click();
							break;
						}
						else{
						String values=elet.getAttribute("value");
						System.out.println(values);
						if(values.equals(ProValue1))
						{
							Actions action = new Actions(driver);
							action.doubleClick(elet).build().perform();
							break;
						}
						}
					}
				}
				break;
				
			case "collect":
			String linkval = null;
			List<WebElement> links=waitele.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
			System.out.println(links.size());
			for(WebElement link:links)
			{
				linkval=link.getText();
				String linkname=link.getAttribute("name");
				if(linkval.equals(ProValue1) || linkname.equals(ProValue1))
				{
					WebElement cssc=driver.findElement(By.cssSelector("a:contains('"+value+"')"));
					waitele.until(ExpectedConditions.elementToBeClickable(cssc)).click();
					WebElement element2 = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0];", cssc);
					if(element2.isDisplayed())
					{
					element2.click();
					result="PASS";
					comments="Link Clicked";
					ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
					break;
					}
					else
					{
						result="FAIL";
						comments="Link not Clicked";
						ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
					}
				}
			}
			
				if(!linkval.equals(ProValue1))
				{
				WebElement ele5=links.get(0);
				if(ele5.isDisplayed())
				{
				Actions action = new Actions(driver);
				action.doubleClick(ele5).build().perform();
				result="PASS";
				comments="Link Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				}
				else
				{
					result="FAIL";
					comments="Link not Clicked";
					ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				}
				}
			
			
			break;
			
		case "xpath":
			WebElement ele9=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@tabIndex='"+AddProValue+"' or @class='"+ProValue1+"']")));
			if(ele9.isDisplayed())
			{
				
				ele9.click();
				result="PASS";
				comments="Link Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Link not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		default:
			System.out.println("Link switchcase default access no matches fount in PropertyName");
			}
		
	} catch (NoSuchElementException e) {
		result="FAIL";
		comments="Link not Clicked";
		ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
		System.err.format("No Element Found to click link" + e);
		
	}
}

	
private static String printStackTrace(Exception e1) {
return null;
}
	
public static void Image(String filePath,HSSFWorkbook workbook,String locatorType, String value,WebDriverWait waitele,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,String result,String comments,int TestScenarioRow,String AddProValue) throws InterruptedException, WriteException, IOException 
{
	try {
		
		if(locatorType.equalsIgnoreCase("id")||locatorType.equalsIgnoreCase("file name"))
		{
			WebElement ele=waitele.until(ExpectedConditions.elementToBeClickable(By.id(value)));
			if(ele.isDisplayed())
			{
			
				Actions action = new Actions(driver);
				action.doubleClick(ele).build().perform();
				result="PASS";
				comments="Image Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Image not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
		}
		else if(locatorType.equalsIgnoreCase("name")){
			WebElement ele=waitele.until(ExpectedConditions.elementToBeClickable(By.name(value)));
			if(ele.isDisplayed())
			{
				
				Actions action = new Actions(driver);
				action.moveToElement(ele).doubleClick(ele).build().perform();
				result="PASS";
				comments="Image Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Image not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
		}
		
		else if(locatorType.equalsIgnoreCase("title")){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='"+value+"']")));
			if(ele.isDisplayed())
			{
				try{
					Actions action = new Actions(driver);
					action.moveToElement(ele).doubleClick(ele).build().perform();}
				catch(Exception e){System.out.println(e);}
				result="PASS";
				comments="Image Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Image not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
		}
		
		
		else if(locatorType.equalsIgnoreCase("JavaScript")){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele=waitele.until(ExpectedConditions.elementToBeClickable(By.name(value)));
			if(ele.isDisplayed())
			{
				js.executeScript("arguments[0].click();", ele);
				result="PASS";
				comments="Image Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="Image not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
		}
		
		
		else if(locatorType.equalsIgnoreCase("src"))
		{
			List<WebElement> eles;
			
				eles=driver.findElements(By.tagName("img"));
		
			System.out.println(eles.size());
			if(eles.size()==0)
			{
				eles=driver.findElements(By.tagName("input"));
			}
			for(WebElement ele:eles)
			{
				System.out.println(ele.getAttribute("name"));
				String src=ele.getAttribute("src");
				if (src.contains(value))
				{
					if(ele.isDisplayed())
					{
						
					/*Actions action = new Actions(driver);
					action.doubleClick(ele).build().perform();*/
					JavascriptExecutor js1 = (JavascriptExecutor) driver;
		            js1.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele);
					result="PASS";
					comments="Image Clicked";
					ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
					}
					else
					{
						result="FAIL";
						comments="Image not Clicked";
						ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
					}
					break;
				}
			}
		
		}
		
		else if(locatorType.equalsIgnoreCase("Mousehover"))
        {
                     List<WebElement> eles;
                     
                     eles=driver.findElements(By.tagName("img"));
             System.out.println(eles.size());
              if(eles.size()==0)
              {
                     eles=driver.findElements(By.tagName("input"));
              }
              for(WebElement ele:eles)
              {
                     String src=ele.getAttribute("src");
                     if (src.contains(value))
                     {
                           if(ele.isDisplayed())
                      {
                             
                             Actions actions = new Actions(driver);
                             actions.moveToElement(ele);
                             String ToolTipText = ele.getAttribute("alt");
                             if(ToolTipText.equals(AddProValue))
                             {
                           result="PASS";
                                         comments="Mousehover Available";
                                         ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);         
                       
                             }
                             else
                             {
                                  result="FAIL";
                                         comments="Mousehover not Available";
                                         ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                                  }
                      }
                      else
                      {     
                     result="FAIL";
                                  comments="Element not available";
                                   ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
                            }
                      break;

                           }
              }

        }

		else if(locatorType.equalsIgnoreCase("collect"))
        {
        List<WebElement> ele6=driver.findElements(By.tagName("input"));
        if(!(ele6.size()==0))
        {
               for(WebElement elet:ele6)
               {
                     if(ModFunc.equalsIgnoreCase("index"))
          {
                 ele6.get(Integer.parseInt(ProValue1)).click();
                 break;
          }
          else{

                     String value1=elet.getAttribute("value");
                     System.out.println(value1);
                     if(value1.equals(ProValue1))
                     {
                            Actions action = new Actions(driver);
                            action.doubleClick(elet).build().perform();
                            break;
                     }
               }
        }
        }
        }
		else{
			System.out.println("Image switchcase default access no matches fount in PropertyName");
		}
		
		
	} catch (NoSuchElementException e) {
		result="FAIL";
		comments="Image not Clicked";
		ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
		System.err.format("No Element Found to click link" + e);
		
	}
}

	
public static void WebCheckBox(String filePath,HSSFWorkbook workbook,String locatorType,String ProValue1,WebDriverWait waitele,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,String result,String comments,int TestScenarioRow,String AddProValue,String Parameter1) throws InterruptedException, WriteException, IOException, AWTException 
{
	try {
		
		switch (locatorType){
		case "name":
		
			WebElement ele=waitele.until(ExpectedConditions.elementToBeClickable(By.name(ProValue1)));
			
			if(ele.isDisplayed())
			{
				try{
				if(Parameter1.equals("ON"))
				{
					if (ele.isSelected())
					{
						
					}
					else
					{
						ele.click();
					}
				}
				else if(Parameter1.equals("OFF"))
				{
					if (ele.isSelected())
					{
						ele.click();
					}
					else
					{
						
					}
				}
				}
				catch(Exception e){
				{
					if (ele.isSelected())
					{				
					}
					else
					{
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].setAttribute('checked','true');",ele);
						
					}
				}
				}
				result="PASS";
				comments="WebCheckBox Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="WebCheckBox not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
		case "name1":
			WebElement ele3 = null;
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
		
			try{
				
				ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='"+ProValue1+"' or @value='"+ProValue1+"']")));
			}
			catch(Exception e){
				try{
					ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='"+ProValue1+"']")));
				}
				catch(Exception e1)
				{
					ele3=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@name='"+ProValue1+"' or @value='"+ProValue1+"']")));
				
				}
			}
			
			if(ele3.isDisplayed())
				
			{
				if(ProValue1.equals("Add"))
				{
					ele3.click();
					
				}
				else if(ProValue1.equals("OK"))
				{
					//js.executeScript("arguments[0].click();", ele3);fgh
					js5.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele3);
				}
				else if(ProValue1.equals("MULTI_LIST_DATA_1_C_ALS0000000000021"))
				{
					//js.executeScript("arguments[0].click();", ele3);fgh
					js5.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele3);
				}
				else if(ProValue1.equals("MULTI_LIST_DATA_3_C_ALS0000000000021"))
				{
					//js.executeScript("arguments[0].click();", ele3);fgh
					js5.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",ele3);
				}
				else
				{
				Actions action = new Actions(driver);
				action.moveToElement(ele3).doubleClick(ele3).build().perform();
				}
				result="PASS";
				comments="Button Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
				
			}
			else
			{
				result="FAIL";
				comments="Button not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
			
		case "id":
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            WebElement ele2=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='"+ProValue1+"']")));
            if(ele2.isDisplayed())
            {
                  if(Parameter1.equals("ON"))
                  {
                         if (ele2.isSelected())
                         {
                                 
                         }
                         else
                         {
                                js2.executeScript("arguments[0].click();", ele2);
                         }
                  }
                  else
                  {
                         js2.executeScript("arguments[0].click();", ele2);
                  }
            
                  result="PASS";
                  comments="WebCheckBox Clicked";
            ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
            }
            else
            {
                  result="FAIL";
                  comments="WebCheckBox not Clicked";
            ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
            }
            break;

		case "type":
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			WebElement ele1=waitele.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
			if(ele1.isDisplayed())
			{
				try{
				if(Parameter1.equals("ON"))
				{
					if (ele1.isSelected())
					{
						
					}
					else
					{
						ele1.click();
					}
				}
				else if(Parameter1.equals("OFF"))
				{
					if (ele1.isSelected())
					{
						ele1.click();
					}
					else
					{
						
					}
				}
				}
				catch(Exception e){
				{
					if (ele1.isSelected())
					{				
					}
					else
					{
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].setAttribute('checked','true');",ele1);
						
					}
				}
				}
				result="PASS";
				comments="WebCheckBox Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			else
			{
				result="FAIL";
				comments="WebCheckBox not Clicked";
				ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
			}
			break;
		default:
			System.out.println("WebCheckBox switchcase default access no matches fount in PropertyName");
			break;
		}
		
	} catch (NoSuchElementException e) {
		result="FAIL";
		comments="WebCheckBox not Clicked";
		ResultReporting.printresult(filePath,workbook,step_Report,checkPointsh,module1,modFunc1,result,comments,TestScenarioRow);
		System.err.format("No Element Found to click link" + e);
		
	}
}

public static int wincount(int n,HSSFSheet TestCaseSheetIN)
{
Count = 0;

for(int s=2;s<=35;s++)
{
String checkwindow="Window";
HSSFCell cellvalue=TestCaseSheetIN.getRow(n).getCell(s);

try{
if(cellvalue.getStringCellValue().equalsIgnoreCase(checkwindow)&& cellvalue.getStringCellValue()!=null)
{
	Count=Count+1;
}

}
catch(Exception e){}
}
return Count;
}

public static String Starttime()
{

	SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
	String Starttime = dateFormat.format(new Date()).toString();
	System.out.println(Starttime);
	return Starttime;
}


public static String Endtime() throws InterruptedException
{
	SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
	
	String Endtime = dateFormat.format(new Date()).toString();
	System.out.println(Endtime);
	return Endtime;
}

public static long Elapsedtime(String Starttime,String Endtime) throws InterruptedException, ParseException
{
String time1 =Starttime;
String time2 =Endtime;

SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
Date date1 = format.parse(time1);
Date date2 = format.parse(time2);
long Elapsedtime = date2.getTime() - date1.getTime();
Elapsedtime = Elapsedtime/1000;
System.out.println("Starttime    "+Starttime);
System.out.println("Endtime      "+Endtime);
System.out.println("Elapsedtime  "+Elapsedtime);
return Elapsedtime;
}

public static void scrolldown()
{
	try{
	((JavascriptExecutor) driver).executeScript("scroll(0,250);");
	}
	catch(Exception e)
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
	}
	
}


public static void highlightele()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("arguments[0].style.border='3px dotted blue'", Element);
}
public static void untilJqueryIsDone(WebDriver driver, int i){
		{
		Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
		if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
		return;
		}
}
}
