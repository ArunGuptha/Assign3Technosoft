package assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task4DtmlxInvalidDetails extends Initialization {

	/*Step one: Hover over Products
	Step two: Goto Suite
	Step Three: Click on Menu
	Step Four: Hover over support 
	Step Five: Click on Technical Support
	Step Six: Enter invalid email/password
	Step Seven: Click on Log in button
	Step Eight: verify the message "ERROR: Invalid e-mail or license number"*/
	@Test
	public void abc() throws InterruptedException {
	Thread.sleep(3000);
	getDriver().manage().window().maximize();
	
	
	WebElement ele1=getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/a"));
	
	Actions action= new Actions(getDriver());
	action.moveToElement(ele1).build().perform();
	Thread.sleep(2000);
	
	WebElement ele2= getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/ul/li[3]/a"));
	action.moveToElement(ele2).build().perform();
	Thread.sleep(2000);
	
	getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/ul/li[3]/ul/li[6]/ul[2]/li[2]/a")).click();
	Thread.sleep(2000);
	
	getDriver().findElement(By.xpath("html/body/div[4]/header/div[1]/div/div/div/div/nav/ul/li[4]/a")).click();
	
	
	getDriver().findElement(By.id("email")).sendKeys("abc@apple.com");
	getDriver().findElement(By.id("license")).sendKeys("Abcabc123!");
	
	String output = getDriver().findElement(By.xpath(".//*[@class='submit-error m-bottom-30']")).getText();
	String input = "ERROR: Invalid e-mail or license number";
	Assert.assertEquals(output, input);
	Thread.sleep(1000);
	
	
	}
	}
