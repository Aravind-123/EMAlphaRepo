package EM;

/*Description: This class File does the parameterization functionality*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import java.io.File;
import java.io.IOException;
 
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

public class Data_Selection {
	
	static String Parameter1;
	public static String ModDataSel(String Module,HSSFSheet TestCaseSheetIN,int n,int p,HSSFWorkbook TestCaseWorkbookIN,String DataSelection) throws FileNotFoundException, IOException
	{
		switch(Module)
		{
		case "DataSelection":
			DataSelection(DataSelection,TestCaseSheetIN,n,p,TestCaseWorkbookIN);
			break;
		default:
			try{
			cellType(78,n,TestCaseSheetIN,TestCaseWorkbookIN);
			}
			catch(NullPointerException e){}
		}
			return Parameter1;
	}


	public static String DataSelection(String DataSelection,HSSFSheet TestcaseSheetIN,int n,int p,HSSFWorkbook TestCaseWorkbookIN) throws FileNotFoundException, IOException
	{
		Parameter1 = null;
		if(DataSelection==null || DataSelection.equalsIgnoreCase(""))
			{
				DataSelection="Data1";
			}
		switch(DataSelection)
		{
		case "Data1":
            cellType(78,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data2":
            cellType(79,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data3":
            cellType(80,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data4":
            cellType(81,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data5":
            cellType(82,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data6":
            cellType(83,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data7":
            cellType(84,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data8":
            cellType(85,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data9":
            cellType(86,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data10":
            cellType(87,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data11":
            cellType(88,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data12":
            cellType(89,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data13":
            cellType(90,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data14":
            cellType(91,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data15":
            cellType(92,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data16":
            cellType(93,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data17":
            cellType(94,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data18":
            cellType(95,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data19":
            cellType(96,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data20":
            cellType(97,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data21":
            cellType(98,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data22":
            cellType(99,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data23":
            cellType(100,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data24":
            cellType(101,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data25":
            cellType(102,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data26":
            cellType(103,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data27":
            cellType(104,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data28":
            cellType(105,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data29":
            cellType(106,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data30":
            cellType(107,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data31":
            cellType(108,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data32":
            cellType(109,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data33":
            cellType(110,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data34":
            cellType(111,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data35":
            cellType(112,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;
     case "Data36":
            cellType(113,n,TestcaseSheetIN,TestCaseWorkbookIN);
     break;

		
		default:
			System.out.println("DataSelection switchcase default access no matches fount in TestSet Sheet");
			break;
		}
		
		System.out.println("Parameter1"+Parameter1);
		return Parameter1;
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public static String cellType(int column,int n,HSSFSheet TestCaseSheetIN,HSSFWorkbook TestCaseWorkbookIN) throws FileNotFoundException, IOException
	{

	try{
			Parameter1=null;
			int celltype=TestCaseSheetIN.getRow(n).getCell(column).getCellType();
			switch(celltype)
			{
			case 0:
				try{
					Parameter1=String.valueOf(TestCaseSheetIN.getRow(n).getCell(column).getNumericCellValue());
					if(Parameter1.contains(".0"))
					{
						Parameter1=Parameter1.replace(".0","");
					}
					}
					catch(IllegalStateException e)
					{
						Parameter1=TestCaseSheetIN.getRow(n).getCell(column).getStringCellValue();
					}
				
				break;
				
			case 1:
				try{
					Parameter1=TestCaseSheetIN.getRow(n).getCell(column).getStringCellValue();
					}
					catch(IllegalStateException e)
					{
						Parameter1=Double.toString(TestCaseSheetIN.getRow(n).getCell(column).getNumericCellValue());
					}
				
				break;
			case 2:
				FormulaEvaluator evaluator = TestCaseWorkbookIN.getCreationHelper().createFormulaEvaluator();
				HSSFWorkbook wbB = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/MOHML_CRF_12.10.1/CaptureData.xls"));
				//HSSFWorkbook wbB = new HSSFWorkbook(new FileInputStream("Z:/Enterprise Management/InputFiles/Build Acceptance Testing/CaptureData.xls"));
			    Map<String, FormulaEvaluator> workbooks = new HashMap<String, FormulaEvaluator>();
			    workbooks.put("EM_Automation_Test Case.xls", evaluator);
			    workbooks.put("CaptureData.xls", wbB.getCreationHelper().createFormulaEvaluator());
			    evaluator.setupReferencedWorkbooks(workbooks);
				evaluator.evaluateFormulaCell(TestCaseSheetIN.getRow(n).getCell(column));
				if(TestCaseSheetIN.getRow(n).getCell(column).getCellFormula().equalsIgnoreCase("Menu!CA65536"))
				{
					Parameter1=RandomStringUtils.randomNumeric(13);
				}
				else{
				try{
				Parameter1=TestCaseSheetIN.getRow(n).getCell(column).getStringCellValue();
				}
				catch(IllegalStateException e)
				{
					System.out.println("check the value   "+TestCaseSheetIN.getRow(n).getCell(column).getNumericCellValue());
					Parameter1=Double.toString(TestCaseSheetIN.getRow(n).getCell(column).getNumericCellValue());
					System.out.println("Parameter1  "+Parameter1);
				}
				}
				break;
			case 3:
				try{
					Parameter1=TestCaseSheetIN.getRow(n).getCell(column).getStringCellValue();
					}
					catch(IllegalStateException e)
					{
						Parameter1=Double.toString(TestCaseSheetIN.getRow(n).getCell(column).getNumericCellValue());
					}
				break;
			}
		
	}
	
	catch(Exception e)
	{
		
	}
	return Parameter1;
	}

}
