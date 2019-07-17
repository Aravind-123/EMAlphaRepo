<<<<<<< HEAD
package EM;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
=======
package EM;check1

import java.io.IOException;
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

<<<<<<< HEAD
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
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

<<<<<<< HEAD

=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
public class CheckPoint {
	public static void checkpoint(String filePath,HSSFWorkbook workbook,String Object1,String ProValue1,WebDriverWait wait,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,int TestScenarioRow,String Parameter1) throws WriteException, IOException
	{
		String xpath;
		String background=null; 
				try
	{
		switch(Object1)
		{
		case "Link":
			if(Parameter1==null)
		{
		xpath="//a[@id='"+ProValue1+"' or @name='"+ProValue1+"'or @title='"+ProValue1+"' or @linktext='"+ProValue1+"' or @text()='"+ProValue1+"' or .='"+ProValue1+"' or @partialLinkText='"+ProValue1+"']";
		WebElement link=driver.findElement(By.xpath(xpath));
		if(link.isDisplayed())
		{
			ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Link Exist",TestScenarioRow);
		}
		
		else
		{
			ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Link does not Exist",TestScenarioRow);
		}
		}

			else
			{
				xpath="//*[@class='"+ProValue1+"'or @title='"+ProValue1+"']";
				List<WebElement> collectele=driver.findElements(By.xpath(xpath));
				ArrayList<String> arrelements = new ArrayList(collectele.size());
				for(WebElement ele:collectele)
				{
						arrelements.add(ele.getText());
						background=ele.getAttribute("style");
						System.out.println(arrelements);
					
					}
				if(arrelements.contains(Parameter1)||Parameter1.equals(background))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Link Exist",TestScenarioRow);
					break;
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Link does not Exist",TestScenarioRow);
				}
				
			}
		break;
<<<<<<< HEAD
		case "PDFVerfication":
            System.out.println("size........"+driver.getWindowHandles().size());
       for(String win:driver.getWindowHandles())
       {            
              driver.switchTo().window(win);
              System.out.println("title......................"+driver.getTitle());
                  if(driver.getCurrentUrl().contains("Report"))
              {
                   break;
              }
              else
              {
                   continue;
              }
       }
            String Currentlink=driver.getCurrentUrl();
                  URL url=new URL(Currentlink);
                  InputStream is=url.openStream();
                  BufferedInputStream fp=new BufferedInputStream(is);
                  PDDocument document=null;
                  document=PDDocument.load(fp);
                  PDFTextStripper stripper = new PDFTextStripper();
                  String extractedText= stripper.getText(document);
                  // System.out.println(extractedText);
                  if(extractedText.contains(Parameter1))
                         {
                                ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Text Exist in PDF File",TestScenarioRow);
                                break;
                         }
                         else
                         {
                                ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Text does not Exist in PDF File",TestScenarioRow);
                         }
            break;

=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		
		case "WebButton":
			xpath="//input[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"' or @value='"+ProValue1+"']";
			WebElement WebButton=driver.findElement(By.xpath(xpath));
			if(Parameter1==null)
			{
			if(WebButton.isDisplayed())
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebButton Exist",TestScenarioRow);
			}
			else
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebButton does not Exist",TestScenarioRow);
			}
			}
			else
			{
				String disabled=WebButton.getAttribute("disabled");
				String value=WebButton.getAttribute("value");
				
					if(!modFunc1.equalsIgnoreCase("Enable"))
					{
						if(Parameter1.equalsIgnoreCase(disabled)||Parameter1.equalsIgnoreCase(value))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebButton Exist",TestScenarioRow);
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebButton does not Exist",TestScenarioRow);
				}
					}
					else if(modFunc1.equalsIgnoreCase("Enable"))
                        {
                            boolean Var3 =WebButton.isDisplayed();
                            boolean Var2 =WebButton.isEnabled();
                            if (Var3==true && Var2==true)
                            {
                                   ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebButton Enabled",TestScenarioRow);
                                   }
                                   else
                                   {
                                   ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebButton disabled",TestScenarioRow);
                                   } 
                            
                            }
              }
        
        break;

		case "WebTable":
			xpath="//td[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"'or .='"+Parameter1+"']";
			WebElement WebTable=driver.findElement(By.xpath(xpath));
			
			if(WebTable.isDisplayed())
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebTable Exist",TestScenarioRow);
			}
			else
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebTable does not Exist",TestScenarioRow);
			}
			break;
				
		/*case "Image":
			xpath="//img[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";	
			String src="img[src*='"+ProValue1+"']";
<<<<<<< HEAD
			WebElement Image = null;
=======
			WebElement Image = null;fasdfasdfsdfdasfdsfadagsdgsdgsdgasgs
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
						try{
						Image=driver.findElement(By.xpath(xpath));
						}
						catch(Exception e)
						{
							Image=driver.findElement(By.cssSelector(src));
						}
						
						if(Image.isDisplayed())
            {
                   ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebElement Exist",TestScenarioRow);
            } 
			else
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Image does not Exist",TestScenarioRow);
			}
		break;*/
			
		case "Image":
            xpath="//img[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
            String src="img[src*='"+ProValue1+"']";
            WebElement Image = null;
            List<WebElement> ele7 = null;
            try{
            Image=driver.findElement(By.xpath(xpath));
            }
            catch(Exception e)
            {              
               ele7=driver.findElements(By.cssSelector(src));
               int a = ele7.size();
             
                   }
            if(ele7.size()==1)
            {
                for(WebElement elet:ele7)
                {
                     if(elet.isDisplayed())
                     {
                            ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"Pass","Image Exist",TestScenarioRow);
                         break;
                     }
                     else{
                      ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Image does not Exist",TestScenarioRow);
                           break;     
                     }
                }
            }
                else if(ele7.size()>1){
                     boolean flag = false;
                   for(WebElement elet:ele7)
                   {
                         int index = ele7.indexOf(elet);
                         String size = Integer.toString(index);
                         if(size.equals(Parameter1))
                         {
                               flag = true;
                               break;
                         }
                   }
                   if(flag){
                   ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"Pass","Image Exist",TestScenarioRow);
                   }else{
                   ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Image  does not Exist",TestScenarioRow);
                   }
                      
                  
                    }
           
                  else{
                          if(Image.isDisplayed())
                             {
                                    ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"Pass","Image Exist",TestScenarioRow);
                                    break;
                             }  
                          else{
                                   ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Image does not Exist",TestScenarioRow);
                           break;
                          }
                  }
                  
                  
                     
            break;
            
		case "Static":
		{
			wait.until(ExpectedConditions.alertIsPresent());
			String text=driver.switchTo().alert().getText();
<<<<<<< HEAD
			if(text.equalsIgnoreCase(ProValue1)||text.equalsIgnoreCase(Parameter1))
=======
			if(text.equalsIgnoreCase(ProValue1))
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Dialog Message Exist",TestScenarioRow);
			}
			else
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Dialog Message does not Exist",TestScenarioRow);
			}
			driver.switchTo().alert().accept();
		}
		break;
		case "WebElement":
            WebElement WebElement;
           xpath="//*[@id='"+ProValue1+"' or @title='"+ProValue1+"'or @class='"+ProValue1+"' or @linktext='"+ProValue1+"' or @text()='"+ProValue1+"']";
            String xpath1="//td[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @linktext='"+ProValue1+"' or .='"+ProValue1+"']";
            String xpath2="//*[.='"+Parameter1+"']";
            String tagname=ProValue1;
     
            try{
            WebElement=driver.findElement(By.xpath(xpath));
            }
            catch(Exception e)
            {
                  try{
                  WebElement=driver.findElement(By.xpath(xpath1));
                  }
                  catch(Exception e1)
                  {
                         try{
                         WebElement=driver.findElement(By.xpath(xpath2));
                         }
                         catch(Exception e2)
                         {
                                WebElement=driver.findElement(By.tagName(tagname));
                         }
                         
                  }
            }
          
                if(Parameter1==null)
           
            {
                  if(WebElement.isDisplayed())
                  {
                         ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebElement Exist",TestScenarioRow);
                  }
                  else
                  {
                         ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebElement does not Exist",TestScenarioRow);
                  }
            }
                else
                {
                	if(modFunc1.equals("WebArr"))
                	{
                		if(driver.getPageSource().contains(Parameter1))
                		{
                		 ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebElement Exist",TestScenarioRow);
                		}
                		else
                		{
                			ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebElement does not Exist",TestScenarioRow);
                		}
                          
                	}
                	else{
                     List<WebElement> collectele=driver.findElements(By.tagName(tagname));
                     if(!(collectele.size()==0))
                     {
                     ArrayList<String> arrelements = new ArrayList(collectele.size());
                           for(WebElement ele:collectele)
                           {
                             arrelements.add(ele.getText().trim());
                           }
                           
                           if(arrelements.contains(Parameter1))
                          
                           {
                                  ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebElement Exist",TestScenarioRow);
                                  break;
                           }
                       
                          else
                           {
                        	     ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebElement does not Exist",TestScenarioRow);
                           }
                     }
                          // }
                     else
               {
                String text=WebElement.getText();
                String style= WebElement.getAttribute("style");
                if(style.contains(Parameter1)||text.equals(Parameter1))
                {
                       ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebElement Exist",TestScenarioRow); 
                }
                else
                  {
                         ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebElement does not Exist",TestScenarioRow);
                  }
               }
                }
              }

     
            break;
