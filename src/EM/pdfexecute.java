package EM;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pdfexecute {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.ie.driver", "Z:/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.navigate().to("http://cscdbche754:9999/HIS/eSM/jsp/login.jsp");
		driver.findElement(By.name("name")).sendKeys("noppadolth");
		driver.findElement(By.name("password")).sendKeys("sihmis");
		//Thread.sleep(2000);
		WebElement loginbtn = (new WebDriverWait(driver, 5))
	  		  .until(ExpectedConditions.elementToBeClickable(By.id("loginID")));
		loginbtn.click();
		driver.getWindowHandle();
		driver.findElement(By.className("dhx_combo_input")).sendKeys("Dietary Services");
		driver.findElement(By.className("dhx_combo_input")).sendKeys(Keys.DOWN);
		driver.findElement(By.className("dhx_combo_input")).sendKeys(Keys.ENTER);
		driver.findElement(By.className("dhx_combo_input")).sendKeys(Keys.TAB);
		driver.findElement(By.id("loginID")).click();
	
		 Set<String> AllWindowHandles = driver.getWindowHandles();
         for(String win:AllWindowHandles)
         {
                driver.switchTo().window(win);
         }
         System.out.println("title......................"+driver.getTitle());
		driver.switchTo().frame("menucontent");
		driver.switchTo().frame("menuFr");
		driver.findElement(By.linkText("Reports")).click();
		driver.findElement(By.linkText("Meal Tickets")).click();
		driver.findElement(By.id("sd73")).click();
		driver.switchTo().defaultContent();
		 driver.switchTo().frame("content");
         driver.switchTo().frame("f_query_rep");
         driver.findElement(By.name("kitchenFrom")).sendKeys("Main Kitchen");
         driver.findElement(By.name("kitchenTo")).sendKeys("Main Kitchen");
         driver.switchTo().defaultContent();
         
         driver.switchTo().frame("content");
         driver.switchTo().frame("commontoolbarFrame");
         driver.findElement(By.name("run")).click();
         driver.switchTo().defaultContent();
         System.out.println("size........"+driver.getWindowHandles().size());
         for(String win:driver.getWindowHandles())
         {
        	 
                driver.switchTo().window(win);
                System.out.println("title......................"+driver.getTitle());
                    if(driver.getTitle().contains("Report"))
                {
                	break;
                }
                else
                {
                	continue;
                }
         }
         System.out.println("title......................"+driver.getTitle());
         driver.switchTo().frame("report_buttons");
         driver.findElement(By.xpath("//input[@value='OK']")).click();
         driver.switchTo().defaultContent();
         System.out.println("size........"+driver.getWindowHandles().size());
         for(String win:driver.getWindowHandles())
         {
        	 
                driver.switchTo().window(win);
                System.out.println("title......................"+driver.getTitle());
                    if(driver.getTitle().contains("Oracle"))
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
			System.out.println(stripper.getStartPage()); 
			 System.out.println(extractedText);
			 
			 if(extractedText.contains("idly"))
			 {
				 System.out.println("PASSSSSSSSSSSSSSSSSSSSSSSSSS");
			 }
			 else
			 {
				 System.out.println("FAILLLLLLLLLLLLL");
			 }
         
	}

}
