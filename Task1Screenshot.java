package assignment2;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class Task1Screenshot extends Initialization {
	


	public static void takeScreenShot() {
		try {
			File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(src, new File("D://SeleniumDocs//" + timeStamp + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public static void screnshotexample() {
		try {
			getDriver().findElement(By.id("pk")).sendKeys("arundasa");

		} catch (Exception e) {
			takeScreenShot();
			e.printStackTrace();
			throw new NoSuchElementException("Specified elemnt is not found");
		}

	}
}

	