<<<<<<< HEAD
            
=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		case "RTEditor":
            String text=driver.switchTo().frame(0).getPageSource();
            if(text.contains(Parameter1))
            {
            ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","FrameText Exist",TestScenarioRow);  
            }
            else
            {
            ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","FrameText does not Exist",TestScenarioRow);
            }
            break;


		case "WebEdit":
            try{
            xpath="//input[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @value='"+ProValue1+"' or @text='"+ProValue1+"']";
            String xpath11="//textarea[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @value='"+ProValue1+"' or @text='"+ProValue1+"']";
            WebElement WebEdit = null;
            try{
                  WebEdit=driver.findElement(By.xpath(xpath));
            }
            catch(Exception e)
            {
                  
                         WebEdit=driver.findElement(By.xpath(xpath11));
                  }
            
                                if(Parameter1==null)
                  {
                                       try{
                  List<WebElement> eles=driver.findElements(By.tagName("textarea"));
                  WebElement textarea = eles.get(0);
                  String WebEditval = textarea.getText();
                  if(ProValue1.equalsIgnoreCase(WebEditval))
                  {
                         ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebEdit Exist",TestScenarioRow);
                  }
                  else
                  {
                         ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebEdit does not Exist",TestScenarioRow);
                  }
                                       }
                                       catch(Exception e2)
                                       {
                                              if(WebEdit.isDisplayed())
                                              {
                                                     ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebEdit Exist",TestScenarioRow);
                                              }
                                              else
                                              {
                                                     ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebEdit does not Exist",TestScenarioRow);
                                              }
                                       }
                  break;
                  }
                  else if(!(Parameter1==null))
                  {
                         String value=WebEdit.getAttribute("value");
                         String disabled=WebEdit.getAttribute("disabled");
<<<<<<< HEAD
                         if(Parameter1.equalsIgnoreCase(value)||Parameter1.equalsIgnoreCase(disabled)||value.contains(Parameter1))
=======
                         if(Parameter1.equalsIgnoreCase(value)||disabled.equalsIgnoreCase(Parameter1)||value.contains(Parameter1))
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
                         {
                                ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebEdit Exist",TestScenarioRow);   
                         }
                         else
                         {
                                ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebEdit does not Exist",TestScenarioRow);
                         }
                         break;
                  }
                 
            }
            catch(Exception e){}
            break;
		case "WebList":
			try{
				xpath="//*[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
			}
			catch(Exception e)
			{
				xpath="//select[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
			}
			
			WebElement WebList=driver.findElement(By.xpath(xpath));
			try{
			if(!Parameter1.equalsIgnoreCase(null))
			{
				String value=WebList.getAttribute("value");
				String disabled=WebList.getAttribute("disabled");
				String option=WebList.getText();
				Select visible=new Select(WebList);
				String visibletext=visible.getFirstSelectedOption().getText();
				if(Parameter1.equalsIgnoreCase(value)||Parameter1.equalsIgnoreCase(disabled)||Parameter1.equalsIgnoreCase(option)||Parameter1.equalsIgnoreCase(visibletext)||value.contains(Parameter1)||option.contains(Parameter1)||(Parameter1.equals("Enable") && disabled==null))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebList Exist",TestScenarioRow);	
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebList does not Exist",TestScenarioRow);
				}
			}
			}
			catch(Exception e)
			{
				if(WebList.isDisplayed())
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebList Exist",TestScenarioRow);
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebList does not Exist",TestScenarioRow);
				}
			}
			break;
		case "WebCheckBox":	
			xpath="//input[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
			WebElement WebCheckBox=driver.findElement(By.xpath(xpath));
			//if(!Parameter1.equalsIgnoreCase(null))
			if(!(Parameter1==null))
			{
				if(modFunc1.equals("Checked")||modFunc1.equals("CheckedCheckPoint")){
					if(WebCheckBox.isSelected() && Parameter1.equalsIgnoreCase("on"))
					{
						ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebCheckBox Exist",TestScenarioRow);
					}
					else if(!WebCheckBox.isSelected() && Parameter1.equalsIgnoreCase("off"))
					{
						ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebCheckBox Exist",TestScenarioRow);
					}
					else
					{
						ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebCheckBox does not Exist",TestScenarioRow);
					}
				}
				
				else{
				String checked=WebCheckBox.getAttribute("checked");
				String disabled=WebCheckBox.getAttribute("disabled");
				String defaultvalue=WebCheckBox.getAttribute("value");
				if(Parameter1.equals(disabled)||Parameter1.equals(checked)||Parameter1.equalsIgnoreCase(defaultvalue)||(Parameter1.equals("Enable") && disabled==null))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebCheckBox Exist",TestScenarioRow);	
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebCheckBox does not Exist",TestScenarioRow);
				}
				}
				}
			else
			{
				if(WebCheckBox.isDisplayed())
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebCheckBox Exist",TestScenarioRow);
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebCheckBox does not Exist",TestScenarioRow);
				}
			}
			break;
		case "WebRadioGroup":	
			xpath="//input[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"'or @value='"+ProValue1+"']";
			WebElement WebRadioGroup=driver.findElement(By.xpath(xpath));
			if(!(Parameter1==null))
			{
				if(modFunc1.equals("Checked")){
					if(WebRadioGroup.isSelected() && Parameter1.equalsIgnoreCase("on"))
					{
						ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebRadioGroup Exist",TestScenarioRow);
					}
					else if(!WebRadioGroup.isSelected() && Parameter1.equalsIgnoreCase("off"))
					{
						ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebRadioGroup Exist",TestScenarioRow);
					}
					else
					{
						ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebRadioGroup does not Exist",TestScenarioRow);
					}
				}
				
				else{
				String disabled=WebRadioGroup.getAttribute("disabled");
				String defaultvalue=WebRadioGroup.getAttribute("value");
				if(Parameter1.equalsIgnoreCase(disabled)||Parameter1.equalsIgnoreCase(defaultvalue))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebRadioGroup Exist",TestScenarioRow);	
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebRadioGroup does not Exist",TestScenarioRow);
				}
				}
				}
			else
			{
				if(WebRadioGroup.isDisplayed()||WebRadioGroup.isEnabled())
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebRadioGroup Exist",TestScenarioRow);
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebRadioGroup does not Exist",TestScenarioRow);
				}
			}
			break;
		}
	}	
		catch(Exception e)
		{
			System.out.println("Checkpoint exception"+e.getMessage());
			ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Checkpoint element failed to identify",TestScenarioRow);
		}
	}
	
	public static void negativeCheckpoint(String filePath,HSSFWorkbook workbook,String Object1,String ProValue1,WebDriverWait wait,WebDriver driver,HSSFSheet step_Report,HSSFSheet checkPointsh,String module1,String modFunc1,int TestScenarioRow,String Parameter1) throws WriteException, IOException
	{
		String xpath;
		try
	{
		switch(Object1)
		{
		/*case "Link":
		xpath="//a[@id='"+ProValue1+"' or @name='"+ProValue1+"' or @linktext='"+ProValue1+"' or @text='"+ProValue1+"']";
		WebElement link=driver.findElement(By.xpath(xpath));
		if(link.isDisplayed())
		{
			ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Link Exist",TestScenarioRow);
		}
		else
		{
			ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Link does not Exist",TestScenarioRow);
		}
		break;
		
*/	
		case "Link":
			if(Parameter1==null)
           // if(Parameter1.isEmpty() || Parameter1.equals(null))
            {
     xpath="//a[@id='"+ProValue1+"' or @name='"+ProValue1+"'or @title='"+ProValue1+"' or @linktext='"+ProValue1+"' or @text()='"+ProValue1+"' or .='"+ProValue1+"' or @partialLinkText='"+ProValue1+"']";
     WebElement link=driver.findElement(By.xpath(xpath));
     if(link.isDisplayed())
     {
            ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Link Exist",TestScenarioRow);
     }
     
     else
     {
            ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Link does not Exist",TestScenarioRow);
     }}

            else
            {
            
                  xpath="//*[@class='"+ProValue1+"']";
                  List<WebElement> collectele=driver.findElements(By.xpath(xpath));
                  ArrayList<String> arrelements = new ArrayList(collectele.size());
                  for(WebElement ele:collectele)
                  {
                                arrelements.add(ele.getText());
                                                       
                         }
                  if(arrelements.contains(Parameter1))
                  {
                         ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Object Exist",TestScenarioRow);
                         break;
                  }
                  else
                  {
                         ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Object does not Exist",TestScenarioRow);
                  }
                  
            }
     break;
case "WebButton":
			xpath="//input[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
			WebElement WebButton=driver.findElement(By.xpath(xpath));
			if(WebButton.isDisplayed())
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebButton Exist",TestScenarioRow);
			}
			else
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebButton does not Exist",TestScenarioRow);
			}
			break;
			
		case "Image":
			/*try{
			xpath="//img[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
			WebElement Image=driver.findElement(By.xpath(xpath));
			ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Image Exist",TestScenarioRow);
			}
			catch(Exception e)
			{
				ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Image does not Exist",TestScenarioRow);
			}
			break;*/
			
		       xpath="//img[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
		       //String srcx="//img[contains(@src='"+ProValue1+"')]";
		       String src="img[src*='"+ProValue1+"']";
		       WebElement Image = null;
		       List<WebElement> ele7 = null;
		       try{
		       Image=driver.findElement(By.xpath(xpath));
		       }
		       catch(Exception e)
		       {              
		          ele7=driver.findElements(By.cssSelector(src));
		          int a = ele7.size();
		          System.out.println(a);
		              }
		       if(!(ele7.size()==0))
		       {
		          if((ele7.size()==1) || Image.isDisplayed())
		           {
		                  ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Image Exist",TestScenarioRow);
		           }  
		          else{
		              for(WebElement elet:ele7)
		              {
		                    int index = ele7.indexOf(elet);
		                    String size = Integer.toString(index);
		                    //String value=elet.getAttribute("value");
		                    if(size.equals(Parameter1))
		                    {
		                    ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","Image Exist",TestScenarioRow);
		                           break;
		                 }
		                 
		              }
		               ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Image does not Exist",TestScenarioRow);
		               break;
		        }
<<<<<<< HEAD
		          
		       }
		       else{
		    	   ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Image does not Exist",TestScenarioRow);
	               break;
=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
		       }
		break;

			
			
		case "WebElement":
            try{
            WebElement WebElement = null;
            xpath="//span[@id='"+ProValue1+"' or @class='"+ProValue1+"' or @linktext='"+ProValue1+"' or @text='"+ProValue1+"']";
   WebElement=driver.findElement(By.xpath(xpath));
     
<<<<<<< HEAD
            if(Parameter1.equals(null))// Changed in 12.10.3
=======
            if(!(Parameter1.equals(null)))
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
            {
                  if(WebElement.isDisplayed())
                  {
                  ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebElement Exist",TestScenarioRow);
                  }
                  else
                  {
                  ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebElement does not Exist",TestScenarioRow);
                  }
            }
            else
            {
                  String value=WebElement.getAttribute("innertext");
<<<<<<< HEAD
                  String value1=WebElement.getText(); // Added in 12.10.3
                  if(Parameter1.equalsIgnoreCase(value)||Parameter1.equalsIgnoreCase(value1))// Changed in 12.10.3
=======
                  if(value.equalsIgnoreCase("innertext"))
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
                  {
                  ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebElement Exist",TestScenarioRow);
                  }
                  else
                  {
                  ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebElement does not Exist",TestScenarioRow);
                  }
            }
<<<<<<< HEAD
            
=======
>>>>>>> 310e30c51b03a75e10e55ebd352c7c6a40660e86
            }
            catch(Exception e){
            ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebElement does not Exist",TestScenarioRow);
            }
            break;

		case "WebEdit":
			xpath="//input[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
			WebElement WebEdit=driver.findElement(By.xpath(xpath));
			if(!Parameter1.equalsIgnoreCase(null))
			{
				String value=WebEdit.getAttribute("value");
				String disabled=WebEdit.getAttribute("disabled");
				if(Parameter1.equalsIgnoreCase(value)||Parameter1.equalsIgnoreCase(disabled))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebEdit Exist",TestScenarioRow);	
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebEdit does not Exist",TestScenarioRow);
				}
			}
			else
			{
				if(WebEdit.isDisplayed())
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebEdit Exist",TestScenarioRow);
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebEdit does not Exist",TestScenarioRow);
				}
			}
			break;
		case "WebList":	
			xpath="//select[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
			WebElement WebList = null;
			try{
			WebList=driver.findElement(By.xpath(xpath));
			}
			catch(Exception e)
			{
				if(Parameter1.equalsIgnoreCase(null))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebList does not Exist",TestScenarioRow);
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebList Exist",TestScenarioRow);
				}
				break;
			}
			if(!Parameter1.equalsIgnoreCase(null))
			{
				String value=WebList.getAttribute("value");
				String disabled=WebList.getAttribute("disabled");
				String gettext=WebList.getText();
				if(Parameter1.equalsIgnoreCase(value)||Parameter1.equalsIgnoreCase(disabled)|| Parameter1.equalsIgnoreCase(gettext))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebList Exist",TestScenarioRow);	
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebList does not Exist",TestScenarioRow);
				}
			}
			else
			{
				if(WebList.isDisplayed())
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebList Exist",TestScenarioRow);
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebList does not Exist",TestScenarioRow);
				}
			}
			break;
		case "WebCheckBox":	
			xpath="//input[@id='"+ProValue1+"' or @tagName='"+ProValue1+"' or @name='"+ProValue1+"' or @text='"+ProValue1+"']";
			WebElement WebCheckBox=driver.findElement(By.xpath(xpath));
			if(!Parameter1.equalsIgnoreCase(null))
			{
				String value=WebCheckBox.getAttribute("checked");
				String disabled=WebCheckBox.getAttribute("disabled");
				if(Parameter1.equalsIgnoreCase(value)||Parameter1.equalsIgnoreCase(disabled))
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebCheckBox Exist",TestScenarioRow);	
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebCheckBox does not Exist",TestScenarioRow);
				}
			}
			else
			{
				if(WebCheckBox.isDisplayed())
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","WebCheckBox Exist",TestScenarioRow);
				}
				else
				{
					ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","WebList does not Exist",TestScenarioRow);
				}
			}
			break;
		case "RTEditor":
            String text=driver.switchTo().frame(0).getPageSource();
            if(text.contains(Parameter1))
            {
            ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"FAIL","FrameText Exist",TestScenarioRow);  
            }
            else
            {
            ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","FrameText does not Exist",TestScenarioRow);
            }
            break;

		}
	}	
		catch(Exception e)
		{
		ResultReporting.printresultcheckpoint(filePath,workbook,step_Report,checkPointsh,module1,"PASS","Negative Checkpoint element failed to identify",TestScenarioRow);
		}
	}
	

}
