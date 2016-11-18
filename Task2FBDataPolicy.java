package assignment2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2FBDataPolicy extends Initialization {

	/*
	 * Step 1: Goto Data Policy link in Facebook Step 2: Click on
	 * "What kinda information do we collect" Step 3: Verify all available text
	 * within that sections
	 */

	@Test
	public void Abc() throws InterruptedException {

		getDriver().findElement(By.xpath(".//*[@id='privacy-link' and text()='Data Policy']")).click();
		Thread.sleep(3000);
		switchToWindow(1);
		getDriver().findElement(By.xpath(".//*[@class='_1tv_' and text()=' What kinds of information do we collect? ']")).click();
		Thread.sleep(5000);
		String rx = getDriver().findElement(By.xpath(".//*[@class='_1z2h' and text()='Things you do and information you provide.']")).getText();
		String ot = getDriver().findElement(By.xpath(".//*[@class='_1z2h'and text()='Things others do and information they provide.']")).getText();
		Assert.assertEquals(rx, "Things you do and information you provide.");
		Assert.assertEquals(ot, "Things others do and information they provide.");
		switchToRootWindowAndCloseCurrentBrowser();
		Thread.sleep(3000);

		
	}

	public static void switchToWindow(int index) {

		List<String> listOfWindows = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(listOfWindows.get(index));
	}

	public static void switchToRootWindowAndCloseCurrentBrowser() {
		List<String> listOfWindows = new ArrayList<String>(getDriver().getWindowHandles());

		for (int i = 1; i < listOfWindows.size(); i++) {
			getDriver().switchTo().window(listOfWindows.get(i));
			getDriver().close();
		}
		getDriver().switchTo().window(listOfWindows.get(0));

	}

	
}