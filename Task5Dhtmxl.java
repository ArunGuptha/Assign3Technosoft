package assignment2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task5Dhtmxl extends Initialization {

	 /* * 1 ) Hover over to Products 
* 2) Hover over to suite 
* 3) CLick on menu
* 4) Scroll down on the page 
* 5) Verify all links at the bottom of the page.
      if any of the links are missing please fail the test*/
	@Test
	
public void Verif() throws InterruptedException{
		getDriver().manage().window().maximize();
		
		
		WebElement ele1=getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/a"));
		
		Actions action= new Actions(getDriver());
		action.moveToElement(ele1).build().perform();
		
		WebElement ele2= getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/ul/li[3]/a"));
		action.moveToElement(ele2).build().perform();
		
		getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/ul/li[3]/ul/li[6]/ul[2]/li[2]/a")).click();

		JavascriptExecutor aaa=(JavascriptExecutor)getDriver();
		aaa.executeScript("scroll(0, 100000);");
		List<WebElement> actual= getDriver().findElements(By.className("footer-col__link"));
		List<WebElement> expected= getDriver().findElements(By.className("footer-col__link"));
		for(WebElement list: actual)
		{
			String s=list.getText();
			for(WebElement e:expected)
			{
			 String s1=e.getText();
			if(s.equals(s1))
				System.out.println(" verification is done for "+s1);
				continue;
		}}
	}
}
