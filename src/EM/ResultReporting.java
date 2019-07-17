package EM;

/*Description: Function to report the results in excel sheet*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ResultReporting {
	static int rowprint=1;
	static int rowprintchk=1;
	static int rowprinttime=1;
	static int colprint=0;
	public static HSSFSheet[] ReportExcel(String filePath,HSSFWorkbook workbook) throws BiffException, IOException, WriteException
	{   
		HSSFSheet Step_Report = null,CheckPointsh = null,Exectimesh = null;
		HSSFSheet[] ResultsSheet;
		ResultsSheet = new HSSFSheet[3];
		try{		
			Step_Report = workbook.getSheet("Step Report");
			CheckPointsh = workbook.getSheet("CheckPoint");
			Exectimesh = workbook.getSheet("Time");
			for(int i=1;i<=Step_Report.getLastRowNum()+1;i++)
			{
				 HSSFRow row = Step_Report.getRow(i);
				 try{
				 Step_Report.removeRow(row);
				 }
				 catch(Exception e){};
			}
			HSSFRow row1=Step_Report.createRow(0);
			row1.createCell(0).setCellValue("TestScenarioRow");
			row1.createCell(1).setCellValue("Module_Name");
			row1.createCell(2).setCellValue("Function_Name");
			row1.createCell(3).setCellValue("Result");
			row1.createCell(4).setCellValue("Comments");
			ResultsSheet[0]=Step_Report;
			ResultsSheet[1]=ReportSecSheet(CheckPointsh);
			ResultsSheet[2]=ReportthirdSheet(Exectimesh);
			writereport(filePath,workbook);
	
		}
		catch(Exception e)
		{
			
		}
		return  ResultsSheet;
	}

	public static HSSFWorkbook writereport(String filePath,HSSFWorkbook workbook) throws IOException
	{
		FileOutputStream outFile = null;
		outFile = new FileOutputStream(new File(filePath));
		workbook.write(outFile);
		return workbook;
	}
	public static HSSFSheet ReportSecSheet(HSSFSheet CheckPointsh) throws BiffException, IOException, WriteException
	{
		try{
			
			for(int i=1;i<=CheckPointsh.getLastRowNum()+1;i++)
			{
				 HSSFRow row = CheckPointsh.getRow(i);
				 CheckPointsh.removeRow(row);
			}
			HSSFRow row2=CheckPointsh.createRow(0);
			row2.createCell(0).setCellValue("TestScenarioRow");
			row2.createCell(1).setCellValue("Function_Name");
			row2.createCell(2).setCellValue("Result");
			row2.createCell(3).setCellValue("Comments");
			}
		catch(Exception e){}
		return CheckPointsh;
	}

	public static HSSFSheet ReportthirdSheet(HSSFSheet Exectimesh) throws BiffException, IOException, WriteException
	{
		try{
			
			for(int i=1;i<=Exectimesh.getLastRowNum()+1;i++)
			{
				 HSSFRow row = Exectimesh.getRow(i);
				 Exectimesh.removeRow(row);
			}
			HSSFRow row2=Exectimesh.createRow(0);
			row2.createCell(0).setCellValue("TestScenarioRow");
			row2.createCell(1).setCellValue("Function_Name");
			row2.createCell(2).setCellValue("Start_Time");
			row2.createCell(3).setCellValue("End_Time");
			row2.createCell(4).setCellValue("Elapsed_Time_in_seconds");
			}
		catch(Exception e){}
		return Exectimesh;
	}
	
	public static void printresult(String filePath,HSSFWorkbook workbook,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,String result,String comments,int TestScenarioRows) throws IOException, WriteException
	{
		TestScenarioRows=TestScenarioRows+1;
		System.out.println("step_Report   "+step_Report.getSheetName());
		HSSFRow row=step_Report.createRow(rowprint);
		row.createCell(0).setCellValue(TestScenarioRows);
		row.createCell(1).setCellValue(module1);
		row.createCell(2).setCellValue(modFunc1);
		row.createCell(3).setCellValue(result);
		row.createCell(4).setCellValue(comments);
		rowprint=rowprint+1;
		writereport(filePath,workbook);
	}



	public static void printresultcheckpoint(String filePath,HSSFWorkbook workbook,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String result,String comments,int TestScenarioRows) throws IOException, WriteException
	{
		TestScenarioRows=TestScenarioRows+1;
		HSSFRow row=checkPointsh.createRow(rowprintchk);
		row.createCell(0).setCellValue(TestScenarioRows);
		row.createCell(1).setCellValue(module1);
		row.createCell(2).setCellValue(result);
		row.createCell(3).setCellValue(comments);
		rowprintchk=rowprintchk+1;
		writereport(filePath,workbook);
	}
	
	public static void printresulttime(String filePath,HSSFWorkbook workbook,HSSFSheet Exectimesh,String TestScenario,String start_Time,String End_Time,long elapsed_Time_in_seconds,int TestScenarioRows) throws IOException, WriteException
	{
		HSSFRow row=Exectimesh.createRow(rowprinttime);
		row.createCell(0).setCellValue(TestScenarioRows);
		row.createCell(1).setCellValue(TestScenario);
		row.createCell(2).setCellValue(start_Time);
		row.createCell(3).setCellValue(End_Time);
		row.createCell(4).setCellValue(elapsed_Time_in_seconds);
		rowprinttime=rowprinttime+1;
		writereport(filePath,workbook);
	}
	
	
	


}
